package com.example.sw.s12;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class RegionRepo {
    public List<Region> getAll() {
        List<Region> result = new ArrayList<>();

        result.add(new Region(1, "Europe"));
        result.add(new Region(2, "Americas"));

        return result;
    }
}
