package sbr.me;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CoderCtrl {
    private static final Logger LOG = LoggerFactory.getLogger(CoderCtrl.class);

    @Autowired
    private CoderRepo repo;

    @GetMapping("/coders")
    public List<Coder> getAll() {
        LOG.trace("getAll");
        return repo.findAll();
    }

    @GetMapping("/coders/{id}")
    public Coder get(@PathVariable Long id) {
        LOG.trace("get " + id);
        return repo.findById(id).orElseThrow(() -> new CoderNotFoundException(id));
    }

    @PostMapping("/coders")
    public Coder create(@RequestBody Coder coder) {
        LOG.trace("create " + coder);
        return repo.save(coder);
    }

    @PutMapping("/coders/{id}")
    public Coder update(@RequestBody Coder newer, @PathVariable Long id) {
        LOG.trace(String.format("update coder %d by %s", id, newer));
        return repo.findById(id).map(coder -> {
            coder.setFirstName(newer.getFirstName());
            coder.setLastName(newer.getLastName());
            coder.setHireDate(newer.getHireDate());
            coder.setSalary(newer.getSalary());
            return repo.save(coder);
        }).orElseGet(() -> {
            newer.setId(id);
            return repo.save(newer);
        });
    }

    @PatchMapping("/coders/{id}")
    public Coder partialUpdate(@RequestBody Coder newer, @PathVariable Long id) {
        LOG.trace(String.format("patch coder %d by %s", id, newer));
        return repo.findById(id).map(coder -> {
            if (newer.getFirstName() != null) {
                coder.setFirstName(newer.getFirstName());
            }
            if (newer.getLastName() != null) {
                coder.setLastName(newer.getLastName());
            }
            if (newer.getHireDate() != null) {
                coder.setHireDate(newer.getHireDate());
            }
            if (newer.getSalary() != 0.0) {
                coder.setSalary(newer.getSalary());
            }
            return repo.save(coder);
        }).orElseThrow(() -> new CoderNotFoundException(id));
    }

    @DeleteMapping("/coders/{id}")
    public void delete(@PathVariable Long id) {
        try {
            repo.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            LOG.warn("Can't delete coder", ex);
            throw new CoderNotFoundException(id);
        }
    }
}
