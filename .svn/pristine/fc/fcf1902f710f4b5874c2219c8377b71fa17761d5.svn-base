package com.grupoatrium.modelo;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Autor {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String nacionalidad;
	private String comentarios;
	
	@ManyToMany( targetEntity=Libro.class,fetch=FetchType.EAGER)
	@JoinTable(name="LibroAutor",
	joinColumns=@JoinColumn(name="autor_id",referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="libro_id", referencedColumnName="id"))
	//@ManyToMany(mappedBy="autores", fetch=FetchType.EAGER)
	private Set<Libro> libros = new HashSet<Libro>();
	
	
	public Autor() {}
	
	public Autor(String nombre, String nacionalidad, String comentarios) {
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.comentarios = comentarios;
	}


	@Override
	public String toString() {
		return "Autor [nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", comentarios=" + comentarios + "]";
	}
	
	
	public void addLibro(Libro l){
		libros.add(l);
		l.getAutores().add(this);
	}
	
	public void deleteLibro(Libro l) {
		libros.remove(l);
		l.getAutores().remove(this);
	}
	
	
	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
		Autor other = (Autor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
