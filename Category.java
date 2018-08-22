/**
 * POJO class to store details of a category
 * @author Richa Jain
 *
 */
public class Category {
	
	private String title;
	private int countChildren;
	
	public Category(String title, int countChildren) {
		this.title = title;
		this.countChildren = countChildren;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCountChildren() {
		return countChildren;
	}

	public void setCountChildren(int countChildren) {
		this.countChildren = countChildren;
	}

}
