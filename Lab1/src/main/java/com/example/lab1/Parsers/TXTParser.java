package com.example.lab1.Parsers;

import com.example.lab1.Mission;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TXTParser implements Parsers{
    
    @Override
    public boolean extension(File file){
        String name = file.getName();
        String l_name = name.toLowerCase();
        return l_name.endsWith(".txt");
    }
    
    @Override
    public Mission parse(File file) throws IOException{
        Mission mission = new Mission();
        
        if(file == null || !file.exists()){
            throw new IOException("File not found or does not exist: " + file);
        }
        
        if(!extension(file)){
            throw new IOException("Invalid extension. File unsupported. Expected: txt." + file);
        }
        
        Path path = Paths.get(file.getPath());
        String text = Files.readString(path);
        
        String parts[] = text.split("\\n");
        
        //System.out.println(text);
        
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
        
        parseMain(mainInfo, mission);
        parseSorcerer(sorcererInfo, mission);
        parseTechnique(techniqueInfo, mission);
        parseCurse(curseInfo, mission);

        return mission;
    }
    
    public void parseMain(ArrayList<String> lines, Mission mission){
        
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
        
        //System.out.println(info);
        
        if(info.containsKey("missionid")){
            String id = info.get("missionid");
            if(id != null && !id.isEmpty()){
                mission.setMissionId(id);
            } 
            else {
                mission.setMissionId("EMPTY");
            }
        } 
        else{
            mission.setMissionId("NOT FOUND");
        }
        
        if(info.containsKey("date")){
            String data = info.get("date");
            if(data != null && !data.isEmpty()){
                mission.setDate(data);
            } 
            else {
                mission.setDate("EMPTY");
            }
        } 
        else{
            mission.setDate("NOT FOUND");
        }
        
        if(info.containsKey("location")){
            String loc = info.get("location");
            if(loc != null && !loc.isEmpty()){
                mission.setLocation(loc);
            } 
            else {
                mission.setLocation("EMPTY");
            }
            
        } 
        else{
            mission.setLocation("NOT FOUND");
        }
        
        if(info.containsKey("outcome")){
            String out = info.get("outcome");
            if(out != null && !out.isEmpty()){
                mission.setOutcome(out);
            } 
            else {
                mission.setOutcome("EMPTY");
            }
        } 
        else{
            mission.setOutcome("NOT FOUND");
        }
        
        if(info.containsKey("damagecost")){
            String d = info.get("damagecost");
            if(d != null && !d.isEmpty()){
                mission.setDamageCost(Integer.parseInt(d));
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
                mission.setNote(note);
            } 
            else{
                mission.setNote("EMPTY");
            }
        } 
        else{
                mission.setNote("NOT FOUND");
        }
        
        if(info.containsKey("comment")){
             String comment = info.get("comment");
            if(comment != null && !comment.isEmpty()){
                mission.setComment(comment);
            } 
            else{
                mission.setComment("EMPTY");
            }
        } 
        else{
                mission.setComment("NOT FOUND");
        }
    }
    
    public void parseSorcerer(ArrayList<String> lines, Mission mission){
        
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
                mission.getSorcerers().add(new Mission.Sorcerer(name, rank != null ? rank : "NOT STATED"));
            } 
            else{
                mission.getSorcerers().add(new Mission.Sorcerer("UNKNOWN", rank != null ? rank : "NOT STATED"));
            }
        }
    }
    
    public void parseTechnique(ArrayList<String> lines, Mission mission){
        
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
            
            Mission.Sorcerer owner = findSorcerer(mission, owner_name);
            mission.getTechniques().add(new Mission.Technique(name, type, owner, damage));
            }else{
                System.err.println("technique " + i + " has no name");
            }
        }
    }
    
    public void parseCurse(ArrayList<String> lines, Mission mission){
        
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
            mission.setCurse(new Mission.Curse(name, lvl));
        }
    }
    
    public Mission.Sorcerer findSorcerer(Mission mission, String owner_name){
        
        if(owner_name == null || owner_name.isEmpty()){
            System.out.println("bibubu");
            return new Mission.Sorcerer("UNKNOWN", "UNKNOWN");
        }
        
        for(Mission.Sorcerer ms: mission.getSorcerers()){
            
            if(owner_name.equals(ms.getName())){
                return ms;
            }
        }
        return new Mission.Sorcerer(owner_name, "UNKNOWN");
    }
}
