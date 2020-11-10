package com.example.todolistroomdatabase25082020.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.todolistroomdatabase25082020.model.WordEntity;
import com.example.todolistroomdatabase25082020.repository.WordRepository;

import java.util.List;

import io.reactivex.MaybeObserver;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WordViewModel extends AndroidViewModel {
    private MutableLiveData<List<WordEntity>> mListWords;
    private WordRepository mWordRepository = null;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mListWords = new MutableLiveData<>();
        mWordRepository = WordRepository.getInstance(application.getBaseContext());
    }


    public void callDataWords(){
        mWordRepository.getWords()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<List<WordEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<WordEntity> wordEntities) {
                        mListWords.setValue(wordEntities);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<List<WordEntity>> getWords(){
        return mListWords;
    }
}
