package com.taskmanager.model.hardware;
import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;

public class DiskMetrics {
    SystemInfo systemInfo = new SystemInfo();
    HWDiskStore disk = systemInfo.getHardware().getDiskStores().get(0);

    public String getName() {
        return disk.getName();
    }

    public String getModel() {
        return disk.getModel();
    }

    public long getSize(){
        return (disk.getSize()/1000000000);
    }
}
