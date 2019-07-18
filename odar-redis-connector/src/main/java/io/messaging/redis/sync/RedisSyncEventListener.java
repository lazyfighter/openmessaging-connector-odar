package io.messaging.redis.sync;

import com.moilioncircle.redis.replicator.Replicator;
import com.moilioncircle.redis.replicator.event.Event;
import com.moilioncircle.redis.replicator.event.EventListener;

public class RedisSyncEventListener implements EventListener {


    public RedisSyncEventListener(EventProcessor eventProcessor) {

    }

    @Override
    public void onEvent(Replicator replicator, Event event) {
        System.out.println(event);
    }
}
