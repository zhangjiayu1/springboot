package com.ztest.chapter19.entity;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.InputStream;

/**
 * @Description  t_api_token_infos
 * @Author  11568
 * @Date 2019-08-21 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="t_api_token_infos" )
public class ApiTokenInfos  implements Serializable {

	private static final long serialVersionUID =  2433894344981225738L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "ati_id" )
	private Long atiId;

   	@Column(name = "ati_app_id" )
	private String appId;

   	@Column(name = "ati_token" )
	private byte[] atiToken;

	/**
	 * 生成token时间（秒单位）
	 */
   	@Column(name = "ati_build_time" )
	private String atiBuildTime;

}
