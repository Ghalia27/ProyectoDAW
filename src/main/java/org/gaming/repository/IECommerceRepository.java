package org.gaming.repository;

import org.gaming.model.DetalleCabecera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IECommerceRepository extends JpaRepository<DetalleCabecera, Integer> {
	
}
