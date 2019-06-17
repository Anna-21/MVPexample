package com.example.tae.mvpexample.presenter;


import com.example.tae.mvpexample.BasePresenter;
import com.example.tae.mvpexample.BaseView;
import com.example.tae.mvpexample.models.api.StarWarsCharacters;


public interface MainActivityContract {

    interface  Presenter extends BasePresenter {
        void getStarWarsCharacter (int id);
    }

    interface  View extends BaseView <Presenter>{
        void setStarWarsCharacters (StarWarsCharacters setStarWarsCharacters);
        void setError(String error);
    }
}
