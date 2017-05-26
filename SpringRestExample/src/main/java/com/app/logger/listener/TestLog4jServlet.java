package com.app.logger.listener;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class TestLog4jServlet extends HttpServlet {
	static final Logger LOGGER = Logger.getLogger(TestLog4jServlet.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOGGER.info("This is a logging statement from log4j");
		String html = "<html><h2>Log4j has been initialized successfully!</h2></html>";
		resp.getWriter().println(html);
	}


}