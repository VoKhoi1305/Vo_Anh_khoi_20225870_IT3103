package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
	private static final int MAX_ITEMS_IN_STORE = 25;
	private ArrayList<Media> itemsInStore = new ArrayList<>();
    private static int currentSize = 0;

  
    public void addMedia(Media media){
        if(itemsInStore.size() >= MAX_ITEMS_IN_STORE){
            System.out.println("The store is full.");
        }
        else {
            media.setId(currentSize++);
            itemsInStore.add(media);
            System.out.println("add media successfully");
        }
    }
    public void removeMedia(Media media){
        if(itemsInStore.contains(media)){
            itemsInStore.remove(media);
            System.out.println("Successfully remove the media");
        }
        else {
            System.out.println("Media not found in the store");
        }
    }
    
    public void displayItems(){
        System.out.println("***********************STORE***********************");
        if(itemsInStore.isEmpty()){
            System.out.println("The store is empty.");
        }
        else {
            for(int i = 0;i < itemsInStore.size();i++){
                System.out.println("Id: " + itemsInStore.get(i).getId() +  " title: " + itemsInStore.get(i).getTitle() + " cost: " + String.format("%.2f", itemsInStore.get(i).getCost()));
            }
        }
        System.out.println("**************************************************");
    }
    
    
    public Media searchByTitle(String title){
        for(Media media : itemsInStore){
            if(media.isMatch(title)) return media;
        }
        return null;
    }

    public Media searchById(int id){
        for(Media media : itemsInStore){
            if(media.getId() == id) return media;
        }
        return null;
    }
}