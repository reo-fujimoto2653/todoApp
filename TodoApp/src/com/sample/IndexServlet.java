package com.sample;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//タスク完了ボタンを押されたときの処理
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		List<Task> list = (List<Task>) session.getAttribute("list");

		String strIdArray[] = request.getParameterValues("id");

		if (strIdArray != null) {
			for (String strId : strIdArray) {
				int id = Integer.parseInt(strId);

				for (Task task : list) {
					if (task.getId() == id) {
						task.setIsCompleted(true);
						break;
					}
				}
			}
		}

		session.setAttribute("list", list);

		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);

		return;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		//セッションからタスク一覧を取得
		List<Task> list = (List<Task>) session.getAttribute("list");
		//sessionのなかにタスクが存在しない場合は新しく作る
		if (list == null) {
			list = new ArrayList<>();
		}
		//セッションからIDを取得してダウンキャスト
		Integer id = (Integer) session.getAttribute("id");
		if (id == null) {
			id = 0;
		}
		//タスク担当者
		String member = request.getParameter("member");
		//日付が文字列でくるので、String->Dateへの変換を行う
		String strDeadLine = request.getParameter("deadline");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		Date deadline = null;
		try {
			deadline = dateFormat.parse(strDeadLine);
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		//タスク名
		String text = (String) request.getParameter("text");
		//タスクのインスタンスを作成
		Task task = new Task(id + 1, member, deadline, text);
		System.out.println(task);
		//セッションから取り出したListに新しく追加する
		list.add(task);
		//セッションにタスクのListとidを格納する
		session.setAttribute("list", list);
		session.setAttribute("id", id + 1);

		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");

		rd.forward(request, response);

		return;
	}

}
