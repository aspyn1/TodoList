package edu.kh.todo.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Todo {
	
	private int todoNo;
	private String todoTitle;
	private String todoMemo;
	private String todoDate;
	private String todoDeleteFlag;
	private int memberNo;

}
