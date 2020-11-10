package com.example.todolistroomdatabase25082020.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

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
                Log.d("BBB",wordEntities.size() + "");
            }
        });

        mWordViewModel.callDataWords();
    }
}