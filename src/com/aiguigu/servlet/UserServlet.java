package com.aiguigu.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aiguigu.bean.User;
import com.aiguigu.service.UserService;
import com.aiguigu.service.impl.UserServiceImpl;
import com.aiguigu.utils.WebUtils;
import com.google.code.kaptcha.Constants;

public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserService us=new UserServiceImpl();
	public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user2=WebUtils.param2bean(request, new User());
		User user=us.login(user2);
		//���û����浽session��
		HttpSession session=request.getSession();
		session.setAttribute("user", user);
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
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		User user=new User(null,username,password,email);
		//ҳ����֤��
		String code=request.getParameter("code");
		HttpSession session=request.getSession();
		String sessionCode=(String) session.getAttribute(Constants.KAPTCHA_SESSION_CONFIG_KEY);
		//�����֤��һ�£���ע�ᣬ����ص�ע��ҳ�沢��ʾ��֤�����
		if(!sessionCode.equals(code)){
			//��֤����ͬ
			request.setAttribute("msg", "��֤�����");
			request.getRequestDispatcher("/page/user/regist.jsp").forward(request, response);
			return;
		}
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
	//�û��ǳ�����
	protected void logout(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		//����session
		session.invalidate();
		//�����̳���ҳ
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
	
	protected void checkuser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//ҳ��Ӧ�ð��û���������   keyӦ����username
		User user=WebUtils.param2bean(request, new User());
		//����û��Ƿ����
		boolean b=us.checkuser(user);
		if(b){
			//����ע��,д���ݾ��Ǹ��ͻ�����Ӧ
			response.getWriter().write("�û�������");
		}else{
			response.getWriter().write("�û����ѱ�ռ��");
		}
	}
	
	
}
