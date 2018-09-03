package resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entity.Category;
import facade.CategoryFacade;


@Path("/CategoryResource")
public class CategoryResource {
	CategoryFacade categoryFacade=CategoryFacade.getInstance();
	
	
	@GET
	@Path("/GetFeeds/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public String insertIntoCategories(@PathParam("name") String name) {
		categoryFacade.insertCategory(name);
		return "hello";
	}
	
	
//	@GET
//	@Path("/GetCategory")
//	@Produces(MediaType.APPLICATION_JSON)
//	public String getAllCategories() {
//		List<Category> categoryList=categoryFacade.getAll();
//		Gson gson = new Gson();
//		System.out.println(gson.toJson(categoryList));
//		String categoryJson=gson.toJson(categoryList);
//		return categoryJson;
//	}
	
	
	
}
