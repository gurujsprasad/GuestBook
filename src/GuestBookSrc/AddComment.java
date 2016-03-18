package GuestBookSrc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int count = 100;
	public AddComment() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter outln = response.getWriter();
		outln.println("<html><body>");
		outln.println("<h2> Add comments</h2>");
		outln.println("<form action = 'AddComment'  method = 'post'> Name: <input type = 'text' name = 'name' id = 'name'/><br/> ");
		outln.println("<textarea cols= '10' rows = '5' name = 'comment' id='comment'></textarea> <br/>");
		outln.println("<input type = 'submit' name = 'ADD' value = 'ADD'/>");
		outln.println("</form>");
		outln.println("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//PrintWriter outln = response.getWriter();
		count++;
	    String name = request.getParameter("name");
	    String comment = request.getParameter("comment");
	    
	    ArrayList<GuestBookEntries> entries = new ArrayList<GuestBookEntries>();
	    
	    entries = (ArrayList<GuestBookEntries>) getServletContext().getAttribute("entries");
	    
	    entries.add(new GuestBookEntries(name, comment, count));
	    
	    getServletContext().setAttribute("entries", entries);
	    response.sendRedirect("Display");
	    
		
	}

}
