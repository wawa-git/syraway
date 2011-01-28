package com.assaassociates.syraway.exts.mbeans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;
import com.assaasoociates.syraway.controller.IPageController;
import com.assaassociates.syraway.model.Page;

@ManagedBean(name="page")
@RequestScoped
public class PageServiceImpl implements IPageService {

private static final long serialVersionUID = 6726658729223350876L;
	
	private IPageController oPageController;
	private Page value;
	private List<Page> pageList;
	private String pageId;
	
	public PageServiceImpl(){
		super(); 
		ApplicationContext appContext = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		this.oPageController = appContext.getBean("pageController", IPageController.class);
		this.value = new Page();
		this.pageList = new ArrayList<Page>();
	}

	public IPageController getPageController() {
		return oPageController;
	}

	public void setPageController(IPageController pPageController) {
		this.oPageController = pPageController;
	}

	public Page getValue() {
		return value;
	}

	public void setValue(Page pValue) {
		this.value = pValue;
	}

	public List<Page> getPageList() {
		return pageList;
	}

	public void setPageList(List<Page> pPageList) {
		this.pageList = pPageList;
	}

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pPageId) {
		this.pageId = pPageId;
		if(this.pageId != null){
			if(getPageController() != null){
				value = getPageController().getPage(Integer.valueOf(this.pageId));
			}
		}
	}

	@Override
	public void addPage(){
		if(this.oPageController != null){
			this.oPageController.addPage(value);
		}
	}

	@Override
	public void listPageListener(AjaxBehaviorEvent event) {
		if(oPageController != null){
			pageList = oPageController.getAllPages();
		}
	}

	@Override
	public List<Page> getAllPages() {
		if(oPageController != null){
			return oPageController.getAllPages();
		}
		return new ArrayList<Page>();
	}
	
	@Override
	public List<Page> getAllVisibleMenus(){
		if(oPageController != null){
			return oPageController.getAllMenus();
		}
		return new ArrayList<Page>();
	}
}
