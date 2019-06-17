package com.example.tae.mvpexample.view;


import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.tae.mvpexample.R;
import com.example.tae.mvpexample.models.ApIService;
import com.example.tae.mvpexample.models.ApiClient;
import com.example.tae.mvpexample.models.api.StarWarsCharacters;
import com.example.tae.mvpexample.presenter.MainActivityContract;
import com.example.tae.mvpexample.presenter.MainActivityPresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    private MainActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter=new MainActivityPresenter(getApplicationContext(), this);
        presenter.getStarWarsCharacter(2);

    }

    @Override
    public void setStarWarsCharacters(StarWarsCharacters starWarsCharacters) {
        Log.i("StaWarsCharacter", starWarsCharacters.getName());
    }

    @Override
    protected void onDestroy() {
        if (presenter !=null){
            presenter.destroy ();
        }

        super.onDestroy();
    }


    @Override
    public void setPresenter(MainActivityContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setError(String error) {
        Log.i("StarWarsCharacter", error);

    }

}





