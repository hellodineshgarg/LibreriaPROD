package com.grupoatrium.beans.user;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.LazyDataModel;

import com.grupoatrium.beans.user.LazyUserDataModel;
import com.grupoatrium.modelo.User;
import com.grupoatrium.repositorios.UserRepostory;;

@ManagedBean(name="dataTableUserBean")
@ViewScoped
public class DataTableUserBean implements Serializable {
	
	@ManagedProperty(value = "#{userRepostory}")
	private UserRepostory userRepository;
	
    private LazyDataModel<User> lazyModel;

    
    public UserRepostory getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepostory userRepository) {
		this.userRepository = userRepository;
	}

	public LazyDataModel<User> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<User> lazyModel) {
		this.lazyModel = lazyModel;
	}
	
	
	@PostConstruct
    public void init() {
        lazyModel = new LazyUserDataModel(userRepository);
	}
	
	
	public void delete(User user) {
		
		userRepository.delete(user);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Borrado", "Item saved."));
	}
	
}
