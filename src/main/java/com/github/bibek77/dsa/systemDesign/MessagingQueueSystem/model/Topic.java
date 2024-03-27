package com.github.bibek77.dsa.systemDesign.MessagingQueueSystem.model;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bibek
 */
@Getter
public class Topic {
    // Topic class contains topic members and topic methods.
    private final String topicName;
    private final String topicId;
    private final List<Message> messages;
    private final List<TopicSubscriber> subscribers;

    public Topic(@NonNull String topicName, @NonNull String topicId) {
        this.topicName = topicName;
        this.topicId = topicId;
        this.messages = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    public synchronized void addMessage(@NonNull Message message) {
        messages.add(message);
    }

    public void addSubscriber(@NonNull TopicSubscriber topicSubscriber) {
        subscribers.add(topicSubscriber);
    }
}
