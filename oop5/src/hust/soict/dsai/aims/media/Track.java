package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable{
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public Track(){

    }
    public Track(String title, int length) throws IllegalArgumentException  {
        super();
        this.title = title;
        if (length <= 0) {
            throw new IllegalArgumentException("Disc length must be positive");
        }
        else {
            this.length = length;
        }
    }

    public void play() throws PlayerException {
        if (this.getLength() > 0){
            System.out.println("Track: " + getTitle());
        } else {
            String errorMessage = "ERROR: Track length is non positive!";
            System.err.println(errorMessage);
            throw new PlayerException(errorMessage);
        }
    }

    @Override
    public boolean equals (Object o){
        if(this == o){
            return true;
        }
        if (!(o instanceof Track)) {
            return false;
        }
        Track track = (Track) o;
        return this.title.equals(track.title) && this.length == (track.length);
    }
}
