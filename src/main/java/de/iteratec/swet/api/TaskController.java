package de.iteratec.swet.api;

import de.iteratec.swet.domain.Mitarbeiter;
import de.iteratec.swet.domain.Task;
import de.iteratec.swet.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * Task controller for demo purpose.
 *
 * @author abr, anton.brass@iteratec.de on 04.04.2016.
 */
@RestController
@RequestMapping(value = "api")
public class TaskController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping
    public void createTask(@RequestBody Task task) {
        LOGGER.info("got task: {}", task);
        taskRepository.save(task);
    }

    @GetMapping
    @RequestMapping(value = "/all")
    public Iterable<Task> getTasks() {
        LOGGER.info("getting all tasks");
        return taskRepository.findAll();
    }

    @GetMapping
    @RequestMapping(value = "/byName/{name}")
    public Task getTaskByName(@PathVariable("name") String name) {
        LOGGER.info("get task by name: {}", name);
        return taskRepository.findByName(name);
    }

    @GetMapping
    @RequestMapping(value = "/laufbahnstufen")
    public Task getLaufbahnstufe(@PathVariable("laufbahnstufe") String laufbahnstufe) {
        LOGGER.info("get Laufbahnstufe: {}", laufbahnstufe);
        return taskRepository.findByName(laufbahnstufe);
    }

    @GetMapping
    @RequestMapping(value = "/kompetenzbereiche")
    public Task getKompetenzbereich(@PathVariable("kompetenzbereich") String kompetenzbereich) {
        LOGGER.info("get Kompetenzbereich: {}", kompetenzbereich);
        return taskRepository.findByName(kompetenzbereich);
    }

    @GetMapping
    @RequestMapping(value = "/kompetenzstufen")
    public Task getKompetenzstufe(@PathVariable("kompetenzstufe") String kompetenzstufe) {
        LOGGER.info("get Kompetenzstufe: {}", kompetenzstufe);
        return taskRepository.findByName(kompetenzstufe);
    }

    @GetMapping("/get/{id}")
    public Mitarbeiter retrieveMitarbeiter(@PathVariable long id) {
        Optional<Mitarbeiter> mitarbeiter = TaskRepository.findById(id);
        
        if (!mitarbeiter.isPresent())
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);

        return mitarbeiter.get();
    }

}
