package com.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.models.TerminalInfo;

@Repository
public interface TerminalInfoRepository extends JpaRepository<TerminalInfo, Long> {
	
	public TerminalInfo findByTerminalId(Long id);
	
	public boolean existsByTerminalId(Long id);
	
	public boolean existsByIpAddress(String ip);

}
