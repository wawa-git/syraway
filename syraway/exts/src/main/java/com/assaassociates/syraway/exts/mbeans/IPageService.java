package com.assaassociates.syraway.exts.mbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.event.AjaxBehaviorEvent;

import com.assaassociates.syraway.model.Page;

public interface IPageService extends Serializable{

	public void addPage();
	public void listPageListener(AjaxBehaviorEvent event);
	public List<Page> getAllPages();
	public List<Page> getAllVisibleMenus();
}
