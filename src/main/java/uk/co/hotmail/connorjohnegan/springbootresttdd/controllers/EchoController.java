package uk.co.hotmail.connorjohnegan.springbootresttdd.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.hotmail.connorjohnegan.springbootresttdd.models.EchoMessage;

@RestController
@RequestMapping("/echo")
public class EchoController {

    @GetMapping("{message}")
    public EchoMessage get(@PathVariable String message) {
        return new EchoMessage(message);
    }
}
