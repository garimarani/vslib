package org.vsfamily.vslib.web.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.vsfamily.vslib.common.domain.Patron;
import org.vsfamily.vslib.manager.domain.GroupRole;
import org.vsfamily.vslib.manager.domain.Manager;
import org.vsfamily.vslib.manager.domain.ManagerGroup;
import org.vsfamily.vslib.manager.domain.ManagerRole;
import org.vsfamily.vslib.web.manager.service.ManagerService;
import org.vsfamily.vslib.web.service.VslibService;

public class VslibUserDetailsService implements UserDetailsService {

	@Autowired
	ManagerService managerService;
	
	@Autowired
	VslibService vslibService;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		this.managerService.createDefaultAdminAccount();
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		
		Manager manager = this.managerService.getManagerByUid(username);
		
		if (manager==null){
			Patron patron = this.vslibService.getPatronByLoginId(username);
			
			if (patron == null){
				throw new UsernameNotFoundException("Username not found");
			}
			
			grantedAuthorities.add(new SimpleGrantedAuthority(patron.getRole()));
			
			return new VslibUserDetails(patron, grantedAuthorities);
		} else {
			
			List<ManagerGroup> listManagerGroup = this.managerService.listManagerGroup(manager);
			
			for(ManagerGroup mg : listManagerGroup){
				List<GroupRole> listGroupRole = this.managerService.listGroupRole(mg.getGroup());
				
				for(GroupRole gr : listGroupRole){
					grantedAuthorities.add(new SimpleGrantedAuthority(gr.getRole().getCode()));
				}
			}
			
			List<ManagerRole> listManagerRole = this.managerService.listManagerRole(manager);
			
			for(ManagerRole mr : listManagerRole){
				grantedAuthorities.add(new SimpleGrantedAuthority(mr.getRole().getCode()));
			}
			
			return new VslibUserDetails(manager, grantedAuthorities);
		}
	}
}
