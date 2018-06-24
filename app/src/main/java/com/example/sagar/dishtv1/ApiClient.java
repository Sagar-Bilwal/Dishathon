package com.example.sagar.dishtv1;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient
{
    private static ApiClient INSTANCE;
    private MovieDbApi movieDbAPI;
    private ApiClient()
    {
        Retrofit retrofit= new Retrofit.Builder().baseUrl("http://api.themoviedb.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        movieDbAPI = retrofit.create(MovieDbApi.class);
    }
    public static ApiClient getInstance() {
        if(INSTANCE == null){
            INSTANCE = new ApiClient();
        }
        return INSTANCE;
    }

    public MovieDbApi getMovieDbApi() {
        return movieDbAPI;
    }
}
