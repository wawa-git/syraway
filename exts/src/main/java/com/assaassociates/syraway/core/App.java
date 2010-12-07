package com.assaassociates.syraway.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.assaassociates.syraway.core.repositories.CollaboratorDAOImpl;
import com.assaassociates.syraway.core.repositories.interfaces.ICollaboratorDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext oContext = new ClassPathXmlApplicationContext("classpath:spring/spring-conf.xml");
    	CollaboratorDAOImpl otest = oContext.getBean("CollaboratorDAO", CollaboratorDAOImpl.class);
    	otest.getCollaborator("test", "test");
    	if(oContext != null)
    		System.out.println( "Hello World!" );
    }
}
