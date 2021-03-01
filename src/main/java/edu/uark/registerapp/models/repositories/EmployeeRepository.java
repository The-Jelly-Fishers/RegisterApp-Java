package edu.uark.registerapp.models.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.uark.registerapp.models.entities.EmployeeEntity;

@Repository
 public interface EmployeeRepository extends CrudRepository<EmployeeEntity, UUID> {
   Optional<EmployeeEntity> findById(UUID id);
   // Iterable<EmployeeEntity> findAllbyClassification(String classification);

   //Optional<EmployeeEntity> findByLookupCode(String lookupCode);
      // when I commented this + the query files out, there ceased to be any error messages 
   
 }
