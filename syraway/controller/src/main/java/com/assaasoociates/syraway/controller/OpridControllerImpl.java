/**
 * 
 */
package com.assaasoociates.syraway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.assaassociates.syraway.dao.IEmployeeDAO;
import com.assaassociates.syraway.dao.IOprIdDAO;
import com.assaassociates.syraway.model.Oprid;

/**
 * @author waheb
 *
 */

@Component("opridController")
public class OpridControllerImpl implements IOpridController {

	@Autowired
	private IEmployeeDAO emplDAO;
	
	@Autowired
	private IOprIdDAO opridDAO;

	public IEmployeeDAO getEmplDAO() {
		return emplDAO;
	}

	public void setEmplDAO(IEmployeeDAO emplDAO) {
		this.emplDAO = emplDAO;
	}

	public IOprIdDAO getOpridDAO() {
		return opridDAO;
	}

	public void setOpridDAO(IOprIdDAO opridDAO) {
		this.opridDAO = opridDAO;
	}

	public void addOprid(Oprid pOprid) {
		if(opridDAO != null){
			opridDAO.addOprid(pOprid);
		}
	}

	public void updateOprid(Oprid pOprid) {
		if(opridDAO != null){
			opridDAO.updateOprid(pOprid);
		}
	}

	public Oprid getOprid(String pOpridId){
		if(opridDAO != null){
			return opridDAO.getOpridById(pOpridId);
		}
		return null;
	}
}
