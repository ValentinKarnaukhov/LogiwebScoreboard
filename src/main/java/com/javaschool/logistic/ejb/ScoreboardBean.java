package com.javaschool.logistic.ejb;




import javax.ejb.Stateful;
import javax.ws.rs.client.*;
import javax.ws.rs.core.Response;

import java.io.Serializable;


@Stateful
public class ScoreboardBean implements Serializable {

    private Client client = ClientBuilder.newClient();


    public String sayHello() {

        String uri = "http://localhost:8081/test";
        WebTarget target = client.target(uri);
        Response response = target.request()
                .get();
        response.close();
        return "TEST";

    }





}
