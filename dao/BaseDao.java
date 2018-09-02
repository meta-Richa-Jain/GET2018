package dao;

import java.util.List;

import Model.Employee;
import Model.EmployeeTransferObject;
import Model.Friend;
import enums.Status;

public interface BaseDao {

	public Status addEmployee(Employee emp);

	public List<EmployeeTransferObject> getEmployeeDetails(String email);

	public List<Friend> getFriendsList(String orgName, String firstName, String lastName);

}
