package com.github.bibek77.dsa.systemDesign.impl;

import com.github.bibek77.dsa.systemDesign.handler.TopicHandler;
import com.github.bibek77.dsa.systemDesign.model.Topic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bibek
 * @implNote This class will be used to perform all types of operations on Message Queue
 */
public class MessageQueue {
    private final Map<String, TopicHandler> topicHandler;

    public MessageQueue() {
        this.topicHandler = new HashMap<>();
    }

    public Topic createTopic() {

        return null;
    }

    public void subscribe() {

    }

    public void publish() {

    }

    public void resetOffset() {


    }
}
