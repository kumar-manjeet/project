package com.tms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tms.models.RegisterComplain;

public interface ComplainRepository extends JpaRepository<RegisterComplain, Long> {

	List<RegisterComplain> findByStatus(String status);

}
