package com.grupoatrium.beans.user;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.grupoatrium.modelo.Role;
import com.grupoatrium.modelo.User;

import com.grupoatrium.repositorios.UserRepostory;

@ManagedBean(name="userBean")
@RequestScoped
public class UserBean {
	
	private String id;
	private String username;
	private String password;
	private boolean enabled = true;
	private Role role;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
	@ManagedProperty(value = "#{userRepostory}")
	private UserRepostory userRepository;
	
	@ManagedProperty(value = "#{passwordEncoder}")
	private PasswordEncoder passwordEncoder;
	
	
	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	public UserRepostory getUserRepository() {
		return userRepository;
	}
	public void setUserRepository(UserRepostory userRepository) {
		this.userRepository = userRepository;
	}
	
	
	
	@PostConstruct
    public void init() {
		
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		System.out.println(request.getParameter("id"));
		String idItem = request.getParameter("id");
		
		if (idItem!=null) {
			Long id = Long.parseLong(idItem) ;
			
			User editarUser = userRepository.findOne(id);
			
			this.setId(idItem);
			this.setUsername(editarUser.getUsername());
			this.setPassword(editarUser.getPassword());
			this.setEnabled(editarUser.isEnabled());
			this.setRole(editarUser.getRole());
			
			
		}

    }
	
	
	public void save() {
		Role role = new Role();
		role.setId(Long.parseLong("1"));
		User user = new User();
		user.setUsername(username);
		user.setPassword(getPasswordEncoder().encode(password));
		user.setEnabled(true);
		user.setRole(role);
		userRepository.save(user);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario salvado", "Item saved."));
	}
	
	
	
	public void edit() {
		User user = userRepository.findOne(Long.parseLong(this.getId()));
		Role role = new Role();
		role.setId(Long.parseLong("1"));
		user.setUsername(username);
		user.setPassword(getPasswordEncoder().encode(password));
		user.setEnabled(true);
		user.setRole(role);
		userRepository.save(user);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario editado", "Item saved."));
		
	}

}





