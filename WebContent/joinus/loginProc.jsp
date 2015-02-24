<%@page import="org.apache.catalina.startup.SetAllPropertiesRule"%>
<%@page import="com.newlecture.jspprj.model.Member"%>
<%@page import="com.newlecture.jspprj.jdbc.JdbcMemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String mid = request.getParameter("mid");
	String pwd = request.getParameter("pwd");
	
	Member m = new JdbcMemberDao().getMember(mid);
	
	String msg = "";
	
	if(m==null)
		msg = "가입해르!";
	else if(!m.getPwd().equals(pwd))
		msg = "틀렸다!";
	else
	{
		session.setAttribute("mid", mid);
	}
	
	if(!msg.equals(""))
	{
	request.setAttribute("msg", msg);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
	dispatcher.forward(request,response);
	}
	
	else
		response.sendRedirect("../index.jsp");
%>
