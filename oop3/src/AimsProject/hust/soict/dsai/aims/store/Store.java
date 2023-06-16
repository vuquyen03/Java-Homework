package AimsProject.hust.soict.dsai.aims.store;

import AimsProject.hust.soict.dsai.aims.disc.DigitalVideoDisc;

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