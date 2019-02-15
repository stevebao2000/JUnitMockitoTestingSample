package com.steve.JUnitMockitoTest;

public class Calculator {
    RemoteService service;

    public Calculator(RemoteService service) {
        this.service = service;
    }

    public int performAdd(int i, int j) {
        return service.add(i, j);
    }

    public int performSquare(int i) {
        return service.square(i);
    }
}
