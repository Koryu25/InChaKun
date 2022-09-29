package com.github.koryu25.ai;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RequestManager {

    private String uri;

    public RequestManager() {
        this.uri = "https://app.cotogoto.ai/webapi/noby.json?appkey=" + "8b635b2ee2e9a87063bc9d3a29778c49" + "&study=1";
    }

    public RequestManager addParameter(String param) {
        this.uri = this.uri + "&" + param;
        return this;
    }

    public String send() throws IOException, InterruptedException, ExecutionException {
        HttpClient client = HttpClient.newHttpClient();

        CompletableFuture<HttpResponse<String>> responseFuture = client.sendAsync(getRequest(), HttpResponse.BodyHandlers.ofString());

        return responseFuture.get().body();
    }

    private HttpRequest getRequest() {
        return HttpRequest.newBuilder(
                URI.create(uri))
                .header("accept", "application/json")
                .build();
    }
}
