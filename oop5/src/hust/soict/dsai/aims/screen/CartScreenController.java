package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
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

import static javafx.application.Platform.runLater;


public class CartScreenController {

    private Cart cart;
    private Store store;

    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
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
    @FXML
    private MenuItem viewStore;


    public CartScreenController(Cart cart, Store store){
        super();
        this.cart = cart;
        this.store = store;
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

        cart.getItemsOrdered().addListener( (javafx.collections.ListChangeListener.Change<? extends Media> c) -> {
            runLater(() -> totalCost.setText(String.format("%.2f $", cart.totalCost())));
        });

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
        JDialog orderDialog = new JDialog(new JFrame(), "Notification");
        if(input == true){
            String title = "Order has been created";
            JLabel orderLabel = new JLabel(title,SwingConstants.CENTER);
            orderDialog.add(orderLabel);
        } else {
           String title = "Cart is empty";
           JLabel orderLabel = new JLabel(title, SwingConstants.CENTER);
           orderDialog.add(orderLabel);
        }

        orderDialog.setLocation(600,400);
        orderDialog.setSize(200,100);
        orderDialog.setVisible(true);
    }

    @FXML
    void btnPlaceOrderAction(ActionEvent event) {
        if(cart.getItemsOrdered().size() == 0){
            placeOrder(false);
        } else {
            cart.clear();
            placeOrder(true);
            updateCost(cart);
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
        float cost = cart.totalCost();
        totalCost.setText(String.format("%.2f$", cost));
    }

    @FXML
    void addBookMenuItem(ActionEvent event) {
        new AddBookToStoreScreen(store);
    }

    @FXML
    void addCDMenuItem(ActionEvent event) {
        new AddCompactDiscToStoreScreen(store);
    }

    @FXML
    void addDVDMenuItem(ActionEvent event) {
        new AddDigitalVideoDiscToStoreScreen(store);
    }

    @FXML
    void viewStoreMenuItemChosen(ActionEvent event) {
        new StoreScreen(store, cart);
    }
}
