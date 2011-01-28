package com.assaasoociates.syraway.controller;

import java.util.List;

import com.assaassociates.syraway.model.PageRole;

public interface IPageRoleController {

	public void addPageRole(PageRole oPageRole);
	public void updatePageRole(PageRole oPageRole);
	public PageRole getPageRole(Integer pPageRoleId); 
	public List<PageRole> getAllPageRoles();
	
}
