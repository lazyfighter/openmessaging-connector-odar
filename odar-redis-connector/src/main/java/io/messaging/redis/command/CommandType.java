package io.messaging.redis.command;

import io.openmessaging.connector.api.data.EntryType;

import java.util.HashMap;
import java.util.Map;

public class CommandType {


    private static Map<String, EntryType> commandEntryType = new HashMap<>();


    static {
        commandEntryType.put("SET", EntryType.CREATE);
    }


    public EntryType getCommandEntryType(String commandName) {

        return commandEntryType.get(commandName) != null ? commandEntryType.get(commandName) : EntryType.UPDATE;


    }

}
