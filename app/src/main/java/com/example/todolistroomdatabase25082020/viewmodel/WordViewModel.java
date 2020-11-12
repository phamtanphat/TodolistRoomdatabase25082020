package com.example.todolistroomdatabase25082020.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.todolistroomdatabase25082020.model.WordEntity;
import com.example.todolistroomdatabase25082020.repository.WordRepository;

import java.util.List;

import io.reactivex.MaybeObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WordViewModel extends AndroidViewModel {
    private MutableLiveData<List<WordEntity>> mListWords;
    private MutableLiveData<Long> mIdInsertSuccess;
    private MutableLiveData<Integer> mIdUpdateSuccess;
    private WordRepository mWordRepository = null;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mListWords = new MutableLiveData<>();
        mIdInsertSuccess = new MutableLiveData<>();
        mIdUpdateSuccess = new MutableLiveData<>();
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

    public void insertWord(WordEntity wordEntity){
        mWordRepository.insertWord(wordEntity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Long aLong) {
                        mIdInsertSuccess.setValue(aLong);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public LiveData<Long> getIdInsertSuccess(){
        return mIdInsertSuccess;
    }
    public void updateWord(WordEntity wordEntity){
        mWordRepository.updateWord(wordEntity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Integer integer) {
                        mIdUpdateSuccess.setValue(integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public LiveData<Integer> getIdUpdateSuccess(){
        return mIdUpdateSuccess;
    }

}
