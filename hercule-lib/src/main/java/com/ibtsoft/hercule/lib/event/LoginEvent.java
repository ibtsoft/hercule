package com.ibtsoft.hercule.lib.event;

import java.net.InetAddress;
import java.time.LocalDateTime;

import static com.ibtsoft.hercule.lib.event.LoginEvent.LoginEventResultEnum.UNKNOWN;

public class LoginEvent extends AuthenticationEvent {

    private final String username;
    private final LoginEventResultEnum result;

    public LoginEvent(InetAddress address, String username) {
        this(address, username, UNKNOWN);
    }

    public LoginEvent(InetAddress address, String username, LoginEventResultEnum result) {
        super(address);
        this.username = username;
        this.result = result;
    }

    public LoginEvent(LocalDateTime time, InetAddress address, String username) {
        this(time, address, username, UNKNOWN);
    }

    public LoginEvent(LocalDateTime time, InetAddress address, String username, LoginEventResultEnum result) {
        super(time, address);
        this.username = username;
        this.result = result;
    }

    public String getUsername() {
        return username;
    }

    public LoginEventResultEnum getResult() {
        return result;
    }

    public enum LoginEventResultEnum {
        UNKNOWN,
        SUCCESS,
        UNKNOWN_USER,
        UNKNOWN_PASSWORD
    }
}
