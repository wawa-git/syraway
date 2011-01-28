package com.assaassociates.syraway.exts.mbeans;

import java.io.Serializable;
import java.util.List;
import javax.faces.event.AjaxBehaviorEvent;
import com.assaassociates.syraway.model.BusinessUnit;
import com.assaassociates.syraway.model.Page;
import com.assaassociates.syraway.model.Role;

public interface IPageRoleService extends Serializable{

	public void addPageRole();
	public void listPageRoleListener(AjaxBehaviorEvent event);
	public List<Role> getAllRole();
	public List<Page> getAllPage();
	public List<BusinessUnit> getAllBu();
	 
}
