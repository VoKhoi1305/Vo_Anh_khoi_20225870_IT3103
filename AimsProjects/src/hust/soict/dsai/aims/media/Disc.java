package hust.soict.dsai.aims.media;

public class Disc extends Media {
	private int length;
	private String director;

	public Disc() {
		super();
	}

	public Disc(String title, String category, float cost, int length, String director) {
		super(title, category, cost);
		this.length = length;
		this.director = director;
	}

	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

	public String toString() {
		return super.toString() + " length : " + getLength() + " director: " + getDirector();
	}

	public void displayInfo() {
		System.out.println("Title: " + getTitle());
		System.out.println("Category: " + getCategory());
		System.out.println("Director: " + director);
		System.out.println("Length: " + length);
		System.out.println("Cost: " + getCost());
	}
//    public String toString() {
//        return super.toString() + " - Length: " + length + " - Director: " + director;
//    }
}