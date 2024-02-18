package com.ashokit.mdel;

import lombok.Data;

@Data
public class TodoModel {

	private Integer id;
	private String todo;
	private String status;
	private String priority;
}
