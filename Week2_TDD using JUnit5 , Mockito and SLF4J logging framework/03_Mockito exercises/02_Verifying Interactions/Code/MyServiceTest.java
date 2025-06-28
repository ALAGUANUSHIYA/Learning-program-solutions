package com.example;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        System.out.println("Test started");

        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        System.out.println("Calling fetchData()...");
        service.fetchData();

        System.out.println("Verifying getData() was called");
        verify(mockApi).getData();

        System.out.println("Test passed: getData() was called as expected");
    }
}