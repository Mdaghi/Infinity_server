package com.github.adminfaces.starter.infra.model;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.adminfaces.starter.infra.security.LogonMB;
import com.github.adminfaces.template.session.AdminFilter;

import tn.esprit.infinity_server.persistence.Administrator;
import tn.esprit.infinity_server.persistence.Client;


@WebFilter("/user/*")
public class ClientFilter extends AdminFilter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		if (LogonMB.user == null) {
			servletResponse.sendRedirect(servletRequest.getContextPath() + "/login.jsf");
		} else {
			if ((LogonMB.user instanceof Client)) {
				chain.doFilter(servletRequest, servletResponse);
			} else if (LogonMB.user instanceof Administrator) {
				servletResponse.sendRedirect(servletRequest.getContextPath() + "/403.jsf");
			}
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
