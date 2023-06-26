package hust.soict.dsai.aims.screen;


import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;
    private JPanel centerPanel;

    Container cp;
    private MenuItemListener menuItemListener = new MenuItemListener();
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

        JMenuItem addBook = new JMenuItem("Add Book");
        JMenuItem addCD = new JMenuItem("Add CD");
        JMenuItem addDVD = new JMenuItem("Add DVD");

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);

        addBook.addActionListener(menuItemListener);
        addCD.addActionListener(menuItemListener);
        addDVD.addActionListener(menuItemListener);

        menu.add(smUpdateStore);

        menu.add(new JMenuItem("View store"));

        JMenuItem viewCart = new JMenuItem("View cart");
        viewCart.addActionListener(menuItemListener);
        menu.add(viewCart);

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

        JButton cartView = new JButton("View cart");
        cartView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CartScreen(cart, store);
                setVisible(false);
            }
        });
        cartView.setPreferredSize(new Dimension (100,50));
        cartView.setMaximumSize(new Dimension(100,50));

        header.add(Box.createRigidArea(new Dimension(10,10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartView);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3,3,2,2));

        ObservableList<Media> mediaInStore = store.getItemsInStore();
        for(int i = 0; i<mediaInStore.size(); i++){
            MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
            center.add(cell);
        }

        return center;
    }

    public StoreScreen(Store store, Cart cart){
        this.store = store;
        this.cart = cart;

        cp = getContentPane();
        cp.setLayout(new BorderLayout());

        centerPanel = createCenter();
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(centerPanel,BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Store");
        setSize(1024,768);

    }

    private class MenuItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String menuItem = e.getActionCommand();
            if (menuItem.equals("Add Book")) {
                new AddBookToStoreScreen(store);
            }
            else if (menuItem.equals("Add CD")) {
                new AddCompactDiscToStoreScreen(store);
            }
            else if (menuItem.equals("Add DVD")) {
                new AddDigitalVideoDiscToStoreScreen(store);
            }
            else if(menuItem.equals("View cart")) {
                new CartScreen(cart, store);
                setVisible(false);
            }
        }
    }
}
