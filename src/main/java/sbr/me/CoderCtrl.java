package sbr.me;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoderCtrl {
    private static final Logger LOG = LoggerFactory.getLogger(CoderCtrl.class);
    private CoderRepo repo;

    public CoderCtrl(CoderRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/coders")
    List<Coder> getAll() {
        LOG.trace("enter getAll()");
        return repo.findAll();
    }
}
