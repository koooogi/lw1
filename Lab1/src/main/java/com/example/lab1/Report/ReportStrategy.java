package com.example.lab1.Report;

import com.example.lab1.Mission.Mission;
import com.example.lab1.Mission.MissionBuilder;

public interface ReportStrategy {
    
    String report(Mission mission, MissionBuilder builder);
}
