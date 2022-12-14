package com.flowers;

import com.flower_shop.Color;

import java.time.LocalDate;
import java.time.Period;


public abstract class Flower {
    protected Name name;
    protected Color color;
    protected Integer price;
    protected Integer height;
    protected LocalDate delivery_date;

    public Flower(Color color, Integer height, String delivery_date) {
        setName();
        setColor(color);
        setHeight(height);
        setDate(delivery_date);
        setPrice();
    }

    public Name getName() {return name;}

    public Color getColor() {
        return color;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getHeight() {return height;}

    public LocalDate getDeliveryDate() {return delivery_date;}

    public Integer getFreshness(){
        return Period.between(delivery_date, LocalDate.now()).getDays();
    }

    protected void setHeight(Integer height){
        if (height >= 10 && height <= 150) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Height is not valid");
        }
    }

    public void setPrice(){
        this.price = 0;
    }
    public void setPrice(Integer price){
        this.price = price;
    }


    protected void setColor(Color color){
        if (true) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color is not valid");
        }
    }

    protected void setName (){
        this.name = null;
    }

    protected void setDate(String delivery_date){
        if (LocalDate.now().isAfter(LocalDate.parse(delivery_date)) || LocalDate.now().isEqual(LocalDate.parse(delivery_date))) {
            this.delivery_date = LocalDate.parse(delivery_date);
            if (!CheckFreshness()) {
                throw new IllegalArgumentException("Flower is too old");
            }
        } else {
            throw new IllegalArgumentException("Date is not valid");
        }
    }

    public boolean CheckFreshness(){
        return getFreshness() < 10;
    }
}
