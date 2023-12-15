package com.tms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.exceptions.TerminalNotRegisteredException;
import com.tms.models.TerminalInfo;
import com.tms.models.reponse.ResponseDto;
import com.tms.models.request.TerminalInfoReq;
import com.tms.repositories.TerminalInfoRepository;
import com.tms.utils.StatusResponse;

@Service
public class TerminalInfoServiceImpl implements TerminalInfoService {
	
	@Autowired
	TerminalInfoRepository terminalInfoRepository;

	@Override
	public boolean existsByTerminalId(Long id) {
		return terminalInfoRepository.existsByTerminalId(id);
	}
	
	@Override
	public boolean existsByIpAddress(String ip) {
		return terminalInfoRepository.existsByIpAddress(ip);
	}
	
	@Override
	public ResponseDto save(TerminalInfoReq request) {
		ResponseDto response = new ResponseDto();
		try {
			
			TerminalInfo info = new TerminalInfo();
			info.setTerminalId(request.getTerminalId());
			info.setVersion(request.getVersion());
			info.setIpAddress(request.getIpAddress());
			info.setOwnerName(request.getOwnerName());
			info.setStatus(false);
			info.setAddress(request.getAddress());
			info.setApartment(request.getApartment());
			info.setCity(request.getCity());
			info.setStreetAddress(request.getStreetAddress());
			info.setState(request.getState());
			TerminalInfo savedInfo = terminalInfoRepository.save(info);
			if (savedInfo != null && savedInfo.getId() != null) {
				response.setMessage("Terminal regestered successfully");
				response.setStatus(StatusResponse.Success);
			}
			else{
				throw new TerminalNotRegisteredException("Terminal not regestered !!");
//				response.setMessage("Terminal not regestered !!");
//				response.setStatus(StatusResponse.Failed);
			}
		} catch (Exception e) {
			response.setMessage("Something went1 wrong");
			response.setStatus(StatusResponse.Failed);
		}
		return response;
	}
	
	

}
