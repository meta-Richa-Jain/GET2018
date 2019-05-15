package Facade;

import java.util.List;

import Model.Employee;
import Model.EmployeeTransferObject;
import Model.Friend;
import dao.DaoFactory;
import dao.MySQLEmployeeDao;
import enums.DBType;
import enums.Status;

public class EmployeeFacade {
	
	private static EmployeeFacade employeeFacade = new EmployeeFacade();
	
	MySQLEmployeeDao mySQLEmployeeDao = (MySQLEmployeeDao) DaoFactory.getDaoForEntity(DBType.MYSQL);
	
	public static EmployeeFacade getInstance() {
		return employeeFacade;
	}
	
	public Status addEmployee(Employee emp) {
		return mySQLEmployeeDao.addEmployee(emp);
	}
	
	public Status checkLoginDetails(String email, String password) {
		return mySQLEmployeeDao.checkLoginDetails(email, password);
	}
	
	public List<EmployeeTransferObject> getEmployeeDetails(String email){
		return mySQLEmployeeDao.getEmployeeDetails(email);
	}
	
	public List<Friend> getFriendsList(String orgName, String firstName, String lastName){
		return mySQLEmployeeDao.getFriendsList(orgName, firstName, lastName);
	}
	
	public Status editEmployee(EmployeeTransferObject emp) {
		return mySQLEmployeeDao.editEmployee(emp);
	}

}
