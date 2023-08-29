package com.astrazeneca.demo.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class CORSFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		String[] allowDomain = { "http://localhost:4200", "http://localhost:5000","http://localhost" };

		Set<String> allowedOrigins = new HashSet<>(Arrays.asList(allowDomain));
		String originHeader = request.getHeader("Origin");

		if (allowedOrigins.contains(originHeader))
			response.setHeader("Access-Control-Allow-Origin", originHeader);

		response.setHeader("Access-Control-Allow-Credentials", "true");

		// Delete is removed
		response.setHeader("Access-Control-Allow-Methods", "POST, GET");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"Content-Type, Accept, X-Requested-With, remember-me, Authorization ,X-OrganizationKey");

		// Added below three headers to resolve penetration test defects
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
		response.setHeader("Cache-Control", " no-store");
		response.setHeader("Pragma", "no-cache");

		// All present and future subdomains will be HTTPS for a max-age of 1
		// year. This blocks access to pages or sub domains that can only be
		// served over HTTP.
		response.setHeader("Strict-Transport-Security", "max-age=31536000");
		response.setHeader("Referrer-Policy", "no-referrer");
		/*
		 * Hiding the server details with custom message.
		 */
		response.setHeader("Server", "happy to serve you");

		/*
		 * manually blocking all the request excepts GET & POST. This is a work around,
		 * until proper security has been implemented.
		 */
		if (request.getMethod().equalsIgnoreCase("get") || request.getMethod().equalsIgnoreCase("post")
				|| request.getMethod().equalsIgnoreCase("delete") || request.getMethod().equalsIgnoreCase("put")) {
			chain.doFilter(req, res);
		}

	}

	@Override
	public void init(FilterConfig filterConfig) {
		// Nothing to initialize
	}

	@Override
	public void destroy() {
		// Nothing to cleanup
	}

}
