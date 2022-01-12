package com.example.alliance.intelligence.controller;

import com.example.alliance.intelligence.entities.SatellitesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommunicationController {

    @Autowired
    private IntelligenceService intelligenceService;

    @PostMapping("/topsecret")
    public ResponseEntity topSecret(RequestEntity<SatellitesRequest> requestEntity) {
        return ResponseEntity.status(HttpStatus.OK).body(intelligenceService.getShipLocation(requestEntity));

    }

    @PostMapping("/topsecret_split/{satellite_name}")
    @ResponseBody
    public ResponseEntity<String> topSecretSplit(RequestEntity<SatellitesRequest> requestEntity, @PathVariable String satellite_name) {
        return ResponseEntity.status(HttpStatus.OK).body("no hay suficiente información");

    }

    @GetMapping("/topsecret_split")
    @ResponseBody
    public ResponseEntity<String> getTopSecretSplit(RequestEntity<SatellitesRequest> requestEntity, @RequestParam String satellite_name) {
        return ResponseEntity.status(HttpStatus.OK).body("no hay suficiente información");

    }
}
