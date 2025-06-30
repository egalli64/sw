package com.example.sw.s2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * A Spring service
 */
@Service
public class CoderSvc {
    private static Logger log = LoggerFactory.getLogger(CoderSvc.class);

    public List<Coder> getAll() {
        log.trace("Enter getAll()");
        List<Coder> result = new ArrayList<>();

        // mocking a call to the DAO
        result.add(new Coder(103, "Alexander", "Hunold", LocalDate.now(), 8_997.85));

        return result;
    }
}
