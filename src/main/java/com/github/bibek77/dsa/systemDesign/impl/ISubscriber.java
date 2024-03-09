package com.github.bibek77.dsa.systemDesign.impl;

import com.github.bibek77.dsa.systemDesign.model.Message;

/**
 * @author bibek
 */
public interface ISubscriber {
    String getId();
    void consume(Message message) throws InterruptedException;
}
