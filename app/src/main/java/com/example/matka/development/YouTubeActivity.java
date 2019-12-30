package com.example.matka.development;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.matka.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YouTubeActivity extends YouTubeBaseActivity  {

    YouTubePlayer.OnInitializedListener mInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube);

        Toolbar toolbar=findViewById(R.id.toolbar_youTube_);
        toolbar.setTitle(R.string.development_toolbar_titile);
        setActionBar(toolbar);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        YouTubePlayerView mYouTubePlayerView =findViewById(R.id.youTube_);
        mInitializedListener= new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                youTubePlayer.loadVideo("6GQyVmbkL60");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        mYouTubePlayerView.initialize(YouTubeConfig.getApiKey(),mInitializedListener);

    }
}
