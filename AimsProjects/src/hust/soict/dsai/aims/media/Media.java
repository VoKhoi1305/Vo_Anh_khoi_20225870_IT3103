package hust.soict.dsai.aims.media;

public abstract class Media {
	protected int id; 
	protected String title;
	protected String category;
	protected float cost; 
	public Media() {
		// TODO Auto-generated constructor stub
	}
	  public Media(String title, String category, float cost){
	        this.title = title;
	        this.category = category;
	        this.cost = cost;
	   }
	public int getId() {
		return id;
	}
	public void setId(int iD) {
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
