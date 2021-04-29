package com.suek.nyamnyam;

//메인화면(tab1 food)에 있는 recycler- food category

public class Item {
    String imgUrl;
    String foodTitle;
    String foodSub;
    String foodMsg;
    String foodBackground;


    public Item() {
    }

    public Item(String imgUrl, String foodTitle, String foodSub, String foodMsg, String foodBackground) {
        this.imgUrl = imgUrl;
        this.foodTitle = foodTitle;
        this.foodSub = foodSub;
        this.foodMsg = foodMsg;
        this.foodBackground = foodBackground;
    }
}
