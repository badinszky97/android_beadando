package hu.nje.tankolasnyilvantarto;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class TankolasRepository {

    private TankolasDao mTankolasDao;
    private LiveData<List<Tankolas>> mindenTankolas;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    TankolasRepository(Application application) {
        TankolasRoomDatabase db = TankolasRoomDatabase.getDatabase(application);
        mTankolasDao = db.wordDao();
        mindenTankolas = mTankolasDao.getMindenTankolas();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Tankolas>> getAllWords() {
        return mindenTankolas;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Tankolas tankolas) {
        TankolasRoomDatabase.databaseWriteExecutor.execute(() -> {
            mTankolasDao.insert(tankolas);
        });
    }


}
