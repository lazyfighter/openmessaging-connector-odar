package io.messaging.redis.connector;

import io.openmessaging.KeyValue;
import io.openmessaging.connector.api.data.SourceDataEntry;
import io.openmessaging.connector.api.source.SourceTask;

import java.util.Collection;

public class RedisSouceTask extends SourceTask {


    @Override
    public Collection<SourceDataEntry> poll() {
        return null;
    }

    @Override
    public void start(KeyValue config) {

    }

    @Override
    public void stop() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }
}
