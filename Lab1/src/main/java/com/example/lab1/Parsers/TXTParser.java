package com.example.lab1.Parsers;

import com.example.lab1.Mission.Mission;
import com.example.lab1.Mission.MissionBuilder;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TXTParser extends BaseParser{
    
    @Override
    public boolean extension(File file){
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
        
        if(info.containsKey("missionid")){
            String id = info.get("missionid");
            if(id != null && !id.isEmpty()){
                builder.setMissionId(id);
            } 
            else {
                builder.setMissionId("EMPTY");
            }
        } 
        else{
            builder.setMissionId("NOT FOUND");
        }
        
        if(info.containsKey("date")){
            String data = info.get("date");
            if(data != null && !data.isEmpty()){
                builder.setDate(data);
            } 
            else {
                builder.setDate("EMPTY");
            }
        } 
        else{
            builder.setDate("NOT FOUND");
        }
        
        if(info.containsKey("location")){
            String loc = info.get("location");
            if(loc != null && !loc.isEmpty()){
                builder.setLocation(loc);
            } 
            else {
                builder.setLocation("EMPTY");
            }
            
        } 
        else{
            builder.setLocation("NOT FOUND");
        }
        
        if(info.containsKey("outcome")){
            String out = info.get("outcome");
            if(out != null && !out.isEmpty()){
                builder.setOutcome(out);
            } 
            else {
                builder.setOutcome("EMPTY");
            }
        } 
        else{
            builder.setOutcome("NOT FOUND");
        }
        
        if(info.containsKey("damagecost")){
            String d = info.get("damagecost");
            if(d != null && !d.isEmpty()){
                builder.setDamageCost(Integer.parseInt(d));
            } 
            else{
                System.err.println("damagecost: empty");
            }
        } 
        else{
                System.err.println("damagecost: not found");
        }
        
        if(info.containsKey("note")){
            String note = info.get("note");
            if (note != null && !note.isEmpty()) {
                builder.setNote(note);
            } 
            else{
                builder.setNote("EMPTY");
            }
        } 
        else{
                builder.setNote("NOT FOUND");
        }
        
        if(info.containsKey("comment")){
             String comment = info.get("comment");
            if(comment != null && !comment.isEmpty()){
                builder.setComment(comment);
            } 
            else{
                builder.setComment("EMPTY");
            }
        } 
        else{
                builder.setComment("NOT FOUND");
        }
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
        
        for(int i = 0; i < info.size(); i++){
            Map<String, String> d = info.get(i);
            String name = d.get("name");
            String rank = d.get("rank");
            
            if(name != null && !name.isEmpty()){
                builder.addSorcerer(new Mission.Sorcerer(name, rank != null ? rank : "NOT STATED"));
            } 
            else{
                builder.addSorcerer(new Mission.Sorcerer("UNKNOWN", rank != null ? rank : "NOT STATED"));
            }
        }
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
        
        for(int i = 0; i < info.size(); i++){
            Map<String, String> d = info.get(i);
            String name = d.get("name");
            String type = d.get("type");
            String owner_name = d.get("owner");
            int damage = 0;
            
            String damage_s = d.get("damage");
            
            if(name != null && !name.isEmpty()){
                if(damage_s != null && !damage_s.isEmpty()){
                try{
                    damage = Integer.parseInt(damage_s);
                }catch(Exception e){
                    System.err.println("Error occured while parsing damage");
                }
            }
            
            if(type == null || type.isEmpty()){
                type = "UNKNOWN";
            }
            
            Mission.Sorcerer owner = findSorcerer(builder, owner_name);
            builder.addTechnique(new Mission.Technique(name, type, owner, damage));
            }else{
                System.err.println("technique " + i + " has no name");
            }
        }
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
        
        if(name != null || lvl != null){
            builder.setCurse(new Mission.Curse(name != null ? name : "NOT FOUND", lvl != null ? lvl : "NOT FOUND"));
        }
    }
}
