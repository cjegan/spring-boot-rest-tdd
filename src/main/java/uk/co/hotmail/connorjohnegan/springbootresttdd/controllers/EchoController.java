package uk.co.hotmail.connorjohnegan.springbootresttdd.controllers;

import org.springframework.web.bind.annotation.*;
import uk.co.hotmail.connorjohnegan.springbootresttdd.models.EchoMessage;

@RestController
@RequestMapping("/echo")
public class EchoController {

    @GetMapping("{message}")
    public EchoMessage get(@PathVariable String message) {
        return new EchoMessage(message);
    }
}
