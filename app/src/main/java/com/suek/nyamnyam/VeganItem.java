package com.suek.nyamnyam;

public class VeganItem {

    //recycler

    String file;  //배경음식화면
    String cat;
    String title;
    String sub;

    String ing;
    String step;

    public VeganItem() {
    }

    public VeganItem(String file, String cat, String title, String sub, String ing, String step) {
        this.file = file;
        this.cat = cat;
        this.title = title;
        this.sub = sub;
        this.ing = ing;
        this.step = step;
    }
}

