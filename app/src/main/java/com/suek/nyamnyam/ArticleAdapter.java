package com.suek.nyamnyam;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter {


    Context context;
    ArrayList<ArticleItem> articleItems;

    public ArticleAdapter(Context context, ArrayList<ArticleItem> articleItems) {
        this.context = context;
        this.articleItems = articleItems;
    }




    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View itemView= layoutInflater.inflate(R.layout.recycler_article, parent, false);
        VH holder= new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH)holder;
        ArticleItem articleItem= articleItems.get(position);
        Glide.with(context).load(articleItem.imgUrl).into(vh.iv);
        vh.tvArticleTitle.setText(articleItem.tvTitle);
    }

    @Override
    public int getItemCount() {
        return articleItems.size();
    }




    class VH extends RecyclerView.ViewHolder{

        ImageView iv;
        TextView tvArticleTitle;

        public VH(@NonNull final View itemView) {
            super(itemView);

            this.iv= itemView.findViewById(R.id.iv);
            this.tvArticleTitle= itemView.findViewById(R.id.tv_article_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, ""+getLayoutPosition(), Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(context, ArticleActivity.class);
                    intent.putExtra("image", articleItems.get(getLayoutPosition()).imgUrl);
                    intent.putExtra("title", articleItems.get(getLayoutPosition()).tvTitle);
                    context.startActivity(intent);
                }
            });
        }
    }
}
