package com.lifuz.test;

import java.util.Date;

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

import com.lifuz.model.News;

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
	public void test() {
		
		
		News news = new News("java", "list", new Date());
		session.save(news);
	}
	
	@Test
	public void testSessionFlush() {
		
		News news = session.get(News.class, 6);
		news.setTitle("oracle");
		
	}
	
	@Test
	public void testSession() {
		
		News news = session.get(News.class, 6);
		System.out.println(news);
		
		news = session.get(News.class, 6);
		System.out.println(news);
	}

}
