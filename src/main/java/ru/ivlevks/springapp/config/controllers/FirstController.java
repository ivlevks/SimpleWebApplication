package ru.ivlevks.springapp.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        model.addAttribute("message", "Hello " + name + surname);

    //    System.out.println(name + surname);
        return "first/hello";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a,
                             @RequestParam("b") int b,
                             @RequestParam("action") String action,
                             Model modelCalc){

        double result;
        switch (action) {
            case "sum" :
                result = a + b;
                break;
            case "multiply" :
                result = a * b;
                break;
            case "sub" :
                result = a - b;
                break;
            case "divide" :
                result = a / (double) b;
                break;
            default: result = 0;
            break;
        }

        modelCalc.addAttribute("result", result);

        return "first/calculator";
    }


    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }
}
