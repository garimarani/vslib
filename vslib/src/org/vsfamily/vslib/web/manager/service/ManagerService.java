package org.vsfamily.vslib.web.manager.service;

import java.util.List;

import org.vsfamily.vslib.manager.domain.GroupRole;
import org.vsfamily.vslib.manager.domain.Manager;
import org.vsfamily.vslib.manager.domain.ManagerGroup;
import org.vsfamily.vslib.manager.domain.ManagerRole;
import org.vsfamily.vslib.manager.domain.VslibGroup;
import org.vsfamily.vslib.manager.domain.VslibRole;


public interface ManagerService {

	public boolean						addGroupRole(GroupRole obj);
	public boolean						addManager(Manager obj);
	public boolean						addManagerGroup(ManagerGroup obj);
	public boolean						addManagerRole(ManagerRole obj);
	public boolean						addVslibGroup(VslibGroup obj);
	public boolean						addVslibRole(VslibRole obj);
	
	public boolean						deleteGroupRole(GroupRole obj);
	public boolean						deleteManager(Manager obj);
	public boolean						deleteManagerGroup(ManagerGroup obj);
	public boolean						deleteManagerRole(ManagerRole obj);
	public boolean						deleteVslibGroup(VslibGroup obj);
	public boolean						deleteVslibRole(VslibRole obj);

	public GroupRole					getGroupRole(Long id);
	public GroupRole					getGroupRole(VslibGroup group, VslibRole role);
	public Manager						getManager(Long id);
	public Manager						getManagerByUid(String uid);
	public ManagerGroup					getManagerGroup(Long id);
	public ManagerGroup					getManagerGroup(Manager manager, VslibGroup group);
	public ManagerRole					getManagerRole(Long id);
	public ManagerRole					getManagerRole(Manager manager, VslibRole role);
	public VslibGroup					getVslibGroup(Long id);
	public VslibGroup					getVslibGroupByCode(String code);
	public VslibGroup					getVslibGroupByName(String name);
	public VslibRole					getVslibRole(Long id);
	public VslibRole					getVslibRoleByCode(String code);
	public VslibRole					getVslibRoleByName(String name);
	
	public List<GroupRole>				listGroupRole(VslibGroup group);
	public List<GroupRole>				listGroupRole(VslibRole role);
	public List<Manager>				listManager();
	public List<ManagerGroup>			listManagerGroup(VslibGroup group);
	public List<ManagerGroup>			listManagerGroup(Manager manager);
	public List<ManagerRole>			listManagerRole(Manager manager);
	public List<ManagerRole>			listManagerRole(VslibRole role);
	public List<VslibGroup>				listVslibGroup();
	public List<VslibRole>				listVslibRole();
	
	public boolean						updateGroupRole(GroupRole obj);
	public boolean						updateManager(Manager obj);
	public boolean						updateManagerGroup(ManagerGroup obj);
	public boolean						updateManagerRole(ManagerRole obj);
	public boolean						updateVslibGroup(VslibGroup obj);
	public boolean						updateVslibRole(VslibRole obj);
	
	public void							createDefaultAdminAccount();
	
}
