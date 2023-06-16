package OtherProjects.hust.soict.dsai.lab02;

import java.util.*;


public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<DigitalVideoDisc> itemsOrdered =
            new ArrayList<>();

    public int qtyOrdered() {
        return itemsOrdered.size();
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if(itemsOrdered.size() > 20) {
            System.out.println("The cart is almost full");
        }
        else {
            itemsOrdered.add(disc);
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        itemsOrdered.remove(disc);
    }

    public float totalCost() {
        float ans = 0;
        for(DigitalVideoDisc DVD : itemsOrdered) {
            ans += DVD.getCost();
        }
        return ans;
    }

    public void showCart() {
        for(int i = 1; i<= itemsOrdered.size(); i++) {
            System.out.println(i+" "+itemsOrdered.get(i-1).getTitle());
        }
    }

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