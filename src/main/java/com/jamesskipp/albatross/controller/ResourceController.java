package com.jamesskipp.albatross.controller;

import com.jamesskipp.albatross.entity.Resource;
import com.jamesskipp.albatross.model.ResourceForm;
import com.jamesskipp.albatross.service.ResourceService;
import com.jamesskipp.albatross.util.URL;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(URL.API + URL.RESOURCE)
public class ResourceController extends AbstractBaseController<Resource> {

    private final ResourceService resourceService;

    ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @Secured("ROLE_USER")
    @PostMapping
    public Resource create(@RequestBody @Valid ResourceForm form) {
        return resourceService.create(form);
    }
}
