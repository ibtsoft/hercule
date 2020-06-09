package com.ibtsoft.hercule.lib.watcher;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.ibtsoft.hercule.lib.event.Event;

public class Watcher {

    private final List<WatcherHeuristic> heuristics;

    public Watcher(final List<WatcherHeuristic> heuristics) {
        this.heuristics = ImmutableList.copyOf(heuristics);
    }

    public void addEvent(final Event event) {
        heuristics.forEach(heuristic -> heuristic.addEvent(event));
    }
}
