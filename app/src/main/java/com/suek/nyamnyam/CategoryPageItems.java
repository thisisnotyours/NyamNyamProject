package com.suek.nyamnyam;

public class CategoryPageItems {

    //recycler_category_page.xml 의 items

    int civ;
    String foodTitle;
    String foodSub;

    public CategoryPageItems() {
    }

    public CategoryPageItems(int civ, String foodTitle, String foodSub) {
        this.civ = civ;
        this.foodTitle = foodTitle;
        this.foodSub = foodSub;
    }
}
