package com.nalmoussa.coding.practice.problem036;

// This acts like a struct {name of shape, area of shape}
class Shape {
    private final String name;
    private final double area;

    Shape(String name, double area) {
        this.name = name;
        this.area = area;
    }

    String getName() {
        return this.name;
    }

    double getArea() {
        return this.area;
    }
}
