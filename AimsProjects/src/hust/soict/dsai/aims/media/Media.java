package hust.soict.dsai.aims.media;

public abstract class Media {
	protected int id; 
	protected String title;
	protected String category;
	protected float cost; 
	public Media() {
		// TODO Auto-generated constructor stub
	}
	public int getID() {
		return id;
	}
	public void setID(int iD) {
		id = iD;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	

}
