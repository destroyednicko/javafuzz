package com.nicko.fuzzer;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Handler {
    public void interfaceInfo() {

        Enumeration<NetworkInterface> interfaces = null;
            try {
                interfaces = NetworkInterface.getNetworkInterfaces();
            } catch (SocketException err) {
                System.out.println("Um erro grave ocorreu!\n : " + err);
            }
            while(true) {
                assert interfaces != null;
                if (!interfaces.hasMoreElements()) break;
                NetworkInterface inter = interfaces.nextElement();
                System.out.printf("\n" + "Interface encontrada: %s", inter);
            }
    }
}
