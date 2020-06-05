package com.adaptive.exoplayer.bangla_tv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.adaptive.exoplayer.R;
import com.adaptive.exoplayer.bangla_tv.adapter.CategoryAdapter;
import com.adaptive.exoplayer.bangla_tv.model.Category;
import com.adaptive.exoplayer.bangla_tv.model.CategoryData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BanglaTvActivity extends AppCompatActivity {
    private static final String TAG = "BanglaTvActivity";
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private CategoryAdapter adapter;
    private List<Category> categoryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangla_tv);
        progressBar = findViewById(R.id.progress_bar);
        recyclerView = findViewById(R.id.recycler_view);

        adapter = new CategoryAdapter(this, categoryList);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);

        getAllCategories();
    }

    private void getAllCategories() {
        progressBar.setVisibility(View.VISIBLE);
        Retrofit retrofit = BanglaTvRetrofit.getInstance();
        BanglaTvApi api = retrofit.create(BanglaTvApi.class);
        Call<CategoryData> call = api.getAllCategories(BanglaTvApi.API_KEY);
        call.enqueue(new Callback<CategoryData>() {
            @Override
            public void onResponse(Call<CategoryData> call, Response<CategoryData> response) {
                if (response.code() == 200){
                    Log.e(TAG, "success");
                    if (response.body().getStatus().equalsIgnoreCase("ok")){
                        categoryList.addAll(response.body().getCategories());
                        adapter.notifyDataSetChanged();
                        progressBar.setVisibility(View.GONE);
                    }
                }else {
                    Log.e(TAG, "failed");
                    Toast.makeText(BanglaTvActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<CategoryData> call, Throwable t) {
                Log.e(TAG, "failed: " + t.getLocalizedMessage());
                Toast.makeText(BanglaTvActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}