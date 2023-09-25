package com.myntra.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailEntity {
	private String recipient;
	private String msgBody;
	private String subject;
	private String attachment;

}
