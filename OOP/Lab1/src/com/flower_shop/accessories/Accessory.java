package com.flower_shop.accessories;

import com.flower_shop.Color;

public class Accessory {
    protected AccessoryName name;
    protected Integer price;
    protected Color color;

    public Accessory(Color color) {
        setName();
        setColor(color);
        setPrice();
    }

    public void setPrice(){
        this.price = 0;
    }

    public void setPrice(Integer price){
        this.price = price;
    }

    protected void setColor(Color color){ this.color = color;}

    public Color getColor() {return color;}

    protected void setName (){
        this.name = null;
    }

    public AccessoryName getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


}
