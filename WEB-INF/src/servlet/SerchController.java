package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MusicBean;
import model.ResultContent;

public class SerchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<MusicBean> musicBean = new ArrayList<MusicBean>();
		musicBean.add(new MusicBean("Ado","私は最強"));
		musicBean.add(new MusicBean("Official髭男dism","TATTOO"));
		musicBean.add(new MusicBean("Mrs.GreenApple","ケセラセラ"));
		musicBean.add(new MusicBean("ずっと真夜中でいいのに。","残機"));
		musicBean.add(new MusicBean("米津玄師","LADY"));
		musicBean.add(new MusicBean("なとり","Overdose"));
		musicBean.add(new MusicBean("Kanaria","酔いどれ知らず"));
		musicBean.add(new MusicBean("amazarashi","季節は次々死んでいく"));
		musicBean.add(new MusicBean("バルーン","シャルル"));

		ResultContent content = new ResultContent(musicBean);
		req.setAttribute("content", content);

		RequestDispatcher dis = req.getRequestDispatcher("/jsp/result.jsp");
		dis.forward(req, resp);
	}

}
