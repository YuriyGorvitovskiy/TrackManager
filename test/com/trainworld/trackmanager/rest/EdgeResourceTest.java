package com.trainworld.trackmanager.rest;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

import com.trainworld.json.JsonResponseTransformer;

public class EdgeResourceTest {

    JsonResponseTransformer transformer = new JsonResponseTransformer();

    @Test
    public void test_Json() throws Exception {
        EdgeResource resource = new EdgeResource();
        resource.id = 1;
        resource.headId = 2;
        resource.tailId = 3;
        resource.type = "track";
        resource.length = 4.5;

        String json = transformer.render(resource);

        try (Scanner in = new Scanner(EdgeResourceTest.class.getResourceAsStream("EdgeResourceTest.json"))) {
            String expected = in.useDelimiter("\\A").hasNext() ? in.next() : "";
            assertEquals(expected, json);
        } catch (Throwable ex) {
            System.out.println(json);
            throw ex;
        }

    }

}
