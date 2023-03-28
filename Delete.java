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
@WebServlet("/deleteCustomer")
public class Delete  extends HttpServlet{
	
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
String ID=req.getParameter("ID");
int id1=Integer.parseInt(ID);


//declare resource
	PreparedStatement pstmt=null;
	
	//create query
		String query="delete from customer_info where custID=(?)";
		
		try {
			pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, id1);
			
			int count=pstmt.executeUpdate();
			PrintWriter pw=resp.getWriter();
			pw.print("<h1>"+count+" record deleted succefully</h1>");
		}
		catch(SQLException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		
}
}
