package Aims;

public class Cart {
	public static final int MAX_NUMBER_OEDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_OEDERED];
	private int totalItems;
	
	 public void addDigitalVideoDisc(DigitalVideoDisc disc) {
	        if (totalItems < MAX_NUMBER_OEDERED) {
	            itemsOrdered[totalItems] = disc; // Add the DVD to the array
	            totalItems++; // Increment the count of items
	           
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
}
