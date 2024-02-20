package com.marketing1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing1.dto.LeadDto;
import com.marketing1.entity.Lead;
import com.marketing1.service.LeadService;
import com.marketing1.util.EmailService;

@Controller
public class LeadController {

	@Autowired
	private LeadService leadService;
	
	@Autowired
	private EmailService emailService;

	// http://localhost:8080/view
	@GetMapping("/view")
	public String viewCreateLead() {
		return "create_lead";
	}

//	@GetMapping("/SaveLead")
//	public String saveLead(Lead lead, ModelMap model) {
//		System.out.println(lead.getFirstName());
//		System.out.println(lead.getLastName());
//		System.out.println(lead.getCity());
//		System.out.println(lead.getEmail());
//		System.out.println(lead.getMobile());
//		leadService.saveLead(lead);
//		model.addAttribute("msg", "lead is saved successfully..");
//		return "create_lead";
//	}
	
	
//	@GetMapping("/SaveLead")
//	public String saveLead(@RequestParam("first") String firstName,
//			@RequestParam("last") String lastName,
//			@RequestParam("city") String city,
//			@RequestParam("email") String email,
//			@RequestParam("mobile") long mobile
//			, ModelMap model) {
//		
//		Lead lead = new Lead();
//		lead.setFirstName(firstName);
//		lead.setLastName(lastName);
//		lead.setCity(city);
//		lead.setEmail(email);
//		lead.setMobile(mobile);
//		
//		leadService.saveLead(lead);
//		model.addAttribute("msg", "lead is saved successfully..");
//		return "create_lead";
//	}
	
	@GetMapping("/SaveLead")
	public String saveLead(LeadDto leadDto, ModelMap model) {
		Lead lead = new Lead();
		
		lead.setFirstName(leadDto.getFirstName());
		lead.setLastName(leadDto.getLastName());
		lead.setCity(leadDto.getCity());
		lead.setEmail(leadDto.getEmail());
		lead.setMobile(leadDto.getMobile());
		
		leadService.saveLead(lead);
		
		emailService.sendEmail(leadDto.getEmail(), "sending email", "Test Email sending");
		
		model.addAttribute("msg", "lead is saved successfully...");
		
		return"create_lead";
	}
	
	
		// http://localhost:8080/listAllLead
	@GetMapping("/listAllLead")
	public String getAllLeads(ModelMap model) {
	List<Lead> lead = leadService.getAllLeads();
	//System.out.println(leads);
	model.addAttribute("lead", lead);
	return "list_lead";
		
	}
	
	@GetMapping("/delete")
	public String deleteLead(@RequestParam("id") long id,ModelMap model) {
		leadService.deleteLead(id);
		List<Lead> lead = leadService.getAllLeads();
		model.addAttribute("lead", lead);
		return "list_lead";
		
	}
	
	// http://localhost:8080/update
	@GetMapping("/update")
	public String updateLead(@RequestParam("id") long id,ModelMap model) {
		Lead lead=leadService.findLead(id);
		model.addAttribute("lead", lead);
		return "update_lead";
		
	}
	@GetMapping("/updateLead")
	public String updateLeadInformation(LeadDto leadDto,ModelMap model) {
		//Lead lead = new Lead();
		//System.out.println(100);
//		lead.setFirstName(leadDto.getFirstName());
//		lead.setLastName(leadDto.getLastName());
//		lead.setCity(leadDto.getCity());
//		lead.setEmail(leadDto.getEmail());
//		lead.setMobile(leadDto.getMobile());
		leadService.updateLead(leadDto);
		//leadService.updateLead(leadDto);
		List<Lead> lead = leadService.getAllLeads();
		//System.out.println(leads);
		model.addAttribute("lead", lead);
		return "list_lead";
		
	}


}
