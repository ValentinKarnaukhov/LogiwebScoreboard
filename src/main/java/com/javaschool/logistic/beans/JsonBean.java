package com.javaschool.logistic.beans;


import com.javaschool.logistic.models.JsonResponse;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class JsonBean implements Serializable {


    @Inject
    private UpdatePageBean updatePageBean;

    public JsonResponse getJsonResponse(){
        return updatePageBean.getJsonResponse();
    }

}
