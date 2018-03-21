package com.grupoatrium.beans.libro;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.LazyDataModel;

import com.grupoatrium.beans.libro.LazyLibroDataModel;
import com.grupoatrium.modelo.Libro;
import com.grupoatrium.repositorios.LibroRepository;

@ManagedBean(name="dataTableLibroBean")
@ViewScoped
public class DataTableLibroBean implements Serializable {
	
	@ManagedProperty(value = "#{libroRepository}")
	private LibroRepository libroRepository;
	
    private LazyDataModel<Libro> lazyModel;

    
    public LibroRepository getLibroRepository() {
		return libroRepository;
	}

	public void setLibroRepository(LibroRepository libroRepository) {
		this.libroRepository = libroRepository;
	}

	public LazyDataModel<Libro> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<Libro> lazyModel) {
		this.lazyModel = lazyModel;
	}
	
	
	@PostConstruct
    public void init() {
        lazyModel = new LazyLibroDataModel(libroRepository);
	}
	
	
	public void delete(Libro libro) {
		
		libroRepository.delete(libro);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Libro Borrado", "Item saved."));
	}
	
}

