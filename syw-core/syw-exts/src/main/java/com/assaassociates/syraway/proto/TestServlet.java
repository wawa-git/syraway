package com.assaassociates.syraway.proto;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.assaassociates.syraway.dao.jpa.CollaboratorDAOImpl;
import com.assaassociates.syraway.model.Collaborator;

/**
 * 
 */

/**
 * @author waheb
 *
 */
public class TestServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6886483498496497962L;

	@PersistenceContext EntityManager oEntityManager; 
	
	@Override
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		arg1.setContentType("text/html");
		PrintWriter out = arg1.getWriter();
		out.print("ceci est un test");

		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());

//		ApplicationContext oContext = new ClassPathXmlApplicationContext("classpath:spring/spring-conf.xml");
//    	
//		
//		CollaboratorDAOImpl otest = oContext.getBean("CollaboratorDAO", CollaboratorDAOImpl.class);
//    	otest.getCollaborator("test", "test");
    	if(ctx != null){
    		System.out.println( "Hello World!" );
    		
    		String[] beans = ctx.getBeanDefinitionNames();
    		for (int i = 0; i < beans.length; i++) {
    			out.print("<br/>");
				out.print("bean : " + beans[i]);
			}
    	}
    	CollaboratorDAOImpl test = new CollaboratorDAOImpl();
    	test.getCollaboratorNameById("toto");
    	
    	if(oEntityManager != null){
    		System.out.println("Servlet : oEntityManager is not null");
    		Collaborator oCollaborator = new Collaborator();
    		oCollaborator.setId("test");
    		oCollaborator.setFirstName("test");
    		oCollaborator.setLastName("test");
    		if(oEntityManager.contains(oCollaborator))
    			System.out.println("existe");
    		else{
    			System.out.println("not existe");
////    			EntityTransaction tx = oEntityManager.getTransaction();
////    			if (tx != null){
////    				tx.begin();
//    				System.out.println("begin trans");
//    				oEntityManager.persist(oCollaborator);
////    				tx.commit();
//    				System.out.println("trans commited");
////    			}else
////    				System.out.println("tras is null");
    		}
    	}
    	else
    		System.out.println("Servlet : oEntityManager is null");
    	
    		
//		super.doGet(arg0, arg1);
	}

}
