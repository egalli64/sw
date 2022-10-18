package com.example.sw.s12;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegionSetterCtrl {
    private static final Logger log = LogManager.getLogger(RegionSetterCtrl.class);

    private RegionRepo repo;

    @Autowired
    public void setRepo(RegionRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/s12s/region/all")
    public String getAll(Model model) {
        log.traceEntry("getAll");

        model.addAttribute("message", repo.getAll());

        return "/s12/result";
    }
}
