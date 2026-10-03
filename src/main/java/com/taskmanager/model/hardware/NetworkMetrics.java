package com.taskmanager.model.hardware;
import com.taskmanager.core.oshi.OshiSystem;
import oshi.SystemInfo;
import oshi.hardware.NetworkIF;

public class NetworkMetrics {
    NetworkIF internet = OshiSystem.systemInfo.getHardware().getNetworkIFs().get(0);

    public String getName(){
        return internet.getName();
    }

    public String[] getIpv4(){
        return internet.getIPv4addr();
    }

    public String[] getIpv6(){
        return internet.getIPv6addr();
    }
}
