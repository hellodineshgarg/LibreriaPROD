package com.grupoatrium.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.security.core.context.SecurityContextHolder;


import com.grupoatrium.modelo.User;

@ManagedBean(name="UserSessionBean")
@ViewScoped
public class UserSessionBean extends BaseBacking implements Serializable{
	
	
	private User user;

	public User getUser() {
			return (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
