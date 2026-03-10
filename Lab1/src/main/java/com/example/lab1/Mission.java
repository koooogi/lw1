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
    
    ArrayList<Sorcerer> sorcerers;
    ArrayList<Technique> techniques;
    private Curse curse;
    
    public Mission(){
        this.sorcerers = new ArrayList<>();
        this.techniques = new ArrayList<>();
    }
    
    public String getMissionId(){
        return missionId;
    }
    public void setMissionId(){
        this.missionId = missionId;
    }
    public String getData(){
        return data;
    }
    public void setData(){
        this.data = data;
    }
    public String getLocation(){
        return location;
    }
    public void setLocation(){
        this.location = location;
    }
    public String getOutcome(){
        return outcome;
    }
    public void setOutcome(){
        this.outcome = outcome;
    }
    public String getNote(){
        return note;
    }
    public void setNote(){
        this.note = note;
    }
    public String getComment(){
        return comment;
    }
    public void setComment(){
        this.comment = comment;
    }
    public int getDamageCost(){
        return damageCost;
    }
    public void setDamageCost(){
        this.damageCost = damageCost;
    }
    public Curse getCurse(){
        return curse;
    }
    public void setCurse(){
        this.curse = curse;
    }
    public ArrayList<Sorcerer> getSorcerers(){
        return sorcerers;
    }
    public void setSorcerers(){
        this.sorcerers = sorcerers;
    }
    public ArrayList<Technique> getTechniques(){
        return techniques;
    }
    public void setTechniques(){
        this.techniques = techniques;
    }
    
    public class Curse{
        private String name;
        private String threatLevel;
        
        public Curse(String name, String threatLevel){
            this.name = name;
            this.threatLevel = threatLevel;
        }
        
        public String getName(){
            return name;
        }
        public void setName(){
            this.name = name;
        }
        public String getThreatLevel(){
            return threatLevel;
        }
        public void setThreatLevel(){
            this.threatLevel = threatLevel;
        }
    }
    
    public class Sorcerer{
        private String name;
        private String rank;
        
        public Sorcerer(String name, String rank){
            this.name = name;
            this.rank = rank;
        }
    }
    
    public class Technique{
        private String name;
        private String type;
        private String owner;
        private int damage;
        
        public Technique(String name, String type, String owner, int damage){
            this.name = name;
            this.type = type;
            this.owner = owner;    
            this.damage = damage;
        }
    }
    
    public void getReport(){
        
    }
}
