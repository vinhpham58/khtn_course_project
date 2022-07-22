package vn.molu.dao;
import vn.molu.domain.Department;
import vn.molu.domain.Employee;
import vn.molu.domain.Role;
import vn.molu.domain.User;

public interface SecurityDAO {
	//Register an account
	public int addUser(User user, Employee employee, Department department, Role role);
	
	//Logon an account
	public User logon(String username);

}
