package com.suek.nyamnyam;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.io.ObjectInput;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryPageAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<CategoryPageItems> items;

    SQLiteDatabase db;
    String dbName= "bookmark.db";
    String tableName= "bookmarkItems";

    public CategoryPageAdapter() {
    }

    public CategoryPageAdapter(Context context, ArrayList<CategoryPageItems> items) {
        this.context = context;
        this.items = items;

        db= context.openOrCreateDatabase(dbName, Context.MODE_PRIVATE, null);   //context가 가지고있음
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View itemView= inflater.inflate(R.layout.recycler_category_page, parent, false);
        VH holder= new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        VH vh= (VH)holder;
        CategoryPageItems categoryPageItems= items.get(position);
        //vh.civ.setImageResource(categoryPageItems.civ);
        Glide.with(context).load(categoryPageItems.civ).into(vh.civ);
        vh.tvFoodTitle.setText(categoryPageItems.foodTitle);  //foodTitle - CategoryPageItems 에 있는
        vh.tvFoodSub.setText(categoryPageItems.foodSub);
        vh.fav.setChecked(categoryPageItems.fav);   //civ, title, sub..등등의 데이터들을 불러올때 기존에 선택했던 체크박스들이 선택되어나옴


    }

    @Override
    public int getItemCount() {
        return items.size();
    }




    class VH extends RecyclerView.ViewHolder{

        CircleImageView civ;   //내가만든 참조변수
        TextView tvFoodTitle;
        TextView tvFoodSub;

        //Bookmark
        CheckBox fav;

        public VH(@NonNull final View itemView) {
            super(itemView);

            this.civ= itemView.findViewById(R.id.civ);
            this.tvFoodTitle= itemView.findViewById(R.id.tv_food_title);
            this.tvFoodSub= itemView.findViewById(R.id.tv_food_sub);

            this.fav= itemView.findViewById(R.id.checkbox_fav);




            //Bookmark
            fav.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {



                    items.get(getLayoutPosition()).fav= isChecked;

                    String foodImg= items.get(getLayoutPosition()).civ;
                    String foodTitle= items.get(getLayoutPosition()).foodTitle;
                    String foodSub= items.get(getLayoutPosition()).foodSub;
                    int fav= items.get(getLayoutPosition()).fav? 1 : 0;

                    //Toast.makeText(context, ""+isChecked, Toast.LENGTH_SHORT).show();
                   Toast.makeText(context, ""+items.get(getLayoutPosition()), Toast.LENGTH_SHORT).show();
                   // Toast.makeText(context, ""+foodTitle+"\n"+foodSub+"\n"+fav+"\n"+foodImg, Toast.LENGTH_SHORT).show();

                    if(isChecked){
                        db.execSQL(" INSERT INTO "+ tableName + "(foodImg, foodTitle, foodSub, fav) VALUES('"+foodImg+"','"+foodTitle+"','"+foodSub+"','"+fav+"')");
                    }else {
                        db.execSQL("DELETE FROM "+ tableName+" WHERE foodTitle='"+foodTitle+"'" );
                    }



                }
            });




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


        }
    }

}
