package com.github.bibek77.dsa.systemDesign.MessagingQueueSystem.handler;

import com.github.bibek77.dsa.systemDesign.MessagingQueueSystem.model.Topic;
import com.github.bibek77.dsa.systemDesign.MessagingQueueSystem.model.TopicSubscriber;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bibek
 */
public class TopicHandler {
    private final Topic topic;
    private final Map<String, SubscriberWorker> subscriberWorkers;

    public TopicHandler(@NonNull Topic topic) {
        this.topic = topic;
        this.subscriberWorkers = new HashMap<>();
    }

    public void publish() {
        for(TopicSubscriber topicSubscriber : topic.getSubscribers()) {
            starSubscriberWorker(topicSubscriber);
        }
    }

    public void starSubscriberWorker(@NonNull TopicSubscriber topicSubscriber) {
        final String subscriberId = topicSubscriber.getSubscriber().getId();
        if(!subscriberWorkers.containsKey(subscriberId)) {
            final SubscriberWorker subscriberWorker = new SubscriberWorker(topic, topicSubscriber);
            subscriberWorkers.put(subscriberId, subscriberWorker);
            new Thread(subscriberWorker).start();
        }
        final SubscriberWorker subscriberWorker = subscriberWorkers.get(subscriberId);
        subscriberWorker.wakeIfNeeded();
    }
}
