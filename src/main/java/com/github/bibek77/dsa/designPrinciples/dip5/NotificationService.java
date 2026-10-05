package com.github.bibek77.dsa.designPrinciples.dip5;

/**
 * @author bibek
 */
public class NotificationService {
    private NotiticationChannel notiticationChannel;

    public NotificationService(NotiticationChannel channel) {
        this.notiticationChannel = channel;
    }

    public void notify(String msg) {
        notiticationChannel.send(msg);
    }
}
