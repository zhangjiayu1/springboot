package com.ztest.chapter35.bean;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description  t_good_infos
 * @Author  11568
 * @Date 2019-09-03 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="t_good_infos" )
public class GoodInfos  implements Serializable {

	private static final long serialVersionUID =  2576280981095758904L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "tg_id" )
	private Integer tgId;

   	@Column(name = "tg_title" )
	private String tgTitle;

   	@Column(name = "tg_price" )
	private Double tgPrice;

   	@Column(name = "tg_unit" )
	private String tgUnit;

   	@Column(name = "tg_order" )
	private int tgOrder;

   	@Column(name = "tg_type_id" )
	private Integer tgTypeId;

}
