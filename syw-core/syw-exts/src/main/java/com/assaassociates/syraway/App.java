package com.assaassociates.syraway;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.assaassociates.syraway.dao.jpa.CollaboratorDAOImpl;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext oContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-persistence.xml");
    	//CollaboratorDAOImpl otest = oContext.getBean("CollaboratorDAO", CollaboratorDAOImpl.class);
    	String[] otest = oContext.getBeanDefinitionNames();
    	//otest.getCollaboratorsByName("test");
    	if(oContext != null){
    		System.out.println( "Hello World!" );
    		for (int i = 0; i < otest.length; i++) {
				System.out.println("BEAN : " + otest[i]);
			}
    	}
    }
}
