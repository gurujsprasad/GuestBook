package GuestBookSrc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Display() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		ArrayList<GuestBookEntries> entry = new ArrayList<GuestBookEntries>();
		
		entry.add(new GuestBookEntries("Guru", "Hello", 1));
		entry.add(new GuestBookEntries("Gautham","Wass up", 2));
		
		config.getServletContext().setAttribute("entries", entry);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter outln = response.getWriter();
		ArrayList<GuestBookEntries> entries = new ArrayList<GuestBookEntries>();
		entries =	(ArrayList<GuestBookEntries>) getServletContext().getAttribute("entries");
		outln.println("<html><body><h2>Guest Book </h2>");
		outln.println("<table border='1'><tr><th>Name</th><th>Comment</th><th>Operations</th></tr>");
		for (int i = 0; i < entries.size(); i ++)
		{			
			outln.println("<tr><td>"+entries.get(i).getName()+"</td><td>"+entries.get(i).getComment()+"</td>");
			outln.println("<td><a href = 'EditComment?id="+ entries.get(i).getId() +"'> Edit </a>");
			outln.println("<td><a href = 'Delete?id="+ entries.get(i).getId() +"'> Delete </a></td></tr>");
		}
		outln.println("</table>");
		outln.println("Clicke <a href = 'AddCommentCookie'>here</a> to add comment");
		outln.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
