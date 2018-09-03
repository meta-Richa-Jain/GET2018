package facade;


import java.util.List;

import dao.CategoryDao;
import dao.MYSQLCategoryDao;
import entity.Category;

public class CategoryFacade {
private static CategoryFacade categoryFacade = new CategoryFacade();
    
	CategoryDao categoryDao = (CategoryDao) MYSQLCategoryDao.getInstance();
 
    public static CategoryFacade getInstance(){
    	return categoryFacade;
    }
    public void insertCategory(String name){
    	categoryDao.insert(name);
    }
    public List<Category> getAll(){
    	return categoryDao.getAll();
    }
}
