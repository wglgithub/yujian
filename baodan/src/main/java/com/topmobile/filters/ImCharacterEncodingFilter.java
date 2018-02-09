package com.topmobile.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * 编码过滤
 * @author wgl
 *
 */
public class ImCharacterEncodingFilter extends CharacterEncodingFilter {
	@Override
	public void setEncoding(String encoding) {
		// TODO Auto-generated method stub
		super.setEncoding(encoding);
	}

	@Override
	public void setForceEncoding(boolean forceEncoding) {
		// TODO Auto-generated method stub
		super.setForceEncoding(forceEncoding);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doFilterInternal(request, response, filterChain);
	}
}
