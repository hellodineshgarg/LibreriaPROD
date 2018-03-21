package com.grupoatrium.beans.direccion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.grupoatrium.beans.BaseBacking;
import com.grupoatrium.modelo.Direccion;
import com.grupoatrium.modelo.Editorial;
import com.grupoatrium.repositorios.DireccionRepository;

@ManagedBean(name="dataTableDireccionBean")
@ViewScoped
public class DataTableDireccionBean implements Serializable {
	
	@ManagedProperty(value = "#{direccionRepository}")
	private DireccionRepository direccionRepository;
	
    private LazyDataModel<Direccion> lazyModel;

    
    public DireccionRepository getDireccionRepository() {
		return direccionRepository;
	}

	public void setDireccionRepository(DireccionRepository direccionRepository) {
		this.direccionRepository = direccionRepository;
	}

	public LazyDataModel<Direccion> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<Direccion> lazyModel) {
		this.lazyModel = lazyModel;
	}
	
	
	@PostConstruct
    public void init() {
        lazyModel = new LazyDireccionDataModel(direccionRepository);
	}
	
	
	public void delete(Direccion direccion) {
		
		direccionRepository.delete(direccion);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Editorial Borrada", "Item saved."));
	}
	
}






