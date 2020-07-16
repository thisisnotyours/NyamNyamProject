package com.suek.nyamnyam;

public class MyPostItem {
    int no;
    String title;
    String msg;
    String file;
    String date;

    public MyPostItem() {
    }

    public MyPostItem(int no, String title, String msg, String file, String date) {
        this.no = no;
        this.title = title;
        this.msg = msg;
        this.file = file;
        this.date = date;
    }
}
