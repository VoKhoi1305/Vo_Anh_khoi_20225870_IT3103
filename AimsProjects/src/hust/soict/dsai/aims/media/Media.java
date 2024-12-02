package hust.soict.dsai.aims.media;
import java.util.Comparator;
import java.util.Objects;

public abstract class Media {
	protected int id; 
	protected String title;
	protected String category;
	protected float cost; 
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

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
	
	public String toString() {
        return String.format("Id: %d - title: %s - category: %s - cost: %.2f", id, title, category, cost);
    }
	
	 public boolean isMatch(String key){
	        return getTitle().equalsIgnoreCase(key);
	    }

	    public boolean equals(Object obj) {
	        if(!(obj instanceof Media)){
	            return false;
	        }
	        return Objects.equals(this.title, ((Media) obj).getTitle());
	    }
	 
}
