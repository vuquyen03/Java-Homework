package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class Store {
    private ObservableList<Media> itemsInStore = FXCollections.observableArrayList();

    public void addMedia(Media media){
        if (itemsInStore.contains(media)){
            System.out.println("This item exists");
        } else{
            itemsInStore.add(media);
        }
    }

    public ObservableList<Media> getItemsInStore(){
        return itemsInStore;
    }

    public void removeMedia(Media media){
        if (itemsInStore.contains(media)){
            itemsInStore.remove(media);
        }
        else {
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
