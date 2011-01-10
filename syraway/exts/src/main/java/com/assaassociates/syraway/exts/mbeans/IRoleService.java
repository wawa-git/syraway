package com.assaassociates.syraway.exts.mbeans;

import java.io.Serializable;
import javax.faces.event.AjaxBehaviorEvent;

public interface IRoleService extends Serializable{

	public void addRole();
	public void listRoleListener(AjaxBehaviorEvent event);
	 
}
