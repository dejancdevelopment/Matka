package com.example.matka.video;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matka.R;
import com.google.android.gms.tasks.OnCompleteListener;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MyHolder> {

    Context context;
    int[] videoImage;
    int[] videoDescription;
    OnCustomListener mListener;

    public void onCustomListener(OnCustomListener listener){
        this.mListener=listener;
    }


    public VideoAdapter(Context context, int[] videoImage, int[] videoDescription) {
        this.context = context;
        this.videoImage = videoImage;
        this.videoDescription = videoDescription;

    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_video_row,parent,false);

        MyHolder myHolder=new MyHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        holder.description.setText(videoDescription[position]);
        holder.imageView.setImageResource(videoImage[position]);
    }

    @Override
    public int getItemCount() {
        return videoDescription.length;
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView description;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.image_);
            description=itemView.findViewById(R.id.text_description);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(mListener!=null){
                        int posiiton=getAdapterPosition();
                        if(posiiton!=RecyclerView.NO_POSITION){
                            mListener.getPosition(posiiton);
                        }
                    }

                }
            });



        }
    }
}
