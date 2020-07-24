package com.suek.nyamnyam;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyPostAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<MyPostItem> items;

    public MyPostAdapter(Context context, ArrayList<MyPostItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View itemView= layoutInflater.inflate(R.layout.recycler_mypost, parent, false);
        VH holder= new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH)holder;
        MyPostItem myPostItem= items.get(position);
        String imgUrl="http://suhyun2963.dothome.co.kr/Retrofit_Board_NyamNyam/";
        Glide.with(context).load(imgUrl).into(vh.iv);
        vh.tvTitle.setText(myPostItem.title);
        vh.tvMsg.setText(myPostItem.msg);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }






    class VH extends RecyclerView.ViewHolder{
        //로그인 정보
        CircleImageView civProfile;
        TextView tvNickName;

        ImageView iv;
        TextView tvTitle;
        TextView tvMsg;

        public VH(@NonNull View itemView) {
            super(itemView);
            iv= itemView.findViewById(R.id.iv);
            tvTitle= itemView.findViewById(R.id.tv_title);
            tvMsg= itemView.findViewById(R.id.tv_msg);

            civProfile= itemView.findViewById(R.id.civ_profile);
            tvNickName= itemView.findViewById(R.id.tv_nickName);

            // 로그인 정보 불러들이기
            SharedPreferences pref= context.getSharedPreferences("Data", Context.MODE_PRIVATE);
            String nickName= pref.getString("nickName", "");
            String profileUrl= pref.getString("profileUrl", "");
            tvNickName.setText(nickName);
            Glide.with(context).load(profileUrl).into(civProfile);

        }
    }
}
