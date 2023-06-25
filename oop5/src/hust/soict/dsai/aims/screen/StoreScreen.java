package hust.soict.dsai.aims.screen;


import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StoreScreen extends JFrame {
    private Store store;
    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar(){
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font (title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension (100,50));
        cart.setMaximumSize(new Dimension(100,50));

        header.add(Box.createRigidArea(new Dimension(10,10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3,3,2,2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for(int i = 0; i<mediaInStore.size(); i++){
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    public StoreScreen(Store store){
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(),BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Store");
        setSize(1024,768);
    }

    public static void main(String[] args){
        Store store = new Store();
        store.addMedia(new Book(4,"Life of Pi", "Adventure fiction", 18.10f));
        store.addMedia(new DigitalVideoDisc(1,"The Lion King",
                "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new Book(2,"SpiderMan", "Animation", 10.95f));
        store.addMedia(new Book(3,"SuperMan", "Animation", 8.95f));
        store.addMedia(new Book(5,"Doraemon", "Animation", 5.95f));
        store.addMedia(new Book(6,"AntMan", "Animation", 10.95f));
        store.addMedia(new DigitalVideoDisc(7,"Aladin",
                "Live action", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc(8,"The Little Mermaid",
                "Live action", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc(9,"The Lion King",
                "Animation", "Roger Allers", 87, 19.95f));

        new StoreScreen(store);
    }
}
