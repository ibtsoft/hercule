package com.ibtsoft.hercule.lib.event;

import java.net.InetAddress;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

public abstract class Event {

    private final LocalDateTime time;
    private final InetAddress address;

    protected Event(final InetAddress address) {
        this(now(), address);
    }

    protected Event(final LocalDateTime time, final InetAddress address) {
        this.time = time;
        this.address = address;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public InetAddress getAddress() {
        return address;
    }
}
