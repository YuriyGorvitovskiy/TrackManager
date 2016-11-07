package com.trainworld.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import spark.ResponseTransformer;

public class JsonResponseTransformer implements ResponseTransformer {

    ObjectMapper mapper = new ObjectMapper();

    public JsonResponseTransformer() {
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    @Override
    public String render(Object resource) throws Exception {
        return mapper.writeValueAsString(resource);
    }

}
