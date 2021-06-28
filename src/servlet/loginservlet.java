package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;

public class loginservlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		String username=request.getParameter("dlusername");
		String password=request.getParameter("dlpassword");
		System.out.print(username);
		boolean c=false;
		try {
			c=UserDao.longin(username,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(c){
			PrintWriter out = resp.getWriter();
			out.print("µ«¬º≥…π¶");
		}else{
			request.setAttribute("msig", "’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
			request.getRequestDispatcher("/login.jsp").forward(request,resp);
		}

		
	}
}
