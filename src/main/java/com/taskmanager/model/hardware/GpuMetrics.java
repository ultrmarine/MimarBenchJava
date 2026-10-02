package com.taskmanager.model.hardware;
import oshi.SystemInfo;
import oshi.hardware.GraphicsCard;

public class GpuMetrics {

    SystemInfo systemInfo = new SystemInfo();   //инфо о пеке
    GraphicsCard gpu = systemInfo.getHardware().getGraphicsCards().get(0);   //определяем видюху

    public String getName() {
        return gpu.getName();
    }

    public String getVendor(){      //ну тоесть производитель по идее
        return gpu.getVendor();
    }

    public long getVram(){      //видво память
        return (gpu.getVRam()/1000000000);  //делю чтобы ровное число было
    }
}
