package vn.molu.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.molu.dao.DepartmentDAO;
import vn.molu.domain.Department;
import vn.molu.utils.HibernateUtil;

public class DepartmentDAOImpl implements DepartmentDAO{

	@Override
	public List<Department> departmentList() {
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			String hql = "FROM Department";
			return session.createQuery(hql, Department.class).list();
		}
	}

	@Override
	public int addDepartment(Department dept) {
		Transaction tran = null;
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {

			tran = session.beginTransaction();
			session.save(dept);
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

}
