package com.sample;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//index.jspから処理を受け取ったときの処理
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		List<Task> list = (List<Task>) session.getAttribute("list");

		int id = Integer.parseInt(request.getParameter("id"));

		Task editTask = null;

		for(Task task:list) {
			if(task.getId()==id) {
				editTask = task;
				break;
			}
		}


		request.setAttribute("editTask", editTask);
		//session.setAttribute("edit",editTask);

		RequestDispatcher rd = request.getRequestDispatcher("/edit.jsp");
		rd.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//edit.jspから処理を受け取ったときの処理
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		List<Task> list = (List<Task>) session.getAttribute("list");

		int id = Integer.parseInt(request.getParameter("id"));

		String strDeadline = (String) request.getParameter("deadline");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		Date deadline = null;

		try {
			deadline = dateFormat.parse(strDeadline);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		for(Task task:list) {
			if(task.getId()==id) {
				task.setMember(request.getParameter("member"));
				task.setText(request.getParameter("text"));
				task.setDeadline(deadline);

				break;
			}
		}

		session.setAttribute("list", list);

		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);

		return;

	}

}
