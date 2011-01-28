package com.assaassociates.syraway.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;


/**
 * The persistent class for the SW_PAGE database table.
 * 
 */
@Entity
@Table(name="SW_PAGE")
public class Page implements Serializable, Comparable<Page> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PAGE_ID", unique=true, nullable=false)
	private int pageId;

	@Column(name="MENU")
	@Basic
	private int menu;

	@Column(name="MENU_NAME", length=45)
	private String menuName;

	@Column(name="MENU_ORDER")
	private int menuOrder;

	@Column(name="NAME", nullable=false, length=45)
	private String name;

	@Column(name="URI", nullable=false, length=45)
	private String uri;

	//bi-directional many-to-one association to PageRole
	@OneToMany(mappedBy="swPage",fetch=FetchType.LAZY)
	private Set<PageRole> swPages;

    public Page() {
    }

	public int getPageId() {
		return this.pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public boolean isMenu() {
		return (this.menu==0)? false: true;
	}

	public void setMenu(boolean menu) {
		this.menu = menu ? 1 : 0;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuOrder() {
		return this.menuOrder;
	}

	public void setMenuOrder(int menuOrder) {
		this.menuOrder = menuOrder;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUri() {
		return this.uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Set<PageRole> getSwPages() {
		return swPages;
	}

	public void setSwPages(Set<PageRole> swPages) {
		this.swPages = swPages;
	}
	
	@Override
	public String toString(){
		return String.valueOf(this.pageId);
	}

	public int compareTo(Page pObj) {
		int result = new Integer(this.menuOrder).compareTo(new Integer(pObj.menuOrder));
		if(result == 0){
			result = this.menuName.compareTo(pObj.menuName);
		}
		return result;
	}
	
}