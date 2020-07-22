package com.suek.nyamnyam;

 //닷홈에 저장된 데이터를 불러올 때 쓰임?

public class HowToCookItem {
    int no;  //아이템 번호
    String file;  //음식이미지 경로
    String cat;   //음식 카테고리 : VEGAN
    String title; //음식 타이틀- eng : Sanchae Bibimbap
    String sub;   //음식 sub-kor: 산채비빔밥
    String ing;   //음식 재료 내용
    String step;  //요리 스텝 내용

    public HowToCookItem() {
    }

    public HowToCookItem(int no, String file, String cat, String title, String sub, String ing, String step) {
        this.no = no;
        this.file = file;
        this.cat = cat;
        this.title = title;
        this.sub = sub;
        this.ing = ing;
        this.step = step;
    }
}
