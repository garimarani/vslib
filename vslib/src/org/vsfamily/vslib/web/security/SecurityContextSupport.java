package org.vsfamily.vslib.web.security;

import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityContextSupport {
	public static VslibUserDetails getUserDetails() {
		return (VslibUserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
	}
}
