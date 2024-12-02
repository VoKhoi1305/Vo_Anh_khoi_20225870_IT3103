
package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc {
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


	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	

	public DigitalVideoDisc(String title) {
		super();
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
		this.title = title;
	}
	public DigitalVideoDisc(String category, String director, float cost) {
		super();
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	 public String toString() {
	        return "DVD - " + title + " - " + category + " - " + director + " - " + length + " mins: " + cost + " $";
	 }

	    // isMatch method
	    public boolean isMatch(String title) {
	        return this.title.equalsIgnoreCase(title);
	 }
	
	  public static int getNbDigitalVideoDiscs() {
	        return nbDigitalVideoDiscs;
	    }


}
