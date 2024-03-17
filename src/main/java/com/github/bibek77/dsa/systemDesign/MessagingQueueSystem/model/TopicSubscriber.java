package com.github.bibek77.dsa.systemDesign.MessagingQueueSystem.model;

import com.github.bibek77.dsa.systemDesign.MessagingQueueSystem.impl.ISubscriber;
import lombok.Getter;
import lombok.NonNull;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author bibek
 */
@Getter
public class TopicSubscriber {
    private final ISubscriber subscriber;
    private final AtomicInteger offset;

    public TopicSubscriber(@NonNull ISubscriber subscriber) {
        this.subscriber = subscriber;
        this.offset = new AtomicInteger(0);
    }
}
