package com.suek.nyamnyam;

import android.widget.EditText;

public class BoardItem {
    int no;
    String nickName;
    String profileUrl;

    String title;
    String msg;
    String file;       // ******  DB 에 저장되는 식별자와 글씨가 같아야함  *********
    String date;

    public BoardItem() {
    }

    public BoardItem(int no, String nickName, String profileUrl, String title, String msg, String file, String date) {
        this.no = no;
        this.nickName = nickName;
        this.profileUrl = profileUrl;
        this.title = title;
        this.msg = msg;
        this.file = file;
        this.date = date;
    }
}
