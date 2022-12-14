package com.flower_shop;

import com.flower_shop.accessories.fastening.Ribbon;
import com.flower_shop.accessories.packing.PackingTape;
import  com.flowers.Flower;
import com.flowers.Name;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Florist florist = new Florist();
        warehouse.buyingFlowers(4, "2022-09-23");
        warehouse.buyingFlowers(6, "2022-09-24");
        warehouse.buyingFlowers(4, "2022-09-22");
        warehouse.buyingFlowers(3, "2022-09-20");
        warehouse.buyingFlowers(6, "2022-09-25");
        interfaceRun(warehouse,florist);
    }

    public static void interfaceRun(Warehouse warehouse, Florist florist){
        while (true){
            System.out.println("Buy bouquet: ");
            System.out.println((Bouquets.AUTUMN_DREAMS.ordinal() + 1) + " - Autumn dreams");
            System.out.println((Bouquets.MORNING_COMPLIMENT.ordinal() + 1) + " - Morning compliment");
            System.out.println((Bouquets.COLORS_OF_AUTUMN.ordinal() + 1) + " - Colors of autumn");
            System.out.println((Bouquets.MOMENTS_OF_LOVE.ordinal() + 1) + " - Moments of love");
            System.out.println("0 - Exit");
            System.out.println("Enter the number of bouquet: ");
            Scanner scanner = new Scanner(System.in);
            int bouquet_number = scanner.nextInt();
            Bouquet bouquet = null;
            switch (bouquet_number)
            {
                case 1:
                    System.out.println("You choose 'Autumn dreams'");
                    bouquet = florist.makeBouquet(warehouse, Bouquets.AUTUMN_DREAMS);
                    break;
                case 2:
                    System.out.println("You choose 'Morning compliment'");
                    bouquet = florist.makeBouquet(warehouse, Bouquets.MORNING_COMPLIMENT);
                    break;
                case 3:
                    System.out.println("You choose 'Colors of autumn'");
                    bouquet = florist.makeBouquet(warehouse, Bouquets.COLORS_OF_AUTUMN);
                    break;
                case 4:
                    System.out.println("You choose 'Moments of love'");
                    bouquet = florist.makeBouquet(warehouse, Bouquets.MOMENTS_OF_LOVE);
                    break;
                case 0:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Incorrect number");
                    break;
            }
            System.out.println("Sort by freshness: ");
            bouquet.sortByFreshness();
            bouquet.printBouquet();

            System.out.println("Find by length: ");
            System.out.println("Enter min length: ");
            int length_min = scanner.nextInt();
            System.out.println("Enter max length: ");
            int length_max = scanner.nextInt();
            ArrayList<Flower> flowers = bouquet.getFlowersByLength(length_min, length_max);
            if (flowers.size() == 0){
                System.out.println("Flowers not found");
            }
            else {
                for (Flower flower : flowers) {
                    System.out.println(flower.getName() + " " + flower.getHeight());
                }
            }

            System.out.println("One more bouquet? (y/n)");
            String answer = scanner.next();
            if (answer.equals("n")|| answer.equals("N")) {
                return;
            }
        }
    }


}
