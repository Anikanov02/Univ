package com.flower_shop;

import com.flower_shop.accessories.Accessory;
import com.flower_shop.accessories.fastening.Ribbon;
import com.flower_shop.accessories.fastening.Rope;
import com.flower_shop.accessories.packing.Box;
import com.flower_shop.accessories.packing.PackingTape;
import com.flower_shop.accessories.packing.Paper;
import  com.flowers.Flower;
import com.flowers.Name;

import java.util.ArrayList;

public class Florist {


    public Bouquet makeBouquet(Warehouse warehouse, ArrayList<Flower> flowers) {
        Bouquet bouquet = new Bouquet();
        for (Flower flower : flowers) {
            if (warehouse.isAvaliable(flower)) {
                bouquet.addFlower(flower);
                warehouse.removeFlower(flower);
            }
        }
        return bouquet;
    }

    public Bouquet makeBouquet(Warehouse warehouse, Bouquets name) {
        switch (name) {
            case AUTUMN_DREAMS:
                return makeAutumnDreamsBouquet(warehouse);
            case MORNING_COMPLIMENT:
                return makeMorningComplimentBouquet(warehouse);
            case COLORS_OF_AUTUMN:
                return makeColorsOfAutumnBouquet(warehouse);
            case MOMENTS_OF_LOVE:
                return makeMomentsOfLoveBouquet(warehouse);
            default:
                return null;
        }
    }

    private Bouquet makeColorsOfAutumnBouquet(Warehouse warehouse) {
        ArrayList<Flower> for_bouquet = new ArrayList<Flower>();
        for_bouquet.add(warehouse.getFlower(Name.SUNFLOWER_TEDDYBEAR, Color.YELLOW));
        for_bouquet.add(warehouse.getFlower(Name.SUNFLOWER_TEDDYBEAR, Color.YELLOW));
        for_bouquet.add(warehouse.getFlower(Name.CHRYSANTHEMUM_DUNE, Color.ORANGE));
        for_bouquet.add(warehouse.getFlower(Name.CHRYSANTHEMUM_DUNE, Color.ORANGE));
        for_bouquet.add(warehouse.getFlower(Name.CHRYSANTHEMUM_ANASTASIA, Color.YELLOW));
        for_bouquet.add(warehouse.getFlower(Name.CHRYSANTHEMUM_ANASTASIA, Color.YELLOW));
        for_bouquet.add(warehouse.getFlower(Name.GYPSOPHILA_ELEGANS, Color.WHITE));
        for_bouquet.add(warehouse.getFlower(Name.GYPSOPHILA_ELEGANS, Color.WHITE));
        for_bouquet.add(warehouse.getFlower(Name.GERBERA_HELIOS, Color.YELLOW));
        for_bouquet.add(warehouse.getFlower(Name.GERBERA_HELIOS, Color.ORANGE));
        for_bouquet.add(warehouse.getFlower(Name.GERBERA_HELIOS, Color.RED));
        Bouquet result  = makeBouquet(warehouse, for_bouquet);
        result.addAccessory(new PackingTape(Color.WHITE));
        result.addAccessory(new Ribbon(Color.YELLOW));
        return result;
    }

    private Bouquet makeMomentsOfLoveBouquet(Warehouse warehouse) {
        ArrayList<Flower> for_bouquet = new ArrayList<Flower>();
        for_bouquet.add(warehouse.getFlower(Name.ROSE_CHERRYLOVE, Color.RED));
        for_bouquet.add(warehouse.getFlower(Name.ROSE_CHERRYLOVE, Color.RED));
        for_bouquet.add(warehouse.getFlower(Name.ROSE_CHERRYLOVE, Color.RED));
        for_bouquet.add(warehouse.getFlower(Name.ROSE_CHERRYLOVE, Color.RED));
        for_bouquet.add(warehouse.getFlower(Name.ROSE_CHERRYLOVE, Color.RED));
        for_bouquet.add(warehouse.getFlower(Name.ROSE_CHERRYLOVE, Color.RED));
        for_bouquet.add(warehouse.getFlower(Name.ROSE_CHERRYLOVE, Color.RED));
        for_bouquet.add(warehouse.getFlower(Name.ROSE_CHERRYLOVE, Color.RED));
        for_bouquet.add(warehouse.getFlower(Name.ROSE_CHERRYLOVE, Color.RED));
        for_bouquet.add(warehouse.getFlower(Name.ROSE_CHERRYLOVE, Color.RED));
        for_bouquet.add(warehouse.getFlower(Name.ROSE_CHERRYLOVE, Color.RED));
        Bouquet result = makeBouquet(warehouse, for_bouquet);
        result.addAccessory(new Ribbon(Color.WHITE));
        result.addAccessory(new Ribbon(Color.RED));
        return result;
    }

    private Bouquet makeAutumnDreamsBouquet(Warehouse warehouse) {
//        Троянда, гортензія, астільба, котінус, амарантус, капелюшна коробка
        ArrayList<Flower> for_bouquet = new ArrayList<Flower>();
        for_bouquet.add(warehouse.getFlower(Name.ROSE_ALOHA, Color.ORANGE));
        for_bouquet.add(warehouse.getFlower(Name.ROSE_ALOHA, Color.ORANGE));
        for_bouquet.add(warehouse.getFlower(Name.ROSE_ALOHA, Color.ORANGE));
        for_bouquet.add(warehouse.getFlower(Name.HYDRANGEA_MACROPHYLLA, Color.PURPLE));
        for_bouquet.add(warehouse.getFlower(Name.HYDRANGEA_MACROPHYLLA, Color.PURPLE));
        for_bouquet.add(warehouse.getFlower(Name.HYDRANGEA_MACROPHYLLA, Color.PURPLE));
        for_bouquet.add(warehouse.getFlower(Name.GERBERA_HELIOS, Color.ORANGE));
        for_bouquet.add(warehouse.getFlower(Name.GERBERA_HELIOS, Color.ORANGE));
        for_bouquet.add(warehouse.getFlower(Name.GERBERA_HELIOS, Color.RED));
        for_bouquet.add(warehouse.getFlower(Name.GERBERA_HELIOS, Color.RED));
        for_bouquet.add(warehouse.getFlower(Name.GERBERA_HELIOS, Color.RED));
        Bouquet result = makeBouquet(warehouse, for_bouquet);
        result.addAccessory(new Paper(Color.YELLOW));
        result.addAccessory(new Rope(Color.RED));
        return result;
    }

    private Bouquet makeMorningComplimentBouquet(Warehouse warehouse) {
        ArrayList<Flower> for_bouquet = new ArrayList<Flower>();
        for_bouquet.add(warehouse.getFlower(Name.ROSE_AKITO, Color.WHITE));
        for_bouquet.add(warehouse.getFlower(Name.ROSE_AKITO, Color.WHITE));
        for_bouquet.add(warehouse.getFlower(Name.ROSE_AKITO, Color.WHITE));
        for_bouquet.add(warehouse.getFlower(Name.ROSE_AKITO, Color.WHITE));
        for_bouquet.add(warehouse.getFlower(Name.EUSTOMA_ROSITA, Color.GREEN));
        for_bouquet.add(warehouse.getFlower(Name.EUSTOMA_ROSITA, Color.GREEN));
        for_bouquet.add(warehouse.getFlower(Name.EUSTOMA_ROSITA, Color.WHITE));
        for_bouquet.add(warehouse.getFlower(Name.EUSTOMA_ROSITA, Color.WHITE));
        for_bouquet.add(warehouse.getFlower(Name.CONVALLARIA_LILYOFTHEVALLEY, Color.WHITE));
        for_bouquet.add(warehouse.getFlower(Name.CONVALLARIA_LILYOFTHEVALLEY, Color.WHITE));
        for_bouquet.add(warehouse.getFlower(Name.CONVALLARIA_LILYOFTHEVALLEY, Color.WHITE));
        for_bouquet.add(warehouse.getFlower(Name.GYPSOPHILA_ELEGANS, Color.WHITE));
        for_bouquet.add(warehouse.getFlower(Name.GYPSOPHILA_ELEGANS, Color.WHITE));
        Bouquet result = makeBouquet(warehouse, for_bouquet);
        result.addAccessory(new Box(Color.WHITE));
        result.addAccessory(new Ribbon(Color.GREEN));
        return result;
    }
}
