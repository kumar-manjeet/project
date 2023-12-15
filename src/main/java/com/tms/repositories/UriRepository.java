package com.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tms.models.Uri;

public interface UriRepository extends JpaRepository<Uri, Long> {

	Uri findByUriEndpoint(String uri);

}
