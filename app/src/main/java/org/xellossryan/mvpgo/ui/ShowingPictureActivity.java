package org.xellossryan.mvpgo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

import org.xellossryan.mvpgo.R;

public class ShowingPictureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showing_picture);
        final PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
        Glide.with(this).load(getIntent().getStringExtra("url")).into(photoView);
    }
}
