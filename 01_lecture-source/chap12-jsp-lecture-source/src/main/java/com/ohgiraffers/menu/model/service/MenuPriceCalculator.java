package com.ohgiraffers.menu.model.service;

public class MenuPriceCalculator {
    public int calcOrderPrice(String menuName, int count) {
        int orderPrice = 0;
        switch (menuName){
            case "햄버거" :
                orderPrice=9800*count;
                break;
            case "짜장면" :
                orderPrice=8000*count;
                break;
            case "짬뽕" :
                orderPrice=8500*count;
                break;
            case "순대국" :
                orderPrice=9000*count;
                break;


        }

        return orderPrice;
    }
}
