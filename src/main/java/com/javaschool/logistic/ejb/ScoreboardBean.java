package com.javaschool.logistic.ejb;




import com.javaschool.logistic.models.JsonResponse;

import javax.ejb.Stateful;
import javax.ws.rs.client.*;

import java.io.Serializable;


@Stateful
public class ScoreboardBean implements Serializable {

    private Client client = ClientBuilder.newClient();

    public JsonResponse getActualInformation() {
        System.out.println("QUERY");
        String uri = "http://localhost:8081/test";
        WebTarget target = client.target(uri);
        return target.request()
                .get(JsonResponse.class);
    }


}
