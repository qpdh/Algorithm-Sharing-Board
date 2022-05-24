package org.tukorea.free.domain;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostVO {
	@Generated
	private Integer id;

	private String title;
	private String description;
	private Date postDate;

	// Foreign Keys
	private String language;
	private String userId;

}
