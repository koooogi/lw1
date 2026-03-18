package com.example.lab1;

import com.example.lab1.Parsers.ParserGenerator;
import com.example.lab1.Parsers.Parsers;
import java.io.File;

public class Lab1 {

    public static void main(String[] args) throws Exception {   
        
        FileManager fm = new FileManager();
        ParserGenerator pg = new ParserGenerator();
        File file = fm.getFile();
        Parsers p = pg.getParser(file);
        Mission m = p.parse(file);
        m.getReport();
        fm.close();
    }
}
