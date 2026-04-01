package com.example.lab1.Parsers;

import com.example.lab1.Mission.Mission;
import java.io.File;

public interface Parsers {
    Mission parse(File file) throws Exception;
    boolean extension(File file);
}
