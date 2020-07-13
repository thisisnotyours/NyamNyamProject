package com.suek.nyamnyam;

public class CategoryPageItems {

    //recycler_category_page.xml 의 items

    String civ;
    int food_bg;
    String foodTitle;
    String foodSub;
    String foodMsg;


    public CategoryPageItems() {
    }

    public CategoryPageItems(String civ, int food_bg, String foodTitle, String foodSub, String foodMsg) {
        this.civ = civ;
        this.food_bg= food_bg;
        this.foodTitle = foodTitle;
        this.foodSub = foodSub;
        this.foodMsg=foodMsg;
    }
}
