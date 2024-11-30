package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Store {

    private DigitalVideoDisc[] itemsInStore;
    private int currentSize;


    public Store(int capacity) {
        itemsInStore = new DigitalVideoDisc[capacity];
        currentSize = 0;
    }

  
    public boolean addDVD(DigitalVideoDisc dvd) {
        if (currentSize < itemsInStore.length) {
            itemsInStore[currentSize] = dvd;
            currentSize++;
            return true;
        } else {
            System.out.println("Store is fulled.");
            return false; 
        }
    }
    public boolean removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < currentSize; i++) {
            if (itemsInStore[i].getid() == dvd.getid()) {
           
                for (int j = i; j < currentSize - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[currentSize - 1] = null; 
                currentSize--;
                return true; 
            }
        }
        System.out.println("DVD not found.");
        return false; 
    }
    
    public void displayItems() {
        System.out.println("DVDS:");
        if (currentSize == 0) {
            System.out.println("NO DVD");
        } else {
            for (int i = 0; i < currentSize; i++) {
            	System.out.println(itemsInStore[i].toString()); 
            }
        }
    }
}
