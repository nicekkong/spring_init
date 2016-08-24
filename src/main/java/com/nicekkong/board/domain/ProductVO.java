/******************************************************
 * Project Name :  spring_board
 * File Name : ProductVO.java
 * Author : nicekkong@gmail.com
 * Create Date : 2016. 8. 25. 오전 1:36
 * Description : 
 ******************************************************/

package com.nicekkong.board.domain;

public class ProductVO {

    private String name;
    private double price;

    public ProductVO(){}

    public ProductVO(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public ProductVO setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public ProductVO setPrice(double price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return "ProductVO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
