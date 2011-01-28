/**
 * 
 */
package com.assaasoociates.syraway.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.assaassociates.syraway.dao.IPageRoleDAO;
import com.assaassociates.syraway.model.PageRole;

/**
 * @author waheb
 *
 */

@Component("pageRoleController")
public class PageRoleControllerImpl implements IPageRoleController {

	@Autowired
	private IPageRoleDAO pageRoleDAO;
	
	public IPageRoleDAO getPageRoleDAO() {
		return pageRoleDAO;
	}

	public void setPageRoleDAO(IPageRoleDAO pageRoleDAO) {
		this.pageRoleDAO = pageRoleDAO;
	}

	public void addPageRole(PageRole pPageRole) {
		if(pageRoleDAO != null){
			pageRoleDAO.addPageRole(pPageRole);
		}
	}

	public void updatePageRole(PageRole pPageRole) {
		if(pageRoleDAO != null){
			pageRoleDAO.updatePageRole(pPageRole);
		}
	}

	public PageRole getPageRole(Integer pPageRoleId) {
		PageRole result = null;
		if(pageRoleDAO != null){
			result = pageRoleDAO.getPageRoleById(pPageRoleId);
		}
		return result;
	}

	public List<PageRole> getAllPageRoles() {
		List<PageRole> result = new ArrayList<PageRole>();
		if(pageRoleDAO != null)
			result = pageRoleDAO.getAllPageRoles();
		return result;
	}
}
