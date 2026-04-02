package com.example.lab1.Parsers;

import com.example.lab1.Mission.Mission;
import com.example.lab1.Mission.MissionBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TXTParser extends BaseParser{
    
    @Override
    public boolean extension(File file){
        if(file == null){
            return false;
        }
        String name = file.getName();
        String l_name = name.toLowerCase();
        return l_name.endsWith(".txt");
    }
    
    @Override
    public void parse(String text, MissionBuilder builder){
        
        String parts[] = text.split("\\n");
        
        ArrayList<String> mainInfo = new ArrayList<>();
        ArrayList<String> sorcererInfo = new ArrayList<>();
        ArrayList<String> techniqueInfo = new ArrayList<>();
        ArrayList<String> curseInfo = new ArrayList<>();
        
        for(String line : parts){
            
            line = line.trim();
            
            if(line.isEmpty()){
                continue;
            }
            
            if(line.startsWith("curse")){
                curseInfo.add(line);
            }
            else if(line.startsWith("sorcerer")){
                sorcererInfo.add(line);
            }
            else if(line.startsWith("technique")){
                techniqueInfo.add(line);
            } 
            else if(line.contains(":")){
                mainInfo.add(line);
            } 
        }
        
        parseMain(mainInfo, builder);
        parseSorcerer(sorcererInfo, builder);
        parseTechnique(techniqueInfo, builder);
        parseCurse(curseInfo, builder);
    }
    
    public void parseMain(ArrayList<String> lines, MissionBuilder builder){
        
        if (lines == null || lines.isEmpty()) return;
        
        Map<String, String> info = new HashMap<>();
        
        for(String line: lines){
            
            if (line.isEmpty()){
                continue;
            }
            
            String parts[] = line.split(":", 2);
            String key = parts[0].trim().toLowerCase();
            String value = parts[1].trim();
            info.put(key, value);
        }
        
        validateBase(builder, info);
    }
    
    public void parseSorcerer(ArrayList<String> lines, MissionBuilder builder){
        
        if(lines == null || lines.isEmpty()) return;
        
        Map<Integer, Map<String, String>> info = new HashMap<>();
        
        for(String line : lines){
            
            if(line.isEmpty()){
                continue;
            }
            
            int start = line.indexOf("[") + 1;
            int end = line.indexOf("]");
            
            int index = Integer.parseInt(line.substring(start, end));
            String scnd = line.substring(end+2);
            String parts[] = scnd.split(":", 2);
            
            String field = parts[0].trim();
            String value = parts[1].trim();
            
            info.putIfAbsent(index, new HashMap<>());
            info.get(index).put(field, value);
        }
        
        validateSorcerer(builder, info);
    }
    
    public void parseTechnique(ArrayList<String> lines, MissionBuilder builder){
        
        if(lines == null || lines.isEmpty()) return;
        
        Map<Integer, Map<String, String>> info = new HashMap<>();
        
        for(String line : lines){
            
            if(line.isEmpty()){
                continue;
            }
            
            int start = line.indexOf("[") + 1;
            int end = line.indexOf("]");
            
            int index = Integer.parseInt(line.substring(start, end));
            String scnd = line.substring(end+2);
            String parts[] = scnd.split(":", 2);
            
            String field = parts[0].trim();
            String value = parts[1].trim();
            
            info.putIfAbsent(index, new HashMap<>());
            info.get(index).put(field, value);
        }
        
        validateTechnique(builder, info);
    }
    
    public void parseCurse(ArrayList<String> lines, MissionBuilder builder){
        
        String name = null;
        String lvl = null;
        
        for(String line: lines){
            
            if(line.isEmpty()){
                continue;
            }
            
            String parts[] = line.split(":", 2);
            String key = parts[0].trim();
            String value = parts[1].trim();
            
            if(key.equals("curse.name")){
                name = value.isEmpty() ? "EMPTY" : value;
            } 
            else if(key.equals("curse.threatLevel")){
                lvl = value.isEmpty() ? "EMPTY" : value;
            }
        }
        
        validateCurse(builder, name, lvl);
    }
}
