package hust.soict.dsai.aims.media;

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
    public Track(String title, int length){
        this.length = length;
        this.title= title;
    }

    public void play(){
        System.out.println("Track: " + getTitle());
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
