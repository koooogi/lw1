package com.example.lab1;

import com.example.lab1.Parsers.ParserGenerator;
import com.example.lab1.Parsers.Parsers;
import java.io.File;

public class Lab1 {

    public static void main(String[] args) throws Exception {
        
        File file1 = new File("C:\\шапито\\6 семестр\\веб\\l1\\other\\Данные о миссиях. Вариант 1\\Mission A.txt");
        File file2 = new File("C:\\шапито\\6 семестр\\веб\\l1\\other\\Данные о миссиях. Вариант 1\\Mission A.json");
        
        
        ParserGenerator pg = new ParserGenerator();
        Parsers parser = pg.getParser(file2);
        
        Mission mission = parser.parse(file2);
        mission.getReport();
        
    }
}
