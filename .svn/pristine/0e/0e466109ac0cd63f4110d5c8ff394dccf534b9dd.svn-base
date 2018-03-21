package com.grupoatrium.beans.autor;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.LazyDataModel;

import com.grupoatrium.beans.autor.LazyAutorDataModel;
import com.grupoatrium.modelo.Autor;
import com.grupoatrium.repositorios.AutorRepository;

@ManagedBean(name="dataTableAutorBean")
@ViewScoped
public class DataTableAutorBean implements Serializable {
	
	
	@ManagedProperty(value = "#{autorRepository}")
	private AutorRepository autorRepository;
	
    private LazyDataModel<Autor> lazyModel;

    
    public AutorRepository getAutorRepository() {
		return autorRepository;
	}

	public void setAutorRepository(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	public LazyDataModel<Autor> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<Autor> lazyModel) {
		this.lazyModel = lazyModel;
	}
	
	
	@PostConstruct
    public void init() {
        lazyModel = new LazyAutorDataModel(autorRepository);
	}
	
	
	public void delete(Autor autor) {
		
		autorRepository.delete(autor);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Editorial Borrada", "Item saved."));
	}
	
	

}
