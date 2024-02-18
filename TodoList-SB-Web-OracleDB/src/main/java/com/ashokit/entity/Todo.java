package com.ashokit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="TODOLIST")
public class Todo {
	
	@Id
	@GeneratedValue
	@Column(name ="id")
	private Integer id;
	
	@Column(name = "todo")
	private String todo;
	
	@Column(name = "status")
	private String status;
	
	@Column(name ="priority")
	private String priority;

}
