package hust.soict.dsai.aims.cart;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBER_OEDERED = 20;
	 private ArrayList<Media> itemsOrdered = new ArrayList<>();
	//add media
	   public void addMedia(Media media){
	      if(itemsOrdered.size() >= MAX_NUMBER_OEDERED){
	         System.out.println("The cart is full");
	      }
	      else {
	         itemsOrdered.add(media);
	         System.out.println("The media has been added");
	      }
	   }

	   //remove media
	   public void removeMedia(Media media){
	      if(itemsOrdered.contains(media)){
	         itemsOrdered.remove(media);
	         System.out.println("The media has been removed");
	      }
	      else {
	         System.out.println("Not found media");
	      }
	   }

	   public float totalCost(){
	      float total = 0;
	      for (Media media : itemsOrdered) {
	         total += media.getCost();
	      }
	      return total;
	   }
	   public void print(){
		      System.out.println("***********************CART***********************");
		      System.out.println("Ordered Items:");
		      for(int i = 0;i < itemsOrdered.size();i++){
		         System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
		      }
		      System.out.printf("Total cost: %.2f $%n", totalCost());
		      System.out.println("***************************************************");
		   }
	
	 public Media searchById(int id) {
	        for (Media dvd : itemsOrdered) {
	            if (dvd.getId() == id) {
	                return dvd;
	            }
	        }
	        return null; 
	    }

	   
	   public Media searchByTitle(String title){
		      for(Media media : itemsOrdered){
		         if(media.isMatch(title)){
		            return media;
		         }
		      }
		      return null;
	 }
}