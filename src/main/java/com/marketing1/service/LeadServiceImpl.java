package com.marketing1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.marketing1.dto.LeadDto;
import com.marketing1.entity.Lead;
import com.marketing1.repository.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {
	
	@Autowired
	private LeadRepository leadRepo;

	@Override
	public void saveLead(@ModelAttribute Lead lead) {
		leadRepo.save(lead);

	}

	@Override
	public List<Lead> getAllLeads() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	
	}
	@Override
	public void deleteLead(long id) {
		leadRepo.deleteById(id);
		
	}

	@Override
	public Lead findLead(long id) {
		Lead lead = leadRepo.findById(id).get();
		return lead;
	}
	

	@Override
	public void updateLead(LeadDto leadDto) {
		Lead lead = new Lead();
		//System.out.println(100);
		lead.setId(leadDto.getId());
		lead.setFirstName(leadDto.getFirstName());
		lead.setLastName(leadDto.getLastName());
		lead.setCity(leadDto.getCity());
		lead.setEmail(leadDto.getEmail());
		lead.setMobile(leadDto.getMobile());
		leadRepo.save(lead);
	}

}
