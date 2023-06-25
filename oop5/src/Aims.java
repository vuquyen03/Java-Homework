import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import java.util.*;


public class Aims {

    private static Scanner sc = new Scanner(System.in);
    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void StoreItems(){
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1,"The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2,"Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladin",
                "Animation", "Guy Ritchie", 100, 18.99f);
        Book book1 = new Book(4,"Life of Pi", "Adventure fiction", 18.10f);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);

        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void viewMenu() throws PlayerException {

        int choice;
        while (true){
            showMenu();
            choice = sc.nextInt();

            if(choice == 1){ //View store
                for(Media media : store.itemsInStore){
                    System.out.println(media.getTitle());
                }

                chooseStoreMenu();
                break;
            }else if (choice ==2){ //Update store

                viewUpdateStore();
                break;
            }else if(choice == 3){ //See current cart

                currentCart();
                break;
            }else if(choice ==0){

                break;
            } else{
                System.out.println("Choose number again .....");
            }

        }
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void chooseStoreMenu() throws PlayerException {
        int choice;
        while (true) {
            storeMenu();
            choice = sc.nextInt();
            sc.nextLine();
            // See a media’s details
            if (choice == 1) {
                System.out.println("Enter the title of media: ");
                String title = sc.nextLine();
                ArrayList<Media> medias = store.search(title);
                if(medias.size() == 0){
                    System.out.println("Media not found");
                } else{
                    for(Media media : medias){
                        System.out.println(media.toString());
                    }
                    mediaDetailsMenu();
                    break;
                }

            } else if (choice ==2){ //Add a media to cart
                System.out.print("Enter the title of the media: ");
                String title = sc.nextLine();
                ArrayList<Media> medias = store.search(title); // search by title
                if (medias.size() != 0) {
                    for (Media media : medias) {
                        cart.addMedia(media); // add item into cart
                    }
                    System.out.println("Number of items on cart: " + cart.getSize());

                } else{
                    System.out.println("Media not found.");
                }

            } else if(choice ==3){ //Play a media
                System.out.print("Enter the title of the media: ");
                String title = sc.nextLine();
                ArrayList<Media> medias = store.search(title); // search by title
                if (medias.size() != 0) {
                    for (Media media : medias) {
                        if (media instanceof Playable){
                            System.out.println("Play " + media.getTitle());
                            ((Playable) media).play();
                        }
                        else{
                            System.out.println("Can not play " + media.getTitle());
                        }
                    }
                } else{
                    System.out.println("Media not found.");
                }

            } else if (choice ==4){ //See current cart

                currentCart();
                break;
            } else if (choice ==0){ //Back

                viewMenu();
                break;
            }else{
                System.out.println("Invalid value. Please choose a number: 0-1-2-3-4");
            }
        }
    }
    public static void updateStore() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

    }

    public static void viewUpdateStore() throws PlayerException {
        int choice;
        while(true){
            updateStore();
            choice = sc.nextInt();
            sc.nextLine();
            if(choice == 1){  //add a media to store
                addStore();
            } else if (choice == 2){ //remove a media to store
                removeStore();
            } else if (choice == 0){

                viewMenu();
                break;
            } else{
                System.out.println("Invalid value.\n");
            }
        }
    }

    public static void addStore(){
        System.out.print("Which type (Book,CD,DVD): ");
        String type = sc.nextLine();

        System.out.print("Enter the id of media: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the title of the media: ");
        String title = sc.nextLine();

        System.out.print("Enter the cost of the media: ");
        float cost = sc.nextFloat();
        sc.nextLine();

        System.out.print("Enter category of the media: ");
        String category = sc.nextLine();

        if(type.equals("Book")){
            store.addMedia(new Book(id, title, category, cost));
        } else if(type.equals("CD")){
            System.out.print("Enter director of the Cd: ");
            String director = sc.nextLine();
            System.out.print("Enter artist of the Cd: ");
            String artist = sc.nextLine();
            System.out.print("Enter number of track of Cd: ");
            int count = sc.nextInt();
            ArrayList<Track> tracks = new ArrayList<>();

            for (int i = 1; i <= count; i++){
                System.out.println("Track " + i +":");
                System.out.print("Enter title of track: ");

                sc.nextLine();
                String title_track = sc.nextLine();
                System.out.print("Length of track: ");
                int length = sc.nextInt();
                tracks.add(new Track(title_track, length));
            }
            store.addMedia(new CompactDisc(id, title, category, cost, artist, tracks, director));

        } else if(type.equals("DVD")){
            System.out.print("Enter director of the DVD: ");
            String director = sc.nextLine();
            System.out.print("Enter length of the DVD: ");
            int length = sc.nextInt();
            store.addMedia(new DigitalVideoDisc(id, title, category, director, length, cost));
        }

    }

    public static void removeStore(){
        for(Media media : store.itemsInStore){
            System.out.println(media.toString());
        }
        System.out.println("Which type (Book,CD,DVD)");
        String type = sc.nextLine();

        System.out.print("Name of media you want to remove: ");
        String title = sc.nextLine();

        ArrayList<Media> removeList = store.search(title);
        for(Media media : removeList){
            store.removeMedia(media);
        }
    }

    public static void mediaDetailsMenu() throws PlayerException {

        while(true){
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0){
                chooseStoreMenu();
                break;

            }else if(choice == 1){
                // Add to cart
                System.out.print("Enter the title of the media: ");
                String title = sc.nextLine();
                ArrayList<Media> medias = store.search(title); // search by title
                if (medias.size() != 0) {
                    for (Media media : medias) {
                        cart.addMedia(media); // add item into cart
                        System.out.println("Added " + media.getTitle() + " to cart.");
                    }
                } else {
                    System.out.println("Media not found.");
                }

            }else if (choice == 2){
                System.out.print("Enter the title of the media: ");
                String title = sc.nextLine();
                ArrayList<Media> medias = store.search(title); // search by title
                if (medias.size() != 0) {
                    for (Media media : medias) {
                        if (media instanceof Playable){
                            System.out.println("Play " + media.getTitle());
                            ((Playable) media).play();
                        }
                        else{
                            System.out.println("Can not play " + media.getTitle());
                        }
                    }
                } else{
                    System.out.println("Media not found.");
                }
            }else{
                System.out.println("Invalid value\n");
                choice = sc.nextInt();
            }
        }

    }


    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void currentCart() throws PlayerException {
        int choice;
        while (true){
            cartMenu();
            choice = sc.nextInt();
            if(choice == 1){ //Filter medias in cart

                filterMedia();
            }else if (choice ==2){ //Sort medias in cart

                sortMedia();
            }else if (choice ==3){ //Remove media from cart

            }else if (choice ==4){ //Play a media

            }else if (choice ==5){ //Place order

                placeOrder();
            }else if (choice ==0){ //Back

                viewMenu();
                break;
            }else{
                System.out.println("Invalid value.\n");
            }
        }
    }

    public static void filterMedia() throws PlayerException {
        System.out.println("1. Filter by id");
        System.out.println("2. Filter by title");
        System.out.println("0. Back");
        int option = sc.nextInt();

        if (option == 1) {
            // Ask the user for an id to filter the medias in the cart
            System.out.println("Please enter an id:");
            int id = sc.nextInt();

            // Filter the medias in the cart by the specified id
            List<Media> filteredMedias = new ArrayList<>();
            for (Media media : cart.getItemsOrdered()) {
                if (media.getId() == id) {
                    filteredMedias.add(media);
                }
            }

            if(filteredMedias.isEmpty()){
                System.out.println("Media not found.");
            }

            // Display the filtered medias to the user
            for (Media media : filteredMedias) {
                System.out.println(media.getTitle() + " (" + media.getCategory() + "): $" + media.getCost());
            }

        } else if (option == 2) {
            sc.nextLine();
            // Ask the user for a title to filter the medias in the cart
            System.out.println("Please enter a title:");
            String title = sc.nextLine();

            // Filter the medias in the cart by the specified title
            List<Media> filteredMedias = new ArrayList<>();
            for (Media media : cart.getItemsOrdered()) {
                if (media.getTitle().equals(title)) {
                    filteredMedias.add(media);
                }
            }

            if(filteredMedias.isEmpty()){
                System.out.println("Media not found.");
            }

            // Display the filtered medias to the user
            for (Media media : filteredMedias) {
                System.out.println(media.getTitle() + " (" + media.getCategory() + "): $" + media.getCost());
            }

        }else if(option == 0){
            currentCart();
        }else {
            System.out.println("Invalid option selected. ");
        }
    }

    public static void sortMedia(){
        System.out.println("Sort medias in cart by:");
        System.out.println("1. Title");
        System.out.println("2. Cost");

        int choice = sc.nextInt();
        sc.nextLine(); // consume the newline character

        if (choice == 1) {
            Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
            System.out.println("Medias sorted by title.");
            for (Media m : cart.getItemsOrdered()){
                System.out.println(m.toString());
            }

        } else if (choice == 2) {
            Collections.sort(cart.getItemsOrdered(),Media.COMPARE_BY_COST_TITLE);
            System.out.println("Medias sorted by cost.");
            for (Media m : cart.getItemsOrdered()){
                System.out.println(m.toString());
            }

        } else {
            System.out.println("Invalid choice.");
        }
    }

    public static void placeOrder(){
        System.out.println(cart.getItemsOrdered().toString());
        System.out.println("An order has been created. Thank you for shopping with us!");
        cart.clear();
    }

    public static void main(String[] args) throws PlayerException {
        StoreItems();
        viewMenu();
    }
}