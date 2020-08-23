package com.smmd.modules.system.Listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import org.springframework.stereotype.Component;

@Component
public class ClientRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        new SubscribeClient().runSubscribe();
    }
}
