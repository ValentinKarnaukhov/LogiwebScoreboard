package com.javaschool.logistic.ejb;




import com.javaschool.logistic.models.JsonResponse;
import com.rabbitmq.client.impl.CredentialsProvider;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ws.rs.client.*;

import java.io.Serializable;


@Stateful
public class ScoreboardBean implements Serializable {


    private Client client = ClientBuilder.newClient();

    public JsonResponse getActualInformation() {
        System.out.println("QUERY");
        String uri = "http://206.189.24.66:8080/test";
        WebTarget target = client.target(uri);

        return target.request()
                .get(JsonResponse.class);
    }


}
