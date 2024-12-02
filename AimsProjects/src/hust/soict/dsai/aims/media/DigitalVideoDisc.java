
package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	private String director;
	private int length;
	private static int nbDigitalVideoDiscs = 0;

	
	public static void setNbDigitalVideoDiscs(int nbDigitalVideoDiscs) {
		DigitalVideoDisc.nbDigitalVideoDiscs = nbDigitalVideoDiscs;
	}
	
	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}

	public DigitalVideoDisc(String title) {
		nbDigitalVideoDiscs++;
        super(title, null, 0, 0, null);
    }

    public DigitalVideoDisc(String category, String title, float cost) {
    	nbDigitalVideoDiscs++;
        super(title, category, cost, 0, null);
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
    	nbDigitalVideoDiscs++;
        super(title, category, cost, 0, director);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
    	nbDigitalVideoDiscs++;
    	super(title, category, cost, length, director);
    }

	  public static int getNbDigitalVideoDiscs() {
	        return nbDigitalVideoDiscs;
	    }
	  
	  public void play() {
	        System.out.println("Playing DVD: " + getTitle());
	        System.out.println("Length DVD: " + getLength());
	    }
	  
	  public String toString() {
	        return "DVD - " + getTitle() + " - " + getCategory() + " - " + director + " - " + length + ": " + getCost() + " $";
	    }
}
