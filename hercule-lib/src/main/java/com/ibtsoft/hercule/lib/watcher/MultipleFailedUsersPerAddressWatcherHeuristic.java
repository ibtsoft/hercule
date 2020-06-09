package com.ibtsoft.hercule.lib.watcher;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ibtsoft.hercule.lib.event.Event;
import com.ibtsoft.hercule.lib.event.LoginEvent;

import static com.ibtsoft.hercule.lib.event.LoginEvent.LoginEventResultEnum.UNKNOWN_PASSWORD;

public class MultipleFailedUsersPerAddressWatcherHeuristic implements WatcherHeuristic {

    private final HashMap<InetAddress, List<LoginEvent>> loginTracks = new HashMap<>();

    @Override
    public void addEvent(Event event) {
        if (event instanceof LoginEvent) {
            loginTracks
                .computeIfAbsent(event.getAddress(), address -> new ArrayList<>())
                .add((LoginEvent) event);
        }
    }

    @Override
    public List<Result> getResults() {
        List<Result> results = new ArrayList<>();
        loginTracks.forEach((address, loginEvents) -> {
            if (loginEvents.stream().filter(loginEvent -> loginEvent.getResult() == UNKNOWN_PASSWORD).count() > 4) {
                results.add(new InetAddressResult("Too many failed login attempts", address));
            }
        });
        return results;
    }
}
