package com.example.beautysalon;

public class Price {
    public double servicePrice, productPrice, serviceDiscount, productDiscount, membershipDiscount;

    public Price(){
        servicePrice = productPrice = serviceDiscount = productDiscount = membershipDiscount = 0;
    }

    public Price(int servicePrice, int productPrice, int serviceDiscount, int productDiscount,int membership){
        this.servicePrice=servicePrice;
        this.productPrice=productPrice;
        this.serviceDiscount=serviceDiscount;
        this.productDiscount=productDiscount;
        this.membershipDiscount=membership;
    }

    public void resetDiscount(){
        this.serviceDiscount = 0;
        this.productDiscount = 0;
    }
}
