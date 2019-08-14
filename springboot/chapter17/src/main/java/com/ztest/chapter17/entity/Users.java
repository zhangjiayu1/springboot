package com.ztest.chapter17.entity;

import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Description  t_users
 * @Author  11568
 * @Date 2019-08-14 
 */


@ToString
@Entity
@Table ( name ="t_users" )
public class Users implements Serializable,UserDetails {

	private static final long serialVersionUID =  969655892635355385L;

	/**
	 * id
	 */
	@Id
   	@Column(name = "u_id" )
	private Long uId;

	/**
	 * 姓名
	 */
   	@Column(name = "u_username" )
	private String username;

	/**
	 * 密码
	 */
   	@Column(name = "u_password" )
	private String uPassword;

   	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "t_user_roles",
			joinColumns = {
					@JoinColumn(name = "ur_user_id")
			},
			inverseJoinColumns = {
					@JoinColumn(name = "ur_role_id")
			}
	)
   	private List<Roles> roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths = new ArrayList<>();
		List<Roles> roles = getRoles();
		for(Roles role : roles){
			auths.add(new SimpleGrantedAuthority(role.getRFlag()));
		}
		return auths;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Long getId() {
		return uId;
	}

	public void setId(Long uId) {
		this.uId = uId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return uPassword;
	}

	public void setPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
}
