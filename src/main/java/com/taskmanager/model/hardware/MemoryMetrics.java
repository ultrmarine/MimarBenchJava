package com.taskmanager.model.hardware;
import com.taskmanager.core.oshi.OshiSystem;
import oshi.hardware.GlobalMemory;

import java.util.List;

public class MemoryMetrics {
    GlobalMemory ram = OshiSystem.systemInfo.getHardware().getMemory();

    public double getTotal(){
        return Math.round((double) ram.getTotal() / (1024 * 1024 * 1024) * 10) / 10.0; // чтоб получить точно значение в плоть до запятой
    }

    public double getAvailable(){
        return Math.round((double) ram.getAvailable() / (1024 * 1024 * 1024) * 10) / 10.0;
    }

    public List getPhysMem(){       //кароче это выдаёт список с подробно расписанной инфой о каждой плашке, надо будет потом нормально это оформить
        return ram.getPhysicalMemory();
    }
}
