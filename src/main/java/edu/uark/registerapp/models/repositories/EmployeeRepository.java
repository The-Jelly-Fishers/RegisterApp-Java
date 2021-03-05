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
   Optional<EmployeeEntity> findByEmployeeid(int employeeid);
   Optional<EmployeeEntity> findByClassification(int classification); 
   boolean existsByActive(String active); 
   // Optional<EmployeeEntity> save(EmployeeEntity e); // call: employeeRepository.save(employeeEntity); return type: Employee Entity 
   // <S extends T> S save(S entity);
    // S is type; S = Employee
   boolean existsByClassification(int classification); 
 }
