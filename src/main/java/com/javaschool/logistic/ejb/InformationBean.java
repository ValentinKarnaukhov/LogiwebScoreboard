package com.javaschool.logistic.ejb;


import com.javaschool.logistic.models.JsonResponse;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.Serializable;


@Stateless
public class InformationBean implements Serializable {

    @EJB
    private ScoreboardBean scoreboardBean;

    private JsonResponse jsonResponse;


    public void update(){
        jsonResponse=scoreboardBean.getActualInformation();
    }

    public JsonResponse getJsonResponse() {
        return jsonResponse;
    }

    public void setJsonResponse(JsonResponse jsonResponse) {
        this.jsonResponse = jsonResponse;
    }
}
