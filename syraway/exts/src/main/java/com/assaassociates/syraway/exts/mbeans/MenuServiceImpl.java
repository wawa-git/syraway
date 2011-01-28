package com.assaassociates.syraway.exts.mbeans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;
import com.assaasoociates.syraway.controller.IPageController;
import com.assaassociates.syraway.model.Page;
import com.assaassosiates.syraway.security.authentication.IUserProfile;

@ManagedBean(name="menu")
@SessionScoped
public class MenuServiceImpl implements IMenuService {

private static final long serialVersionUID = 6726658729223350876L;
	
	private IPageController oPageController;
	private IUserProfile oUserProfile;
	private List<Page> oAllMenus;
	private List<Page> oAllAuthorizedMenus;

	public MenuServiceImpl(){
		super(); 
		ApplicationContext appContext = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		this.oPageController = appContext.getBean("pageController", IPageController.class);
		this.oUserProfile = appContext.getBean("userProfile", IUserProfile.class);
	}

	public IPageController getPageController() {
		return oPageController;
	}

	public void setPageController(IPageController pPageController) {
		this.oPageController = pPageController;
	}

	@Override
	public List<Page> getAllMenus() {
		if(oAllMenus == null){
			if(oPageController != null){
				oAllMenus =  oPageController.getAllMenus();
				Collections.sort(oAllMenus);
			}else{
				oAllMenus = new ArrayList<Page>();
			}
		}
		return oAllMenus;
	}
	
	@Override
	public List<Page> getAllAuthorizedMenus() {
		if(oAllAuthorizedMenus == null){
			if(oPageController != null){
				oAllAuthorizedMenus = new ArrayList<Page>();
				for (Page oMenu : getAllMenus()) {
					if(oUserProfile.isAuthorizedUri(oMenu.getUri())){
						oAllAuthorizedMenus.add(oMenu);
					}
				}
				Collections.sort(oAllAuthorizedMenus);
			}
		}
		return oAllAuthorizedMenus;
	}
	
	@Override
	public void invalidateMenusCache(){
		oAllMenus = null;
		oAllAuthorizedMenus = null;
	}
}