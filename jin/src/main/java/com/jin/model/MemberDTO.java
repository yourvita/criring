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
	@NonNull private String memberemail;
	@NonNull private String memberpw;
	private String membername;
	private String memberaddr;
}
