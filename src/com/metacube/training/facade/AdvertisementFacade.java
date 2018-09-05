package com.metacube.training.facade;

import java.util.List;

import com.metacube.training.dao.AdvertisementDao;
import com.metacube.training.dao.BaseDao;
import com.metacube.training.dao.CategoryDao;
import com.metacube.training.enums.Status;
import com.metacube.training.model.Advertisement;
import com.metacube.training.model.Category;

/**
 * Facade Class for advertisement
 */
public class AdvertisementFacade {
	private static AdvertisementFacade advertisementFacade = new AdvertisementFacade();

	BaseDao<Advertisement> advertisementDao =  AdvertisementDao.getInstance();
	BaseDao<Category> categoryDao = CategoryDao.getInstance();

	/**
	 * method to create the singleton object
	 * 
	 * @return object
	 */
	public static AdvertisementFacade getInstance() {
		return advertisementFacade;
	}

	/**
	 * Method to insert advertisement
	 * 
	 * @param advertisement, advertisement object
	 * @return status
	 */
	public Status insertAdvertisement(Advertisement advertisement) {
		List<Advertisement> advertisementList = advertisementDao.getAll();
		List<Category> categoryList = categoryDao.getAll();

		for (Advertisement ad : advertisementList) {
			if (ad.getTitle().equals(advertisement.getTitle())) {
				return Status.DUPLICATE;
			}
		}

		for (Category category : categoryList) {

			if (category.getId() == advertisement.getCategoryId()) {
				return ((AdvertisementDao) advertisementDao).insert(advertisement);
			}
		}
		return Status.INVALID;
	}

	/**
	 * Method to return the list of all advertisements
	 * 
	 * @return list of advertisements
	 */
	public List<Advertisement> getAll() {
		return advertisementDao.getAll();
	}

	/**
	 * Method to return all the advertisements of a particular category
	 * 
	 * @param id, category id
	 * @return list of advertisements
	 */
	public List<Advertisement> getAllById(int id) {
		return ((AdvertisementDao) advertisementDao).getAllById(id);
	}

	/**
	 * Method to update the name of the advertisement
	 * 
	 * @param name of the advertisement
	 * @param id   of the advertisement
	 * @return status
	 */
	public Status updateName(String name, int id) {
		List<Advertisement> advertismentList = advertisementDao.getAll();
		for(Advertisement ad: advertismentList) {
			if(ad.getId() == id) {
				return ((AdvertisementDao) advertisementDao).updateName(name, id);
			}
		}
		return Status.NOT_FOUND;
		
	}

	/**
	 * Method to delete the advertisement
	 * 
	 * @param id of the advertisement
	 * @return status
	 */
	public Status deleteAdvertisement(int id) {

		List<Advertisement> advertisementList = advertisementDao.getAll();
		for (Advertisement ad : advertisementList) {
			if (ad.getId() == id) {
				return ((AdvertisementDao) advertisementDao).deleteAdvertisement(id);
			}
		}
		return Status.NOT_FOUND;
	}

}
