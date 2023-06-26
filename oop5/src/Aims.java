import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;

public class Aims{
    public static void main(String[] args){
        Store store = new Store();
        Cart cart = new Cart();
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


        new StoreScreen(store, cart);
    }
}