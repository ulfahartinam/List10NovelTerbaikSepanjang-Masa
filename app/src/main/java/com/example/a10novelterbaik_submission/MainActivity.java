package com.example.a10novelterbaik_submission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.a10novelterbaik_submission.adapter.ListBookAdapter;
import com.example.a10novelterbaik_submission.model.Book;
import com.example.a10novelterbaik_submission.model.BooksData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListBookAdapter.OnItemSelected {
    private RecyclerView rvBooks;
    private ArrayList<Book> listBook = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Daftar 10 Novel Terbaik");

        rvBooks = findViewById(R.id.rv_Books);
        rvBooks.setHasFixedSize(true);

        listBook.addAll(BooksData.getListData());
        showRecyclerList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.menu_profile){
            Intent intent = new Intent (MainActivity.this, ProfileActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showRecyclerList(){
        rvBooks.setLayoutManager(new LinearLayoutManager(this));
        ListBookAdapter listBookAdapter = new ListBookAdapter(this, listBook, this);
        rvBooks.setAdapter(listBookAdapter);
    }

    @Override
    public void onSelected(Book book) {
        Intent intent = new Intent(MainActivity.this, DetailBook.class);
        intent.putExtra(DetailBook.PHOTO, book.getPhoto());
        intent.putExtra(DetailBook.NAME, book.getName());
        intent.putExtra(DetailBook.TITLE, book.getTitle());
        intent.putExtra(DetailBook.DESCRIPTION, book.getDetail());
        startActivity(intent);

    }
}
