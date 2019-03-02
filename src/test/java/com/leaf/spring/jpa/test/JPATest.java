package com.leaf.spring.jpa.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.leaf.spring.jpa.entities.Person;
import com.leaf.spring.jpa.service.PersonService;

public class JPATest {

	private ApplicationContext ioc = null;
	
	{
		ioc = new ClassPathXmlApplicationContext("classpath*:application*.xml");
	}
	
	@Test
	public void testDataSource() throws Exception {
		DataSource dataSource = ioc.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}
	
	@Test
	public void testSave()  {
		PersonService service = ioc.getBean(PersonService.class);
		Person p1 = new Person();
		p1.setAge(23);
		p1.setEmail("leaf@gmail.com");
		p1.setLastName("Leaf");
		Person p2 = new Person();
		p2.setAge(25);
		p2.setEmail("demo@gmail.com");
		p2.setLastName("Demo");
		service.savePersons(p1, p2);
	}
}
