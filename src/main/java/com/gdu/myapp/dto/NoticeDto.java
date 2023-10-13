package com.gdu.myapp.dto;

import java.sql.Clob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NoticeDto {
	private int notice_no;
	private int gubun;
	private String title;
	private Clob content;
}
