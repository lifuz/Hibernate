package com.lifuz.one2one.foreign;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HibernateTest {
	
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	@Before
	public void init(){
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure().build();
		
		Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();
		
		sessionFactory = metadata.buildSessionFactory();
		
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		
		
	}
	
	@After
	public void destroy() {
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
	}
	
	@Test
	public void testSave() {
		
		Department department = new Department();
		department.setDeptName("DEPT-AA");
		
		Manager manager = new Manager();
		manager.setMgrName("MGR-AA");
		
		//设定关联关系
		department.setMgr(manager);
		manager.setDept(department);
		
		//保存操作
		session.save(manager);
		session.save(department);
		
		
	}

}
