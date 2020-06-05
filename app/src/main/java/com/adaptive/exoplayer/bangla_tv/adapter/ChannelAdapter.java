package com.adaptive.exoplayer.bangla_tv.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adaptive.exoplayer.MainActivity;
import com.adaptive.exoplayer.R;
import com.adaptive.exoplayer.bangla_tv.model.Post;
import com.bumptech.glide.Glide;

import java.util.List;

public class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.ChannelViewHolder>{
    private boolean on_attach = true;
    private Context context;
    private List<Post> channelList;

    public ChannelAdapter(Context context, List<Post> channelList) {
        this.context = context;
        this.channelList = channelList;
    }

    @NonNull
    @Override
    public ChannelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false);
        return new ChannelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChannelViewHolder holder, int position) {
        Post channel = channelList.get(position);
        StringBuilder url = new StringBuilder();
        url.append("http://pronobtelecom.com/HB/upload/");
        url.append(channel.getChannelImage());
        Glide.with(context)
                .load(url.toString())
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("streamUrl", channel.getChannelUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return channelList.size();
    }

    class ChannelViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;

        public ChannelViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cat_image);
            textView = itemView.findViewById(R.id.cat_name);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                on_attach = false;
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        super.onAttachedToRecyclerView(recyclerView);
    }
}
