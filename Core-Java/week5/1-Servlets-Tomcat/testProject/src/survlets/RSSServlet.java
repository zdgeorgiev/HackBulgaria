package survlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.syndication.io.FeedException;

import logic.RSSObject;
import logic.RSSUtils;

/**
 * Servlet implementation class RSSServlet
 */
@WebServlet("/RSSServlet")
public class RSSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String HTML_START="<html><body>";
    public static final String HTML_END="</body></html>";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		List<RSSObject> objs = RSSUtils.getContent();
		StringBuilder html = new StringBuilder();
		html.append(HTML_START);
		
		for (RSSObject obj : objs) {
			html.append("<h3><a href=\"" + obj.getLink() + "\">" + obj.getTitle() + "</a></h3>");
			html.append(obj.getContent());
			html.append("<div>" + obj.getDate() + "</div>");
		}

		html.append(HTML_START);

		response.getWriter().println(html.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
