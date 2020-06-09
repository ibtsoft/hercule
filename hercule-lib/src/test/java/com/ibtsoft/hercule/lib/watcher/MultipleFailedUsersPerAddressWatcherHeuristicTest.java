package com.ibtsoft.hercule.lib.watcher;

import java.net.UnknownHostException;
import java.util.List;

import org.junit.Test;

import com.ibtsoft.hercule.lib.event.LoginEvent;

import static com.ibtsoft.hercule.lib.event.LoginEvent.LoginEventResultEnum.UNKNOWN_PASSWORD;
import static java.net.InetAddress.getByAddress;
import static org.assertj.core.api.Assertions.assertThat;

public class MultipleFailedUsersPerAddressWatcherHeuristicTest {

    @Test
    public void addEvent() throws UnknownHostException {
        MultipleFailedUsersPerAddressWatcherHeuristic heuristic = new MultipleFailedUsersPerAddressWatcherHeuristic();

        heuristic.addEvent(new LoginEvent(getByAddress(new byte[] { 100, 100, 100, 100 }), "testuser", UNKNOWN_PASSWORD));
        heuristic.addEvent(new LoginEvent(getByAddress(new byte[] { 100, 100, 100, 100 }), "testuser", UNKNOWN_PASSWORD));
        heuristic.addEvent(new LoginEvent(getByAddress(new byte[] { 100, 100, 100, 100 }), "testuser", UNKNOWN_PASSWORD));
        heuristic.addEvent(new LoginEvent(getByAddress(new byte[] { 100, 100, 100, 100 }), "testuser", UNKNOWN_PASSWORD));
        heuristic.addEvent(new LoginEvent(getByAddress(new byte[] { 100, 100, 100, 100 }), "testuser", UNKNOWN_PASSWORD));

        List<Result> results = heuristic.getResults();

        assertThat(results.size()).isEqualTo(1);
    }

    @Test
    public void getResults() {
    }
}
