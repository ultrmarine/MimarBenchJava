package com.taskmanager.model.hardware;
import com.taskmanager.core.oshi.OshiSystem;
import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;

public class DiskMetrics {
    HWDiskStore disk = OshiSystem.systemInfo.getHardware().getDiskStores().get(0);

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
