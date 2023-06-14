package hust.soict.dsai.aims.media;

import java.util.*;

public abstract class Media {

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    private int id;
    private String title;
    private String category;
    private float cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Media(){

    }

    public Media (String title, String category, float cost){
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    public Media(int id, String title, String category, float cost){
        this(title,category,cost);
        this.id = id;
    }


    @Override
    public boolean equals (Object o){
        if(this == o){
            return true;
        }
        if (!(o instanceof Track)) {
            return false;
        }
        Media media = (Media) o;
        return this.title.equals(media.title);
    }

    public String toString(){
        return "Id: "+ getId() + " title: " + getTitle() + ", category: "+ getCategory();
    }

//    public static void main(String[] args){
//        List<Media> mediae = new ArrayList<Media>();
//
//        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King",
//                "Animation", "Roger Allers", 87, 19.95f);
//
//        DigitalVideoDisc dvd1 = new DigitalVideoDisc("ABC",
//                "Animation", "Roger Allers", 87, 10.95f);
//
//        Disc cd = new Disc();
//
//        mediae.add(dvd);
//        mediae.add(dvd1);
//
//        for (Media m : mediae){
//            System.out.println(m.toString());
//        }
//        Collections.sort(mediae, COMPARE_BY_TITLE_COST);
//        for (Media m : mediae){
//            System.out.println(m.toString());
//        }
//    }
}
