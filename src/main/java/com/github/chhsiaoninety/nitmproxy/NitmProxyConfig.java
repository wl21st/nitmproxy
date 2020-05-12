package com.github.chhsiaoninety.nitmproxy;

import java.util.Arrays;
import java.util.List;

import com.github.chhsiaoninety.nitmproxy.enums.ProxyMode;
import com.google.common.base.Joiner;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NitmProxyConfig {

    private ProxyMode proxyMode;

    private String host;

    private int port;

    // TLS related
    private List<Integer> httpsPorts;

    private String certFile;

    private String keyFile;

    private boolean insecure;

    private int maxContentLength;

    private boolean clientHttp2;

    private boolean serverHttp2;

    // Default values
    public NitmProxyConfig() {
        proxyMode = ProxyMode.HTTP;

        host = "127.0.0.1";
        port = 41080;

        httpsPorts = Arrays.asList(443, 41443);
        certFile = "server.pem";
        keyFile = "key.pem";
        insecure = false;

        maxContentLength = 1024 * 1024;

        clientHttp2 = true;
        serverHttp2 = true;
    }

    @Override
    public String toString() {
        List<String> properties = Arrays
            .asList(String.format("proxyMode=%s", proxyMode), String.format("host=%s", host),
                String.format("port=%s", port), String.format("httpsPorts=%s", httpsPorts),
                String.format("certFile=%s", certFile), String.format("keyFile=%s", keyFile),
                String.format("insecure=%b", insecure), String.format("maxContentLength=%d", maxContentLength),
                String.format("clientHttp2=%s", clientHttp2), String.format("serverHttp2=%s", serverHttp2));
        return String.format("NitmProxyConfig%n%s", Joiner.on(System.lineSeparator()).join(properties));
    }
}