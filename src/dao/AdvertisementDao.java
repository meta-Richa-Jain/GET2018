package dao;

import java.util.List;

import entity.Advertisement;

public interface AdvertisementDao extends BaseDao<Advertisement> {
	public List<Advertisement> getAllById(int id);
	public void updateName(String name,int id);
}
