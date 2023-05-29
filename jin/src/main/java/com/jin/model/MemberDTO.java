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
<<<<<<< HEAD
	@NonNull private String memberemail;
	@NonNull private String memberpw;
	private String membername;
	private String memberaddr;
=======
	@NonNull private String  MB_EMAIL;
	@NonNull private String MB_PW;
	private String MB_NAME;
	private String MB_ADDR;
	private String MB_JOINDATE;
	private String ADMIN_YN;
	private String MB_PENALTY;
	private double LAT;
	private double LNG;
>>>>>>> branch 'master' of https://github.com/yourvita/criring.git
}
