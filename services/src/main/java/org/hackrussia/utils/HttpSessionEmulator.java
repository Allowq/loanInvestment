package org.hackrussia.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
@Scope(value = "singleton")
public class HttpSessionEmulator {
    private ConcurrentMap<UUID, Pair<String, Timer>> session = new ConcurrentHashMap<>();

    public void put(UUID uuid, String id) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                session.remove(uuid);
            }
        }, 1000 * 60 * 30);
        session.put(uuid, Pair.of(id, timer));
    }

    public boolean exist(UUID uuid) {
        return session.containsKey(uuid);
    }

    public String get(UUID uuid) {
        return session.get(uuid).getFirst();
    }

    public void remove(UUID uuid) {
        session.remove(uuid);
    }
}
