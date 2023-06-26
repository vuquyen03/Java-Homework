package hust.soict.dsai.aims.screen;

import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;


public class AddDigitalVideoDiscToStoreScreen extends JFrame{

    private Store store;
    public AddDigitalVideoDiscToStoreScreen (Store store) {
        super();
        this.store = store;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Add DVD to Store");
        this.setVisible(true);
        this.setSize(520,300);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("addDVDToStoreScreen.fxml"));

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
    @FXML
    private TextField directorTextField;
    @FXML
    private TextField lengthTextField;

    public AddDigitalVideoDiscToStoreController(Store store) {
        super();
        this.store = store;
    }

    public void reset() {
        titleTextField.setText("");
        categoryTextField.setText("");
        costTextField.setText("");
        directorTextField.setText("");
        lengthTextField.setText("");
    }
    @FXML
    void btnAddToStoreClicked(ActionEvent event) {
        String title = titleTextField.getText();
        String category = categoryTextField.getText();
        float cost;
        try {
            cost = Float.parseFloat(costTextField.getText());
        } catch (NumberFormatException e) {
            costTextField.setText("");
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to parse cost!");
            alert.setTitle("Wrong type");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        String director = directorTextField.getText();
        int length;
        try {
            length = Integer.parseInt(lengthTextField.getText());
        } catch(NumberFormatException e) {
            lengthTextField.setText("");
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to parse length!");
            alert.setTitle("Wrong type");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }

        addMediaStore(new DigitalVideoDisc(title, category, cost, director, length));
        reset();
    }
}