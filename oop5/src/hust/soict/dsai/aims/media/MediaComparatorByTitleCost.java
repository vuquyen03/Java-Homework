package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        int titleComparison = o1.getTitle().compareTo(o2.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        } else {
            if (o1.getCost() > o2.getCost()) {
                return -1;
            } else if (o1.getCost() < o2.getCost()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
