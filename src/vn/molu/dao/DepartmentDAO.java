package vn.molu.dao;

import java.util.List;
import vn.molu.domain.Department;

public interface DepartmentDAO {
	// Get Department List
	public List<Department> departmentList();

	// Add a new Department
	public int addDepartment(Department dept);
}
