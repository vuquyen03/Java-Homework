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

    public void setCost(float cost) throws IllegalArgumentException{
        try{
            if (cost >= 0){
                this.cost = cost;
            } else {
                throw new IllegalArgumentException("ERROR: Cost cannot be negative");
            }
        } catch (IllegalArgumentException e){
            System.out.println("Cost cannot be negative");
        }
    }

    public Media(){

    }

    public Media (String title, String category, float cost) throws IllegalArgumentException{
        this.title = title;
        this.category = category;
        try {
            if (cost >= 0) {
                this.cost = cost;
            } else {
                throw new IllegalArgumentException("ERROR: Cost cannot be negative");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Cost cannot be negative");
        }
    }

    public Media(int id, String title, String category, float cost){
        this(title,category,cost);
        this.id = id;
    }


    @Override
    public boolean equals (Object o)  throws NullPointerException, ClassCastException{
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            try {
                if (o == null) {
                    throw new NullPointerException("ERROR: Object is null");
                } else {
                    throw new ClassCastException("ERROR: Class cast exception");
                }
            } catch (NullPointerException | ClassCastException enc) {
                return false;
            }
        }
        Media media = (Media) o;
        return this.title.equals(media.title);
    }

    public String toString(){
        return "Id: "+ getId() + " title: " + getTitle() + ", category: "+ getCategory();
    }

    public boolean search(String input) {
        if (title.contains(input)){
            return true;
        } else{
            return false;
        }
    }
}
