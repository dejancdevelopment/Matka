package com.example.matka.video;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matka.R;

public class VideosFragment extends Fragment implements OnCustomListener {

    private RecyclerView videolistView;
    int[] video_descriptiion;
    int[] video_images;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_video, container, false);

        videolistView = view.findViewById(R.id.list_view_);
        videolistView.setLayoutManager(new LinearLayoutManager(getContext()));

        video_images = new int[]
                {R.drawable.video_image1,
                        R.drawable.video_image2,
                        R.drawable.video_image3,
                        R.drawable.video_image4,
                        R.drawable.video_image5,
                        R.drawable.video_image6};

        video_descriptiion = new int[]
                {R.string.video_description1,
                        R.string.video_description2,
                        R.string.video_description3,
                        R.string.video_description4,
                        R.string.video_description5,
                        R.string.video_description6};


        VideoAdapter adapter = new VideoAdapter(getContext(), video_images, video_descriptiion);
        adapter.onCustomListener(this);

        videolistView.setAdapter(adapter);


        return view;
    }

    @Override
    public void getPosition(int position) {

        switch (position) {
            case 0:
                Uri uri = Uri.parse("https://www.youtube.com/watch?v=ci93H59m2IY&feature=emb_title");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case 1:
                Uri uri1 = Uri.parse("https://www.youtube.com/watch?v=u8Yr9vqyU_8&feature=emb_title");
                Intent intent1 = new Intent(Intent.ACTION_VIEW, uri1);
                startActivity(intent1);
                break;
            case 2:
                Uri uri2 = Uri.parse("https://www.youtube.com/watch?v=mXEulg0a1Yk&feature=emb_title");
                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                startActivity(intent2);
                break;
            case 3:
                Uri uri3 = Uri.parse("https://www.youtube.com/watch?v=Y0roxYTwLwQ&feature=emb_title");
                Intent intent3 = new Intent(Intent.ACTION_VIEW, uri3);
                startActivity(intent3);
                break;
            case 4:
                Uri uri4 = Uri.parse("https://www.youtube.com/watch?v=qwkQVShCklw&feature=emb_title");
                Intent intent4 = new Intent(Intent.ACTION_VIEW, uri4);
                startActivity(intent4);
                break;
            case 5:
                Uri uri5 = Uri.parse("https://www.youtube.com/watch?v=ohWQvr7y93k&feature=emb_title");
                Intent intent5 = new Intent(Intent.ACTION_VIEW, uri5);
                startActivity(intent5);
                break;
                default:

        }
    }
}
