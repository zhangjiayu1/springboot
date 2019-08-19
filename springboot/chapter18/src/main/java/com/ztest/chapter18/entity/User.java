package com.ztest.chapter18.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description  t_user
 * @Author  11568
 * @Date 2019-08-19 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="t_user" )
public class User  implements Serializable {

	private static final long serialVersionUID =  3748515467314612546L;

	@Id
	@Size(min = 0,max = 50)
   	@Column(name = "username",updatable = false, nullable = false)
	private String username;

	@Email
	@Size(min = 0,max = 50)
   	@Column(name = "email" )
	private String email;

	@Size(min = 0,max = 50)
   	@Column(name = "password" )
	private String password;

   	@Column(name = "activated" )
	private boolean activated;

	@Size(min = 0,max = 50)
   	@Column(name = "activationkey" )
	private String activationkey;

	@Size(min = 0,max = 50)
   	@Column(name = "resetpasswordkey" )
	private String resetpasswordkey;

	@ManyToMany
	@JoinTable(name = "user_authority",
				joinColumns = @JoinColumn(name = "username"),
				inverseJoinColumns = @JoinColumn(name = "authority"))
	private Set<Authority> authorities;

	@Override
	public int hashCode() {
		return username.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		if(obj == null || getClass() != obj.getClass()){
			return false;
		}
		User user = (User) obj;
		if(!username.equals(user.getUsername())){
			return false;
		}
		return true;
	}
}
