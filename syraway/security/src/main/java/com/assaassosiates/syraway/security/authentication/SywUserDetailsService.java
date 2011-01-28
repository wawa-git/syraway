/**
 * 
 */
package com.assaassosiates.syraway.security.authentication;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.assaasoociates.syraway.controller.IEmployeeController;
import com.assaasoociates.syraway.controller.IUserRoleController;
import com.assaassociates.syraway.model.Employee;
import com.assaassociates.syraway.model.UserRole;
import com.assaassosiates.syraway.security.authentication.UserProfile;

/**
 * @author waheb
 *
 */
public class SywUserDetailsService implements UserDetailsService {

	@Autowired
	IEmployeeController oEmployeeController;
	
	@Autowired
	IUserRoleController oUserRoleController;
	
	@Autowired
	UserProfile oUserprofile;
	
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(String pUsername)
			throws UsernameNotFoundException, DataAccessException {
		if(this.oEmployeeController != null){
			Employee oEmpl = this.oEmployeeController.getEmployeeFromEmail(pUsername);
			if(oEmpl != null){
				List<GrantedAuthority> oListGrantedAuthorities = getGrantedAuthoritiesList(oEmpl.getEmplId());
				
				
				if(this.oUserprofile != null){
					this.oUserprofile.setTransient(false);
					this.oUserprofile.setEmpl(oEmpl);
					this.oUserprofile.setListAuthorities(oListGrantedAuthorities);
					System.err.println("==========================================***************le profile est transient ? " + this.oUserprofile.isTransient());
				}
				return createUserDetails(pUsername, oEmpl, oListGrantedAuthorities);
			}else{
				throw new UsernameNotFoundException("email : " + pUsername + " not found");
			}
		}else{
			throw new UsernameNotFoundException("can't access Employee Controller");
		}
	}
	
	public UserDetails createUserDetails(String pUsername, Employee pEmployee, List<GrantedAuthority> pListAuthorities){
		User oResult = new User(pUsername, pEmployee.getSwOprid().getPassword(), true, true, true, true, pListAuthorities);
		return oResult;
	}
	
	public List<GrantedAuthority> getGrantedAuthoritiesList(int pEmplId){
		List<GrantedAuthority> oResult = new ArrayList<GrantedAuthority>();
		if(oUserRoleController != null){
			List<UserRole> oUserRoles = oUserRoleController.getAllUserRolesOfEmplId(pEmplId);
			if(oUserRoles != null){
				for (UserRole oUserRole : oUserRoles) {
					oResult.add(new GrantedAuthorityImpl(oUserRole.getSwRole().getName()));
				}
			}
		}
		for (GrantedAuthority oItem : oResult) {
			System.out.println("GrantedAuthority : " + oItem.getAuthority());
		}
		return oResult;
	}

	public IEmployeeController getEmployeeController() {
		return oEmployeeController;
	}

	public void setEmployeeController(IEmployeeController pEmployeeController) {
		this.oEmployeeController = pEmployeeController;
	}

	public UserProfile getUserprofile() {
		return oUserprofile;
	}

	public void setUserprofile(UserProfile pUserprofile) {
		this.oUserprofile = pUserprofile;
	}

	public IUserRoleController getUserRoleController() {
		return oUserRoleController;
	}

	public void setUserRoleController(IUserRoleController pUserRoleController) {
		this.oUserRoleController = pUserRoleController;
	}

}
