package com.tms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.exceptions.TerminalAlreadyExistException;
import com.tms.models.reponse.ResponseDto;
import com.tms.models.request.TerminalInfoReq;
import com.tms.services.TerminalInfoService;
import com.tms.utils.StatusResponse;

@RestController
@RequestMapping("/terminalInfo")
public class TerminalInfoController {
	
	@Autowired
	TerminalInfoService infoService;
	
	@PostMapping("/addTerminal")
	public ResponseDto registerTerminal(@RequestBody TerminalInfoReq request) {
		ResponseDto response = new ResponseDto();
			if(infoService.existsByTerminalId(request.getTerminalId())) {
				throw new TerminalAlreadyExistException("Terminal Id already exists");
			}
			if(infoService.existsByIpAddress(request.getIpAddress())) {
				throw new TerminalAlreadyExistException("Terminal ip address already exists");
			}
			response = infoService.save(request);
	return response;

	
}
}
