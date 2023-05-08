package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ResultContent;
import util.Serializer;

public class PageController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String trans = req.getParameter("trans");
		ResultContent content=(ResultContent)Serializer.fromString(req.getParameter("content"));

		if("next".equals(trans)) {
			content.nextPage();
		}
		else if("prev".equals(trans)) {
			content.prevPage();
		}

		req.setAttribute("content", content);

		RequestDispatcher dis = req.getRequestDispatcher("/jsp/result.jsp");
		dis.forward(req, resp);
	}
}
