package com.example.lab1.Parsers;

import com.example.lab1.Mission.Mission;
import com.example.lab1.Mission.MissionBuilder;
import java.io.File;

public interface Parsers {
    Mission parse(File file, MissionBuilder builder) throws Exception;
    boolean extension(File file);
}
