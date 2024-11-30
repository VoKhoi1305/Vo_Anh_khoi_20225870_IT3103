package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class TestStore {
        public static void main(String[] args) {
            Store store = new Store(5);
            DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Matrix", "Action", "Wachowski", 136, 19.99f);
            DigitalVideoDisc dvd2 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 14.99f);
            DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 24.99f);
            DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avengers: Endgame", "Action", "Anthony Russo", 181, 29.99f);
            DigitalVideoDisc dvd5 = new DigitalVideoDisc("Interstellar", "Sci-Fi", "Christopher Nolan", 169, 19.99f);
            store.addDVD(dvd1);
            store.addDVD(dvd2);
            store.addDVD(dvd3);
            store.addDVD(dvd4);
            store.addDVD(dvd5);
            DigitalVideoDisc dvd6 = new DigitalVideoDisc("Avatar", "Sci-Fi", "James Cameron", 162, 22.99f);
            store.addDVD(dvd6); 
            store.displayItems();
            System.out.println("\n Delete Inception");
            store.removeDVD(dvd2);
            store.displayItems();
            System.out.println("\n Delete Titanic not exist");
            DigitalVideoDisc dvd7 = new DigitalVideoDisc("Titanic", "Romance", "James Cameron", 195, 19.99f);
            store.removeDVD(dvd7);
            store.displayItems();
        }
}
