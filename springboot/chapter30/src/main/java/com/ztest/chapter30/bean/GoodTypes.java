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
 * @Description  t_good_types
 * @Author  11568
 * @Date 2019-08-30 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="t_good_types" )
public class GoodTypes  implements Serializable {

	private static final long serialVersionUID =  3125846557141647200L;

	@Id
   	@Column(name = "tgt_id" )
	private Long tgtId;

   	@Column(name = "tgt_name" )
	private String tgtName;

   	@Column(name = "tgt_is_show" )
	private int tgtIsShow;

   	@Column(name = "tgt_order" )
	private int tgtOrder;

}
