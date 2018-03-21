package com.grupoatrium.beans.editorial;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.LazyDataModel;

import com.grupoatrium.modelo.Editorial;
import com.grupoatrium.repositorios.EditorialRepository;


@ManagedBean(name="dataTableEditorialBean")
@ViewScoped
public class DataTableEditorialBean implements Serializable{
	
	
	@ManagedProperty(value = "#{editorialRepository}")
	private EditorialRepository editorialRepository;
	
    private LazyDataModel<Editorial> lazyModel;

    
    public EditorialRepository getEditorialRepository() {
		return editorialRepository;
	}

	public void setEditorialRepository(EditorialRepository editorialRepository) {
		this.editorialRepository = editorialRepository;
	}

	public LazyDataModel<Editorial> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<Editorial> lazyModel) {
		this.lazyModel = lazyModel;
	}
	
	
	@PostConstruct
    public void init() {
        lazyModel = new LazyDataTableEditorial(editorialRepository);
	}
	
	
	public void delete(Editorial editorial) {
		
		editorialRepository.delete(editorial);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Editorial Borrada", "Item saved."));
	}
	
	
}
