package org.vsfamily.vslib.web.common.schedulers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.vsfamily.vslib.web.service.VslibService;

public class VslibSchedulers {

	@Autowired
	VslibService vslibService;
	
	@Scheduled(fixedDelay=86400000)
	public void releaseHoldAndReserve(){
		
		System.out.println("Releasing holds and reserves");
		
		this.vslibService.doReleaseHold();
		this.vslibService.doReleaseReserve();
	}
}
