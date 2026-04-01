package com.example.lab1;

import com.example.lab1.Mission.Mission;
import com.example.lab1.Parsers.ParserGenerator;
import com.example.lab1.Parsers.Parsers;
import java.io.File;

/**
 *
 * @author kogi <astronaut.kogi@gmail.com>
 */

public class Lab1 {

    public static void main(String[] args) throws Exception {   
        
        FileManager fm = new FileManager();
        ParserGenerator pg = new ParserGenerator();
        File file = fm.getFile();
        if(file == null){
            fm.close();
            return;
        }
        Parsers p = pg.getParser(file);
        if (p == null) {
        return;
        }
        Mission m = p.parse(file);
        m.getReport();
        fm.close();
    }
}
