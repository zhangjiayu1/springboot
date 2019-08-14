package com.ztest.chapter17.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description  t_roles
 * @Author  11568
 * @Date 2019-08-14 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="t_roles" )
public class Roles  implements Serializable {

	private static final long serialVersionUID =  257834494007756709L;

	@Id
   	@Column(name = "r_id" )
	private Long rId;

   	@Column(name = "r_name" )
	private String rName;

	@Column(name = "r_flag")
	private String rFlag;


}
