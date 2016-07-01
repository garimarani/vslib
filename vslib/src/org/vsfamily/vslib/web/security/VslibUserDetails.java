package org.vsfamily.vslib.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.vsfamily.vslib.common.domain.Patron;
import org.vsfamily.vslib.manager.domain.Manager;

@SuppressWarnings("serial")
public class VslibUserDetails implements UserDetails {

	private String username;
	private String password;
	private boolean accountNonLocked = false;
	private boolean accountNonExpired = false;
	private boolean credentialsNonExpired = false;
	private boolean enabled = false;
	private List<? extends GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

	public VslibUserDetails(Manager manager,
			List<? extends GrantedAuthority> authorities) {
		this.username = manager.getUid();
		this.password = manager.getPassword();
		this.accountNonExpired = manager.isAccountNonExpired();
		this.accountNonLocked = manager.isAccountNonLocked();
		this.enabled = manager.isEnabled();
		this.credentialsNonExpired = true;
		this.authorities = authorities;
	}

	public VslibUserDetails(Patron patron,
			List<? extends GrantedAuthority> authorities) {
		this.username = patron.getLoginId();
		this.password = patron.getPassword();
		this.accountNonExpired = true;
		this.accountNonLocked = true;
		this.enabled = true;
		this.credentialsNonExpired = true;
		this.authorities = authorities;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}
}
