package com.ztest.chapter8.entity;

import javax.persistence.*;
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
public class LoggerEntity implements Serializable {

	private static final long serialVersionUID =  8366448851643784075L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private String aliReturnTime;

	/**
	 * 接口返回数据json
	 */
   	@Column(name = "ali_return_data" )
	private String aliReturnData;

	/**
	 * 请求时httpStatusCode代码，如：200,400,404等
	 */
   	@Column(name = "ali_http_status_code" )
	private int aliHttpStatusCode;

	/**
	 * 请求耗时（毫秒单位）
	 */
   	@Column(name = "ali_time_consuming" )
	private int aliTimeConsuming;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getAliId() {
		return aliId;
	}

	public void setAliId(Long aliId) {
		this.aliId = aliId;
	}

	public String getAliClientIp() {
		return aliClientIp;
	}

	public void setAliClientIp(String aliClientIp) {
		this.aliClientIp = aliClientIp;
	}

	public String getAliUri() {
		return aliUri;
	}

	public void setAliUri(String aliUri) {
		this.aliUri = aliUri;
	}

	public String getAliType() {
		return aliType;
	}

	public void setAliType(String aliType) {
		this.aliType = aliType;
	}

	public String getAliMethod() {
		return aliMethod;
	}

	public void setAliMethod(String aliMethod) {
		this.aliMethod = aliMethod;
	}

	public String getAliParamData() {
		return aliParamData;
	}

	public void setAliParamData(String aliParamData) {
		this.aliParamData = aliParamData;
	}

	public String getAliSessionId() {
		return aliSessionId;
	}

	public void setAliSessionId(String aliSessionId) {
		this.aliSessionId = aliSessionId;
	}

	public Date getAliTime() {
		return aliTime;
	}

	public void setAliTime(Date aliTime) {
		this.aliTime = aliTime;
	}

	public String getAliReturnTime() {
		return aliReturnTime;
	}

	public void setAliReturnTime(String aliReturnTime) {
		this.aliReturnTime = aliReturnTime;
	}

	public String getAliReturnData() {
		return aliReturnData;
	}

	public void setAliReturnData(String aliReturnData) {
		this.aliReturnData = aliReturnData;
	}

	public int getAliHttpStatusCode() {
		return aliHttpStatusCode;
	}

	public void setAliHttpStatusCode(int aliHttpStatusCode) {
		this.aliHttpStatusCode = aliHttpStatusCode;
	}

	public int getAliTimeConsuming() {
		return aliTimeConsuming;
	}

	public void setAliTimeConsuming(int aliTimeConsuming) {
		this.aliTimeConsuming = aliTimeConsuming;
	}
}
