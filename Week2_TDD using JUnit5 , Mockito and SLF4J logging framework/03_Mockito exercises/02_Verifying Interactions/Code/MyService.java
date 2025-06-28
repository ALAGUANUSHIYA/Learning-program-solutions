package com.example;

public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        System.out.println("MyService: fetchData() called"); // 👈 add this
        return api.getData();
    }

}
