package AimsProject.src.hust.soict.aims.store;

import AimsProject.src.hust.soict.aims.disc.DigitalVideoDisc;

import java.util.*;

public class Store {
    ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();

    public void addDVD(DigitalVideoDisc dvd) {
        itemsInStore.add(dvd);
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        if (itemsInStore.contains(dvd)){
            itemsInStore.remove(dvd);
        }
    }
}
