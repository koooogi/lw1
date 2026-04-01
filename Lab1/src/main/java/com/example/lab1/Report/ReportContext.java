package com.example.lab1.Report;

import com.example.lab1.Mission.Mission;
import com.example.lab1.Mission.MissionBuilder;

public class ReportContext {
    
    private ReportStrategy strategy;
    
    public ReportContext(){
        this.strategy = new ConcreteReport();
    }
    
    public ReportContext(ReportStrategy strategy){
        this.strategy = strategy;
    }
    
    public void setStrategy(ReportStrategy strategy){
        this.strategy = strategy;
    }
    
    public String getReport(Mission mission, MissionBuilder builder){
        if(strategy == null){
            throw new IllegalStateException("No strategy made");
        }
        return strategy.report(mission, builder);
    }
}
