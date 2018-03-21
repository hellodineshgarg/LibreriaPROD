package com.grupoatrium.beans.libro;

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
import com.grupoatrium.modelo.Editorial;
import com.grupoatrium.modelo.Libro;
import com.grupoatrium.repositorios.AutorRepository;
import com.grupoatrium.repositorios.EditorialRepository;
import com.grupoatrium.repositorios.LibroRepository;

@ManagedBean(name="libroBean")
@ViewScoped
public class LibroBean {

	
	private String id;
	private String isbn;
	private String titulo;
	private Set<Autor> autores = new HashSet<Autor>();
	private Editorial editorial;
	private int publicacion;
	private double precio;
	private String descripcion;
	
	private String editorial_id;
	private Map<String,String> editoriales = new HashMap<String, String>();
	
	private String selectedAutor;
	private Map<String,String> allAutores = new HashMap<String, String>();
	
	
	
	
	
	public Map<String, String> getAllAutores() {
		return allAutores;
	}
	public void setAllAutores(Map<String, String> allAutores) {
		this.allAutores = allAutores;
	}
	public String getSelectedAutor() {
		return selectedAutor;
	}
	public void setSelectedAutor(String selectedAutor) {
		this.selectedAutor = selectedAutor;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Set<Autor> getAutores() {
		return autores;
	}
	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	public int getPublicacion() {
		return publicacion;
	}
	public void setPublicacion(int publicacion) {
		this.publicacion = publicacion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	public String getEditorial_id() {
		return editorial_id;
	}
	public void setEditorial_id(String editorial_id) {
		this.editorial_id = editorial_id;
	}
	
	
	
	public Map<String, String> getEditoriales() {
		return editoriales;
	}
	public void setEditoriales(Map<String, String> editoriales) {
		this.editoriales = editoriales;
	}








	@ManagedProperty(value = "#{autorRepository}")
	private AutorRepository autorRepository;
	
	
	@ManagedProperty(value = "#{libroRepository}")
	private LibroRepository libroRepository;
	
	
	
	@ManagedProperty(value = "#{editorialRepository}")
	private EditorialRepository editorialRepository;
	
	
	
	
	

	public EditorialRepository getEditorialRepository() {
		return editorialRepository;
	}
	public void setEditorialRepository(EditorialRepository editorialRepository) {
		this.editorialRepository = editorialRepository;
	}
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
		
		List<Autor> allAutoresAux = autorRepository.findAll();
		List<Editorial> allEditoriales = editorialRepository.findAll();
		
		for (Autor a:allAutoresAux) {
			
			this.allAutores.put(a.getNombre(),a.getId().toString());
		}
		
		
		for (Editorial e:allEditoriales) {
			
			this.editoriales.put(e.getNombre()+e.getId().toString()  , e.getId().toString());
			
		}
		
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		System.out.println(request.getParameter("id"));
		String idItem = request.getParameter("id");
		
		if (idItem!=null) {
			Long id = Long.parseLong(idItem) ;
			
			Libro editarLibro = libroRepository.findOne(id);
			
			this.setId(idItem);
			this.setIsbn(editarLibro.getIsbn());
			this.setTitulo(editarLibro.getTitulo());
			this.setPublicacion(editarLibro.getPublicacion());
			this.setPrecio(editarLibro.getPrecio());
			this.setAutores(editarLibro.getAutores());
			this.setDescripcion(editarLibro.getDescripcion());
			
			
			try {
				this.setEditorial_id(editarLibro.getEditorial().getId().toString());
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			this.setEditorial(editarLibro.getEditorial());
			
		}

    }
	
	public void addAutor(){
		Autor autor = autorRepository.findOne(Long.parseLong(this.getSelectedAutor()));
		Libro libro = libroRepository.findOne(Long.parseLong(this.getId()));
		autores.add(autor);
		libro.addAutor(autor);
		libroRepository.save(libro);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Autor añadido", "Item saved."));
	}
	
	public void edit() {
		Editorial editorial = editorialRepository.findOne(Long.parseLong(getEditorial_id()));
		Libro libro = new Libro(this.getIsbn(),this.getTitulo(),null,editorial,this.getPublicacion(),this.getPrecio(),this.getDescripcion());
		libro.setId(Long.parseLong(this.getId()) );
		
		libroRepository.save(libro);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Libro Editado", "Item saved."));
		
	}
	
	public void deleteAutor(Autor autor) {
		Libro libro = libroRepository.findOne(Long.parseLong(this.getId()));
		autores.remove(autor);
		libro.deleteAutor(autor);
		libroRepository.save(libro);
	} 
	
	
	
	
	public void save() {
		Editorial editorial = editorialRepository.findOne(Long.parseLong(getEditorial_id()));
		Libro libro = new Libro(this.getIsbn(),this.getTitulo(),null,editorial,this.getPublicacion(),this.getPrecio(),this.getDescripcion());
		libroRepository.save(libro);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Libro salvado", "Item saved."));
	}
	
	
	
	
}
