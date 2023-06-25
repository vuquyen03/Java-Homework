package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks;

    public String getArtist() {
        return artist;
    }

    public CompactDisc(int id, String title, String category, float cost, int length,
                       String artist, ArrayList<Track> tracks, String director) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(String title, String category, float cost, String director, String artist){
        super(title,category,cost);
        this.setDirector(director);
        this.artist = artist;
    }

    public CompactDisc(int id, String title, String category, float cost,
                       String artist, ArrayList<Track> tracks, String director) {
        super(title,category,cost);
        this.setId(id);
        this.artist = artist;
        this.tracks = tracks;
        this.setDirector(director);
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("This track already exists");
        } else {
            tracks.add(track);
        }
    }

    public void removeTrack(Track track) {
        if (!tracks.contains(track)) {
            System.out.println("This track doesn't exist");
        } else {
            tracks.remove(track);
        }
    }

    public int getLength() {
        int ans = 0;
        for (Track track : tracks) {
            ans += track.getLength();
        }
        return ans;
    }

    public void play() throws PlayerException {
        if(this.getLength() > 0){
            Iterator iter = tracks.iterator();
            Track nextTrack;
            while (iter.hasNext()){
                nextTrack = (Track) iter.next();
                try {
                    nextTrack.play();
                } catch (PlayerException e){
                    throw e;
                }
            }
        } else{
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Id: "+ getId() +'\n');
        sb.append("Title: "+ getTitle() +'\n');
        sb.append("Category: "+ getCategory() +'\n');
        sb.append("Cost: "+ getCost() +'\n');
        for (Track track : tracks) {
            sb.append("Track: " +track.getTitle());
            sb.append("\n");
        }
        return sb.toString();
    }
}
