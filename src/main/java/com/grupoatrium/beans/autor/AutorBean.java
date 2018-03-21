package com.grupoatrium.beans.autor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.grupoatrium.modelo.Autor;
import com.grupoatrium.modelo.Direccion;
import com.grupoatrium.modelo.Editorial;
import com.grupoatrium.modelo.Libro;
import com.grupoatrium.repositorios.AutorRepository;
import com.grupoatrium.repositorios.LibroRepository;


@ManagedBean(name="autorBean")
@ViewScoped
public class AutorBean {
	
	
	private String id;
	private String nombre;
	private String nacionalidad;
	private String comentarios;
	private Set<Libro> libros = new HashSet<Libro>();
	
	
	private Map<String,String> allLibros = new HashMap<String, String>();
	private String selectedLibro;
	
	
	
	public String getSelectedLibro() {
		return selectedLibro;
	}

	public void setSelectedLibro(String selectedLibro) {
		this.selectedLibro = selectedLibro;
	}



	
	
	public Map<String, String> getAllLibros() {
		return allLibros;
	}

	public void setAllLibros(Map<String, String> allLibros) {
		this.allLibros = allLibros;
	}

	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	
	
	@ManagedProperty(value = "#{autorRepository}")
	private AutorRepository autorRepository;
	
	
	@ManagedProperty(value = "#{libroRepository}")
	private LibroRepository libroRepository;
	
	
	
	

	public LibroRepository getLibroRepository() {
		return libroRepository;
	}

	public void setLibroRepository(LibroRepository libroRepository) {
		this.libroRepository = libroRepository;
	}

	public AutorRepository getAutorRepository() {
		return autorRepository;
	}

	public void setAutorRepository(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}
	
	
	
	
	
	
	
	
	

	@PostConstruct
    public void init() {
		
		List<Libro> auxAllLibros= libroRepository.findAll(); 
		for (Libro l:auxAllLibros) {
			
			this.allLibros.put(l.getTitulo(),l.getId().toString());
			
		}
		
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		System.out.println(request.getParameter("id"));
		String idItem = request.getParameter("id");
		
		if (idItem!=null) {
			Long id = Long.parseLong(idItem) ;
			
			Autor editarAutor = autorRepository.findOne(id);
			this.setId(idItem)  ;
			this.setNombre(editarAutor.getNombre());
			this.setNacionalidad(editarAutor.getNacionalidad());
			this.setComentarios(editarAutor.getComentarios());
			this.setLibros(editarAutor.getLibros());
		}

    }
	
	public void edit() {
		Autor autor = new Autor(this.getNombre(),this.getNacionalidad(),this.getComentarios());
		autor.setId(Long.parseLong(this.getId()));
		autorRepository.save(autor);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Autor editado", "Item saved."));
		
	}

	public void save() {
		Autor autor = new Autor(this.getNombre(),this.getNacionalidad(),this.getComentarios());
		autorRepository.save(autor);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Autor salvado", "Item saved."));
	}
	
	public void addLibro() {
		
		Libro libro = libroRepository.findOne(Long.parseLong(this.getSelectedLibro()));
		this.getLibros().add(libro);
		Autor autor = autorRepository.findOne(Long.parseLong(this.getId()));
		autor.addLibro(libro);
		autorRepository.save(autor);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Libro salvado", "Item saved."));
		
	}
	
	public void deleteLibro(Libro libro) {
		Autor autor = autorRepository.findOne(Long.parseLong(this.getId()));
		this.getLibros().remove(libro);
		autor.deleteLibro(libro);
		autorRepository.save(autor);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Libro eliminado", "Item saved."));
		
	}
	

}
