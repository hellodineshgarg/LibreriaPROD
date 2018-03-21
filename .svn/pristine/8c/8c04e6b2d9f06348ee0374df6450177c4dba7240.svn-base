package com.grupoatrium.beans.autor;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import com.grupoatrium.modelo.Autor;
import com.grupoatrium.repositorios.AutorRepository;

public class LazyAutorDataModel extends LazyDataModel <Autor> {

	private AutorRepository repository;
	
	public LazyAutorDataModel(AutorRepository autorRepository) {
		this.repository=autorRepository;
	}
	
	 @Override
    public Integer getRowKey(Autor autor) {
		return autor.getId().intValue();
    }
	    
    @Override
    public Autor getRowData(String rowKey) {
        return repository.findOne(Long.parseLong(rowKey));
    }
	
	
    @Override
    public List<Autor> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {

    	if (sortField== null) {
    		sortField = "id";
    	}
    	
    	
    	PageRequest pagerequest = new PageRequest(first / pageSize, pageSize,  sortOrder == SortOrder.ASCENDING ? Direction.ASC : Direction.DESC, sortField);
    	
    	
    	String nombre = (String) filters.getOrDefault("nombre", "");
    	String nacionalidad =  (String) filters.getOrDefault("nacionalidad", "");
    	String comentarios =  (String) filters.getOrDefault("comentarios", "");
    	
    	
    	Page<Autor> data = repository.NombreContainingAndNacionalidadContainingAndComentariosContaining(nombre,nacionalidad, comentarios, pagerequest);
    	
    	setRowCount((int) data.getTotalElements());
		return data.getContent();

    }
	
	
	
}