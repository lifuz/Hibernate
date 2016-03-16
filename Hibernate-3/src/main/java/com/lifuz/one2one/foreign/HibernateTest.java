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
	
	/**
	 * 测试获取
	 */
	@Test
	public void testGet() {
		//1.默认情况下对关联属性使用懒加载
		//2.所以会出现懒加载异常问题
		
		Department dept = session.get(Department.class, 22);
		
		System.out.println(dept.getDeptName());
		
	}
	
	/**
	 * 测试保存
	 */
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
		//建议先保存没有外键类的对象
		session.save(manager);
		session.save(department);
		
		
	}

}
