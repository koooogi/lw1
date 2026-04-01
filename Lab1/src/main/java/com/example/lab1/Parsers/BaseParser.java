package com.example.lab1.Parsers;

import com.example.lab1.Mission.Mission;
import com.example.lab1.Mission.MissionBuilder;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class BaseParser implements Parsers{

    @Override
    public Mission parse(File file, MissionBuilder builder) throws Exception {
    
    if(file == null || !file.exists()){
        throw new IOException("File not found or does not exist");
    }
    
    if(!extension(file)){
        throw new IOException("Invalid file format. Valid extensions: XML, TXT, JSON");
    }
    
    Path path = Paths.get(file.getPath());
    String text = Files.readString(path);
    parse(text, builder);
    
    return builder.build();
    }
    
    public Mission.Sorcerer findSorcerer(MissionBuilder builder, String owner_name){
        if(owner_name == null || owner_name.isEmpty()){
            return new Mission.Sorcerer("UNKNOWN", "UNKNOWN");
        }
        
        for(Mission.Sorcerer ms: builder.getSorcerers()){
            
            if(owner_name.equals(ms.getName())){
                return ms;
            }
        }
        
        return new Mission.Sorcerer(owner_name, "UNKNOWN");
    }
    
    public abstract void parse(String text, MissionBuilder builder);

    @Override
    public abstract boolean extension(File file);
}
