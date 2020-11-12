package com.example.todolistroomdatabase25082020.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.todolistroomdatabase25082020.R;
import com.example.todolistroomdatabase25082020.model.WordEntity;
import com.example.todolistroomdatabase25082020.viewmodel.WordViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    WordViewModel mWordViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWordViewModel = new WordViewModel(getApplication());

        mWordViewModel.getWords().observe(this, new Observer<List<WordEntity>>() {
            @Override
            public void onChanged(List<WordEntity> wordEntities) {
                WordEntity wordEntity = wordEntities.get(0);
                wordEntity.setIsMemorized(1);
                mWordViewModel.updateWord(wordEntity);
            }
        });

        mWordViewModel.callDataWords();
//        mWordViewModel.getIdInsertSuccess().observe(this, new Observer<Long>() {
//            @Override
//            public void onChanged(Long aLong) {
//                Toast.makeText(MainActivity.this, aLong + "", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        mWordViewModel.insertWord(new WordEntity("One","Một",0));

        mWordViewModel.getIdUpdateSuccess().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                Toast.makeText(MainActivity.this, integer + "", Toast.LENGTH_SHORT).show();
            }
        });


    }
}