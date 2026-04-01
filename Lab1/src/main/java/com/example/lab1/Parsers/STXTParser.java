package com.example.lab1.Parsers;

import com.example.lab1.Mission.MissionBuilder;
import java.io.File;

public class STXTParser extends BaseParser{

    @Override
    public boolean extension(File file) {
        String name = file.getName();
        String l_name = name.toLowerCase();
        return l_name.endsWith(".txt");
    }
    
    @Override
    public void parse(String text, MissionBuilder builder) {
    }
    
}
