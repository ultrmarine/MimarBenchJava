package com.taskmanager.core.oshi;

import oshi.SystemInfo;

public class OshiSystem{
    public static final SystemInfo systemInfo = new SystemInfo(); // сбор инфы о пк,перенос в отдельный файл,а то вроде каждый раз вызывая её очень сильно грузит память
}