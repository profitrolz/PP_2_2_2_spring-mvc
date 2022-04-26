package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class HelloController {

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "index";
    }

    @GetMapping(value = "cars")
    public String getCars(@RequestParam Optional<Integer> count, ModelMap model) {
        List<Car> cars = getCars();
        model.addAttribute("cars",
                getCars().stream()
                .limit(count.orElse(cars.size()))
                .collect(Collectors.toList())
        );
        return "cars";
    }

    private List<Car> getCars() {
        return List.of(new Car("Toyota", "Corolla", "1.6"),
                new Car("Mazda", "Demio", "1.3"),
                new Car("Lexus", "RX350", "2.4"),
                new Car("Ford", "Mustang", "4.4"),
                new Car("Toyota", "Prius", "1.5"));
    }

}