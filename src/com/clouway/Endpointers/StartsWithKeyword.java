package com.clouway.Endpointers;

public class StartsWithKeyword implements Endpoint {
    private String endpoint;
    public StartsWithKeyword(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public boolean matches(String url) {
        String[] endpoints = url.split("/");
//        for (String point:endpoints) {
//            System.out.println(point);
//        }
        return endpoints[3].startsWith(endpoint);
    }
}
