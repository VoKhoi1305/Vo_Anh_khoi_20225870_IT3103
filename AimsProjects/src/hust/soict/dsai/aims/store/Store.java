package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Store {
	private static final int MAX_ITEMS = 25;
	private ArrayList<Media> items = new ArrayList<>();
	private int currentId = 0;

	public boolean addMedia(Media media) {
		if (items.size() >= MAX_ITEMS) {
			System.out.println("Store is full. Cannot add more items.");
			return false;
		}
		media.setId(currentId++);
		items.add(media);
		return true;
	}

	public boolean removeMedia(String title) {
		for (Media media : items) {
			if (media.isMatch(title)) {
				items.remove(media);
				return true;
			}
		}
		return false;
	}

	public void displayItems() {
		System.out.println("***********************STORE***********************");
		if (items.isEmpty()) {
			System.out.println("The store is empty.");
		} else {
			for (Media media : items) {
				media.displayInfo();
				System.out.println("-------------------");
			}
		}
		System.out.println("**************************************************");
	}

	public Media searchByTitle(String title) {
		for (Media media : items) {
			if (media.isMatch(title)) {
				return media;
			}
		}
		return null;
	}
	
	 public ArrayList<Media> getItemsInStore() {
	        return items;
	    }
}