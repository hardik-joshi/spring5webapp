package com.jhardik.spring5webapp.repositories;

import com.jhardik.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;


public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
