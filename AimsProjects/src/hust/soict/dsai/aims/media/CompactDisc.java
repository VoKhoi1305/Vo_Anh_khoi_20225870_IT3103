package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks;

	public CompactDisc() {
		super();
		this.tracks = new ArrayList<>();
	}

	public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
		super(title, category, cost, length, director);
		this.artist = artist;
		this.tracks = new ArrayList<>();
	}
	public CompactDisc(String title, String category, float cost, String artist) {
		
		super();
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
		this.artist = artist;
		this.setId(id);
		id++;
	}
	public String getArtist() {
		return artist;
	}

	public int getLength() {
		int totalLength = 0;
		for (Track track : tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}

	public void addTrack(Track track) {
		if (!tracks.contains(track)) {
			tracks.add(track);
			System.out.println("add track successfully");
		} else {
			System.out.println("track already exists");
		}
	}

	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("remove track successfully");
		} else {
			System.out.println("not found track");
		}
	}

	public void play() {
		System.out.println("Play this CD by: " + this.getArtist());
		System.out.println("Length CD: " + this.getLength());
		for (Track track : tracks) {
			track.play();
		}
	}

	public String toString() {
		return super.toString() + "artist: " + artist;
	}
}
