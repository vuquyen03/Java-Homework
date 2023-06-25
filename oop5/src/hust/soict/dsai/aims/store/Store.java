package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.*;

public class Store {
    public ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public void addMedia(Media media){
        itemsInStore.add(media);
    }

    public ArrayList<Media> getItemsInStore(){
        return itemsInStore;
    }

    public void removeMedia(Media media){
        if (itemsInStore.contains(media)){
            itemsInStore.remove(media);
        }
        else{
            System.out.println("This item doesn't exist");
        }
    }

    public ArrayList<Media> search(String title){
        ArrayList<Media> ans = new ArrayList<>();
        for(Media item : itemsInStore){
            if(item.getTitle().equals(title)){
                ans.add(item);
            }
        }
        return ans;
    }

}
