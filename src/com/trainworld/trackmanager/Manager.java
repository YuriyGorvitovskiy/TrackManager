package com.trainworld.trackmanager;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.stop;

import com.trainworld.json.JsonResponseTransformer;

import spark.ResponseTransformer;

public class Manager {

    Graph               graph;

    ResponseTransformer responseTransformer;

    public Manager() {
        this(new Graph(), new JsonResponseTransformer());
    }

    public Manager(Graph graph, ResponseTransformer responseTransformer) {
        this.graph = graph;
        this.responseTransformer = responseTransformer;
    }

    public void setupEndPoints() {
        get("/graph/track/:id", (req, res) -> graph.getEdge(Long.parseLong(req.params(":id"))), responseTransformer);
        get("/graph/track/:id/head", (req, res) -> graph.getHeadEdge(Long.parseLong(req.params(":id"))), responseTransformer);
        get("/graph/track/:id/tail", (req, res) -> graph.getTailEdge(Long.parseLong(req.params(":id"))), responseTransformer);
    }

    public static void main(String[] args) {
        new Manager().setupEndPoints();
        delete("/server", (req, res) -> {
            stop();
            return "Server goes down!";
        });
    }

}
