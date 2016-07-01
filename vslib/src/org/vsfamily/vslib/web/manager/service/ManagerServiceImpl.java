package org.vsfamily.vslib.web.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.vsfamily.common.domain.Address;
import org.vsfamily.common.domain.Salutation;
import org.vsfamily.vslib.manager.domain.GroupRole;
import org.vsfamily.vslib.manager.domain.Manager;
import org.vsfamily.vslib.manager.domain.ManagerGroup;
import org.vsfamily.vslib.manager.domain.ManagerRole;
import org.vsfamily.vslib.manager.domain.VslibGroup;
import org.vsfamily.vslib.manager.domain.VslibRole;
import org.vsfamily.vslib.web.manager.repository.ManagerDAO;


@Component(value="managerService")
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	ManagerDAO managerDAO;

	@Override
	public boolean addGroupRole(GroupRole obj) {
		return this.managerDAO.save(obj);
	}

	@Override
	public boolean addManager(Manager obj) {
		
		//PasswordEncoder encoder = new Md5PasswordEncoder();
		//String hashedPass = encoder.encodePassword(obj.getPassword(), null);
		
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPass = encoder.encode(obj.getPassword());
		
        obj.setPassword(hashedPass);
		
		return this.managerDAO.save(obj);
	}

	@Override
	public boolean addManagerGroup(ManagerGroup obj) {
		return this.managerDAO.save(obj);
	}

	@Override
	public boolean addManagerRole(ManagerRole obj) {
		return this.managerDAO.save(obj);
	}

	@Override
	public boolean addVslibGroup(VslibGroup obj) {
		return this.managerDAO.save(obj);
	}

	@Override
	public boolean addVslibRole(VslibRole obj) {
		return this.managerDAO.save(obj);
	}

	@Override
	public boolean deleteGroupRole(GroupRole obj) {
		return this.managerDAO.delete(obj);
	}

	@Override
	public boolean deleteManager(Manager obj) {
		return this.managerDAO.delete(obj);
	}

	@Override
	public boolean deleteManagerGroup(ManagerGroup obj) {
		return this.managerDAO.delete(obj);
	}

	@Override
	public boolean deleteManagerRole(ManagerRole obj) {
		return this.managerDAO.delete(obj);
	}

	@Override
	public boolean deleteVslibGroup(VslibGroup obj) {
		return this.managerDAO.delete(obj);
	}

	@Override
	public boolean deleteVslibRole(VslibRole obj) {
		return this.managerDAO.delete(obj);
	}

	@Override
	public GroupRole getGroupRole(Long id) {
		return (GroupRole) this.managerDAO.getObjectById(GroupRole.class, id);
	}

	@Override
	public GroupRole getGroupRole(VslibGroup group, VslibRole role) {
		return (GroupRole) this.managerDAO.getObjectByArgTwo(GroupRole.class, "group", group, "role", role);
	}

	@Override
	public Manager getManager(Long id) {
		return (Manager) this.managerDAO.getObjectById(Manager.class, id);
	}

	@Override
	public Manager getManagerByUid(String uid) {
		return (Manager) this.managerDAO.getObjectByArg(Manager.class, "uid", uid);
	}

	@Override
	public ManagerGroup getManagerGroup(Long id) {
		return (ManagerGroup) this.managerDAO.getObjectById(ManagerGroup.class, id);
	}

	@Override
	public ManagerGroup getManagerGroup(Manager manager, VslibGroup group) {
		return (ManagerGroup) this.managerDAO.getObjectByArgTwo(ManagerGroup.class, "manager", manager, "group", group);
	}

	@Override
	public ManagerRole getManagerRole(Long id) {
		return (ManagerRole) this.managerDAO.getObjectById(ManagerRole.class, id);
	}

	@Override
	public ManagerRole getManagerRole(Manager manager, VslibRole role) {
		return (ManagerRole) this.managerDAO.getObjectByArgTwo(ManagerRole.class, "manager", manager, "role", role);
	}

	@Override
	public VslibGroup getVslibGroup(Long id) {
		return (VslibGroup) this.managerDAO.getObjectById(VslibGroup.class, id);
	}

	@Override
	public VslibGroup getVslibGroupByCode(String code) {
		return (VslibGroup) this.managerDAO.getObjectByArg(VslibGroup.class, "code", code);
	}

	@Override
	public VslibGroup getVslibGroupByName(String name) {
		return (VslibGroup) this.managerDAO.getObjectByArg(VslibGroup.class, "name", name);
	}

	@Override
	public VslibRole getVslibRole(Long id) {
		return (VslibRole) this.managerDAO.getObjectById(VslibRole.class, id);
	}

	@Override
	public VslibRole getVslibRoleByCode(String code) {
		return (VslibRole) this.managerDAO.getObjectByArg(VslibRole.class, "code", code);
	}

	@Override
	public VslibRole getVslibRoleByName(String name) {
		return (VslibRole) this.managerDAO.getObjectByArg(VslibRole.class, "name", name);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GroupRole> listGroupRole(VslibGroup group) {
		return (List<GroupRole>) this.managerDAO.listObjectArg(GroupRole.class, "group", group);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GroupRole> listGroupRole(VslibRole role) {
		return (List<GroupRole>) this.managerDAO.listObjectArg(GroupRole.class, "role", role);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Manager> listManager() {
		return (List<Manager>) this.managerDAO.listObjectSortedTwo(Manager.class, "firstName", "asc", "middleName", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ManagerGroup> listManagerGroup(VslibGroup group) {
		return (List<ManagerGroup>) this.managerDAO.listObjectArg(ManagerGroup.class, "group", group);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ManagerGroup> listManagerGroup(Manager manager) {
		return (List<ManagerGroup>) this.managerDAO.listObjectArg(ManagerGroup.class, "manager", manager);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ManagerRole> listManagerRole(Manager manager) {
		return (List<ManagerRole>) this.managerDAO.listObjectArg(ManagerRole.class, "manager", manager);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ManagerRole> listManagerRole(VslibRole role) {
		return (List<ManagerRole>) this.managerDAO.listObjectArg(ManagerRole.class, "role", role);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VslibGroup> listVslibGroup() {
		return (List<VslibGroup>) this.managerDAO.listObjectSorted(VslibGroup.class, "code", "asc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VslibRole> listVslibRole() {
		return (List<VslibRole>) this.managerDAO.listObjectSorted(VslibRole.class, "code", "asc");
	}

	@Override
	public boolean updateGroupRole(GroupRole obj) {
		return this.managerDAO.update(obj);
	}

	@Override
	public boolean updateManager(Manager obj) {
		return this.managerDAO.update(obj);
	}

	@Override
	public boolean updateManagerGroup(ManagerGroup obj) {
		return this.managerDAO.update(obj);
	}

	@Override
	public boolean updateManagerRole(ManagerRole obj) {
		return this.managerDAO.update(obj);
	}

	@Override
	public boolean updateVslibGroup(VslibGroup obj) {
		return this.managerDAO.update(obj);
	}

	@Override
	public boolean updateVslibRole(VslibRole obj) {
		return this.managerDAO.update(obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void createDefaultAdminAccount() {
		
		List<Salutation> listSalutation = (List<Salutation>) this.managerDAO.listObjectSorted(Salutation.class, "id", "asc");
		
		Salutation salutation = null;
		
		if (listSalutation.isEmpty()){
			salutation = new Salutation();
			salutation.setCode("Mr.");
			salutation.setAddDefaults("system");
			this.managerDAO.save(salutation);
		} else {
			salutation = listSalutation.get(0);
		}
		
		Manager manager = this.getManagerByUid("admin");
		if (manager == null){
			manager = new Manager();
			manager.setUid("admin");
			manager.setAccountNonLocked(true);
			manager.setAddress(new Address());
			manager.getAddress().setLocationOne("-NA-");
			manager.getAddress().setCity("-NA-");
			manager.getAddress().setAddDefaults("system");
			manager.setEnabled(true);
			manager.setFirstName("System");
			manager.setLastName("Administrator");
			manager.setSalutation(salutation);
			manager.setAddDefaults("system");
			
			//PasswordEncoder encoder = new Md5PasswordEncoder();
			//String hashedPass = encoder.encodePassword("password", null);
			
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	        String hashedPass = encoder.encode("password");
	        
			manager.setPassword(hashedPass);
			
			this.managerDAO.save(manager);
			
			VslibRole role = this.getVslibRoleByCode("ROLE_ADMIN");
			
			if (role == null){
				role = new VslibRole();
				role.setCode("ROLE_ADMIN");
				role.setName("Role Administrator");
				role.setAddDefaults("system");
				
				this.addVslibRole(role);
			}
			
			ManagerRole managerRole = new ManagerRole();
			managerRole.setManager(manager);
			managerRole.setRole(role);
			managerRole.setAddDefaults("system");
			this.addManagerRole(managerRole);
		}
		
	}
	
}
