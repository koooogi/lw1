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
        public void setName(){
            this.name = name;
        }
        public String getRank(){
            return rank;
        }
        public void setRank(){
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
        public void setName(){
            this.name = name;
        }
        public String getType(){
            return type;
        }
        public void setType(){
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
        public void setDamage(){
            this.damage = damage;
        }
    }
    
    public void getReport(){
        
    }
}
