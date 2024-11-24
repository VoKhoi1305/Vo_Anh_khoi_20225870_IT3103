package Aims;

public class Aims {
		public static void main(String[] args) {

			//Create a new cart
			Cart anOrder = new Cart();

			//Create new dvd objects and add them to the cart
			DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
			"Animation", "Roger Allers", 87, 19.95f) ;
			anOrder. addDigitalVideoDisc(dvd1);

			DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
			"Science Fiction", "George Lucas", 87, 24.95f) ;
			anOrder.addDigitalVideoDisc(dvd2);

			DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
			"Animation", 18.99f);
			anOrder.addDigitalVideoDisc(dvd3);
			
			Cart anOrder2 = new Cart();
		 System.out.println("--- Adding DVDs using an array ---");
	     DigitalVideoDisc[] dvdList = {dvd3};
	     anOrder2.addDigitalVideoDisc(dvdList); // Add multiple DVDs via array
	     System.out.println("Total Cost after adding DVDs via array: " + anOrder2.totalCost());
			
			
			//print total cost of the items in the cart
			System.out.println("Total Cost is: ");
			System.out. println(anOrder.totalCost());
			anOrder.removeDigitalVideoDisc(dvd2); 
			System.out.println("Total Cost is: ");
			System.out. println(anOrder.totalCost());
			}
	}