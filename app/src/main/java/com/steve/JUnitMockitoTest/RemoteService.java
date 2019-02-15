package com.steve.JUnitMockitoTest;

public class RemoteService {
    public int add(int i, int j) {
        return (i+j);
    }

    public int square(int i) {
        return i * i;
    }

    public boolean Login(String name, String password) {
        // ......
        return true;
    }
}
