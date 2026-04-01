package com.example.lab1;

import com.example.lab1.Mission.Mission;
import com.example.lab1.Mission.MissionBuilder;
import com.example.lab1.Parsers.ParserGenerator;
import com.example.lab1.Parsers.Parsers;
import com.example.lab1.Report.ConcreteReport;
import com.example.lab1.Report.ReportContext;
import java.io.File;

/**
 *
 * @author kogi <astronaut.kogi@gmail.com>
 */

public class Lab1 {

    public static void main(String[] args) throws Exception {   
        
        try{
            FileManager fm = new FileManager();
            ParserGenerator pg = new ParserGenerator();
            File file = fm.getFile();
            if(file == null || !file.exists()){
                System.out.println("File not found or does not exist");
                return;
            }
            Parsers parser = pg.getParser(file);
            if (parser == null){
                System.out.println("No parser made. Valid extensions: XML, TXT, JSON");
                return;
            }
            
            MissionBuilder builder = new MissionBuilder();
            Mission mission = parser.parse(file, builder);
            ReportContext context = new ReportContext(new ConcreteReport());
            String report = context.getReport(mission, builder);
            System.out.println(report);
            
        }catch(Exception e){
            System.err.println("Error occured: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
