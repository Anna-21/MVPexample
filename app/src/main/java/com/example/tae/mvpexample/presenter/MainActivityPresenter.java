package com.example.tae.mvpexample.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.example.tae.mvpexample.models.ApIService;
import com.example.tae.mvpexample.models.ApiClient;
import com.example.tae.mvpexample.models.api.StarWarsCharacters;
import com.example.tae.mvpexample.view.MainActivity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivityPresenter  implements MainActivityContract.Presenter {
    private ApIService apIService;
    private CompositeDisposable disposable = new CompositeDisposable();
    private StarWarsCharacters starWarsCharacters;
    private Context context;
    private MainActivityContract.View view;

    public MainActivityPresenter(Context context, MainActivityContract.View view){
        this.context = context;
        this.view = view;
        view.setPresenter(this);
    }
    //private TextView textView;

    @Override
    public void getStarWarsCharacter(int id) {

        apIService = ApiClient.getClient(context)
                .create(ApIService.class);


        disposable.add(
                apIService.getCharacter(id)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<StarWarsCharacters>() {
                            @Override
                            public void onSuccess(StarWarsCharacters starWarsCharacters) {
                                view.setStarWarsCharacters (starWarsCharacters);


                                Log.i("x", starWarsCharacters.getName());
                                //textView.setText(starWarsCharacters.getName().toString());

                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.i("x", e.getMessage());

                                }
                          }
                        )
        );
    }
@Override
    public void destroy(){
    disposable.dispose();
    }
}

