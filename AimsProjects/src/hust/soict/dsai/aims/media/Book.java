package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public void addAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			authors.add(authorName);
		} else {
			System.out.println("Author already exists in the list.");
		}
	}

	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
		} else {
			System.out.println("Author not found in the list.");
		}
	}

	public Book(int id, String title, String category, float cost, List<String> authors) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.authors = authors;
	}

	public Book() {
		super();
	}

	public String toString() {
		return super.toString() + " Authors: " + String.join(", ", authors);
	}

	@Override
	public void displayInfo() {
		// TODO Auto-generated method stub

	}
}
