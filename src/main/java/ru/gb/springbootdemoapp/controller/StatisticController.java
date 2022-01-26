package ru.gb.springbootdemoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.springbootdemoapp.aop.Aspect;

@Controller
public class StatisticController {

    private final Aspect aspect;

    public StatisticController(Aspect aspect) {
        this.aspect = aspect;
    }

    @GetMapping("/statistic")
    public String getStatistic(Model model) {
        model.addAttribute("millis", aspect.getMillis());
        return "statistic";
    }
}
