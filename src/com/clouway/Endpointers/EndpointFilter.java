package com.clouway.Endpointers;

public class EndpointFilter{
    private final Endpoint[] endpoints;

    public EndpointFilter(Endpoint... endpoints) {
        this.endpoints = endpoints;
    }

    public boolean shouldFilter(String url) {
        for (Endpoint each : endpoints) {
            if (each.matches(url)) {
                return true;
            }
        }
        return false;
    }

//    public boolean isStartingWith(String keyword){
//        for (Endpoint point: endpoints) {
//            if(point.matches(keyword)){
//                return true;
//            }
//        }
//        return false;
//    }
}
