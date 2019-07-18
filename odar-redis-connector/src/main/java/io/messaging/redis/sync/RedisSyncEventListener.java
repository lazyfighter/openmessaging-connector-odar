package io.messaging.redis.sync;

import com.moilioncircle.redis.replicator.RedisSocketReplicator;
import com.moilioncircle.redis.replicator.Replicator;
import com.moilioncircle.redis.replicator.cmd.impl.SetCommand;
import com.moilioncircle.redis.replicator.event.Event;
import com.moilioncircle.redis.replicator.event.EventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedisSyncEventListener implements EventListener {


    private Logger logger = LoggerFactory.getLogger(RedisSyncEventListener.class);

    private EventProcessor eventProcessor;

    public RedisSyncEventListener(EventProcessor eventProcessor) {
        this.eventProcessor = eventProcessor;
    }

    @Override
    public void onEvent(Replicator replicator, Event event) {
        logger.info("event name:{}", event.getClass().getCanonicalName());
        RedisSocketReplicator redisSocketReplicator = (RedisSocketReplicator) replicator;
        eventProcessor.setConfiguration(redisSocketReplicator.getConfiguration());
        handler(event);

    }

    private void handler(Event event) {
        if (event instanceof SetCommand) {
            SetCommand eventCommand = (SetCommand) event;
            byte[] key = eventCommand.getKey();
            byte[] value = eventCommand.getValue();
            logger.info("set {} value {}", new String(key), new String(value));
        }
    }
}
