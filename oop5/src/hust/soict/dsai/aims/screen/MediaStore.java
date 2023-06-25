package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import javax.naming.LimitExceededException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private Cart cart;
    private Media media;
    public MediaStore(Media media, Cart cart){
        super();
        this.media = media;
        this.cart = cart;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog();
                dialog.setLayout(new BorderLayout());
                dialog.setTitle("Playing Box");

                JLabel l = new JLabel("You are playing " + media.getTitle());
                dialog.add(l,BorderLayout.CENTER);
                dialog.setSize(200, 200);
                dialog.setLocation(500,200);
                dialog.setVisible(true);
            }
        });

        JButton addCart = new JButton("Add to cart");
        addCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog Dialog = new JDialog(new JFrame(), "Notification");
                if (cart.getItemsOrdered().contains(media)){
                    JLabel Label = new JLabel("Media already exists in cart", SwingConstants.CENTER);
                    Dialog.add(Label);
                } else{
                    cart.addMedia(media);
                    String notification;
                    notification = media.getTitle();
                    JLabel Label = new JLabel(notification, SwingConstants.CENTER);
                    Dialog.add(Label);
                }
                Dialog.setLocation(500,200);
                Dialog.setSize(200,100);Dialog.setVisible(true);
              }

        });

        container.add(addCart);

        if(media instanceof Playable){
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

}
