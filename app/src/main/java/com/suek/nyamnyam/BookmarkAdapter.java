package com.suek.nyamnyam;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class BookmarkAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<BookmarkItems> items;

    SQLiteDatabase db;
    String dbName="bookmark.db";
    String tableName= "bookmarkItems";


    public BookmarkAdapter() {
    }

    public BookmarkAdapter(Context context, ArrayList<BookmarkItems> items) {
        this.context = context;
        this.items = items;

        db= context.openOrCreateDatabase(dbName, Context.MODE_PRIVATE, null);
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View itemView= inflater.inflate(R.layout.recycler_bookmark, parent, false);
        VH holder= new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH)holder;
        BookmarkItems bookmarkItems= items.get(position);
        //vh.civ.setImageResource(categoryPageItems.civ);
        Glide.with(context).load(bookmarkItems.civ).into(vh.civ);
        vh.tvFoodTitle.setText(bookmarkItems.foodTitle);  //foodTitle - CategoryPageItems 에 있는
        vh.tvFoodSub.setText(bookmarkItems.foodSub);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }




    class VH extends RecyclerView.ViewHolder{

        CircleImageView civ;   //내가만든 참조변수
        TextView tvFoodTitle;
        TextView tvFoodSub;

        ImageView delete_fav;



        public VH(@NonNull final View itemView) {
            super(itemView);

            this.civ= itemView.findViewById(R.id.civ);
            this.tvFoodTitle= itemView.findViewById(R.id.tv_food_title);
            this.tvFoodSub= itemView.findViewById(R.id.tv_food_sub);

            this.delete_fav= itemView.findViewById(R.id.delete_fav);








//food category page 각 recyclerview 에 리스너 달아주기 -> 누르면 카테고리1 페이지로 이동
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, ""+tvFoodSub.getText(), Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(context, VeganActivity.class);           //category page items 의 데이터를 VeganActivity 로 보냄
                    intent.putExtra("civ", items.get(getLayoutPosition()).civ);
                    intent.putExtra("foodTitle", items.get(getLayoutPosition()).foodTitle);
                    intent.putExtra("foodSub", items.get(getLayoutPosition()).foodSub);
                    //추가할 데이터 전달하기
                    intent.putExtra("foodMsg", items.get(getLayoutPosition()).foodMsg);
                    intent.putExtra("foodBackground", items.get(getLayoutPosition()).foodBackground);

                    context.startActivity(intent);
                }
            });






            delete_fav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //AlertDialog.Builder builder= new AlertDialog.Builder(context, );

                    //bookmarkItems 테이블에서 선택할 이름 얻어오기?
                    String foodTitle= items.get(getLayoutPosition()).foodTitle;

                    db.execSQL("DELETE FROM "+tableName+" WHERE foodTitle=?", new String[]{foodTitle});
                }
            });







        }
    }

}
