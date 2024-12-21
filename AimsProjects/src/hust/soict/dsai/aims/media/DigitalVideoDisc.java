
package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	private static int nbDigitalVideoDiscs = 0;

	public static void setNbDigitalVideoDiscs(int nbDigitalVideoDiscs) {
		DigitalVideoDisc.nbDigitalVideoDiscs = nbDigitalVideoDiscs;
	}

//	public DigitalVideoDisc(String title) {
//		nbDigitalVideoDiscs++;
//        super(title, null, 0, 0, null);
//    }
//
//    public DigitalVideoDisc(String category, String title, float cost) {
//    	nbDigitalVideoDiscs++;
//        super(title, category, cost, 0, null);
//    }
//
//    public DigitalVideoDisc(String director, String category, String title, float cost) {
//    	nbDigitalVideoDiscs++;
//        super(title, category, cost, 0 , director);
//    }

	public DigitalVideoDisc(String title, String category, float cost, int length, String director) {
		super(title, category, cost, length, director);
		nbDigitalVideoDiscs++;
	}

	public static int getNbDigitalVideoDiscs() {
		return nbDigitalVideoDiscs;
	}

	public void play() {
		System.out.println("Playing DVD: " + getTitle());
		System.out.println("Length DVD: " + getLength());
	}
//	  public String toString() {
//	        return "DVD - " + getTitle() + " - " + getCategory() + " - " + director + " - " + length + ": " + getCost() + " $";
//	    }
}
