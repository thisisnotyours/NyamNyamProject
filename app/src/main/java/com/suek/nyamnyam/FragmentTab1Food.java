package com.suek.nyamnyam;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


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
    Boolean selectDate= true;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view= inflater.inflate(R.layout.tab1_food_fragment, container, false);


        //Food Category Recyclerview items
        items.add(new Item("https://images.happycow.net/venues/1024/14/53/hcmp145394_726578.jpeg", "VEGAN"));    //이미지들 바꿔주기
        items.add(new Item("https://recipe1.ezmember.co.kr/cache/recipe/2015/04/21/84d2afaa37d7d004c66bfb32817744a11.jpg", "SOUP"));
        items.add(new Item("https://www.nongsaro.go.kr/ps/img/interabang/num207/headerImg.jpg", "RICE"));
        items.add(new Item("https://m.handokmall.kr/web/product/big/201901/b76a02afec251e63c5f3013f3bd461b5.jpg", "MEAT"));
        items.add(new Item("https://image.auction.co.kr/itemimage/11/a9/e0/11a9e0eb26.jpg", "NOODLE"));
        items.add(new Item("https://i.ytimg.com/vi/ybCOfiNp01M/maxresdefault.jpg", "VEGGIE"));
        items.add(new Item("https://travelright.com/wp-content/uploads/2019/12/Korean-Patbingsu.jpg", "DESSERT"));
        items.add(new Item("https://files.bonif.co.kr/upload/cmdt/BF101_pic_qhO61yeq.jpg", "PORRIDGE"));
        items.add(new Item("https://d3h1lg3ksw6i6b.cloudfront.net/media/image/2019/05/17/965cc82059734e0f8d3159e99b4af981_%E1%84%81%E1%85%A9%E1%86%BE%E1%84%89%E1%85%A9%E1%86%BC%E1%84%91%E1%85%A7%E1%86%AB-1030x773.jpg", "SPECIAL"));
        items.add(new Item("https://imagescdn.gettyimagesbank.com/500/201708/jv10928958.jpg", "PANCAKE"));
        items.add(new Item("https://imagescdn.gettyimagesbank.com/500/201811/a11203592.jpg", "BUNSIK"));

        recyclerView= view.findViewById(R.id.recycler_food_category);
        adapter= new RecyclerCategoryAdapter(view.getContext(), items);
        recyclerView.setAdapter(adapter);







        //Food Tab Fragment 에서 보여지는 추천레시피 recyclerview
        recommendedItems.add(new RecommendedItems(R.drawable.gametitle_09, "Gimbab"));
        recommendedItems.add(new RecommendedItems(R.drawable.gametitle_09, "Gimbab"));
        recommendedItems.add(new RecommendedItems(R.drawable.gametitle_09, "Gimbab"));
        recommendedItems.add(new RecommendedItems(R.drawable.gametitle_09, "Gimbab"));
        recommendedItems.add(new RecommendedItems(R.drawable.gametitle_09, "Gimbab"));
        recommendedItems.add(new RecommendedItems(R.drawable.gametitle_09, "Gimbab"));
        recommendedItems.add(new RecommendedItems(R.drawable.gametitle_09, "Gimbab"));
        recommendedItems.add(new RecommendedItems(R.drawable.gametitle_09, "Gimbab"));
        recommendedItems.add(new RecommendedItems(R.drawable.gametitle_09, "Gimbab"));

        recommendedRecyclerView= view.findViewById(R.id.recycler_recommended);
        recommendedAdapter= new RecommendedAdapter(getActivity(), recommendedItems);
        recommendedRecyclerView.setAdapter(recommendedAdapter);


        iv= view.findViewById(R.id.iv_food_culture);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), FoodCultureActivity.class);
                intent.putExtra("image", "korean food culture");   //value 는 무슨 역할????????
                startActivity(intent);
            }
        });















        //다시

        //달력 날짜를 클릭하면 뜨는 다이얼로그
        calendarView= view.findViewById(R.id.calendarview);
        calendarView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectDate){
                    //AlertDialog
                }
            }
        });

        return view;
    }





}
