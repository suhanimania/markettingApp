package com.marketing1.service;

import java.util.List;

import com.marketing1.dto.LeadDto;
import com.marketing1.entity.Lead;

public interface LeadService {
    public void saveLead(Lead leads);

	public List<Lead> getAllLeads();

	public void deleteLead(long id);

	public Lead findLead(long id);
	
	public void updateLead(LeadDto leadDto);
}
