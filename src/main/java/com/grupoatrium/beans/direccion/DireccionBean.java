package com.grupoatrium.beans.direccion;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.grupoatrium.modelo.Direccion;
import com.grupoatrium.repositorios.DireccionRepository;

@ManagedBean(name="direccionBean")
@RequestScoped
public class DireccionBean {
	
	
	// SAVE AND UPDATE
		private Long id;
		private String calle;
		private int numero;
		private String poblacion;
		private int cp;
		private String provincia;
		
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCalle() {
			return calle;
		}

		public void setCalle(String calle) {
			this.calle = calle;
		}
		
		
		public int getNumero() {
			return numero;
		}

		public void setNumero(int numero) {
			this.numero = numero;
		}

		public String getPoblacion() {
			return poblacion;
		}

		public void setPoblacion(String poblacion) {
			this.poblacion = poblacion;
		}

		public int getCp() {
			return cp;
		}

		public void setCp(int cp) {
			this.cp = cp;
		}

		public String getProvincia() {
			return provincia;
		}

		public void setProvincia(String provincia) {
			this.provincia = provincia;
		}
		
		// SAVE AND UPDATE
		
		
		
		
		@ManagedProperty("#{param.id}")
	    private String itemId;
		
		@ManagedProperty(value = "#{direccionRepository}")
		private DireccionRepository direccionRepository;
		
		
		public DireccionRepository getDireccionRepository() {
			return direccionRepository;
		}

		public void setDireccionRepository(DireccionRepository direccionRepository) {
			this.direccionRepository = direccionRepository;
		}
		

		public String getItemId() {
			return itemId;
		}

		public void setItemId(String itemId) {
			this.itemId = itemId;
		}

		@PostConstruct
	    public void init() {
			if (this.getItemId()!=null) {
				Long id = Long.parseLong(this.getItemId()) ;
				
				Direccion editarDireccion = direccionRepository.findOne(id);
				this.setId(Long.parseLong(this.getItemId()));
				this.setCalle(editarDireccion.getCalle());
				this.setCp(editarDireccion.getCp());
				this.setNumero(editarDireccion.getNumero());
				this.setPoblacion(editarDireccion.getPoblacion());
				this.setProvincia(editarDireccion.getProvincia());
			}

	    }
		
		
		
		public void edit() {
			Direccion editarDirecion = new Direccion(this.getCalle(), this.getNumero() , this.getPoblacion(), this.getCp(), this.getProvincia());
			editarDirecion.setId(this.getId());
			direccionRepository.save(editarDirecion);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Direcion editada", "Item saved."));
			
		}
		
		public void save() {
			
			Direccion nuevaDireccion = new Direccion(this.getCalle(), this.getNumero() , this.getPoblacion(), this.getCp(), this.getProvincia());
			direccionRepository.save(nuevaDireccion);
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Direcion salvada", "Item saved."));
		}
	
	
	

}
