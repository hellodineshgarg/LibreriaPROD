package com.grupoatrium.beans.libro;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.grupoatrium.modelo.Libro;
import com.grupoatrium.repositorios.LibroRepository;

public class LazyLibroDataModel extends LazyDataModel <Libro> {

	private LibroRepository repository;
	
	public LazyLibroDataModel(LibroRepository direccionRepository) {
		this.repository=direccionRepository;
	}
	
	 @Override
    public Integer getRowKey(Libro direccion) {
		return direccion.getId().intValue();
    }
	    
    @Override
    public Libro getRowData(String rowKey) {
        return repository.findOne(Long.parseLong(rowKey));
    }
	
	
    @Override
    public List<Libro> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {

    	if (sortField== null) {
    		sortField = "id";
    	}
    	
    	
    	PageRequest pagerequest = new PageRequest(first / pageSize, pageSize,  sortOrder == SortOrder.ASCENDING ? Direction.ASC : Direction.DESC, sortField);
    	
    	
    	String isbn = (String) filters.getOrDefault("isbn", "");
    	String titulo=  (String) filters.getOrDefault("titulo", "");
    	String descripcion=  (String) filters.getOrDefault("descripcion", "");
    	
    	Page<Libro> data = repository.findByIsbnContainingAndTituloContainingAndDescripcionContaining(isbn,titulo, descripcion, pagerequest);
    	
    	  	
    	setRowCount((int) data.getTotalElements());
		return data.getContent();

    }
	
	
	
}
