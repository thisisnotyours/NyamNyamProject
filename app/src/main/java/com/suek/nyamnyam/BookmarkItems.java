package com.suek.nyamnyam;

public class BookmarkItems {


    String civ;
    String foodTitle;
    String foodSub;

    String deleteFav;



    //전달할 데이터 추가해주기
    String foodMsg;
    String foodBackground;



    public BookmarkItems() {
    }




    public BookmarkItems(String civ, String foodTitle, String foodSub) {
        this.civ = civ;
        this.foodTitle = foodTitle;
        this.foodSub = foodSub;
    }



    public BookmarkItems(String deleteFav) {
        this.deleteFav = deleteFav;
    }



    public BookmarkItems(String civ, String foodTitle, String foodSub, String foodMsg, String foodBackground) {
        this.civ = civ;
        this.foodTitle = foodTitle;
        this.foodSub = foodSub;
        this.foodMsg = foodMsg;
        this.foodBackground = foodBackground;

    }


}
