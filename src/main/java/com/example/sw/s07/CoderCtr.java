package com.example.sw.s07;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/s07")
public class CoderCtr {
    private static Logger log = LoggerFactory.getLogger(CoderCtr.class);

    private CoderSvc svc;

    // implicit autowiring
    public CoderCtr(CoderSvc svc) {
        this.svc = svc;
    }

    @GetMapping("/coders")
    public List<Coder> coders() {
        log.trace("enter coders()");

        return svc.getAll();
    }
}
