package com.suek.nyamnyam;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


// 1. Food Tab

public class FragmentTab1Food extends Fragment {

    ArrayList<Item> items= new ArrayList<>();
    RecyclerCategoryAdapter adapter;
    RecyclerView recyclerView;

    ArrayList<RecommendedItems> recommendedItems= new ArrayList<>();
    RecommendedAdapter recommendedAdapter;
    RecyclerView recommendedRecyclerView;

    ImageView iv;

    CalendarView calendarView;
    ArrayList<CalendarItem> calendarItems= new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view= inflater.inflate(R.layout.tab1_food_fragment, container, false);


        //메인화면(tap1 food)에 있는 Food Category Recyclerview items
        items.add(new Item("https://images.happycow.net/venues/1024/14/53/hcmp145394_726578.jpeg", "VEGAN", "채식",
                "It's not a secret that Korea is well known as meat paradise for those meat lovers. But that doesn't mean that vegetarians can't have Korean food! We'll share general dishes how to enjoy Korean food like a pure vegetarian and you will soon fall in love.",
                "https://images.happycow.net/venues/1024/14/53/hcmp145394_726578.jpeg"));
        items.add(new Item("https://recipe1.ezmember.co.kr/cache/recipe/2015/04/21/84d2afaa37d7d004c66bfb32817744a11.jpg", "SOUP", "찌개",
                "Soup is called as Jjigae or Guk. Jjigae is basically contains more solid ingredients such as vegetables, meat or seafood. It's common practice for families to share a pot of Jjigae, whilst Guk is prepared for each person in a bowl as a side dish.",
                "https://recipe1.ezmember.co.kr/cache/recipe/2015/04/21/84d2afaa37d7d004c66bfb32817744a11.jpg"));
        items.add(new Item("https://www.nongsaro.go.kr/ps/img/interabang/num207/headerImg.jpg", "RICE", "밥",
                "Rice is called as Ssal before it's cooked and Bap after it's cooked. Rice is the basics of Korean food and harmonized with various side dishes. Koreans usually cook rice itself and also enjoy having with other grains in it.",
                "https://www.nongsaro.go.kr/ps/img/interabang/num207/headerImg.jpg"));
        items.add(new Item("https://m.handokmall.kr/web/product/big/201901/b76a02afec251e63c5f3013f3bd461b5.jpg", "MEAT", "고기",
                "Gogi is what we call for meat. Somewhat Korean BBQ is well known as a staple but there are more to offer amazing meat dishes that you've ever heard. It will not only satisfy your tongue, but also your gastric from healthy and beneficial ingredients.",
                "https://m.handokmall.kr/web/product/big/201901/b76a02afec251e63c5f3013f3bd461b5.jpg"));
        items.add(new Item("https://image.auction.co.kr/itemimage/11/a9/e0/11a9e0eb26.jpg", "NOODLE", "면",
                "",
                "https://image.auction.co.kr/itemimage/11/a9/e0/11a9e0eb26.jpg"));
        items.add(new Item("https://i.ytimg.com/vi/ybCOfiNp01M/maxresdefault.jpg", "VEGGIE", "야채",
                "",
                "https://i.ytimg.com/vi/ybCOfiNp01M/maxresdefault.jpg"));
        items.add(new Item("https://travelright.com/wp-content/uploads/2019/12/Korean-Patbingsu.jpg", "DESSERT", "디저트",
                "",
                "https://travelright.com/wp-content/uploads/2019/12/Korean-Patbingsu.jpg"));
        items.add(new Item("https://files.bonif.co.kr/upload/cmdt/BF101_pic_qhO61yeq.jpg", "PORRIDGE", "죽",
                "",
                "https://files.bonif.co.kr/upload/cmdt/BF101_pic_qhO61yeq.jpg"));
        items.add(new Item("https://d3h1lg3ksw6i6b.cloudfront.net/media/image/2019/05/17/965cc82059734e0f8d3159e99b4af981_%E1%84%81%E1%85%A9%E1%86%BE%E1%84%89%E1%85%A9%E1%86%BC%E1%84%91%E1%85%A7%E1%86%AB-1030x773.jpg", "SPECIAL", "스페셜",
                "",
                "https://d3h1lg3ksw6i6b.cloudfront.net/media/image/2019/05/17/965cc82059734e0f8d3159e99b4af981_%E1%84%81%E1%85%A9%E1%86%BE%E1%84%89%E1%85%A9%E1%86%BC%E1%84%91%E1%85%A7%E1%86%AB-1030x773.jpg"));
        items.add(new Item("https://imagescdn.gettyimagesbank.com/500/201708/jv10928958.jpg", "PANCAKE", "부침개",
                "",
                "https://imagescdn.gettyimagesbank.com/500/201708/jv10928958.jpg"));
        items.add(new Item("https://imagescdn.gettyimagesbank.com/500/201811/a11203592.jpg", "BUNSIK", "분식",
                "",
                "https://imagescdn.gettyimagesbank.com/500/201811/a11203592.jpg"));

        recyclerView= view.findViewById(R.id.recycler_food_category);
        adapter= new RecyclerCategoryAdapter(view.getContext(), items);
        recyclerView.setAdapter(adapter);







        //Food Tab Fragment 에서 보여지는 추천레시피 recyclerview
        recommendedItems.add(new RecommendedItems("https://images.happycow.net/venues/1024/14/53/hcmp145394_726578.jpeg", "Gimbab"));
        recommendedItems.add(new RecommendedItems("https://images.happycow.net/venues/1024/14/53/hcmp145394_726578.jpeg", "Gimbab"));
        recommendedItems.add(new RecommendedItems("https://images.happycow.net/venues/1024/14/53/hcmp145394_726578.jpeg", "Gimbab"));
        recommendedItems.add(new RecommendedItems("https://images.happycow.net/venues/1024/14/53/hcmp145394_726578.jpeg", "Gimbab"));
        recommendedItems.add(new RecommendedItems("https://images.happycow.net/venues/1024/14/53/hcmp145394_726578.jpeg", "Gimbab"));
        recommendedItems.add(new RecommendedItems("https://images.happycow.net/venues/1024/14/53/hcmp145394_726578.jpeg", "Gimbab"));


        recommendedRecyclerView= view.findViewById(R.id.recycler_recommended);
        recommendedAdapter= new RecommendedAdapter(getActivity(), recommendedItems);
        recommendedRecyclerView.setAdapter(recommendedAdapter);


        iv= view.findViewById(R.id.iv_food_culture);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), FoodCultureActivity.class);
                //intent.putExtra 해주기
                startActivity(intent);
            }
        });















        //다시

        //달력 날짜를 클릭하면 뜨는 다이얼로그
        calendarView= view.findViewById(R.id.calendarview);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                //String date=year+"-"+(month+1)+"-"+dayOfMonth;
                String date= String.format("%4d-%02d-%02d", year, (month+1), dayOfMonth);
                Log.i("tag", date);
                loadData(date);

            }
        });
        return view;



    }//onCreateView



    void loadData(String date){
        Retrofit retrofit= RetrofitHelper_Calendar.getInstance();
        RetrofitService_Calendar retrofitService= retrofit.create(RetrofitService_Calendar.class);
        Call<ArrayList<CalendarItem>> call= retrofitService.loadDataFromCalendar(date);
        call.enqueue(new Callback<ArrayList<CalendarItem>>() {
            @Override
            public void onResponse(Call<ArrayList<CalendarItem>> call, Response<ArrayList<CalendarItem>> response) {
                if(response.isSuccessful()){
                    //Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
                    ArrayList<CalendarItem> items= response.body();
                    //Toast.makeText(getContext(), items.size()+"", Toast.LENGTH_SHORT).show();

                    if(items.size()!=0){

                        AlertDialog.Builder builder= new AlertDialog.Builder(getContext());
                        View view1= LayoutInflater.from(getActivity()).inflate(R.layout.calendar_dialog, null);   //붙일 부모가 없으니 null


                        CalendarItem item= items.get(0);
                        TextView tvTitle= view1.findViewById(R.id.tv_title);
                        TextView tvDate= view1.findViewById(R.id.tv_date);
                        TextView tvMsg= view1.findViewById(R.id.tv_msg);
                        ImageView iv= view1.findViewById(R.id.iv);

                        tvTitle.setText(item.title);
                        tvDate.setText(item.date);
                        tvMsg.setText(item.msg);
                        String imgUri= "http://suhyun2963.dothome.co.kr/CalendarDialog/"+item.file;
                        Glide.with(view1).load(imgUri).into(iv);


                        //Log.i("tag",  )
                        //Glide.with(view1).load()




                        builder.setView(view1);
                        AlertDialog alertDialog= builder.create();
                        alertDialog.show();

                    }


                }
            }

            @Override
            public void onFailure(Call<ArrayList<CalendarItem>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }





}
