package com.ztest.chapter13.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description  
 * @Author  Hunter
 * @Date 2019-08-09 
 */

@Data
@Entity
@Table ( name ="t_user" )
public class User  implements Serializable {

	private static final long serialVersionUID =  3442808243958102197L;

	/**
	 * 编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "t_id" )
	private Long tId;

	/**
	 * 名称
	 */
   	@Column(name = "t_name" )
	private String tName;

	/**
	 * 年龄
	 */
   	@Column(name = "t_age" )
	private int tAge;

	/**
	 * 家庭住址
	 */
   	@Column(name = "t_address" )
	private String tAddress;

   	@Column(name = "t_pwd" )
	private String tPwd;

}
