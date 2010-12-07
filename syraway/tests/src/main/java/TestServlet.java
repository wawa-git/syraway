import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 */

/**
 * @author waheb
 *
 */
public class TestServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		arg1.setContentType("text/html");
		PrintWriter out = arg1.getWriter();
		out.print("ceci est un test");
		out.flush();
		
		super.doGet(arg0, arg1);
	}

}
