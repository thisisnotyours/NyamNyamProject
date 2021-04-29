package com.suek.nyamnyam;

public class RecommendedItems {
    String foodIv;
    String foodTitle;

    String foodTitleEng;
    String foodSub;
    //String foodMsg;
    String foodIng;
    String foodStep;
    String source;

    public RecommendedItems() {
    }

    public RecommendedItems(String foodIv, String foodTitle, String foodTitleEng, String foodSub, String foodIng, String foodStep, String source) {
        this.foodIv = foodIv;
        this.foodTitle = foodTitle;
        this.foodTitleEng = foodTitleEng;
        this.foodSub = foodSub;
        this.foodIng = foodIng;
        this.foodStep = foodStep;
        this.source = source;
    }
}
