package com.ibtsoft.hercule.lib.watcher;

import java.util.List;

import com.ibtsoft.hercule.lib.event.Event;

public interface WatcherHeuristic {

    void addEvent(Event event);

    List<Result> getResults();
}
