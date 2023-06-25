package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CartScreenController {

    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    private Cart cart;
    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private ToggleGroup filterCategory;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediacategory;
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    @FXML
    private Label totalCost;
    @FXML
    private TextField tfFilter;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;

    public CartScreenController(Cart cart){
        super();
        this.cart = cart;
    }

    private FilteredList<Media> filteredCartList;

    @FXML
    private void initialize(){
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost"));

        cart.addMedia(new Book(4,"Life of Pi", "Adventure fiction", 18.10f));
        cart.addMedia(new DigitalVideoDisc(1,"The Lion King",
                "Animation", "Roger Allers", 87, 19.95f));

        filteredCartList = new FilteredList<>(cart.getItemsOrdered());
        tblMedia.setItems(filteredCartList);

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {

                    @Override
                    public void changed(ObservableValue<? extends Media> observableValue, Media oldValue, Media newValue) {
                            if (newValue != null){
                                updateButtonBar(newValue);
                            }
                    }
                }
        );


        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                showFilterMedia(newValue);
            }
        });

        updateCost(cart);
    }


    private void updateButtonBar(Media media){
        btnRemove.setVisible(true);
        if(media instanceof Playable){
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    private void placeOrder(boolean input){
       if(input == true){

       } else {
           JDialog orderDialog = new JDialog(new JFrame(), "Notification");
           String title = "Cart is empty";

           JLabel orderLabel = new JLabel(title, SwingConstants.CENTER);
           orderDialog.add(orderLabel);
           orderDialog.setLocation(500,500);
           orderDialog.setSize(600,200);
           orderDialog.pack();
           orderDialog.setVisible(true);
       }
    }

    @FXML
    void btnPlaceOrderAction(ActionEvent event) {
        if(cart.getItemsOrdered().size() == 0){
            placeOrder(false);
        } else {
            cart.clear();
            initialize();
            placeOrder(true);
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Stage playerStage = new Stage();
        playerStage.setTitle("Playing");
        Text message = new Text("You're playing a media");
        VBox layout = new VBox(1, message);
        layout.setAlignment(Pos.CENTER);
        playerStage.setScene(new Scene(layout, 300, 100));
        playerStage.show();
    }

    @FXML
    private void btnRemovePressed(ActionEvent event){
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        updateCost(cart);
    }

    private void showFilterMedia(String input){
        filteredCartList.setPredicate(s -> s.search(input));
    }

    private void updateCost(Cart cart){
        float cost = 0;
        for (Media media : cart.getItemsOrdered()){
            cost += media.getCost();
        }
        totalCost.setText(String.format("%.2f$", cost));
    }


}
