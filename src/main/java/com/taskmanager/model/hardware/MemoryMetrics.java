package com.taskmanager.model.hardware;
import com.taskmanager.core.oshi.OshiSystem;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;

import java.util.List;

public class MemoryMetrics {
    GlobalMemory ram = OshiSystem.systemInfo.getHardware().getMemory();

    public long getTotal(){
        return ((ram.getTotal()/1000000000)-2);
    }

    public long getAvailable(){
        return ((ram.getAvailable()/1000000000)-2);
    }

    public List getPhysMem(){       //кароче это выдаёт список с подробно расписанной инфой о каждой плашке, надо будет потом нормально это оформить
        return ram.getPhysicalMemory();
    }
}
