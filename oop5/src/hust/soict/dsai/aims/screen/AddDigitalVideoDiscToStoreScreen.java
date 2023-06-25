package hust.soict.dsai.aims.screen;

import java.io.IOException;
import java.net.URL;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class AddDigitalVideoDiscToStoreScreen extends JFrame{

    private Store store;

    public AddDigitalVideoDiscToStoreScreen (Store store) {
        super();
        this.store = store;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Add DVD to Store");
        this.setVisible(true);
        this.setSize(520,230);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = getClass().getResource("/hust/soict/dsai/aims/screen/addDVDToStoreScreen.fxml");
                    FXMLLoader loader = new FXMLLoader(url);

                    AddDigitalVideoDiscToStoreController controller =
                            new AddDigitalVideoDiscToStoreController(store);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene (new Scene(root));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

class AddDigitalVideoDiscToStoreController extends AddItemToStoreScreenController {

    public AddDigitalVideoDiscToStoreController(Store store) {
        super();
        this.store = store;
    }

    @FXML
    void btnAddToStoreClicked(ActionEvent event) {
        String title = titleTextField.getText();
        String category = categoryTextField.getText();
        float cost = (float) Double.parseDouble(costTextField.getText());

        addMediaStore(new DigitalVideoDisc(title, category, cost));
        reset();
    }

}