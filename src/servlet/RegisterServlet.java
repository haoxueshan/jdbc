package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.doman.User;
import com.service.UserService;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegisterServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserService userService=new UserService();
		request.setCharacterEncoding("UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		User u1=new User();
		u1.setUsername(username);
		u1.setPassword(password);
		boolean b=false;
		try {
			 b=userService.register(u1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(b){
			request.setAttribute("msg", "×¢²á³É¹¦ÇëµÇÂ¼");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "×¢²áÊ§°Ü,ÒÑÓÐ¸ÃÕËºÅ");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		
	}

}
