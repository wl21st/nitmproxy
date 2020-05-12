package com.github.chhsiaoninety.nitmproxy;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class ConnectionInfo {

    private Address clientAddr;

    private Address serverAddr;

    public ConnectionInfo(Address clientAddr) {
        this.clientAddr = clientAddr;
    }

    public ConnectionInfo(Address clientAddr, Address serverAddr) {
        this.clientAddr = clientAddr;
        this.serverAddr = serverAddr;
    }

    @Override
    public String toString() {
        return String.format("[Client (%s)] <=> [Server (%s)]", clientAddr, serverAddr);
    }

    public String toString(boolean client) {
        if (client) {
            return String.format("[Client (%s)] <=> [PROXY]", clientAddr);
        } else {
            return String.format("[PROXY] <=> [Server (%s)]", serverAddr);
        }
    }
}
