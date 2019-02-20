package com.ros.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ros.utils.DBConnectionUtils;

/**
 * Servlet implementation class CreateHelloServlet
 */
@WebServlet("/addServlet")
public class CreateHelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    /**
     * Default constructor. 
     */
    public CreateHelloServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("IN POST");

		    String firstname=request.getParameter("firstName");
		    String lastname=request.getParameter("lastName");
		    String email=request.getParameter("email");
		    String password=request.getParameter("password");

		    try {
		    	DBConnectionUtils connectionUtils = new DBConnectionUtils();
		    	Connection connection = connectionUtils.getDBConnection();
		        Statement stmt = connection.createStatement();
		        String query = "insert into userdetails values('"+firstname+"','"+email+"','"+password+"','"+lastname+"')";
		        int result = stmt.executeUpdate(query);
		        PrintWriter out = response.getWriter();

		        if (result>0) 
		        {
		        out.println(result + "value(s) inserted");
		        }

		        else {

		            out.println("Error inserting values... ");
		        }

		    } catch (SQLException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }

		}
	

}
