package com.flower_shop;

import  com.flowers.Flower;
import  com.flowers.Name;
import com.flowers.big.hydrangea.Macrophylla;
import com.flowers.big.hydrangea.Paniculata;
import com.flowers.big.hydrangea.Petiolaris;
import com.flowers.big.lily.Asiatic;
import com.flowers.big.lily.Martagon;
import com.flowers.big.lily.Oriental;
import com.flowers.big.peony.FestivaMaxima;
import com.flowers.big.peony.Kansas;
import com.flowers.big.peony.SarahBernhardt;
import com.flowers.big.sunflower.AutumnBeauty;
import com.flowers.big.sunflower.Chianti;
import com.flowers.big.sunflower.TeddyBear;
import com.flowers.middle.chrysanthemum.Anastasia;
import com.flowers.middle.chrysanthemum.Dune;
import com.flowers.middle.chrysanthemum.Gazele;
import com.flowers.middle.chrysanthemum.Inga;
import com.flowers.middle.eustoma.Corelli;
import com.flowers.middle.eustoma.Echo;
import com.flowers.middle.eustoma.Mariachi;
import com.flowers.middle.eustoma.Rosita;
import com.flowers.middle.gerbera.Helios;
import com.flowers.middle.gerbera.Romeo;
import com.flowers.middle.gerbera.Tamara;
import com.flowers.middle.gerbera.Vincent;
import com.flowers.middle.rose.*;
import com.flowers.middle.tulip.Albatros;
import com.flowers.middle.tulip.Brest;
import com.flowers.middle.tulip.Cummins;
import com.flowers.middle.tulip.Gabriella;
import com.flowers.small.convallaria.LilyOfTheValley;
import com.flowers.small.gypsophila.Elegans;
import com.flowers.small.gypsophila.Repens;
import com.flowers.small.myosotis.BlueBall;
import com.flowers.small.myosotis.Indigo;
import com.flowers.small.myosotis.SnowQueen;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private Map<Flower, Integer> flowers;

    public Warehouse() {
        flowers = new HashMap<Flower, Integer>();
    }

    public void addFlower(Flower flower) {
        flowers.put(realFlowerInWarehouse(flower), getCount(flower) + 1);
    }

    public Flower realFlowerInWarehouse(Flower flower) {
        for (Map.Entry<Flower, Integer> f : flowers.entrySet()){
            if (f.getKey().getName() == flower.getName() && f.getKey().getColor() == flower.getColor()) {
                return f.getKey();
            }
        }
        return flower;
    }

    public void removeFlower(Flower flower) {
        removeFlower(flower.getName(), flower.getColor());
    }

    public void removeFlower(Name name, Color color) {
        for (Map.Entry<Flower, Integer> f : flowers.entrySet()){
            if (f.getKey().getName() == name && f.getKey().getColor() == color) {
                if (f.getValue() > 0) {
                    flowers.put(f.getKey(), f.getValue() - 1);
                }
            }
        }
    }

    public boolean isAvaliable(Flower flower) {
        return getCount(flower) > 0;
    }

    public boolean isAvaliable(Name name, Color color) {
        return getCount(name, color) > 0;
    }

    public Flower getFlower(Name name, Color color) {
        for (Map.Entry<Flower, Integer> f : flowers.entrySet()){
            if (f.getKey().getName() == name && f.getKey().getColor() == color) {
                removeFlower(f.getKey());
                return f.getKey();
            }
        }
        return null;
    }


    public Integer getCount(Flower flower) {
        return getCount(flower.getName(), flower.getColor());
    }

    public Integer getCount(Name name, Color color) {
        for (Map.Entry<Flower, Integer> f : flowers.entrySet()){
            if (f.getKey().getName() == name && f.getKey().getColor() == color) {
                return f.getValue();
            }
        }
        return 0;
    }

    public void printFlowerCount() {
        for (Map.Entry<Flower, Integer> f : flowers.entrySet())
            System.out.println(f.getKey().getName() + " " + f.getKey().getColor() +
                    " " + f.getValue());
    }

    public void buyingFlowers(Integer count, String date) {
        for (int i = 0; i < count; i++) {
            buyingFlowers(date);
        }
    }

    public void buyingFlowers(String date) {
        addFlower(new Macrophylla(Color.PURPLE, 120, date));
        addFlower(new Macrophylla(Color.BLUE, 120, date));
        addFlower(new Macrophylla(Color.PINK, 100, date));
        addFlower(new Paniculata(Color.WHITE, 110, date));
        addFlower(new Paniculata(Color.PINK, 120, date));
        addFlower(new Petiolaris(Color.WHITE, 115, date));

        addFlower(new Asiatic(Color.WHITE, 90, date));
        addFlower(new Asiatic(Color.YELLOW, 100, date));
        addFlower(new Asiatic(Color.RED, 110, date));
        addFlower(new Martagon(Color.PINK, 90, date));
        addFlower(new Martagon(Color.YELLOW, 100, date));
        addFlower(new Martagon(Color.VIOLET, 110, date));
        addFlower(new Oriental(Color.PINK, 90, date));
        addFlower(new Oriental(Color.ORANGE, 95, date));
        addFlower(new Oriental(Color.WHITE, 105, date));

        addFlower(new FestivaMaxima(Color.WHITE, 93, date));
        addFlower(new Kansas(Color.CRIMSON, 80, date));
        addFlower(new SarahBernhardt(Color.PINK, 80, date));

        addFlower(new AutumnBeauty(Color.ORANGE, 100, date));
        addFlower(new AutumnBeauty(Color.YELLOW, 100, date));
        addFlower(new Chianti(Color.BURGUNDY, 85, date));
        addFlower(new TeddyBear(Color.YELLOW, 90, date));


        addFlower(new Anastasia(Color.GREEN, 50, date));
        addFlower(new Anastasia(Color.WHITE, 55, date));
        addFlower(new Anastasia(Color.PINK, 45, date));
        addFlower(new Anastasia(Color.YELLOW, 40, date));
        addFlower(new Dune(Color.YELLOW, 30, date));
        addFlower(new Dune(Color.ORANGE, 35, date));
        addFlower(new Gazele(Color.WHITE, 45, date));
        addFlower(new Gazele(Color.YELLOW, 50, date));
        addFlower(new Gazele(Color.VIOLET, 40, date));
        addFlower(new Inga(Color.WHITE, 35, date));
        addFlower(new Inga(Color.YELLOW, 35, date));

        addFlower(new Corelli(Color.PINK, 45, date));
        addFlower(new Corelli(Color.VIOLET, 45, date));
        addFlower(new Echo(Color.WHITE, 35, date));
        addFlower(new Echo(Color.PINK, 35, date));
        addFlower(new Echo(Color.VIOLET, 35, date));
        addFlower(new Mariachi(Color.WHITE, 40, date));
        addFlower(new Mariachi(Color.YELLOW, 40, date));
        addFlower(new Mariachi(Color.VIOLET, 40, date));
        addFlower(new Rosita(Color.WHITE, 30, date));
        addFlower(new Rosita(Color.PINK, 30, date));
        addFlower(new Rosita(Color.VIOLET, 30, date));
        addFlower(new Rosita(Color.GREEN, 30, date));

        addFlower(new Helios(Color.YELLOW, 35, date));
        addFlower(new Helios(Color.ORANGE, 35, date));
        addFlower(new Helios(Color.RED, 35, date));
        addFlower(new Romeo(Color.ORANGE, 30, date));
        addFlower(new Romeo(Color.RED, 30, date));
        addFlower(new Romeo(Color.PINK, 30, date));
        addFlower(new Tamara(Color.BURGUNDY, 40, date));
        addFlower(new Tamara(Color.ORANGE, 40, date));
        addFlower(new Tamara(Color.YELLOW, 40, date));
        addFlower(new Vincent(Color.YELLOW, 35, date));
        addFlower(new Vincent(Color.PINK, 35, date));
        addFlower(new Vincent(Color.RED, 35, date));

        addFlower(new Akito(Color.PINK, 50, date));
        addFlower(new Akito(Color.WHITE, 50, date));
        addFlower(new Aloha(Color.ORANGE, 50, date));
        addFlower(new Aloha(Color.PINK, 50, date));
        addFlower(new Amsterdam(Color.CORAL, 80, date));
        addFlower(new CherryLove(Color.RED, 75, date));
        addFlower(new Engagement(Color.CREAM, 75, date));
        addFlower(new GoldStrike(Color.YELLOW, 70, date));
        addFlower(new Kiko(Color.CRIMSON, 75, date));

        addFlower(new Albatros(Color.WHITE, 25, date));
        addFlower(new Brest(Color.RED, 27, date));
        addFlower(new Cummins(Color.VIOLET, 30, date));
        addFlower(new Gabriella(Color.PINK, 33, date));


        addFlower(new LilyOfTheValley(Color.WHITE, 15, date));

        addFlower(new Elegans(Color.WHITE, 30, date));
        addFlower(new Repens(Color.WHITE, 35, date));
        addFlower(new Repens(Color.PINK, 25, date));
        addFlower(new Repens(Color.VIOLET, 30, date));

        addFlower(new BlueBall(Color.BLUE, 15, date));
        addFlower(new Indigo(Color.BLUE, 15, date));
        addFlower(new SnowQueen(Color.WHITE, 20, date));
    }
}


