package com.nmc.planer;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ResourceRepository extends CrudRepository<resource, Long> {

    List<resource> findByResourceName(String resourceName);
    
  
    @Query("select r from resource r where r.resourceName = ?1 and r.status = ?2")
    List<resource> findByResourceNameStatus(String resourceName,char status);
    
    
}
