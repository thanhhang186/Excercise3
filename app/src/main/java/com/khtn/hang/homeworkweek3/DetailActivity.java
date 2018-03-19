package com.khtn.hang.homeworkweek3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    ImageView imgPoster, imgVideo;
    TextView tvTitle, tvDate, tvOverview;
    RatingBar rating;
    private static final String HEADER_PATH = "https://image.tmdb.org/t/p/w500/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        imgPoster = (ImageView)findViewById(R.id.imgPoster);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvDate = (TextView) findViewById(R.id.tvDate);
        rating = (RatingBar) findViewById(R.id.rating);
        tvOverview = (TextView) findViewById(R.id.tvOverview);
        imgVideo = (ImageView) findViewById(R.id.imgVideo);
        Intent intent = getIntent();
        if (intent != null){
            Result result = (Result) intent.getSerializableExtra("detail");
                if(result!= null){
                    Picasso.get().load(HEADER_PATH+result.getPoster_path())
                            .fit()
                            .centerCrop()
                            .into(imgPoster);
                    tvTitle.setText(result.getTitle());
                    tvDate.setText("Release Date: "+result.getRelease_date());
                    tvOverview.setText(result.getOverview().toString());
                    rating.setRating(result.getVote_average()/2);
                    imgVideo.setVisibility(result.isVideo()? View.VISIBLE : View.GONE);
                    getSupportActionBar().setTitle(result.getTitle());
                }
        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
