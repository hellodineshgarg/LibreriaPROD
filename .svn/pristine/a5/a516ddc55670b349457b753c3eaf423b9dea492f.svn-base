package com.grupoatrium.beans.carrito;

import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.grupoatrium.modelo.Libro;

@ManagedBean(name="carritoBean")
@SessionScoped
public class CarritoBean {
	
	private  Set<Libro> libros = new HashSet<Libro>();

	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	} 
	
	
	public void addLibroCarrito(Libro libro) {
		libros.add(libro);
	}
	
	public void deleteLibroCarrito(Libro libro) {
		libros.remove(libro);
		
	}
	
}
