package com.adaptive.exoplayer.bangla_tv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.adaptive.exoplayer.bangla_tv.adapter.ChannelAdapter;
import com.adaptive.exoplayer.R;
import com.adaptive.exoplayer.bangla_tv.model.ChannelData;
import com.adaptive.exoplayer.bangla_tv.model.Post;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ChannelListActivity extends AppCompatActivity {
    private static final String TAG = "ChannelListActivity";
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private ChannelAdapter adapter;
    private List<Post> channelList = new ArrayList<>();
    private int cat_id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel_list);
        progressBar = findViewById(R.id.progress_bar);
        recyclerView = findViewById(R.id.recycler_view);

        adapter = new ChannelAdapter(this, channelList);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);

        cat_id = getIntent().getIntExtra("id", 0);
        getChannelListData(cat_id, 1);
    }

    private void getChannelListData(int cat_id, int page) {
        progressBar.setVisibility(View.VISIBLE);
        Retrofit retrofit = BanglaTvRetrofit.getInstance();
        BanglaTvApi api = retrofit.create(BanglaTvApi.class);
        Call<ChannelData> call = api.getCategoryDetailsByPage(BanglaTvApi.API_KEY, cat_id, page, 20);
        call.enqueue(new Callback<ChannelData>() {
            @Override
            public void onResponse(Call<ChannelData> call, Response<ChannelData> response) {
                if (response.code() == 200){
                    Log.e(TAG, "success");
                    if (response.body().getStatus().equalsIgnoreCase("ok")){
                        channelList.addAll(response.body().getPosts());
                        adapter.notifyDataSetChanged();
                        progressBar.setVisibility(View.GONE);
                    }
                }else {
                    Log.e(TAG, "failed");
                    Toast.makeText(ChannelListActivity.this, "failed", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<ChannelData> call, Throwable t) {
                Log.e(TAG, "failed: " + t.getLocalizedMessage());
                Toast.makeText(ChannelListActivity.this, "failed", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}