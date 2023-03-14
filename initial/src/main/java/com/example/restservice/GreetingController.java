package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //GetMapping method ensures that requests sent to the /greeting endpoint are mapped
    //to our greeting method
    @GetMapping("/greeting")

    //RequestParam binds the value send in the query to the name parameter of the greeting
    //method, with a default value of "World" if no value is received.
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        /*
        Create and return a new Greeting object. ID value comes from the counter value
        and will be automatically incremented, while the content value is generated
        from the defined String template using the given name as a parameter.

        The generated Greeting object is automatically converted to JSON.
        */
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}