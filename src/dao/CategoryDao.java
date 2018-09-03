package dao;

import entity.Category;

public interface CategoryDao extends BaseDao<Category>{
	public void insert(String title);
	
}
