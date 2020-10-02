package com.nalmoussa.coding.practice.problem036;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ShapeAreaSorter {

    public static void main(String[] args) {
        File file = new File("src/main/java/com/mcg/input.txt");
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            PriorityQueue<Shape> shapeQueue = createShapeQueue(scanner);
            outputShapeAreas(shapeQueue);
        } catch (FileNotFoundException e) {
            System.out.println("File not Found!!");
        }
    }

    private static void outputShapeAreas(PriorityQueue<Shape> shapeQueue) {
        while (!shapeQueue.isEmpty()) {
            Shape shape = shapeQueue.remove();
            System.out.println(shape.getName() + " " + shape.getArea());
        }
    }

    private static PriorityQueue<Shape> createShapeQueue(Scanner scanner) {
        PriorityQueue<Shape> shapeQueue = new PriorityQueue<>(new AreaComparator());
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.split("\\s+");
            String name = tokens[0].toLowerCase();
            double[] dimensions = parseDimensions(tokens);
            double area;
            if (isValid(dimensions)) {
                switch (name) {
                    case "circle":
                        area = Math.PI*Math.pow(dimensions[0]/2, 2);
                        break;
                    case "square":
                        area = Math.pow(dimensions[0], 2);
                        break;
                    case "rectangle":
                        area = dimensions[0] * dimensions[1];
                        break;
                    case "triangle":
                        area = 0.5 * dimensions[0] * dimensions[1];
                        break;
                    default:
                        continue; // Ignore
                }
                shapeQueue.add(new Shape(name, area));
            }
        }

        return shapeQueue;
    }

    private static boolean isValid(double[] dimensions) {
        if (dimensions.length < 1 || dimensions.length > 2) {
            return false;
        }

        for (double dimension : dimensions) {
            if (dimension <= 0) {
                return false;
            }
        }
        return true;
    }

    private static double[] parseDimensions(String[] tokens) {
        int count = tokens.length - 1;
        double[] dimensions = new double[count];
        for (int i = 0; i < count; i++) {
            try {
                dimensions[i] = Double.parseDouble(tokens[i + 1]);
            } catch (NumberFormatException ex) {
                dimensions[i] = -1; // This guarantees the line will be ignored
            }
        }
        return dimensions;
    }
}
