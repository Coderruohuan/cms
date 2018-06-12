package com.wang.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class BeanServlet
 */

public class BeanServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public BeanServlet2() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		BeanClass bean1 = (BeanClass) context.getBean("singleClass");
		System.out.println("singleClass:" + bean1);

		BeanClass bean2 = (BeanClass) context.getBean("propertyClass");
		System.out.println("propertyClass:" + bean2);

		BeanClass bean3 = (BeanClass) context.getBean("requsetClass");
		System.out.println("requsetClass:" + bean3);

		BeanClass bean4 = (BeanClass) context.getBean("sessionClass");
		System.out.println("sessionClass:" + bean4);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
