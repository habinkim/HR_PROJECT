package com.ecoandrich.hr.common.controller;


import com.ecoandrich.hr.common.config.Uris;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping(value = Uris.HEALTH_CHECK_ROOT)
    public String healthCheck() {
        return "ok";
    }

}
