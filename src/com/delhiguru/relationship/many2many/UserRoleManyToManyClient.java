package com.delhiguru.relationship.many2many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.delhiguru.util.HibernateUtil;

public class UserRoleManyToManyClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Integer userId = saveUser();
		//System.out.println("userId : " + userId);
		Integer roleId = saveRole();
		System.out.println("roleId : " + roleId);
		
	}
	
	public static Integer saveUser() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Integer id = null;
		try {
			transaction = session.beginTransaction();
			User user = new User();
			user.setUsername("ranjeet");
			user.setDescription("This is ranjeet");
			
			/*List<Role> roles = new ArrayList<Role>();
			Role role = new Role();
			role.setRoleName("ROLE_ADMIN");
			role.setDescription("with super user role.");
			Role role2 = new Role();
			role2.setRoleName("ROLE_USER");
			role2.setDescription("with user role.");
			roles.add(role);
			roles.add(role2);
			user.setRoles(roles);*/
			
			Role[] rolesArray = new Role[2];
			Role role1 = new Role();
			role1.setRoleName("ROLE_ADMIN");
			role1.setDescription("with super user role.");
			Role role3 = new Role();
			role3.setRoleName("ROLE_USER");
			role3.setDescription("with user role.");
			rolesArray[0] = role1;
			rolesArray[1] = role3;
			user.setRolesArray(rolesArray);
			
			id = (Integer) session.save(user);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return id;

	}
	
	public static Integer saveRole() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Integer id = null;
		try {
			transaction = session.beginTransaction();
			
			Role role = new Role();
			role.setRoleName("USER_ROLE");
			role.setDescription("this is user role");
			
			List<User> users = new ArrayList<User>();
			
			User user1 = new User();
			user1.setUsername("ranjeet");
			user1.setDescription("This is ranjeet");
			User user2 = new User();
			user2.setUsername("Ashish");
			user2.setDescription("This is Ashish");
			role.setUsers(users);
			
			
			id = (Integer) session.save(role);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return id;

	}

}
