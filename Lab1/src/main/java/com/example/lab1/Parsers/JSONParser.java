//package com.example.lab1.Parsers;
//
//import com.example.lab1.Mission.Mission;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.io.File;
//import java.io.IOException;
//
//public class JSONParser implements Parsers{
//    
//    private ObjectMapper om; 
//    
//    public JSONParser(){
//        this.om = new ObjectMapper();
//    }
//    
//    @Override
//    public boolean extension(File file){
//        String name = file.getName();
//        String l_name = name.toLowerCase();
//        return l_name.endsWith(".json");
//    }
//    
//    @Override
//    public Mission parse(File file){
//        Mission mission = new Mission();
//        
//        if(file == null || !file.exists()){
//            System.out.println("File not found or does not exist");
//            return mission;
//        }
//        
//        if(!extension(file)){
//            System.out.println("Invalid extension. File unsupported. Expected: json.");
//            return mission;
//        }
//        
//        try{
//            mission = om.readValue(file, Mission.class);
//            findSorcerers(mission);
//        }catch(IOException e){
//            System.err.println("Failed parsing of JSON file" + e.getMessage());
//        }
//        
//        return mission;
//    }
//    
//    private void findSorcerers(Mission mission){
//        
//        if(mission.getTechniques() == null || mission.getTechniques().isEmpty()){
//            return;
//        }
//        
//        if(mission.getSorcerers() == null || mission.getSorcerers().isEmpty()){
//            for(Mission.Technique mt : mission.getTechniques()){
//                    Mission.Sorcerer owner = mt.getOwner();
//                    if(owner != null && owner.getName() != null){
//                        String ownerName = owner.getName();
//                        mt.setOwner(new Mission.Sorcerer(ownerName, "UNKNOWN"));
//                    } 
//                    else{
//                        mt.setOwner(new Mission.Sorcerer("UNKNOWN", "UNKNOWN"));
//                    }
//            }
//        }
//        
//        for(Mission.Technique mt : mission.getTechniques()){
//            Mission.Sorcerer owner = mt.getOwner();
//            if(owner != null && owner.getName() != null){
//                String name = owner.getName();
//            
//                for(Mission.Sorcerer ms : mission.getSorcerers()){
//                    if(ms != null && name.equals(ms.getName())){
//                        mt.setOwner(ms);
//                        break;
//                    }
//                }
//            }
//        }  
//    }
//}
