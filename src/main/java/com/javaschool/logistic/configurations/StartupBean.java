package com.javaschool.logistic.configurations;


import com.javaschool.logistic.beans.ListenerBean;
import com.javaschool.logistic.beans.UpdatePageBean;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Singleton
@Startup
public class StartupBean {


    @Inject
    private ListenerBean listenerBean;

    @Inject
    private UpdatePageBean updatePageBean;



    @PostConstruct
    private void init() throws IOException, TimeoutException {
        updatePageBean.onUpdate("update");
        listenerBean.receive();

    }
}
