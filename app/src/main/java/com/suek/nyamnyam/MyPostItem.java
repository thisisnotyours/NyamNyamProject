package com.suek.nyamnyam;

public class MyPostItem {

    //로그인정보
    String nickName;
    String profileUrl;

    int no;
    String title;
    String msg;
    String file;
    String date;

    public MyPostItem() {
    }

    public MyPostItem(String nickName, String profileUrl, int no, String title, String msg, String file, String date) {
        this.nickName = nickName;
        this.profileUrl = profileUrl;
        this.no = no;
        this.title = title;
        this.msg = msg;
        this.file = file;
        this.date = date;
    }
}
