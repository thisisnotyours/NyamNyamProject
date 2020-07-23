package com.suek.nyamnyam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FoodCultureActivity extends AppCompatActivity {

    //서버에 저장되어있는 모든 아이템들..
    //ArrayList<FoodCultureItem> allItems= new ArrayList<>();

    ArrayList<FoodCultureItem> foodCultureItems= new ArrayList<>();
    RecyclerView recyclerView;
    FoodCultureAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_culture);

        //foodCultureItems.add(new FoodCultureItem("https://www.90daykorean.com/wp-content/uploads/2016/07/Korean-Table-Manners1.png", "Bapsang Yejeol","밥상예절", "", ""));

        recyclerView= findViewById(R.id.recycler);
        adapter= new FoodCultureAdapter(this, foodCultureItems);
        recyclerView.setAdapter(adapter);


    }//onCreate


    @Override
    protected void onResume() {
        super.onResume();

        loadDataFromServer();
    }


    void loadDataFromServer(){
        //테스트..
       /* foodCultureItems.add(new FoodCultureItem("Korean table manner","https://www.90daykorean.com/wp-content/uploads/2016/07/Korean-Table-Manners1.png","sub","source","msg"));
        foodCultureItems.add(new FoodCultureItem("Korean table manner","https://www.90daykorean.com/wp-content/uploads/2016/07/Korean-Table-Manners1.png","sub","source","msg"));*/

        Retrofit retrofit= RetrofitHelper_FoodCulture.getInstance();
        RetrofitService_FoodCulture retrofitService= retrofit.create(RetrofitService_FoodCulture.class);
        Call<ArrayList<FoodCultureItem>> call= retrofitService.loadDataFromFoodCulture();
        call.enqueue(new Callback<ArrayList<FoodCultureItem>>() {
            @Override
            public void onResponse(Call<ArrayList<FoodCultureItem>> call, Response<ArrayList<FoodCultureItem>> response) {
                if (response.isSuccessful()){

                    ArrayList<FoodCultureItem> items= response.body();
                    Toast.makeText(FoodCultureActivity.this, "success loading"+items.size(), Toast.LENGTH_SHORT).show();

                    foodCultureItems.clear();
                    adapter.notifyDataSetChanged();

                    for(FoodCultureItem item : items){
                        foodCultureItems.add(0, item);
                        adapter.notifyItemInserted(0);
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<FoodCultureItem>> call, Throwable t) {
                Toast.makeText(FoodCultureActivity.this, "loading fail"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }


}
