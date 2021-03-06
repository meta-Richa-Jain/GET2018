package com.metacube.training.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.metacube.training.enums.Status;
import com.metacube.training.facade.CategoryFacade;
import com.metacube.training.model.Category;

@Path("/Category")
public class CategoryResource {

	CategoryFacade categoryFacade = CategoryFacade.getInstance();

	@POST
	@Path("/InsertCategory")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Status insertCategory(@HeaderParam("Authorization") String authorization, Category category) {

		if (!"REST".equals(authorization)) {
			return Status.ERROR;
		}
		if (category.getName() != null) {
			return categoryFacade.insertCategory(category.getName());
		} else {
			return Status.NULL_VALUES;
		}
	}

	@GET
	@Path("/GetCategory")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllCategories(@HeaderParam("Authorization") String authorization) {

		if (!"REST".equals(authorization)) {
			return "" + Status.ERROR;
		}

		List<Category> categoryList = categoryFacade.getAll();
		if (categoryList.size() != 0) {
			Gson gson = new Gson();
			String categoryJson = gson.toJson(categoryList);
			return categoryJson;
		}
		return "No Data Present";
	}

	@PUT
	@Path("/UpdateCategory")
	@Produces(MediaType.APPLICATION_JSON)
	public Status updateCategory(@HeaderParam("Authorization") String authorization, Category category) {

		if (!"REST".equals(authorization)) {
			return Status.ERROR;
		}
		if (category.getName() != null) {
			return categoryFacade.updateCategory(category);
		}
		return Status.NULL_VALUES;
	}
}
