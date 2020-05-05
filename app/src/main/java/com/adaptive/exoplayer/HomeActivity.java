package com.adaptive.exoplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ChannelAdapter adapter;
    private List<Channel> channelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.recycler_view);
        progressBar = findViewById(R.id.progress_bar);
        
        adapter = new ChannelAdapter(this, channelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();
        recyclerView.setAdapter(adapter);
        
        getData();
    }

    private void getData() {
        progressBar.setVisibility(View.VISIBLE);
        Retrofit retrofit = RetrofitClient.getInstance();
        ChannelApi api = retrofit.create(ChannelApi.class);
        Call<List<Channel>> call = api.getAllChannels();
        call.enqueue(new Callback<List<Channel>>() {
            @Override
            public void onResponse(Call<List<Channel>> call, Response<List<Channel>> response) {
                if (response.code() == 200){
                    channelList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }else {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(HomeActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Channel>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(HomeActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                Log.e("ChannelData", t.getLocalizedMessage());
            }
        });
    }
}
