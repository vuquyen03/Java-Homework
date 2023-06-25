package hust.soict.dsai.aims.screen;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddItemToStoreScreenController {

    protected Store store;

    @FXML
    protected Button btnAddToStore;

    @FXML
    protected TextField categoryTextField;

    @FXML
    protected TextField costTextField;

    @FXML
    protected TextField titleTextField;

    public void reset() {
        titleTextField.setText("");
        categoryTextField.setText("");
        costTextField.setText("");
    }

    public void addMediaStore(Media media) {

        JDialog Dialog = new JDialog(new JFrame(), "Notification");

        if(store.getItemsInStore().contains(media)){
            JLabel Label = new JLabel("Media already exists in store", SwingConstants.CENTER);
            Dialog.add(Label);

        } else{
            store.addMedia(media);
            String content = media.getTitle();
            JLabel Label = new JLabel(content, SwingConstants.CENTER);
            Dialog.add(Label);
        }

        Dialog.setLocation(600,400);
        Dialog.setSize(200,100);
        Dialog.setVisible(true);
    }
}
