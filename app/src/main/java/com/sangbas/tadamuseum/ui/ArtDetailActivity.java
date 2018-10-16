package com.sangbas.tadamuseum.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.sangbas.tadamuseum.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArtDetailActivity extends AppCompatActivity {


    @BindView(R.id.art_title) TextView titleText;
    @BindView(R.id.art_image) ImageView artImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_detail);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String title = getIntent().getStringExtra("title");
        String image = getIntent().getStringExtra("image");

        titleText.setText(title);
        Picasso.get()
                .load(image)
                .resize(500, 500)
                .centerCrop()
                .into(artImage);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        this.finish();
        return true;
    }
}
