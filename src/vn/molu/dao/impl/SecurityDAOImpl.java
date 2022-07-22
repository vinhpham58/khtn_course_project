package vn.molu.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import vn.molu.dao.SecurityDAO;
import vn.molu.domain.Department;
import vn.molu.domain.Employee;
import vn.molu.domain.Role;
import vn.molu.domain.User;
import vn.molu.utils.HelperUtil;
import vn.molu.utils.HibernateUtil;

public class SecurityDAOImpl implements SecurityDAO {
	@Override
	public int addUser(User user, Employee employee, Department department, Role role) {
		Transaction tran = null;
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			user.setId(HelperUtil.randomLong());
			user.setPassword(HelperUtil.bcrypt(user.getPassword()));
			user.setEmployee(employee);
			employee.setDepartment(department);
			
			//Add role list to user
			Set<Role> roles = new HashSet<>();
			roles.add(role);
			user.setRoles(roles);
			
			tran = session.beginTransaction();
			session.save(employee);
			session.save(user);
			tran.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			if (tran != null) {
				tran.rollback();
			}
			return 0;
		}
	}

	@Override
	public User logon(String username) {
		User user = null;
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			String hql = "select u from User u where u.username = :username";
			Query query = session.createQuery(hql);
			query.setParameter("username", username);
			user = (User) query.uniqueResult();
		} catch (HibernateException e) {
			System.out.println(e);
		}
		return user;
	}
	
}
