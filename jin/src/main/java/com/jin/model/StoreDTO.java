package com.jin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreDTO {
	private String email;
	private String pw;
	private String name;
	private String addr;
	private String tel;
	private int laundry_cnt;
	private int dryer_cnt;
}
