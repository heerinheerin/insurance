package com.Myproject.insurance.constant;

public enum Category { // 지역별
    //
    SEOUL("서울특별시"),
    GYEONGGI("경기도"),
    INCHEON("인천광역시"),
    GANGWON("강원특별자치도"),
    DAEJEON("대전광역시"),
    GWANGJU("광주광역시"),
    BUSAN("부산광역시"),
    JEJU("제주특별자치도"),

    // 업종별
    FOODSERVICE("외식·음료"),
    SHOPSELL("매장관리·판매"),
    SERVICE("서비스"),
    OFFICEJOP("사무직"),
    IT("IT·개발"),
    COUNSEL("고객상담"),
    DELIVERY("운전·배달");


    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
