package com.example.sagar.dishtv1.responses;


import com.example.sagar.dishtv1.models.Movie;

import java.util.ArrayList;

/**
 * Created by SAGAR on 08-04-2018.
 */

public class MovieResponse
{
    private ArrayList<Movie> results;

    public ArrayList<Movie> getResults() {
        return results;
    }

    public void setResults(ArrayList<Movie> results) {
        this.results = results;
    }
}
