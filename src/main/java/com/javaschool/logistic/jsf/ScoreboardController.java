package com.javaschool.logistic.jsf;


import com.javaschool.logistic.ejb.ReceiverBean;
import com.javaschool.logistic.ejb.ScoreboardBean;
import com.javaschool.logistic.models.JsonResponse;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.event.PhaseEvent;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

@ManagedBean
public class ScoreboardController {

    private JsonResponse jsonResponse;

    @EJB
    private ScoreboardBean scoreboardBean;

    @EJB
    private ReceiverBean receiverBean;

    public void init(PhaseEvent event) throws IOException, TimeoutException {
        receiverBean.receive();
    }


}
