package com.javaschool.logistic.beans;




import com.javaschool.logistic.models.JsonResponse;

import javax.ejb.Singleton;
import javax.ws.rs.client.*;

import java.io.Serializable;


@Singleton
public class RestBean implements Serializable {

    private Client client = ClientBuilder.newClient();

    public JsonResponse getActualInformation() {
        System.out.println("QUERY");
        String uri = "http://206.189.24.66:8080/test";
        WebTarget target = client.target(uri);
        return target.request()
                .get(JsonResponse.class);
    }


}
