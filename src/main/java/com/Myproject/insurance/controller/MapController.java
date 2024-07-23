package com.Myproject.insurance.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MapController {
    @GetMapping(value = "/map")
    public String map() {
        return "map/map";
    }
}
