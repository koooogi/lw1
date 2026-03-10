package com.example.lab1.Parsers;

import com.example.lab1.Mission;
import java.io.File;

public class XMLParser implements Parsers{
    
    @Override
    public boolean extension(File file){
        String name = file.getName();
        String l_name = name.toLowerCase();
        return l_name.endsWith(".xml");
    }
    
    @Override
    public Mission parse(File file){
        Mission mission = new Mission();
        
        
    }
}
