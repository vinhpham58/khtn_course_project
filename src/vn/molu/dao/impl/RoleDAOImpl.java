package vn.molu.dao.impl;

import java.util.List;
import org.hibernate.Session;
import vn.molu.dao.RoleDAO;
import vn.molu.domain.Role;
import vn.molu.utils.HibernateUtil;

public class RoleDAOImpl implements RoleDAO{

	@Override
	public List<Role> roleList() {
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			String hql = "FROM Role";
			return session.createQuery(hql, Role.class).list();
		}
	}

}
