package com.example.lab1.Mission;

import com.example.lab1.ENUMs.Outcome;
import com.example.lab1.ENUMs.Rank;
import com.example.lab1.ENUMs.TechniqueType;
import com.example.lab1.ENUMs.ThreatLevel;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class Mission {
    
    private String missionId;
    private String date;
    private String location;
    private Outcome outcome;
    private String note;
    private String comment;
    private int damageCost;
    
    private List<Sorcerer> sorcerers;
    private List<Technique> techniques;
    private Curse curse;
    
    public Mission(){
        this.sorcerers = new ArrayList<>();
        this.techniques = new ArrayList<>();
        this.curse = new Curse();
        this.outcome = Outcome.UNKNOWN;
    }
    
    public String getMissionId(){
        return missionId;
    }
    public void setMissionId(String missionId){
        this.missionId = missionId;
    }
    public String getDate(){
        return date;
    }
    public void setDate(String data){
        this.date = data;
    }
    public String getLocation(){
        return location;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public Outcome getOutcome(){
        return outcome;
    }
    public void setOutcome(Outcome outcome){
        this.outcome = outcome;
    }
    public void setOutcome(String outcome){
        this.outcome = Outcome.fromString(outcome);
    }
    public String getNote(){
        return note;
    }
    public void setNote(String note){
        this.note = note;
    }
    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    public int getDamageCost(){
        return damageCost;
    }
    public void setDamageCost(int damageCost){
        this.damageCost = damageCost;
    }
    public Curse getCurse(){
        return curse;
    }
    public void setCurse(Curse curse){
        this.curse = curse;
    }
    public List<Sorcerer> getSorcerers(){
        return sorcerers;
    }
    public void setSorcerers(ArrayList<Sorcerer> sorcerers){
        this.sorcerers = sorcerers;
    }
    public List<Technique> getTechniques(){
        return techniques;
    }
    public void setTechniques(ArrayList<Technique> techniques){
        this.techniques = techniques;
    }
    
    public static class Curse{
        private String name;
        private ThreatLevel threatLevel;
        
        public Curse(){
            this.threatLevel = ThreatLevel.UNKNOWN;
        }
        
        public Curse(String name, String threatLevel){
            this.name = name;
            this.threatLevel = ThreatLevel.fromString(threatLevel);
        }
        
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
        public ThreatLevel getThreatLevel(){
            return threatLevel;
        }
        public void setThreatLevel(ThreatLevel threatLevel){
            this.threatLevel = threatLevel;
        }
        public void setThreatLevel(String threatLevel){
            this.threatLevel = ThreatLevel.fromString(threatLevel);
        }
    }
    
    public static class Sorcerer{
        private String name;
        private Rank rank;
        
        public Sorcerer(){
            this.rank = Rank.UNKNOWN;
        }
        
        public Sorcerer(String name, String rank){
            this.name = name;
            this.rank = Rank.fromString(rank);
        }
        
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
        public Rank getRank(){
            return rank;
        }
        public void setRank(Rank rank){
            this.rank = rank;
        }
        public void setRank(String rank){
            this.rank = Rank.fromString(rank);
        }
    }
    
    public static class Technique{
        private String name;
        private TechniqueType type;
        private Sorcerer owner;
        private int damage;
        
        public Technique(){
            this.type = TechniqueType.UNKNOWN;
        }
        
        public Technique(String name, String type, Sorcerer owner, int damage){
            this.name = name;
            this.type = TechniqueType.fromString(type);
            this.owner = owner;    
            this.damage = damage;
        }
        
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
        public TechniqueType getType(){
            return type;
        }
        public void setType(TechniqueType type){
            this.type = type;
        }
        public void setType(String type){
            this.type = TechniqueType.fromString(type);
        }
        public Sorcerer getOwner(){
            return owner;
        }
        @JsonProperty("owner")
        public void setOwnerFromString(String ownerName){
            this.owner = new Sorcerer(ownerName, null);
        }
        public void setOwner(Sorcerer owner){
            this.owner = owner;
        }
        public int getDamage(){
            return damage;
        }
        public void setDamage(int damage){
            this.damage = damage;
        }
    }
}
