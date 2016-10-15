//package Servlet;
//
//import javax.servlet.*;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//public class LoginServlet implements Servlet {
//
//    public void init(ServletConfig config) throws ServletException {
//        System.out.println("init");
//    }
//
//    public void service(ServletRequest request, ServletResponse response)
//            throws ServletException, IOException {
//        System.out.println("from service");
//        PrintWriter out = response.getWriter();
//        out.println("Hello,world!");
//    }
//
//    public void destroy() {
//        System.out.println("destroy");
//    }
//
//    public String getServletInfo() {
//        return null;
//    }
//
//    public ServletConfig getServletConfig() {
//        return null;
//    }
//
//}
package Servlet;
import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class LoginServlet implements Servlet{
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
	request.setCharacterEncoding("utf-8");
    String username = request.getParameter("username");
    String password = request.getParameter("paw");
    System.out.println(username+password);
   }
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
