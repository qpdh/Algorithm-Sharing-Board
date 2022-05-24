package org.tukorea.free.domain;

import java.util.Date;

import lombok.*;

import javax.validation.constraints.Past;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

	private String id;
	
	private String passwd;

	@Past
	private Date joinDate;
}
