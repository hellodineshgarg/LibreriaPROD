package com.grupoatrium.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Editorial {
	
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nombre;
	
	@OneToOne(targetEntity=Direccion.class)
	private Direccion direccion;
	private String nif;
	
	
	
	public Editorial() {}
	public Editorial(String nombre, Direccion direccion, String nif) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.nif = nif;
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
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	@Override
	public String toString() {
		return "Editorial [nombre=" + nombre + ", direccion=" + direccion + ", nif=" + nif + "]";
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
		Editorial other = (Editorial) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
