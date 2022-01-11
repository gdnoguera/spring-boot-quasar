package com.example.alliance.intelligence.controller;

import com.example.alliance.intelligence.entities.SatellitesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${communication.context.path}")
public class CommunicationController {

    @Autowired
    private IntelligenceService intelligenceService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity topSecret(RequestEntity<SatellitesRequest> requestEntity) {
        return ResponseEntity.status(HttpStatus.OK).body(intelligenceService.getShipLocation(requestEntity));

    }
}
