package com.grupoatrium.beans.editorial;



import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupoatrium.modelo.Direccion;
import com.grupoatrium.modelo.Editorial;
import com.grupoatrium.repositorios.DireccionRepository;
import com.grupoatrium.repositorios.EditorialRepository;

@ManagedBean(name="editorialBean")
@RequestScoped
public class EditorialBean implements Serializable{

	
	private Long id;
	private String nombre;
	private String direccion_id;
	private String nif;
	
	
	private Map<String,String> direcciones = new HashMap<String, String>();
	
	
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
	
	public String getDireccion_id() {
		return direccion_id;
	}
	public void setDireccion_id(String direccion_id) {
		this.direccion_id = direccion_id;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	
	@ManagedProperty("#{param.id}")
    private String itemId;
	
	@ManagedProperty(value = "#{editorialRepository}")
	private EditorialRepository editorialRepository;
	
	
	@ManagedProperty(value = "#{direccionRepository}")
	private DireccionRepository direccionRepository;


	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public EditorialRepository getEditorialRepository() {
		return editorialRepository;
	}
	public void setEditorialRepository(EditorialRepository editorialRepository) {
		this.editorialRepository = editorialRepository;
	}
	public DireccionRepository getDireccionRepository() {
		return direccionRepository;
	}
	public void setDireccionRepository(DireccionRepository direccionRepository) {
		this.direccionRepository = direccionRepository;
	}
	
	
	public Map<String, String> getDirecciones() {
		return direcciones;
	}
	public void setDirecciones(Map<String, String> direcciones) {
		this.direcciones = direcciones;
	}
	
	@PostConstruct
    public void init() {
		
		List<Direccion> allDirecciones = direccionRepository.findAll(); 
		for (Direccion d:allDirecciones) {
			
			this.direcciones.put(d.getPoblacion()+d.getNumero(),d.getId().toString());
			
		}
		
		if (this.getItemId()!=null) {
			Long id = Long.parseLong(this.getItemId()) ;
			
			Editorial editarEditorial = editorialRepository.findOne(id);
			this.setId(Long.parseLong(this.getItemId()));
			this.setNif(editarEditorial.getNif());
			this.setNombre(editarEditorial.getNombre());
			try {
				this.setDireccion_id(editarEditorial.getDireccion().getId().toString());
			} catch (Exception e) {}
			

		}

    }
	
	
	
	public void edit() {
		Direccion direccion = direccionRepository.findOne(Long.parseLong(this.getDireccion_id()));
		Editorial editarEditorial = new Editorial(this.getNombre(),direccion,this.getNif());
		editarEditorial.setId(this.getId());
		editorialRepository.save(editarEditorial);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Editorial editada", "Item saved."));
		
	}
	
	public void save() {
		Direccion direccion = direccionRepository.findOne(Long.parseLong(this.getDireccion_id()));
		Editorial editorial = new Editorial(this.getNombre(),direccion,this.getNif());
		editorialRepository.save(editorial);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Editorial salvada", "Item saved."));
	}
	
}
