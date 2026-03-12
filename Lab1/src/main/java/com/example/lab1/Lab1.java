package com.example.lab1;

import com.example.lab1.Parsers.ParserGenerator;
import com.example.lab1.Parsers.Parsers;
import java.io.File;

public class Lab1 {

    public static void main(String[] args) throws Exception {
        
        File file = new File("C:\\шапито\\6 семестр\\веб\\l1\\other\\Данные о миссиях. Вариант 1\\Mission A.txt");
        
        ParserGenerator pg = new ParserGenerator();
        Parsers parser = pg.getParser(file);
        
        Mission mission = parser.parse(file);
        mission.getReport();
        
    }
}
