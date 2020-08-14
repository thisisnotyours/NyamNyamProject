package com.suek.nyamnyam;

public class CategoryPageItems {

    //recycler_category_page.xml 의 items

    String civ;
    String foodTitle;
    String foodSub;



    //전달할 데이터 추가해주기
    String foodMsg;
    String foodBackground;


    Boolean fav;

    public CategoryPageItems() {
    }

    public CategoryPageItems(String civ, String foodTitle, String foodSub, String foodMsg, String foodBackground, Boolean fav) {
        this.civ = civ;
        this.foodTitle = foodTitle;
        this.foodSub = foodSub;
        this.foodMsg = foodMsg;
        this.foodBackground = foodBackground;
        this.fav = fav;
    }
}
