package com.example.a10novelterbaik_submission.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.a10novelterbaik_submission.R;
import com.example.a10novelterbaik_submission.model.Book;

import java.util.ArrayList;

public class ListBookAdapter extends RecyclerView.Adapter<ListBookAdapter.ListViewHolder> {
    private Context context;
    private ArrayList<Book> listbook;
    private OnItemSelected onItemSelected;

    public ListBookAdapter(Context context, ArrayList<Book> book, OnItemSelected onItemSelected) {
        this.context = context;
        this.listbook = book;
        this.onItemSelected = onItemSelected;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row_book, viewGroup,false);
        return new ListViewHolder(view);
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;

        ListViewHolder(View itemView){
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_title);

        }
    }

    /*@NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_book, viewGroup,false);
        return new ListViewHolder(view);
    }*/

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        final Book book = listbook.get(position);

        //Glide.with(context).load(holder.itemView.getResources().getIdentifier("ImageName", "R.drawable.laskar_pelangi",holder.itemView.getPackage);

      // System.out.println("Data Photo : " + book.getPhoto());
        int drawableResourceId = this.context.getResources().getIdentifier(book.getPhoto(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);

        //holder.imgPhoto.setImageResource(Integer.valueOf(book.getPhoto()));
        holder.tvName.setText(book.getName());
        holder.tvDetail.setText(book.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onItemSelected.onSelected(book);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listbook.size();
    }

    public interface OnItemSelected {
        void onSelected(Book book);
    }

}
