package com.example.alliance.intelligence.controller;

import com.example.alliance.intelligence.entities.Response;
import org.springframework.http.RequestEntity;

public interface IntelligenceService {

    public Response getShipLocation(RequestEntity requestEntity);
}
