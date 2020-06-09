package com.ibtsoft.hercule.lib.event;

import java.net.InetAddress;
import java.time.LocalDateTime;

public abstract class AuthenticationEvent extends Event {

    protected AuthenticationEvent(InetAddress address) {
        super(address);
    }

    protected AuthenticationEvent(LocalDateTime time, InetAddress address) {
        super(time, address);
    }
}
