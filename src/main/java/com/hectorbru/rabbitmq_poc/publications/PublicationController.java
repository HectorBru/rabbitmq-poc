package com.hectorbru.rabbitmq_poc.publications;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("publications/")
public class PublicationController {

    @GetMapping
    public Object getAllPublications() {
        return 1;
    }
}
