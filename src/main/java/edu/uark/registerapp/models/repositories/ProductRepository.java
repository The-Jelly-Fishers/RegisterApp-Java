package edu.uark.registerapp.models.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.uark.registerapp.models.entities.ProductEntity;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, UUID> {
	Optional<ProductEntity> findById(UUID id);
	Optional<ProductEntity> findByLookupCode(String lookupCode);
}
