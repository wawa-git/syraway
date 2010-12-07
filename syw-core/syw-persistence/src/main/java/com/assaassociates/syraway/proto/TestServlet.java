package com.assaassociates.syraway.proto;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.assaassociates.syraway.dao.jpa.CollaboratorDAOImpl;

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
    	
    		
//		super.doGet(arg0, arg1);
	}

}
