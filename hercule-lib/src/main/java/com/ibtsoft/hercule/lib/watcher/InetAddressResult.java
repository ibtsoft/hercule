package com.ibtsoft.hercule.lib.watcher;

import java.net.InetAddress;

import static java.lang.String.format;

public class InetAddressResult extends Result {

    private final InetAddress address;

    public InetAddressResult(String message, InetAddress address) {
        super(message);
        this.address = address;
    }

    public InetAddress getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return format(
            "Suspicious activity from the following address: %s, message: %s",
            address.toString(),
            getMessage());
    }
}
