package com.grupoatrium.beans.direccion;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;

import com.grupoatrium.modelo.Direccion;
import com.grupoatrium.repositorios.DireccionRepository;

public class LazyDireccionDataModel extends LazyDataModel <Direccion> {

	private DireccionRepository repository;
	
	public LazyDireccionDataModel(DireccionRepository direccionRepository) {
		this.repository=direccionRepository;
	}
	
	 @Override
    public Integer getRowKey(Direccion direccion) {
		return direccion.getId().intValue();
    }
	    
    @Override
    public Direccion getRowData(String rowKey) {
        return repository.findOne(Long.parseLong(rowKey));
    }
	
	
    @Override
    public List<Direccion> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {

    	if (sortField== null) {
    		sortField = "id";
    	}
    	
    	
    	PageRequest pagerequest = new PageRequest(first / pageSize, pageSize,  sortOrder == SortOrder.ASCENDING ? Direction.ASC : Direction.DESC, sortField);
    	
    	
    	String poblacion = (String) filters.getOrDefault("poblacion", "");
    	String calle =  (String) filters.getOrDefault("calle", "");
    	String provincia =  (String) filters.getOrDefault("provincia", "");
    	
    	
    	String id_string = (String) filters.getOrDefault("id", "0");
    	Long id = Long.parseLong(id_string);
    	
    	
    	
    	Page<Direccion> data = repository.findByPoblacionContainingAndCalleContainingAndProvinciaContaining(poblacion,calle, provincia, pagerequest);
    	
    	setRowCount((int) data.getTotalElements());
		return data.getContent();

    }
	
	
	
}
