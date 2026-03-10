package com.example.lab1;

import java.util.ArrayList;

public class Mission {
    
    private String missionId;
    private String data;
    private String location;
    private String outcome;
    private String note;
    private String comment;
    private int damageCost;
    
    private ArrayList<Sorcerer> sorcerers;
    private ArrayList<Technique> techniques;
    private Curse curse;
    
    public Mission(){
        this.sorcerers = new ArrayList<>();
        this.techniques = new ArrayList<>();
        this.curse = new Curse();
    }
    
    public String getMissionId(){
        return missionId;
    }
    public void setMissionId(String missionId){
        this.missionId = missionId;
    }
    public String getData(){
        return data;
    }
    public void setData(String data){
        this.data = data;
    }
    public String getLocation(){
        return location;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public String getOutcome(){
        return outcome;
    }
    public void setOutcome(String outcome){
        this.outcome = outcome;
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
    public ArrayList<Sorcerer> getSorcerers(){
        return sorcerers;
    }
    public void setSorcerers(ArrayList<Sorcerer> sorcerers){
        this.sorcerers = sorcerers;
    }
    public ArrayList<Technique> getTechniques(){
        return techniques;
    }
    public void setTechniques(ArrayList<Technique> techniques){
        this.techniques = techniques;
    }
    
    public static class Curse{
        private String name;
        private String threatLevel;
        
        public Curse(){}
        
        public Curse(String name, String threatLevel){
            this.name = name;
            this.threatLevel = threatLevel;
        }
        
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
        public String getThreatLevel(){
            return threatLevel;
        }
        public void setThreatLevel(String threatLevel){
            this.threatLevel = threatLevel;
        }
    }
    
    public static class Sorcerer{
        private String name;
        private String rank;
        
        public Sorcerer(String name, String rank){
            this.name = name;
            this.rank = rank;
        }
        
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
        public String getRank(){
            return rank;
        }
        public void setRank(String rank){
            this.rank = rank;
        }
    }
    
    public static class Technique{
        private String name;
        private String type;
        private Sorcerer owner;
        private int damage;
        
        public Technique(String name, String type, Sorcerer owner, int damage){
            this.name = name;
            this.type = type;
            this.owner = owner;    
            this.damage = damage;
        }
        
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
        public String getType(){
            return type;
        }
        public void setType(String type){
            this.type = type;
        }
        public Sorcerer getOwner(){
            return owner;
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
    
    public void getReport(){
        System.out.println("*".repeat(100));
        System.out.println("*".repeat(100));
        System.out.println("*".repeat(50) + "MISSION REPORT" + "*".repeat(50));
        System.out.println("*".repeat(100));
        System.out.println("*".repeat(100));
        System.out.println("Mission ID:" + getMissionId());
        System.out.println("Data:" + getData());
        System.out.println("Location:" + getLocation());
        System.out.println("*".repeat(100));
        System.out.println("*".repeat(50) + "CURSE" + "*".repeat(50));
        System.out.println("Name:" + curse.getName());
        System.out.println("Threat level:" + curse.getThreatLevel());
        System.out.println("*".repeat(100));
        System.out.println("*".repeat(50) + "SORCERERS" + "*".repeat(50));
        for(Sorcerer s : sorcerers){
            System.out.println("Name:" + s.getName());
            System.out.println("Rank:" + s.getRank());
        }
        System.out.println("*".repeat(100));
        System.out.println("*".repeat(100));
        System.out.println("*".repeat(50) + "TECHNIQUES" + "*".repeat(50));
        for(Technique t : techniques){
            System.out.println("Name:" + t.getName());
            System.out.println("Type:" + t.getType());
            System.out.println("Owner:" + t.getOwner().getName());
            System.out.println("Damage:" + t.getDamage());
        }
        System.out.println("*".repeat(100));
        System.out.println("*".repeat(50) + "RESULTS" + "*".repeat(50));
        System.out.println("Outcome:" + getOutcome());
        System.out.println("Damage Cost:" + getDamageCost());
        if(note != null && !note.isEmpty()){
            System.out.println("Note:" + getNote());
        }
        
        if(comment != null && !comment.isEmpty()){
            System.out.println("Comment:" + getComment());
        }
        System.out.println("*".repeat(100));
        System.out.println("*".repeat(100));
    }
}
