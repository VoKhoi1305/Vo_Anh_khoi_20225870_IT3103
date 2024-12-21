
package hust.soict.dsai.aims.media;

import java.util.Objects;

public class Track implements Playable {
	private String title;
	private int length;

	public Track() {
	}

	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Track))
			return false;
		else {
			return Objects.equals(this.title, ((Track) obj).getTitle()) && this.length == ((Track) obj).getLength();
		}
	}

	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

}
