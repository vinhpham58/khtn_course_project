package vn.molu.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.molu.dao.DepartmentDAO;
import vn.molu.dao.RoleDAO;
import vn.molu.dao.SecurityDAO;
import vn.molu.dao.impl.DepartmentDAOImpl;
import vn.molu.dao.impl.RoleDAOImpl;
import vn.molu.dao.impl.SecurityDAOImpl;
import vn.molu.domain.Department;
import vn.molu.domain.Employee;
import vn.molu.domain.Role;
import vn.molu.domain.User;

@Controller
public class SecurityController {
	RoleDAO roleDAO = new RoleDAOImpl();
	DepartmentDAO departmentDAO = new DepartmentDAOImpl();
	SecurityDAO securityDAO = new SecurityDAOImpl();
	
	@RequestMapping({ "/sample/", "/sample/index.html", "/index.html" })
	public String index() {
		return "index";
	}

	@RequestMapping("/register.html")
	public String register(HttpServletRequest req) {
		List<Department> listOfDepartment = departmentDAO.departmentList();
		List<Role> listOfRole = roleDAO.roleList();
		req.setAttribute("listOfDepartment", listOfDepartment);
		req.setAttribute("listOfRole", listOfRole);
		return "register";
	}
	
	@RequestMapping(value = "/register.html", method = RequestMethod.POST)
	public String register(User user, Employee employee, Department department, Role role) {
		securityDAO.addUser(user, employee, department, role);
		return "redirect:/login.html";
	}
	
	@RequestMapping("/login.html")
	public String login(HttpServletRequest request) {
		return "login";
	}
	
	@RequestMapping("/forbidden.html")
	public String forbidden() {
		return "forbidden";
	}
	
	@RequestMapping("sample/list.html")
	public String list(HttpServletRequest req) {
		List<Department> listOfDepartment = departmentDAO.departmentList();
		req.setAttribute("listOfDepartment", listOfDepartment);
			return "list";
	}
	
	@RequestMapping("sample/department-add.html")
	public String add() {
		return "add";
	}
	
	@RequestMapping(value = "sample/department-add.html", method = RequestMethod.POST)
	public String add(Department department) {
		departmentDAO.addDepartment(department);
		return "redirect:/sample/index.html";
	}
}
