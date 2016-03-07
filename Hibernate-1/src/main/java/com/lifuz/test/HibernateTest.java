package com.lifuz.test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import com.lifuz.model.News;

public class HibernateTest {

	@Test
	public void test() {

		// 1.创建一个SessionFactory 对象

		SessionFactory sessionFactory = null;

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure().build();
		
		Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();
		
		sessionFactory = metadata.buildSessionFactory();

		// 2.创建一个Session 对象
		Session session = sessionFactory.openSession();

		// 3.开启事务

		Transaction transaction = session.beginTransaction();

		// 4.执行保存操作

		News news = new News("java", "prd", new Date(new java.util.Date().getTime()));

		session.save(news);

		// 5.提交事务

		transaction.commit();

		// 6.关闭Session 对象
		session.close();

		// 7.关闭SessionFactory 对象

		sessionFactory.close();

	}

}
