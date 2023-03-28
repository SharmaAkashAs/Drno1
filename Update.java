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
@WebServlet("/UpdateCustomer")
public class Update extends HttpServlet {
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
		String Name=req.getParameter("name");
		String Email=req.getParameter("email");
		String Number=req.getParameter("no");
		
		//parse values
		int id1=Integer.parseInt(Id);
		long num=Long.parseLong(Number);
	
		//declare resource
		PreparedStatement pstmt=null;
		 
		//create query
		String query="update customer_info set custName=?,custEmail=?,custno=? where custID=?";
		
		try {
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, Name);
			pstmt.setString(2, Email);
			pstmt.setLong(3, num);
			pstmt.setInt(4, id1);
			int count=pstmt.executeUpdate();
			PrintWriter pw=resp.getWriter();
			pw.print("<h1>"+count+" record updated succefully</h1>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}

}
