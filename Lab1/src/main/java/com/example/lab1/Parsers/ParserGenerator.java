package com.example.lab1.Parsers;

import java.io.File;
import java.util.ArrayList;

public class ParserGenerator{
    
    private ArrayList<Parsers> parsers = new ArrayList<>();
    
    public ParserGenerator(){
        parsers.add(new TXTParser());
        parsers.add(new XMLParser());
        parsers.add(new JSONParser());
    }
    
    public Parsers getParser(File file){
        if(file == null){
            return null;
        }
        for(Parsers p : parsers){
            if(p.extension(file)){
                return p;
            }
        }
        System.out.println("No parser made. Valid extensions: XML, TXT, JSON");
        return null;
    }
}
