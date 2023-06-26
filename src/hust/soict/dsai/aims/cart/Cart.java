package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.*;

public class Cart {

    // maximum size of Cart
    public static final int MAX_NUMBERS_ORDERED = 20;

    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public ArrayList<Media> getItems(){
        return itemsOrdered;
    }
    public int getSize(){
        return itemsOrdered.size();
    }
    public void addMedia(Media media){
        if(itemsOrdered.contains(media)){
            System.out.println("This media already exists");
        }else{
            itemsOrdered.add(media);
        }
    }

    // remove media in cart
    public void removeMedia(Media media){
        if(itemsOrdered.size() == 0){
            System.out.println("This media is empty");
        } else if(!itemsOrdered.contains(media)){
            System.out.println("This media doesn't exist");
        } else{
            itemsOrdered.remove(media);
        }
    }

    public void clear(){
        itemsOrdered.clear();
    }

    // find total cost of the cart
    public float totalCost() {
        float ans = 0;
        for(Media media : itemsOrdered) {
            ans += media.getCost();
        }
        return ans;
    }

    // show title of every dvd in cart
    public void showCart() {
        for(int i = 1; i<= itemsOrdered.size(); i++) {
            System.out.println(i+" "+itemsOrdered.get(i-1).getTitle());
        }
    }

    // search by title
    public void searchByTitle(String title) {
        int index = 0;
        for(Media item : itemsOrdered) {
            String temp = item.getTitle().toUpperCase();
            if(temp.contains(title.toUpperCase())) {
                index += 1;
                System.out.println(index + " " + item.getTitle());
            }
        }
    }

    // print total cost
    public void print() {
        System.out.println("CART");
        for (Media i : itemsOrdered) {
            System.out.println(i);
        }
        System.out.println("total cost = " + totalCost());
        System.out.println("------------------------------");
    }

}
