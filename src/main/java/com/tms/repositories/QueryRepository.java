package com.tms.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tms.models.Query;

public interface QueryRepository extends JpaRepository<Query, Long> {

	public Boolean existsByTerminalId(String terminalId);

	List<Query> findByStatus(String status);

	List<Query> findByTerminalId(String id);

	List<Query> findByMobileNumber(String mobileNumber);

	List<Query> findByEmail(String email);

}
