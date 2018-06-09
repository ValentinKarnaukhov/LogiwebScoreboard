package com.javaschool.logistic.beans;


import com.javaschool.logistic.models.JsonResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;


@ApplicationScoped
public class UpdatePageBean implements Serializable {


    @Inject
    @Push(channel = "push")
    private PushContext productsContext;

    @Inject
    private RestBean restBean;

    private JsonResponse jsonResponse;

    public void onUpdate(@Observes String message) throws IOException, TimeoutException {
        jsonResponse=restBean.getActualInformation();
        productsContext.send("update");
    }

    JsonResponse getJsonResponse() {
        return jsonResponse;
    }
}
