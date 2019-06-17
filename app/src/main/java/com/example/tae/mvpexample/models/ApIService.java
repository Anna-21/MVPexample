package com.example.tae.mvpexample.models;


import com.example.tae.mvpexample.models.api.StarWarsCharacters;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApIService {
    @GET("people/{id}")
    Single<StarWarsCharacters> getCharacter(@Path("id") int id);
}
