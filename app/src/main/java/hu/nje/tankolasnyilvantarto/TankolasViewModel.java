package hu.nje.tankolasnyilvantarto;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TankolasViewModel extends AndroidViewModel {

    private TankolasRepository mRepository;

    private final LiveData<List<Tankolas>> mAllWords;

    public TankolasViewModel(Application application) {
        super(application);
        mRepository = new TankolasRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    LiveData<List<Tankolas>> getAllWords() { return mAllWords; }

    public void insert(Tankolas tankolas) { mRepository.insert(tankolas); }
}
