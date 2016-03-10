package com.lifuz.model.n21.both;

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
	public void init() {
		
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
	public void testDelete() {
		
		Order order = session.get(Order.class, 2);
		session.delete(order);
		
	}
	
	@Test
	public void testUpdate() {
		
		Order order = session.get(Order.class, 2);
		order.getCustomer().setCustomerName("oracle");
		
	}
	
	@Test
	public void testManyToOneGet() {
		
		Order order = session.get(Order.class, 2);
		System.out.println(order.getOrderName());
		System.out.println(order);
	}
	
	@Test
	public void testManyToOneSave() {
		
		Customer customer = new Customer();
		customer.setCustomerName("lifuz");
		
		Order order1 = new Order();
		order1.setOrderName("order-1");
		order1.setCustomer(customer);
		
		Order order2 = new Order();
		order2.setOrderName("order-2");
		order2.setCustomer(customer);
		
		customer.getOrders().add(order2);
		customer.getOrders().add(order1);
		
		session.save(customer);
		session.save(order2);
		session.save(order1);
		
		System.out.println(customer);
		
	}
	
	@Test
	public void testManyToOne(){
		
		
	}

}
