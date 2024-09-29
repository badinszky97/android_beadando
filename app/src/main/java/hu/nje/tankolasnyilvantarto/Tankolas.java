package hu.nje.tankolasnyilvantarto;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Tankolas {


    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    public Tankolas(@NonNull String word) {this.mWord = word;}

    public String getWord(){return this.mWord;}
}
