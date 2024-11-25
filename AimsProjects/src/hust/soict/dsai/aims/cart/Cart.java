package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBER_OEDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_OEDERED];
	private int totalItems;
	
	 public void addDigitalVideoDisc(DigitalVideoDisc disc) {
	        if (totalItems < MAX_NUMBER_OEDERED) {
	            itemsOrdered[totalItems] = disc; 
	            totalItems++; 
	 }
	 }
	 public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		    if (totalItems + dvdList.length <= MAX_NUMBER_OEDERED) {
		        for (int i = 0; i < dvdList.length; i++) {
		            itemsOrdered[totalItems] = dvdList[i]; 
		            totalItems++; 
		        }
		    } else {
		        System.out.println("The cart is full.");
		    }
		}
	
	 public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
	    if (totalItems + dvds.length <= MAX_NUMBER_OEDERED) {
	        for (int i = 0; i < dvds.length; i++) {
	            itemsOrdered[totalItems] = dvds[i]; 
	            totalItems++; 
	        }
	    } else {
	        System.out.println("The cart is almost full. Cannot add all DVDs!");
	    }
	}
	 
	 public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		 if (totalItems + 2 <= MAX_NUMBER_OEDERED) {
			 addDigitalVideoDisc(dvd1);
			 addDigitalVideoDisc(dvd2);
		 }
	 }
	 
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < totalItems; i++) {
            if (itemsOrdered[i].getTitle().equals(disc.getTitle())) { // Check if the disc matches
                found = true;
                // Shift items to the left to remove the disc
                for (int j = i; j < totalItems - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[totalItems - 1] = null; // Clear the last item
                totalItems--; // Decrement the count of items
                break;
            }
        }
    }
	
	
	
	public float totalCost() {
        float total = 0;
        for (int i = 0; i < totalItems; i++) {
            total += itemsOrdered[i].getCost(); // Sum the costs of the DVDs
        }
        return total;
    }
	
	
	public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        double totalCost = 0;
        for (int i = 0; i < totalItems; i++) {
            DigitalVideoDisc dvd = itemsOrdered[i];
            System.out.println((i + 1) + ". " + dvd);
            totalCost += dvd.getCost();
        }
        System.out.println("Total cost: " + totalCost + " $");
        System.out.println("***************************************************");
    }
	
	 public DigitalVideoDisc searchById(int id) {
	        for (DigitalVideoDisc dvd : itemsOrdered) {
	            if (dvd.getid() == id) {
	                return dvd;
	            }
	        }
	        return null; // Return null if not found
	    }

	    // Search DVDs by title
	    public void searchByTitle(String title) {
	        boolean found = false;
	        for (DigitalVideoDisc dvd : itemsOrdered) {
	            if (dvd.isMatch(title)) {
	                System.out.println(dvd);
	                found = true;
	            }
	        }

	        if (!found) {
	            System.out.println("No DVD found with the title: " + title);
	        }
	    }
}