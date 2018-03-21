package com.grupoatrium.modelo;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Libro implements Serializable{
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)	
	private Long id;
	private String isbn;
	private String titulo;
	
	@ManyToMany(targetEntity=Autor.class, fetch=FetchType.EAGER)
	//@ManyToMany(targetEntity=Autor.class)
	@JoinTable(name="LibroAutor", joinColumns=@JoinColumn(name="libro_id",referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="autor_id", referencedColumnName="id"))
	private Set<Autor> autores = new HashSet<Autor>();
	
	@ManyToOne(targetEntity=Editorial.class)
	private Editorial editorial;
	private int publicacion;
	private double precio;
	private String descripcion;
	
	public Libro() {}
	
	public Libro(String isbn, String titulo, Set<Autor> autores, Editorial editorial, int publicacion, double precio,
			String descripcion) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autores = autores;
		this.editorial = editorial;
		this.publicacion = publicacion;
		this.precio = precio;
		this.descripcion = descripcion;
	}
	
	public void addAutor(Autor a) {
		autores.add(a);
		a.getLibros().add(this);
	}
	 public void deleteAutor(Autor a) {
		autores.remove(a);
		a.getLibros().remove(a);
		 
	 }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autores=" + autores + ", editorial=" + editorial
				+ ", publicacion=" + publicacion + ", precio=" + precio + ", descripcion=" + descripcion + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	

}
