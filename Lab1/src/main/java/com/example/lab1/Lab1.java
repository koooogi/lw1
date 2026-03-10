package com.example.lab1;

public class Lab1 {

    public static void main(String[] args) {
        Mission mission = new Mission();
        
        // Основная информация
        mission.setMissionId("M-2024-017");
        mission.setData("2024-10-12");
        mission.setLocation("Токио, район Сибуя");
        mission.setOutcome("SUCCESS");
        mission.setDamageCost(1200000);
        
        // Проклятие
        mission.setCurse(new Mission.Curse("Проклятие подземного перехода", "HIGH"));
        
        // Маги
        Mission.Sorcerer itadori = new Mission.Sorcerer("Итадори Юдзи", "GRADE_1");
        Mission.Sorcerer fushiguro = new Mission.Sorcerer("Фушигуро Мэгуми", "GRADE_2");
        mission.getSorcerers().add(itadori);
        mission.getSorcerers().add(fushiguro);
        
        // Техники
        mission.getTechniques().add(new Mission.Technique("Черная вспышка", "INNATE", itadori, 500000));
        mission.getTechniques().add(new Mission.Technique("Техника десяти теней", "SHIKIGAMI", fushiguro, 700000));
        
        // Дополнительно
        mission.setNote("Гражданские не пострадали");
        
        // Вывод отчета
        mission.getReport();
    }
}
