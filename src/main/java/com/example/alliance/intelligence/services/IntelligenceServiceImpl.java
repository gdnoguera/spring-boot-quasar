package com.example.alliance.intelligence.services;

import com.example.alliance.intelligence.controller.IntelligenceService;
import com.example.alliance.intelligence.entities.Position;
import com.example.alliance.intelligence.entities.Response;
import com.example.alliance.intelligence.entities.SatellitesRequest;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

@Service
public class IntelligenceServiceImpl implements IntelligenceService {

    @Autowired
    InteligenceService inteligenceService;

    @Autowired
    private Environment environment;

    @Override
    public Response getShipLocation(RequestEntity requestEntity) {

        SatellitesRequest satellitesRequest = (SatellitesRequest) requestEntity.getBody();
        String message = null;
        if (satellitesRequest.getMessages().size() < 2) {
            System.out.println("NÃ¹mero de mensajes insuficientes");

        }
        message = inteligenceService.getMessage(satellitesRequest.getMessages());

        cargarPositions(satellitesRequest);
            double[] points = inteligenceService.getLocation(satellitesRequest.getPositions(), satellitesRequest.getDistances());
            Position position = new Position(points);
            return new Response(position, message);

     
    }

    private void cargarPositions(SatellitesRequest satellitesRequest) {

        if (satellitesRequest.getPositions()[0] == null) {
            int numberSat = Integer.parseInt(environment.getProperty("satellites.numbers"));
            double[][] pointsList = new double[numberSat][];
            String[] satellitePos;
            for (int i = 0; i < satellitesRequest.getSatellites().size(); i++) {
                satellitePos = environment.getProperty("satellites." + i + ".position").split(",");
                pointsList[i] = Arrays.stream(satellitePos)
                        .map(Double::valueOf)
                        .mapToDouble(Double::doubleValue)
                        .toArray();
            }
            satellitesRequest.setPositions(pointsList);
        }
    }

}
