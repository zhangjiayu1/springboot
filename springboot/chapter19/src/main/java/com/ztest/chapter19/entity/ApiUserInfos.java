package com.ztest.chapter19.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.InputStream;

/**
 * @Description  t_api_user_infos
 * @Author  11568
 * @Date 2019-08-21 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="t_api_user_infos" )
public class ApiUserInfos  implements Serializable {

	private static final long serialVersionUID =  323524990100633992L;

	/**
	 * 授权唯一标识
	 */
	@Id
   	@Column(name = "aui_app_id" )
	private String appId;

	/**
	 * 授权密钥
	 */
   	@Column(name = "aui_app_secret" )
	private byte[] appSecret;

	/**
	 * 用户状态,1：正常，0：无效
	 */
   	@Column(name = "aui_status" )
	private int auiStatus;

	/**
	 * 日请求量
	 */
   	@Column(name = "aui_day_request_count" )
	private int auiDayRequestCount;

	/**
	 * 绑定IP地址多个使用“,”隔开
	 */
   	@Column(name = "aui_ajax_bind_ip" )
	private String auiAjaxBindIp;

	/**
	 * 备注
	 */
   	@Column(name = "aui_mark" )
	private String auiMark;

}
