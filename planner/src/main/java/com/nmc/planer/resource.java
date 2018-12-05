package com.nmc.planer;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "resource")
public class resource {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long id;
	public String resourceName;
	public char resourceType;
	public Timestamp fromTime;
	public Timestamp toTime;
	public char status;

}
