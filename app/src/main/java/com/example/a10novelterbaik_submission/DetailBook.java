package com.example.a10novelterbaik_submission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailBook extends AppCompatActivity {
    public static final String PHOTO = "data_photo";
    public static final String NAME = "data_name";
    public static final String TITLE = "data_title";
    public static final String DESCRIPTION = "data_description";

    Toolbar toolbar;
    ImageView imgPhoto;
    TextView tvName, tvTitle, tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_book);

        toolbar = findViewById(R.id.toolbar);
        imgPhoto = findViewById(R.id.img_item_book);
        tvName = findViewById(R.id.tv_book_name);
        tvTitle = findViewById(R.id.tv_book_title);
        tvDescription = findViewById(R.id.tv_book_desc);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail 10 Novel Terbaik Sepanjang Masa");

        if (getIntent().getExtras() != null) {
            int drawableResourceId = this.getResources().getIdentifier(getIntent().getExtras().getString(PHOTO), "drawable", this.getPackageName());

            Glide.with(this)
                    .load(drawableResourceId)
                    .apply(new RequestOptions().override(256, 256))
                    .into(imgPhoto);
            tvName.setText(getIntent().getExtras().getString(NAME));
            tvTitle.setText(getIntent().getExtras().getString(TITLE));
            tvDescription.setText(getIntent().getExtras().getString(DESCRIPTION));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() ==android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
