package com.github.bibek77.dsa.systemDesign.handler;

import com.github.bibek77.dsa.systemDesign.model.Message;
import com.github.bibek77.dsa.systemDesign.model.Topic;
import com.github.bibek77.dsa.systemDesign.model.TopicSubscriber;
import lombok.NonNull;
import lombok.SneakyThrows;

/**
 * @author bibek
 */
public class SubscriberWorker implements Runnable {
    private final Topic topic;
    private final TopicSubscriber topicSubscriber;

    public SubscriberWorker(@NonNull final Topic topic, @NonNull final TopicSubscriber topicSubscriber) {
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (topicSubscriber) {
            do {
                int curOffset = topicSubscriber.getOffset().get();
                while (curOffset >= topic.getMessages().size()) {
                    topicSubscriber.wait();
                }
                Message message = topic.getMessages().get(curOffset);
                topicSubscriber.getSubscriber().consume(message);

                topicSubscriber.getOffset().compareAndSet(curOffset, curOffset + 1);

            } while (true);
        }
    }

    synchronized public void wakeIfNeeded() {
        synchronized (topicSubscriber) {
            topicSubscriber.notify();
        }
    }
}
