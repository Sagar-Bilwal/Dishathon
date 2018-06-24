package com.example.sagar.dishtv1;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sagar.dishtv.R;
import com.example.sagar.dishtv1.adapter.MovieRecyclerAdapter;
import com.example.sagar.dishtv1.models.Movie;
import com.example.sagar.dishtv1.responses.MovieResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesViewer extends AppCompatActivity implements MovieRecyclerAdapter.onItemClickListener{

    RecyclerView recyclerView;
    ProgressBar progressBar;
    MovieRecyclerAdapter movieRecyclerAdapter;
    ArrayList<Movie> Movies = new ArrayList<>();
    List<Movie> DbMovies=new ArrayList<>();
    public String MOVIE_ID="MOVIE_ID";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_viewer);
        recyclerView=findViewById(R.id.recyclerView);
        movieRecyclerAdapter=new MovieRecyclerAdapter(this, Movies,this);
        progressBar=findViewById(R.id.progressbar);
        fetchMovies();
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setAdapter(movieRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void fetchMovies()
    {
        Call<MovieResponse> call=ApiClient.getInstance().getMovieDbApi().getMovies() ;
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(@NonNull Call<MovieResponse> call, @NonNull Response<MovieResponse> response) {
                MovieResponse movies=response.body();
                progressBar.setVisibility(View.GONE);
                if(movies!=null) {
                    Movies.clear();
                    Movies.addAll(movies.getResults());
                    movieRecyclerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(@NonNull Call<MovieResponse> call, @NonNull Throwable t) {
                Log.d("error", t.getMessage());
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MoviesViewer.this,"No Connection",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(int position) {
        Toast.makeText(this, "Clicked Once", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(int position) {
        Toast.makeText(this,Movies.get(position).getTitle()+" is Added to your Favourites",Toast.LENGTH_LONG).show();
        return true;
    }
}
