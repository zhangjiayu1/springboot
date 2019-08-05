package com.ztest.chapter8.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

/**
 * @Description  
 * @Author  Hunter
 * @Date 2019-08-05 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="t_logger_infos" )
public class LoggerInfos  implements Serializable {

	private static final long serialVersionUID =  8366448851643784075L;

   	@Column(name = "ali_id" )
	private Long aliId;

	/**
	 * 客户端请求IP地址
	 */
   	@Column(name = "ali_client_ip" )
	private String aliClientIp;

	/**
	 * 日志请求地址
	 */
   	@Column(name = "ali_uri" )
	private String aliUri;

	/**
	 * 终端请求方式,普通请求,ajax请求
	 */
   	@Column(name = "ali_type" )
	private String aliType;

	/**
	 * 请求方式method,post,get等
	 */
   	@Column(name = "ali_method" )
	private String aliMethod;

	/**
	 * 请求参数内容,json
	 */
   	@Column(name = "ali_param_data" )
	private String aliParamData;

	/**
	 * 请求接口唯一session标识
	 */
   	@Column(name = "ali_session_id" )
	private String aliSessionId;

	/**
	 * 请求时间
	 */
   	@Column(name = "ali_time" )
	private Date aliTime;

	/**
	 * 接口返回时间
	 */
   	@Column(name = "ali_returm_time" )
	private String aliReturmTime;

	/**
	 * 接口返回数据json
	 */
   	@Column(name = "ali_return_data" )
	private String aliReturnData;

	/**
	 * 请求时httpStatusCode代码，如：200,400,404等
	 */
   	@Column(name = "ali_http_status_code" )
	private String aliHttpStatusCode;

	/**
	 * 请求耗时（毫秒单位）
	 */
   	@Column(name = "ali_time_consuming" )
	private Long aliTimeConsuming;

}
