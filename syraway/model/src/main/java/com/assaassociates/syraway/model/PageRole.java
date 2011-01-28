package com.assaassociates.syraway.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SW_PAGE_ROLE database table.
 * 
 */
@Entity
@Table(name="SW_PAGE_ROLE")
public class PageRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PAGE_ROLE_ID", unique=true, nullable=false)
	private int pageRoleId;

	@Column(name="DESCRIPTION", length=100)
	private String description;

	@Column(name="NAME", length=100)
	private String name;

	//bi-directional many-to-one association to PageRole
    @ManyToOne
	@JoinColumn(name="PAGE_ID", nullable=false)
	private Page swPage;
	
    //bi-directional many-to-one association to PageRole
    @ManyToOne
	@JoinColumn(name="BU_ID", nullable=false)
	private BusinessUnit swBu;
  
    //bi-directional many-to-one association to PageRole
    @ManyToOne
	@JoinColumn(name="ROLE_ID", nullable=false)
	private Role swRole;

    public PageRole() {
    }

	public int getPageRoleId() {
		return this.pageRoleId;
	}

	public void setPageRoleId(int pageRoleId) {
		this.pageRoleId = pageRoleId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Page getSwPage() {
		return swPage;
	}

	public void setSwPage(Page swPage) {
		this.swPage = swPage;
	}

	public BusinessUnit getSwBu() {
		return swBu;
	}

	public void setSwBu(BusinessUnit swBu) {
		this.swBu = swBu;
	}

	public Role getSwRole() {
		return swRole;
	}

	public void setSwRole(Role swRole) {
		this.swRole = swRole;
	}

	
}