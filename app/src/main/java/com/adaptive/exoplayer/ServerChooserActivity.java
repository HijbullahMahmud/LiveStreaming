package com.adaptive.exoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.adaptive.exoplayer.bangla_tv.BanglaTvActivity;

public class ServerChooserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_chooser);
    }

    public void aosTv(View view) {
        startActivity(new Intent(ServerChooserActivity.this, HomeActivity.class));
    }

    public void banglaTvBkash(View view) {
        startActivity(new Intent(ServerChooserActivity.this, BanglaTvActivity.class));
    }
}