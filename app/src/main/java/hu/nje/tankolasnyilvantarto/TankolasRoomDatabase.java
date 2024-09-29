package hu.nje.tankolasnyilvantarto;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Tankolas.class}, version = 1, exportSchema = false)
public abstract class TankolasRoomDatabase extends RoomDatabase {

    public abstract TankolasDao wordDao();

    private static volatile TankolasRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static TankolasRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TankolasRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    TankolasRoomDatabase.class, "word_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                TankolasDao dao = INSTANCE.wordDao();
                dao.deleteAll();

                Tankolas tankolas = new Tankolas("Hello");
                dao.insert(tankolas);
                tankolas = new Tankolas("World");
                dao.insert(tankolas);
            });
        }
    };

}
