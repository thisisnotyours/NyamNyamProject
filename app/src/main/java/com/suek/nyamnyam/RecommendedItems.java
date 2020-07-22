package com.suek.nyamnyam;

public class RecommendedItems {
    String iv;
    String foodtTitle;

    //위의 참조변수 + 각 아이템을 누르면 howToCook 에서 보여지는 데이터들..-> 안보여짐
    /*String foodCat;  //카테고리 : vegan
    String foodSub;
    String foodIng;
    String foodStep;*/



    public RecommendedItems() {
    }

    public RecommendedItems(String iv, String foodtTitle) {
        this.iv = iv;
        this.foodtTitle = foodtTitle;
    }
}
