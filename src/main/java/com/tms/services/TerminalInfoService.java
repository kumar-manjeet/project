package com.tms.services;

import com.tms.models.reponse.ResponseDto;
import com.tms.models.request.TerminalInfoReq;

public interface TerminalInfoService {
	
//	ResponseDto saveTerminalInfo(TerminalInfoReq request);
	
	boolean existsByTerminalId(Long id);
	
	boolean existsByIpAddress(String ip);
	
	ResponseDto save(TerminalInfoReq request);

}
