package com.bryzz.rest.webservices.restfulwebservices.dynamicfiltering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class DynamicFilteringController {
	
	@GetMapping("/dynamic-filtering")
	public MappingJacksonValue retrieveDynamicBean() {
		DynamicBean dynamicBean = new DynamicBean("0001", "0002", "0003");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(dynamicBean);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	@GetMapping("/dynamic-filtering-list")
	public MappingJacksonValue retrieveListOfDynamicBean() {
		List<DynamicBean> list = Arrays.asList(new DynamicBean("value001", "value002", "value003"), 
				new DynamicBean("value011", "value012", "value013"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filters);
		
		return mapping;
	}
}
