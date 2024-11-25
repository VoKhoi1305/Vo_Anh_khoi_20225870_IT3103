package Aims;

public class TestCart {
	public static void main(String[] args) {
		//Create a new cart
		Cart cart = new Cart() ;

		//Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
		"Animation", "Roger Allers", 87, 19.95f);
		cart.addDigitalVideoDisc(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
		"Science Fiction", "George Lucas", 87, 24.95f);
		cart.addDigitalVideoDisc(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
		"Animation", 18.99f);
<<<<<<< HEAD
		cart.addDigitalVideoDisc(dvd3);		
=======
		cart.addDigitalVideoDisc(dvd3);
		
>>>>>>> e7dcad858175606d4b6eec71b40c9c71e09ce4f5
		cart.print();
	}
}
