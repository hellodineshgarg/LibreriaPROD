package com.grupoatrium.beans.editorial;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;


import com.grupoatrium.modelo.Editorial;
import com.grupoatrium.repositorios.EditorialRepository;

public class LazyDataTableEditorial  extends LazyDataModel <Editorial> {
	
private EditorialRepository repository;
	
	public LazyDataTableEditorial(EditorialRepository editorialRepository) {
		this.repository=editorialRepository;
	}
	
	 @Override
    public Integer getRowKey(Editorial direccion) {
		return direccion.getId().intValue();
    }
	    
    @Override
    public Editorial getRowData(String rowKey) {
        return repository.findOne(Long.parseLong(rowKey));
    }
	
	
    @Override
    public List<Editorial> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {

    	if (sortField== null) {
    		sortField = "id";
    	}
    	
    	
    	PageRequest pagerequest = new PageRequest(first / pageSize, pageSize,  sortOrder == SortOrder.ASCENDING ? Direction.ASC : Direction.DESC, sortField);
    	
    	
    	String nif = (String) filters.getOrDefault("nif", "");
    	String nombre =  (String) filters.getOrDefault("nombre", "");
    	
    	Page<Editorial> data = repository.findByNifContainingAndNombreContaining(nif,nombre,pagerequest);
    	
    	setRowCount((int) data.getTotalElements());
		return data.getContent();

    }

}
