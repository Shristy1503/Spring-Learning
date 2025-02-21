package com.example.demo.controller;


import org.springframework.web.bind.annotation.*;
import com.example.demo.model.User;

@RestController
@RequestMapping("/hello")
public class HelloRestController {

    // curl localhost:8080/hello
    // curl localhost:8080/hello/home
    @RequestMapping(value = {"", "/", "/home"})
    public String sayHello() {
        return "Hello From BridgeLabz!";
    }

    // curl localhost:8080/hello/query?name=Baxazan
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "name") String name) {
        return "Hello " + name + "!";
    }

    // curl localhost:8080/hello/param/DAKAR
    @GetMapping("/param/{name}")
    public String sayHelloParam(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    // curl -X POST -H "Content-Type: application/json" -d '{"firstName": "Lina", "lastName": "Harry"}' http://localhost:8080/hello/post
    @PostMapping("/post")
    public String sayHello(@RequestBody User user) {
        return "Hello " + user.getFirstName() + " " + user.getLastName() + "!";
    }

    // curl -X PUT localhost:8080/hello/put/Lisa?lastName=Plastane
    @PutMapping("/put/{firstName}")
    public String sayHello(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName) {
        return "Hello " + firstName + " " + lastName + "!";
    }
}
