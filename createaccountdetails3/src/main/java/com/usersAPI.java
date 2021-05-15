package com;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/usersAPI")
public class usersAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	users usersObj;

	public usersAPI() {
		super();
		usersObj = new users();
	}

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String output = usersObj.insertusers(
				request.getParameter("UserFirstName"),
				request.getParameter("UserLastName"),
				request.getParameter("UserAddress"),
				request.getParameter("UserNIC"),
				request.getParameter("UserPhoneNumber"),
				request.getParameter("UserEmail"),
				request.getParameter("UserName"),
				request.getParameter("UserPassword"));
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Map<String, String> paras = getParasMap(request);
		String output = usersObj.updateusers(Integer.parseInt(paras.get("hidUserIdSave").toString()),
				paras.get("UserFirstName"),
				paras.get("UserLastName"),
				paras.get("UserAddress"),
				paras.get("UserNIC"),
				paras.get("UserPhoneNumber"),
				paras.get("UserEmail"),
				paras.get("UserName"),
				paras.get("UserPassword"));
		response.getWriter().write(output);
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Map<String, String> paras = getParasMap(request);
		String output = usersObj.removeusers(Integer.parseInt(paras.get("UserId").toString()));
		response.getWriter().write(output);
	}

	
	// Convert request parameters to a Map
	private static Map<String,String> getParasMap(HttpServletRequest request)
	{
		Map<String, String> map = new HashMap<String, String>();
		try
		{
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ?
					scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			String[] params = queryString.split("&");
			for (String param : params)
			{
				String[] p = param.split("=");
				map.put(p[0], java.net.URLDecoder.decode(p[1], StandardCharsets.UTF_8.name()));
			}
		}
		catch (Exception e)
		{
		}
		return map;
	}
}