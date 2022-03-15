package ch19.ex01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

//di를 이용한 데이터 받아오기
public class PersonTest {

	public static void main(String[] args) {
		//person.xml file load
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml"));
		//personService id value load
		PersonService person = (PersonService) factory.getBean("personService");
		
		//javacode no create
		//PersonService person = new PersonServiceImpl();
		person.sayHello();
	}

}
