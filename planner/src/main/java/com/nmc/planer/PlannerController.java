package com.nmc.planer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/planner/slot/available")
public class PlannerController {

	Logger logger = LoggerFactory.getLogger(PlannerController.class);

	@Autowired
	private ResourceRepository resourceRepository;
	
	
	@RequestMapping(value = "/{resourceID}", method = RequestMethod.GET)
	
	public String getAvailableSlots(@RequestHeader("Accept") String contentType,@PathVariable("resourceID") String resourceID,Model model) {

		Iterable<resource> resource = resourceRepository.findByResourceNameStatus(resourceID, 'A');

		logger.info("Requested for " + contentType +" response. ");
	

		
		model.addAttribute("resource", populteSlot(resource));
		//logger.info(");
		return "availableSlots";
		
	}

	


	private List<Slot> populteSlot(Iterable<resource> resI) {
		ArrayList<Slot> slots = new ArrayList<Slot>();
		Iterator<com.nmc.planer.resource> resIterator = resI.iterator();
		;
		while (resIterator.hasNext()) {
			resource r = resIterator.next();

			Slot s = new Slot();
			s.setId(r.id);
			s.setResource(r.resourceName);
			s.setFromTime(r.fromTime);
			s.setToTime(r.toTime);
			s.setStatus("" + r.status);

			slots.add(s);
		}

		return slots;

	}

}
