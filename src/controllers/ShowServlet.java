package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;
import utils.DButil;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/show")
public class ShowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //DB操作
        EntityManager em = DButil.createEntityManager();

        //該当のIDのメッセージ1件のみをDBから取得
        Task t = em.find(Task.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        //データをリクエストスコープにセットしてJSP呼び出し
        request.setAttribute("task", t);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/messages/show.jsp");
        rd.forward(request, response);
    }
}
