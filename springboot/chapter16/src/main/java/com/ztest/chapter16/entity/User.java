package com.ztest.chapter16.entity;

import javax.persistence.*;
import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description  t_user
 * @Author  11568
 * @Date 2019-08-13 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="t_user" )
public class User  implements Serializable {

	private static final long serialVersionUID =  6076146643259031098L;

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
