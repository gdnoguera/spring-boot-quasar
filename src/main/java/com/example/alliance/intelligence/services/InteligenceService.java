package com.example.alliance.intelligence.services;

import com.example.alliance.util.Util;
import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import org.springframework.stereotype.Service;

import java.util.List;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;

@Service
public class InteligenceService {
    Util util=new Util();
    

    public double[] getLocation(double[][] positions, double[] distances) {

        TrilaterationFunction trilaterationFunction = new TrilaterationFunction(positions, distances);
        NonLinearLeastSquaresSolver nSolver = new NonLinearLeastSquaresSolver(trilaterationFunction, new LevenbergMarquardtOptimizer());

        return nSolver.solve().getPoint().toArray();
    }

    public String getMessage(List<List<String>> msgList) {

        List<String> msgPhrases = util.getMsgPhrases(msgList);
        if (!util.validateMessagesSize(msgList, msgPhrases.size())) {
            System.out.println("Tamaño mensaje incorrecto");
        }

        util.removeGap(msgList, msgPhrases.size());
        String message = util.completeMessage(msgList);
        if (!util.validateMessagePhrases(msgPhrases, message)) {
            System.out.println("No se puede conocer el mensaje");
        }

        return message;
    }

   
}
