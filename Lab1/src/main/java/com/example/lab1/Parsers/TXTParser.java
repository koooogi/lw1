package com.example.lab1.Parsers;

import com.example.lab1.Mission;
import java.io.File;

public class TXTParser implements Parsers{
    
    @Override
    public boolean extension(File file){
        String name = file.getName();
        String l_name = name.toLowerCase();
        return l_name.endsWith(".txt");
    }
    
    @Override
    public Mission parse(File file){
        Mission mission = new Mission();
        
        if(file == null || !file.exists()){
            System.out.println("File not found or does not exist");
            return mission;
        }
        
        if(!extension(file)){
            System.out.println("Invalid extension. File unsupported. Expected: txt.");
            return mission;
        }
        
        
    }
}
