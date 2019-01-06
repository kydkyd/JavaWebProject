package com.kyd.javawebbook.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.sql.SQLException;
import java.util.concurrent.Executor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dyc.javawebbook.dao.BookDao;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * Servlet implementation class Bookservlet
 */
@WebServlet("/Bookservlet/*")
public class Bookservlet extends HttpServer {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Bookservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {
			String booksjson = BookDao.SELECT();
			PrintWriter out = response.getWriter();
			out.write(booksjson);
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("application/plain");
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");

	    if (request.getRequestURI().equals("/demo1/Bookservlet/DELETE")) //根据项目路径更改
	    {
	      System.out.println("delete");
	      String id = request.getParameter("id");
	      String result;
	      try {
	        result = BookDao.DELETE(id);
	        PrintWriter out = response.getWriter();
	        out.write(result);
	        out.flush();
	        out.close();
	      } catch (ClassNotFoundException | SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      }

	    }

	    if (request.getRequestURI().equals("/demo1/Bookservlet/UPDATE")) {
	      System.out.println("update");

	      BufferedReader reader = request.getReader();
	      String json = reader.readLine();
	      System.out.println(json);
	      reader.close();
	      String result;
	      try {
	        result = BookDao.UPDATE(json);
	        PrintWriter out = response.getWriter();
	        out.write(result);
	        out.flush();
	        out.close();
	      } catch (ClassNotFoundException | SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      }
	    }

	    if (request.getRequestURI().equals("/demo1/Bookservlet/INSERT")) {
	      System.out.println("insert");

	      BufferedReader reader = request.getReader();
	      String json = reader.readLine();
	      System.out.println(json);
	      reader.close();
	      String result;
	      try {
	        result = BookDao.INSERT(json);
	        PrintWriter out = response.getWriter();
	        out.write(result);
	        out.flush();
	        out.close();
	      } catch (ClassNotFoundException | SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      }
	    }
	}

	@Override
	public void bind(InetSocketAddress arg0, int arg1) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HttpContext createContext(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpContext createContext(String arg0, HttpHandler arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InetSocketAddress getAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Executor getExecutor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeContext(String arg0) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeContext(HttpContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setExecutor(Executor arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop(int arg0) {
		// TODO Auto-generated method stub
		
	}
}
