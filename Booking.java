package Demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/booking1")
public class Booking extends HttpServlet {
Connection con;
	
	

	@Override
	public void init() throws ServletException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/table","root","9130627990@As");
		}catch(ClassNotFoundException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//fetch the values from html page
		String Id=req.getParameter("id");
	String Id1=req.getParameter("id1");
	String Id2=req.getParameter("id2");
	String Time=req.getParameter("time");
	
	int id3=Integer.parseInt(Id);
	int id4=Integer.parseInt(Id1);
	//declare resource
	PreparedStatement pstmt;
	
	
	//create query
	String query="insert into droane(bookingId,locId,droaneId,createdTime)values(?,?,?,?)";
	
	try {
		pstmt=con.prepareStatement(query);
		pstmt.setInt(1, id3);
		pstmt.setInt(2, id4);
		pstmt.setString(3,Id2);
		pstmt.setString(4,Time);
		int count=pstmt.executeUpdate();
		PrintWriter pw=resp.getWriter();
		pw.print("<h1>"+count+ "Booking Successfully</h1>");
	}
	catch(SQLException e) {
		//TODO Auto-generated catch block
		e.printStackTrace();
		
		
	}
	
	}

}
