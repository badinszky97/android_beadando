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

    public int getiMennyiseg() {
        return iMennyiseg;
    }

    @ColumnInfo(name = "mennyiseg")
    public int iMennyiseg;

    @ColumnInfo(name = "datum")
    public long lDatum;

    public Tankolas(@NonNull String word, int mennyiseg, long datum)
    {
        this.mWord = word;
        this.iMennyiseg = mennyiseg;
        this.lDatum = datum;
    }
    public Tankolas(@NonNull String word)
    {
        this.mWord = word;
    }
    public String getWord(){return this.mWord;}

}
