package com.jin.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class MemberDTO {
	@NonNull private String email;
	@NonNull private String Pw;
	private String name;
	private String addr;
	private String joinDate;
	private String adminYN;
	private String penalty;
}
