package com.example.lab1;

import java.io.File;
import java.util.Scanner;

public class FileManager {
    
    private Scanner s;
    
    public FileManager(){
        this.s = new Scanner(System.in);
    }
    
    public File getFile(){
        
        System.out.println("*".repeat(100));
        System.out.println("*".repeat(100));
        System.out.println("SUPPORTED EXTENSIONS: XML, JSON, TXT");
        System.out.println("INPUT EXIT TO FINISH: ");
        System.out.println("*".repeat(100));
        System.out.println("*".repeat(100));
        System.out.println("INPUT FULL FILE_LOCATION: ");
        
        
        while(true){
            String input = s.nextLine();
            
            if(input.equalsIgnoreCase("exit")){
                System.out.println("*".repeat(100));
                System.out.println("*".repeat(100));
                return null;
            }
            if(input.isEmpty()){
                System.out.println("EMPTY INPUT");
                continue;
            }
            
            File file = new File(input);
            return file;
        }
    }
    
    public void close(){
        s.close();
    }
}
