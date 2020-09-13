package sbr.me;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoderCtrl {
    private static final Logger LOG = LoggerFactory.getLogger(CoderCtrl.class);

    @Autowired
    private CoderRepo repo;

    @GetMapping("/coders")
    List<Coder> getAll() {
        LOG.trace("enter getAll()");
        return repo.findAll();
    }
}
