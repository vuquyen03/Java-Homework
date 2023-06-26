package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;
    private String director;
    private int length;

    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }

    public DigitalVideoDisc(String title) {
        super();
        this.setTitle(title);
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title,category,cost);
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, float cost, String director, int length){
        super(title,category,cost);
        this.director = director;
        this.length = length;
    }


    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title,category,cost);
        this.director = director;
        this.length = length;
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id,title,category,cost,length,director);
        nbDigitalVideoDiscs++;
    }

    public String toString() {
        return "DVD: " +getTitle() + "-" + getCategory() + "-" +getDirector() + "-" + getLength() + "-" + getCost();
    }

    public void play() throws PlayerException {
        if (this.getLength() > 0){
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            String errorMessage = "ERROR: DVD length is non positive!";
            System.err.println(errorMessage);
            throw new PlayerException(errorMessage);
        }
    }
}

