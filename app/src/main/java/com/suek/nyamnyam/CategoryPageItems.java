package com.suek.nyamnyam;

public class CategoryPageItems {

    //recycler_category_page.xml 의 items

    String civ;
    String foodTitle;
    String foodSub;
    String foodMsg;
    String foodBackground;


    public CategoryPageItems() {
    }

    public CategoryPageItems(String civ, String foodTitle, String foodSub, String foodMsg, String foodBackground) {
        this.civ = civ;
        this.foodTitle = foodTitle;
        this.foodSub = foodSub;
        this.foodMsg = foodMsg;
        this.foodBackground = foodBackground;
    }
}
