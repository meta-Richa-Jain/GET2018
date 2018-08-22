package pojo;
/**
 * POJO class to store details of an Image
 * @author Richa Jain
 *
 */
public class Image {

	private String url;
	private String title;
	private int productId;
	
	public Image(String url, String title, int productId){
		this.url = url;
		this.title = title;
		this.productId = productId;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	

}
