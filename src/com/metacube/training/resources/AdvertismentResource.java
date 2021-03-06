package com.metacube.training.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.metacube.training.enums.Status;
import com.metacube.training.facade.AdvertisementFacade;
import com.metacube.training.model.Advertisement;

@Path("/Advertisement")
public class AdvertismentResource {

	AdvertisementFacade advertisementFacade = AdvertisementFacade.getInstance();

	@POST
	@Path("/InsertAdvertisement")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Status insertAdvertisement(@HeaderParam("Authorization") String authorization, Advertisement advertisement) {

		if (!"REST".equals(authorization)) {
			return Status.ERROR;
		}
		if (advertisement.getDescription() != null && advertisement.getTitle() != null) {
			return advertisementFacade.insertAdvertisement(advertisement);
		}
		return Status.NULL_VALUES;

	}

	@GET
	@Path("/GetAllAdvertisment")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllAdvertisements(@HeaderParam("Authorization") String authorization) {

		if (!"REST".equals(authorization)) {
			return "" + Status.ERROR;
		}

		List<Advertisement> advertismentList = advertisementFacade.getAll();
		if (advertismentList.size() != 0) {
			Gson gson = new Gson();
			String advertismnetJson = gson.toJson(advertismentList);
			return advertismnetJson;
		} else {
			return "No advertisement is present";
		}
	}

	@GET
	@Path("/GetAdvertismentById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllAdvertisementByCategoryId(@HeaderParam("Authorization") String authorization,
			@PathParam("id") String id) {

		if (!"REST".equals(authorization)) {
			return "" + Status.ERROR;
		}

		List<Advertisement> advertismentList = advertisementFacade.getAllById(Integer.parseInt(id));
		if (advertismentList.size() != 0) {
			Gson gson = new Gson();
			String advertismnetJson = gson.toJson(advertismentList);
			return advertismnetJson;
		} else {
			return "No advertisement is present for this category id";
		}
	}

	@PUT
	@Path("/UpdateAdvertisement/{id}/{title}")
	@Produces(MediaType.APPLICATION_JSON)
	public Status updateAdvertisement(@HeaderParam("Authorization") String authorization, @PathParam("id") String id,
			@PathParam("title") String title) {

		if (!"REST".equals(authorization)) {
			return Status.ERROR;
		}
		if (title != null) {
			return advertisementFacade.updateName(title, Integer.parseInt(id));
		}
		return Status.NULL_VALUES;
	}

	@DELETE
	@Path("/DeleteAdvertisementById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Status deleteAdvertisement(@HeaderParam("Authorization") String authorization, @PathParam("id") int id) {

		if (!"REST".equals(authorization)) {
			return Status.ERROR;
		}

		return advertisementFacade.deleteAdvertisement(id);

	}

}
