package com.example.matka.exibits;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.matka.R;

public class ExhibitsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_exibits,container,false);
        final LinearLayout linearLayout=view.findViewById(R.id.exibits_text_layout);
        final ScrollView scrollView=view.findViewById(R.id.scrolle_view_);
        final ImageView arrow=view.findViewById(R.id.arrow_up_);
        final ImageView arrow_down=view.findViewById(R.id.arrow_down_);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                linearLayout.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
                arrow.setVisibility(View.GONE);
                arrow_down.setVisibility(View.VISIBLE);
            }
        });

        arrow_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                linearLayout.setVisibility(View.VISIBLE);
                scrollView.setVisibility(View.GONE);
                arrow.setVisibility(View.VISIBLE);
                arrow_down.setVisibility(View.GONE);

            }
        });

        return view;
    }
}
