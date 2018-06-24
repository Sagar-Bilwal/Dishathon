package com.example.sagar.dishtv1;

import com.example.sagar.dishtv1.responses.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieDbApi
{
    final String API_Key="d7736b944015d9ad77241f6761abe09a";
    @GET("/3/movie/popular?api_key=d7736b944015d9ad77241f6761abe09a")
    Call<MovieResponse> getMovies();
}
