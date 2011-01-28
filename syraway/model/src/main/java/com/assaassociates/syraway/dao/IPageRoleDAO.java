/**
 * 
 */
package com.assaassociates.syraway.dao;

import java.util.List;

import com.assaassociates.syraway.model.PageRole;

/**
 * @author waheb
 *
 */
public interface IPageRoleDAO {
	public PageRole getPageRoleById(Integer pPageRoleId);
	public List<PageRole> getPageRoleOfPage(Integer pPageId);
	public void addPageRole(PageRole pPageRole);
	public void updatePageRole(PageRole pPageRole);
	public void removePageRole(PageRole pPageRole);
	public void removePageRole(Integer pPageRoleId);
	public List<PageRole> getAllPageRoles();
}
