package uk.co.hotmail.connorjohnegan.springbootresttdd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uk.co.hotmail.connorjohnegan.springbootresttdd.models.TodoEntity;
import uk.co.hotmail.connorjohnegan.springbootresttdd.repositories.TodosRepository;

@RestController
@RequestMapping("/todos")
public class TodosController {

    @Autowired
    private TodosRepository todosRepository;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public TodoEntity create(@RequestBody TodoEntity todoEntity) {
        return todosRepository.save(todoEntity);
    }
}
