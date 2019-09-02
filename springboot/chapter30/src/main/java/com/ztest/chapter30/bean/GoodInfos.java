package com.ztest.chapter30.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description  t_good_infos
 * @Author  11568
 * @Date 2019-08-30 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="t_good_infos" )
public class GoodInfos  implements Serializable {

	private static final long serialVersionUID =  5125907206538395802L;

	@Id
   	@Column(name = "tg_id" )
	private Long tgId;

   	@Column(name = "tg_title" )
	private String tgTitle;

   	@Column(name = "tg_price" )
	private Double tgPrice;

   	@Column(name = "tg_unit" )
	private String tgUnit;

   	@Column(name = "tg_order" )
	private int tgOrder;

   	@Column(name = "tg_type_id" )
	private Long tgTypeId;

}
