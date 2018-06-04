package com.javaschool.logistic.ejb;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Singleton
@Startup
public class StartupBean {

    @EJB
    private InformationBean informationBean;

    @EJB
    private ReceiverBean receiverBean;

    @PostConstruct
    public void start() throws IOException, TimeoutException {
        informationBean.update();
        receiverBean.receive();
    }
}
