package com.aiguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aiguigu.bean.User;
import com.aiguigu.service.UserService;
import com.aiguigu.service.impl.UserServiceImpl;

public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us=new UserServiceImpl();
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		User user=new User(null,username,password,email);
		boolean b=us.regist(user);
		System.out.println(user.toString()+b);
		//�û�ע��
		if(b){
			//ע��ɹ������سɹ�ҳ�棬�ض���
			response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.jsp");
		}else{
			//ע��ʧ�ܣ�����ע��ҳ������ע�ᣬת��
			request.setAttribute("msg", "�û��Ѵ���");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
		
	}

}
