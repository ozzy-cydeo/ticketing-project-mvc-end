package com.cybertek.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;
import com.cybertek.dto.ProjectDTO;
import com.cybertek.implementation.ProjectServiceImpl;

@Component
@ConfigurationPropertiesBinding
public class ProjectDTOConverter implements Converter<String, ProjectDTO>{
	
	@Autowired
	ProjectServiceImpl service;
	
	
	@Override
	public ProjectDTO convert(String source) {
	
		ProjectDTO object = new ProjectDTO();
		try {
			object = service.getProjectDTOByProjectCode(source);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}

}
