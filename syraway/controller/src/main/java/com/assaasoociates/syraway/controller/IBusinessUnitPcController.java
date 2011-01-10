package com.assaasoociates.syraway.controller;

import java.util.List;
import com.assaassociates.syraway.model.BusinessUnitPc;

public interface IBusinessUnitPcController {

	public void addBusinessUnitPc(BusinessUnitPc pBusinessUnitPc);
	
	public BusinessUnitPc getBuPc(int pBuPc);
	
	public List<BusinessUnitPc> getAllBuPc();
}
