package com.taskmanager.model.hardware;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;

public class CpuMetrics {

    SystemInfo systemInfo = new SystemInfo();   //инфо о пеке
    CentralProcessor processor = systemInfo.getHardware().getProcessor();   //определяем процесар

    public String getName() {
        return processor.getProcessorIdentifier().getName();
    }

    public int getPhysicalCores() {     //физ ядра
        return processor.getPhysicalProcessorCount();
    }

    public double[] getCurrentFreq() {        //текущая частота/частоты
        long[] list =  processor.getCurrentFreq();

        double[] result = new double[list.length];

        for (int i = 0; i < list.length; i++) {
            result[i] = Math.round((double) list[i] / 1000000000 * 100) / 100.0;        //округляем весь этот мусор чтобы ггц были и норм выглядело
        }

        return result;
    }

    public double getMaxFreq() {      //макс частота
        long freq = processor.getMaxFreq();
        double result = (double) freq / 1000000000;     //делю на миллиард чтоб ггц были и норм выглядело
        return result;
    }
}