package com.ztest.chapter14.entity;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description  t_good_infos瀹炰綋绫籠n * @Author  11568
 * @Date 2019-08-09 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="t_good_infos" )
public class GoodInfos  implements Serializable {

	private static final long serialVersionUID =  6319956015029623494L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "tg_id" )
	private Long tgId;

   	@Column(name = "tg_title" )
	private String tgTitle;

   	@Column(name = "tg_price" )
	private Double tgPrice;

   	@Column(name = "tg_unit" )
	private String tgUnit;

   	@Column(name = "tg_order" )
	private String tgOrder;

   	@OneToOne
   	@JoinColumn(name = "tg_type_id" )
	private GoodTypes type;

}
