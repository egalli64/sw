package com.example.sw.s07;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CoderSvc {
    public List<Coder> getAll() {
        List<Coder> result = new ArrayList<>();

        result.add(new Coder(103, "Alexander", "Hunold", LocalDate.now(), 8_997.85));

        return result;
    }
}
