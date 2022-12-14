package com.flower_shop;

import com.flower_shop.accessories.Accessory;
import com.flower_shop.accessories.decoration.DecorationAccessory;
import com.flower_shop.accessories.fastening.FasteningAccessory;
import com.flower_shop.accessories.packing.PackingAccessory;
import  com.flowers.Flower;

import java.util.ArrayList;

public class Bouquet {
    private ArrayList<Flower> flowers;
    private PackingAccessory packing;
    private FasteningAccessory fastening;
    private DecorationAccessory decoration;
    private Integer price;

    public Bouquet( ) {
        this.flowers = new ArrayList<>();
        this.packing = null;
        this.fastening = null;
        this.decoration = null;
        this.price = 0;
    }

    public Bouquet( ArrayList<Flower> flowers) {
        this.flowers = flowers;
        this.price = 0;
        for (Flower flower : flowers) {
            this.price += flower.getPrice();
        }
    }

    public Bouquet( ArrayList<Flower> flowers, PackingAccessory packing, FasteningAccessory fastening) {
        this.flowers = flowers;
        this.price = 0;
        for (Flower flower : flowers) {
            this.price += flower.getPrice();
        }
        this.packing = packing;
        this.fastening = fastening;
    }

    public Bouquet( ArrayList<Flower> flowers, PackingAccessory packing, FasteningAccessory fastening, DecorationAccessory decoration) {
        this.flowers = flowers;
        this.price = 0;
        for (Flower flower : flowers) {
            this.price += flower.getPrice();
        }
        this.packing = packing;
        this.fastening = fastening;
        this.decoration = decoration;
    }

    public  ArrayList<Flower> getFlowers() {
        return flowers;
    }

    public Integer getPrice() {
        return price;
    }

    public void printBouquet() {
        System.out.println("\nBouquet price: " + price + "₴\n");
        for (Flower flower : flowers) {
            System.out.println(flower.getName() + " " + flower.getColor() + " " + flower.getPrice() + "₴");
        }
        if (packing != null) {
            System.out.println("Packed in: " + packing.getName() + " " + packing.getColor() + " " + packing.getPrice() + "₴");
        }
        if (fastening != null) {
            System.out.println("With: " + fastening.getName() + " " + fastening.getColor() + " " + fastening.getPrice() + "₴");
        }
        if (decoration != null) {
            System.out.println("With: " + decoration.getName() + " " + decoration.getColor() + " " + decoration.getPrice() + "₴");
        }
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
        price += flower.getPrice();
    }

    public void addAccessory(Accessory accessory) {
        if (accessory instanceof PackingAccessory) {
            packing = (PackingAccessory) accessory;
        } else if (accessory instanceof FasteningAccessory) {
            fastening = (FasteningAccessory) accessory;
        } else if (accessory instanceof DecorationAccessory) {
            decoration = (DecorationAccessory) accessory;
        }
        price += accessory.getPrice();
    }


    public  void sortByFreshness(){
        flowers.sort((o1, o2) -> o1.getFreshness().compareTo(o2.getFreshness()));
    }

    public ArrayList<Flower> getFlowersByLength(int length_min, int length_max){
        ArrayList<Flower> res_flowers = new ArrayList<>();
        for (Flower flower : flowers) {
            if (flower.getHeight() >= length_min && flower.getHeight() <= length_max) {
                res_flowers.add(flower);
            }
        }
        if (res_flowers.size() > 0) {
            return res_flowers;
        }
        return null;
    }

}
