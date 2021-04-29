package com.suek.nyamnyam;

public class CalendarItem {
    int no;       //아이템번호
    String name;  //작성자 : 개발자만 쓸수있음
    String date;  //특정한 날짜 : 8.15
    String title; //제목 : 광복절
    String msg;   //내용 : National Liberation Day
    String file;  //이미지 경로

    public CalendarItem() {
    }

    public CalendarItem(int no, String name, String date, String title, String msg, String file) {
        this.no = no;
        this.name = name;
        this.date = date;
        this.title = title;
        this.msg = msg;
        this.file = file;
    }
}
