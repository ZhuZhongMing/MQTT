package com.smmd.modules.system.controller;

import com.smmd.modules.system.Listener.SubscribeClient;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import java.text.MessageFormat;

@Component
public class ClienTTest implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        new SubscribeClient().runSubscribe();
    }
}
