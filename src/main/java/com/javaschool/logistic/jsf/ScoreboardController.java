package com.javaschool.logistic.jsf;



import com.javaschool.logistic.ejb.InformationBean;
import com.javaschool.logistic.models.JsonResponse;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;



@ManagedBean
@SessionScoped
public class ScoreboardController implements Serializable {


    @EJB
    private InformationBean informationBean;


    public JsonResponse getJsonResponse() {
        return informationBean.getJsonResponse();
    }



}
