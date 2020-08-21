package com.aiguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aiguigu.bean.User;
import com.aiguigu.service.UserService;
import com.aiguigu.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us=new UserServiceImpl();
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user=us.login(new User(null,username,password,null));
		if(user==null){
			//��¼ʧ��
			request.setAttribute("msg", "�û�������");
			//������Ҫ���Ե���Ŀ
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}else{
			//��¼�ɹ�
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.jsp");
		}
	}

}
