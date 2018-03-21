package com.grupoatrium.beans.user;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;

import com.grupoatrium.modelo.User;
import com.grupoatrium.repositorios.UserRepostory;;

public class LazyUserDataModel extends LazyDataModel <User> {

	private UserRepostory repository;
	
	public LazyUserDataModel(UserRepostory userRepository) {
		this.repository=userRepository;
	}
	
	 @Override
    public Integer getRowKey(User user) {
		return user.getId().intValue();
    }
	    
    @Override
    public User getRowData(String rowKey) {
        return repository.findOne(Long.parseLong(rowKey));
    }
	
	
    @Override
    public List<User> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {

    	if (sortField== null) {
    		sortField = "id";
    	}
    	
    	
    	PageRequest pagerequest = new PageRequest(first / pageSize, pageSize,  sortOrder == SortOrder.ASCENDING ? Direction.ASC : Direction.DESC, sortField);
    	
    	
    	String username = (String) filters.getOrDefault("username", "");
    //	Boolean enabled =  (Boolean) filters.getOrDefault("enabled", "true");
    	boolean enabled = true;
    	//String role =  (String) filters.getOrDefault("provincia", "");
    	
    	
    	Page<User> data = repository.findByUsernameContaining(username,pagerequest);
    	//Page<User> data = repository.findByUsernameContainingAndEnabledTrue(username,enabled, pagerequest);
    	//Page<User> data = repository.findAll(pagerequest);
    	
    	setRowCount((int) data.getTotalElements());
		return data.getContent();

    }
	
	
	
}
