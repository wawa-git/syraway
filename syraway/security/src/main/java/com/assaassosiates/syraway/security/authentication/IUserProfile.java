package com.assaassosiates.syraway.security.authentication;

import java.io.Serializable;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import com.assaassociates.syraway.model.Employee;

public interface IUserProfile extends Serializable {

	public boolean isTransient();
	public void setTransient(boolean pTransient);
	public Employee getEmpl();
	public void setEmpl(Employee oEmpl);
	public List<GrantedAuthority> getListAuthorities();
	public void setListAuthorities(List<GrantedAuthority> pListAuthorities);
	public List<String> getListAuthoritiesName();
	public boolean isAuthorized(String pAuthority);
	public boolean isAuthorizedUri(String pUri);
}