package com.danyprj;

import java.io.Console;

import com.danyprj.toyrobot.exception.ToyRobotSimulatorException;
import com.danyprj.toyrobot.simulator.Game;
import com.danyprj.toyrobot.simulator.SquareBoard;
import com.danyprj.toyrobot.simulator.ToyRobot;

public class ToyRobotMain {

    public static void main(String[] args) {

        Console console = System.console();

        if (console == null) {
            System.err.println("No console.msg");
            System.exit(1);
        }

        SquareBoard squareBoard = new SquareBoard(5, 5);
        ToyRobot robot = new ToyRobot();
        Game game = new Game(squareBoard, robot);

        System.out.println("Toy Robot Simulator");
        System.out.println("Enter a command, Valid commands are:");
        System.out.println("\'PLACE X,Y,NORTH|SOUTH|EAST|WEST\', MOVE, LEFT, RIGHT, REPORT or EXIT");

        boolean keepRunning = true;
        while (keepRunning) {
            String inputString = console.readLine(": ");
            if ("EXIT".equals(inputString)) {
                keepRunning = false;
            } else {
                try {
                    String outputVal = game.eval(inputString);
                    System.out.println(outputVal);
                } catch (ToyRobotSimulatorException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}