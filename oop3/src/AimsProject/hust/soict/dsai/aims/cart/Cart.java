package AimsProject.hust.soict.dsai.aims.cart;

import AimsProject.hust.soict.dsai.aims.disc.DigitalVideoDisc;

import java.util.*;

public class Cart {

    // maximum size of Cart
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<DigitalVideoDisc> itemsOrdered =
            new ArrayList<>();

    public int qtyOrdered() {
        return itemsOrdered.size();
    }

    // add DVD into itemsOrdered
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if(itemsOrdered.size() > 20) {
            System.out.println("The cart is almost full");
        }
        else {
            itemsOrdered.add(disc);
        }
    }

    // add each DVD from dvdList into the itemsOrdered
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
        for(DigitalVideoDisc disc : dvdList) {
            addDigitalVideoDisc(disc);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc  dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        itemsOrdered.remove(disc);
    }

    // find total cost of the cart
    public float totalCost() {
        float ans = 0;
        for(DigitalVideoDisc DVD : itemsOrdered) {
            ans += DVD.getCost();
        }
        return ans;
    }

    // show title of every dvd in cart
    public void showCart() {
        for(int i = 1; i<= itemsOrdered.size(); i++) {
            System.out.println(i+" "+itemsOrdered.get(i-1).getTitle());
        }
    }

    // search dvd by title
    public void searchByTitle(String title) {
        int index = 0;
        for(DigitalVideoDisc item : itemsOrdered) {
            String temp = item.getTitle().toUpperCase();
            if(temp.contains(title.toUpperCase())) {
                index += 1;
                System.out.println(index + " " + item.getTitle());
            }
        }
    }

    public void print() {
        System.out.println("CART");
        for (DigitalVideoDisc i : itemsOrdered) {
            System.out.println(i);
        }
        System.out.println("total cost = "+totalCost());
    }

    public void sortByTitle() {
        Collections.sort(itemsOrdered, new Comparator<DigitalVideoDisc>() {
            @Override
            public int compare(DigitalVideoDisc a, DigitalVideoDisc b) {
                // Use compareToIgnoreCase() to ignore character casing
                int result = a.getTitle().compareToIgnoreCase(b.getTitle());
                if (result != 0) {
                    // Titles are not equal, so sort by title ascending
                    return result;
                } else {
                    // Titles are equal, so sort by cost descending
                    return Float.compare(b.getCost(), a.getCost());
                }
            }
        });
    }
}