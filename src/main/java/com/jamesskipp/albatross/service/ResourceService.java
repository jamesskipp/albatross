package com.jamesskipp.albatross.service;

import com.jamesskipp.albatross.entity.Resource;
import com.jamesskipp.albatross.model.ResourceForm;
import com.jamesskipp.albatross.repository.ResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {

    private final ResourceRepository resourceRepository;

    ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public Resource create(ResourceForm form) {
        Resource resource = new Resource();
        resource.setName(form.getName());
        resource.setType(form.getType());
        return resourceRepository.save(resource);
    }
}
