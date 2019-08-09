package com.ztest.chapter14.entity;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description  t_good_types
 * @Author  11568
 * @Date 2019-08-09 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="t_good_types" )
public class GoodTypes  implements Serializable {

	private static final long serialVersionUID =  356284898721045513L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "tgt_id" )
	private Long tgtId;

   	@Column(name = "tgt_name" )
	private String tgtName;

   	@Column(name = "tgt_is_show" )
	private String tgtIsShow;

   	@Column(name = "tgt_order" )
	private int tgtOrder;

}
