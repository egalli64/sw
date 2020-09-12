package msr.me;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoderCtrl {
    private CoderRepo repo;

    public CoderCtrl(CoderRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/coders")
    List<Coder> all() {
        return repo.findAll();
    }
}
