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
        
//        System.out.println("MAIN");
//        for (String line : mainInfo) {
//            System.out.println(line);
//        }
//        
//        System.out.println("\nCURSE");
//        for (String line : curseInfo) {
//            System.out.println(line);
//        }
//        
//        System.out.println("\nSORCERER");
//        for (String line : sorcererInfo) {
//            System.out.println(line);
//        }
//        
//        System.out.println("\nTECHNIQUE");
//        for (String line : techniqueInfo) {
//            System.out.println(line);
//        }
        
        parseMain(mainInfo, mission);
        parseSorcerer(sorcererInfo, mission);
        parseTechnique(techniqueInfo, mission);
        parseCurse(curseInfo, mission);

        return mission;
    }
    
    public void parseMain(ArrayList<String> lines, Mission mission){
        
        Map<String, String> info = new HashMap<>();
        
        for(String line: lines){
            String parts[] = line.split(":", 2);
            String key = parts[0].trim().toLowerCase();
            String value = parts[1].trim();
            info.put(key, value);
        }
        
        //System.out.println(info);
        
        if(info.containsKey("missionid")){
            mission.setMissionId(info.get("missionid"));
        }
        if(info.containsKey("date")){
            mission.setData(info.get("date"));
        }
        if(info.containsKey("location")){
            mission.setLocation(info.get("location"));
        }
        if(info.containsKey("outcome")){
            mission.setOutcome(info.get("outcome"));
        }
        if(info.containsKey("damagecost")){
            mission.setDamageCost(Integer.parseInt(info.get("damagecost")));
        }
        if(info.containsKey("note")){
            mission.setNote(info.get("note"));
        }
        if(info.containsKey("comment")){
            mission.setComment(info.get("comment"));
        }
    }
    
    public void parseSorcerer(ArrayList<String> lines, Mission mission){
        Map<Integer, Map<String, String>> info = new HashMap<>();
        
        for(String line : lines){
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
            mission.getSorcerers().add(new Mission.Sorcerer(name, rank));
        }
    }
    
    public void parseTechnique(ArrayList<String> lines, Mission mission){
        Map<Integer, Map<String, String>> info = new HashMap<>();
        
        for(String line : lines){
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
            int damage = Integer.parseInt(d.get("damage"));
            
            Mission.Sorcerer owner = findSorcerer(mission, owner_name);
            mission.getTechniques().add(new Mission.Technique(name, type, owner, damage));
        }
    }
    
    public void parseCurse(ArrayList<String> lines, Mission mission){
        
        String name = null;
        String lvl = null;
        
        for(String line: lines){
            String parts[] = line.split(":", 2);
            String key = parts[0].trim();
            String value = parts[1].trim();
            
            if(key.equals("curse.name")){
                name = value;
            } else if(key.equals("curse.threatLevel")){
                lvl = value;
            }
        }
        
        if(name != null || lvl != null){
            mission.setCurse(new Mission.Curse(name, lvl));
        }
    }
    
    public Mission.Sorcerer findSorcerer(Mission mission, String owner_name){
        for(Mission.Sorcerer ms: mission.getSorcerers()){
            if(owner_name.equals(ms.getName())){
                return ms;
            }
        }
        return null;
    }
}
