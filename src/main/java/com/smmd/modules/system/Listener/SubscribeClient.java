package com.smmd.modules.system.Listener;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Slf4j
public class SubscribeClient {

    public void  runSubscribe() {
        String broker = "tcp://47.105.51.27:1883";
        String clientId = "JavaSample";
        MemoryPersistence persistence = new MemoryPersistence();

        try{
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker:" + broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");

            // String topic="/sys/hubin/message"; // 湖滨主题
            String [] topic={"/lideng/cnc/fanuc/001", "/lideng/cnc/fanuc/002", "/lideng/cnc/fanuc/003"}; // 利登1号机主题
            System.out.println("Subscribe to topic:" + topic);
            sampleClient.subscribe(topic);
            //sampleClient.subscribe(topic);

            sampleClient.setCallback(new MqttCallback() {
                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    System.out.println("=========================================================");
                    log.info("topic:" + topic);
                    log.info("message:" + message);
                    //String theMsg = MessageFormat.format("{0} is arrived for topic {1}.", new String(message.getPayload()), topic);
                    //System.out.println(theMsg);
                    System.out.println("=========================================================");
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                }

                @Override
                public void connectionLost(Throwable throwable) {
                }
            });

            /*String content = "Message from MqttPublishSample";
            int qos = 2;
            System.out.println("Publishing message:" + content);
            MqttMessage message =new MqttMessage(content.getBytes());
            message.setQos(qos);
            sampleClient.publish(topic, message);
            System.out.println("Message published");*/

        }catch(MqttException me){
            System.out.println("reason" + me.getReasonCode());
            System.out.println("msg" + me.getMessage());
            System.out.println("loc" + me.getLocalizedMessage());
            System.out.println("cause" + me.getCause());
            System.out.println("excep" + me);
            me.printStackTrace();
        }
    }
}
