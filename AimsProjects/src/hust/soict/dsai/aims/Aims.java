package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
public class Aims {
		public static void main(String[] args) {
			Cart anOrder = new Cart();
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
	     DigitalVideoDisc[] dvdList = {dvd3,dvd2,dvd1};
	     anOrder2.addDigitalVideoDisc(dvdList);
	     System.out.println("Total Cost after adding DVDs via array: " + anOrder2.totalCost());
			
			System.out.println("Total Cost is: ");
			System.out. println(anOrder.totalCost());
			anOrder.removeDigitalVideoDisc(dvd2); 
			System.out.println("Total Cost is: ");
			System.out. println(anOrder.totalCost());
			}
	}