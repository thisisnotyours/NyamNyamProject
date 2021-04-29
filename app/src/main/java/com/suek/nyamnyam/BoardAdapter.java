package com.suek.nyamnyam;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class BoardAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<BoardItem> items;


    public BoardAdapter(Context context, ArrayList<BoardItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View itemView= layoutInflater.inflate(R.layout.recycler_board, parent, false);
        VH holder= new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH)holder;
        BoardItem boardItem= items.get(position);
        String imgUrl= "http://suhyun2963.dothome.co.kr/Retrofit_Board_NyamNyam/" + boardItem.file;
        Glide.with(context).load(imgUrl).into(vh.iv);
        vh.tv_title.setText(boardItem.title);
        vh.tv_msg.setText(boardItem.msg);

        //중간에 확인하기
        Log.d( "TAG", boardItem.file+"" );
        Log.d( "TAG", boardItem.title+"" );
        Log.d( "TAG", boardItem.msg+"" );
        Log.d( "TAG", boardItem.date+"" );
    }

    @Override
    public int getItemCount() {
        return items.size();
    }





    class VH extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv_title;
        TextView tv_msg;

        //로그인정보
        CircleImageView civProfile;
        TextView tvNickName;

        public VH(@NonNull View itemView) {
            super(itemView);
            iv= itemView.findViewById(R.id.iv);
            tv_title= itemView.findViewById(R.id.tv_title);
            tv_msg= itemView.findViewById(R.id.tv_msg);

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
