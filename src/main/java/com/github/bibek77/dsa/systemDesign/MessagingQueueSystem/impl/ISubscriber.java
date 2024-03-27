package com.github.bibek77.dsa.systemDesign.MessagingQueueSystem.impl;

import com.github.bibek77.dsa.systemDesign.MessagingQueueSystem.model.Message;

/**
 * @author bibek
 */
public interface ISubscriber {
    String getId();
    void consume(Message message) throws InterruptedException;
}
