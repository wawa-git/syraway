package com.assaassociates.syraway.exts.mbeans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;
import com.assaasoociates.syraway.controller.IBusinessUnitController;
import com.assaasoociates.syraway.controller.IPageController;
import com.assaasoociates.syraway.controller.IPageRoleController;
import com.assaasoociates.syraway.controller.IRoleController;
import com.assaassociates.syraway.model.BusinessUnit;
import com.assaassociates.syraway.model.Page;
import com.assaassociates.syraway.model.PageRole;
import com.assaassociates.syraway.model.Role;

@ManagedBean(name="pageRole")
@RequestScoped
public class PageRoleServiceImpl implements IPageRoleService {

private static final long serialVersionUID = 6726658729223350876L;
	
	private IPageRoleController oPageRoleController;
	private IRoleController oRoleController;
	private IBusinessUnitController oBusinessUnitController;
	private IPageController oPageController;
	private PageRole value;
	private List<PageRole> pageRoleList;
	private String roleId;
	private String pageId;
	private String pageRoleId;
	private String buId;
	
	public IPageRoleController getPageRoleController() {
		return oPageRoleController;
	}

	public void setPageRoleController(IPageRoleController pPageRoleController) {
		this.oPageRoleController = pPageRoleController;
	}

	public IRoleController getRoleController() {
		return oRoleController;
	}

	public void setRoleController(IRoleController pRoleController) {
		this.oRoleController = pRoleController;
	}

	public IBusinessUnitController getBusinessUnitController() {
		return oBusinessUnitController;
	}

	public void setBusinessUnitController(
			IBusinessUnitController pBusinessUnitController) {
		this.oBusinessUnitController = pBusinessUnitController;
	}

	public PageRole getValue() {
		return value;
	}

	public void setValue(PageRole value) {
		this.value = value;
	}

	public IPageController getPageController() {
		return oPageController;
	}

	public void setPageController(IPageController pPageController) {
		this.oPageController = pPageController;
	}

	public List<PageRole> getPageRoleList() {
		return pageRoleList;
	}

	public void setPageRoleList(List<PageRole> pPageRoleList) {
		this.pageRoleList = pPageRoleList;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getBuId() {
		return buId;
	}

	public void setBuId(String buId) {
		this.buId = buId;
	}

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pPageId) {
		this.pageId = pPageId;
	}

	public String getPageRoleId() {
		return pageRoleId;
	}
	
	public void setPageRoleId(String pUserRoleId) {
		this.pageRoleId = pUserRoleId;
		if(this.pageRoleId != null){
			if(getPageRoleController() != null){
				try {
					value = getPageRoleController().getPageRole(Integer.valueOf(this.pageRoleId));
					if(value != null){
						setRoleId(String.valueOf(value.getSwRole().getRoleId()));
						setPageId(String.valueOf(value.getSwPage().getPageId()));
						setBuId(String.valueOf(value.getSwBu().getBuId()));
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public PageRoleServiceImpl(){
		super(); 
		ApplicationContext appContext = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		this.oPageRoleController = appContext.getBean("pageRoleController", IPageRoleController.class);
		this.oRoleController = appContext.getBean("roleController", IRoleController.class);
		this.oPageController = appContext.getBean("pageController", IPageController.class);
		this.oBusinessUnitController = appContext.getBean("buController",IBusinessUnitController.class);
		this.value = new PageRole();
		this.pageRoleList = new ArrayList<PageRole>();
	}
	
	@Override
	public void addPageRole(){
		if(this.oPageRoleController != null){
			if(getPageId() != null && !"".equals(getPageId().trim())){
				System.out.println("=============================== PAGE_ID" + getPageId() + " " + getPageController().getPage(Integer.valueOf(getPageId())).toString());
				value.setSwPage(getPageController().getPage(Integer.valueOf(getPageId())));
			}
			if(getRoleId() != null && !"".equals(getRoleId().trim())){
				System.out.println("=============================== ROLE_ID" + getRoleId() + " + " + getRoleController().getRole(Integer.valueOf(getRoleId())).toString());
				value.setSwRole(getRoleController().getRole(Integer.valueOf(getRoleId())));
			}
			if(getBuId() != null && !"".equals(getBuId().trim())){
				value.setSwBu(getBusinessUnitController().getBusinessUnit(getBuId()));
			}
			this.oPageRoleController.addPageRole(value);
		}
	}

	@Override
	public void listPageRoleListener(AjaxBehaviorEvent event) {
		if(oPageRoleController != null){
			pageRoleList = oPageRoleController.getAllPageRoles();
		}
	}

	@Override
	public List<Role> getAllRole() {
		if(oRoleController != null){
			return oRoleController.getAllRoles();
		}
		return new ArrayList<Role>();
	}
	
	@Override
	public List<Page> getAllPage() {
		if(oPageController != null){
			return oPageController.getAllPages();
		}
		return new ArrayList<Page>();
	}
	
	@Override
	public List<BusinessUnit> getAllBu() {
		if(oBusinessUnitController != null){
			return oBusinessUnitController.getAllBu();
		}
		return new ArrayList<BusinessUnit>();
	}
}
