package com.ztest.chapter18.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description  t_authority
 * @Author  11568
 * @Date 2019-08-19 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="t_authority" )
public class Authority  implements Serializable {

	private static final long serialVersionUID =  5523852949423892051L;

	@Id
	@NotNull
	@Size(min = 0,max = 50)
   	@Column(name = "name" )
	private String name;

	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		if(obj == null || getClass() != obj.getClass()){
			return false;
		}
		Authority authority = (Authority) obj;
		if(!name.equals(authority.name)){
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
