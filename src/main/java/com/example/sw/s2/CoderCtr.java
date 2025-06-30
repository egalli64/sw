package com.example.sw.s2;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A Spring MVC controller, specific for REST, mapping calls to /s2 URL
 */
@RestController
@RequestMapping("/s2")
public class CoderCtr {
    private static Logger log = LoggerFactory.getLogger(CoderCtr.class);

    // A service used in the controller, injected by Spring
    private CoderSvc svc;

    // implicit autowiring
    public CoderCtr(CoderSvc svc) {
        this.svc = svc;
    }

    /**
     * The method annotation completes the class-wide one: the HTTP associated
     * command is GET, the URL is /s2/coders; it follows the REST conventions.
     * 
     * @return
     */
    @GetMapping("/coders")
    public List<Coder> coders() {
        log.trace("Enter coders()");

        return svc.getAll();
    }
}
