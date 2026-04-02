package com.example.lab1.Report;

import com.example.lab1.Mission.Mission;
import com.example.lab1.Mission.MissionBuilder;
import java.util.Map;

public class ConcreteReport implements ReportStrategy{

    @Override
    public String report(Mission mission, MissionBuilder builder) {
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("*".repeat(100)).append("\n");
        sb.append("*".repeat(50)).append("MISSION REPORT").append("*".repeat(36)).append("\n");
        sb.append("*".repeat(100)).append("\n\n");
        sb.append("Mission ID: ").append(mission.getMissionId()).append("\n");
        sb.append("Date: ").append(mission.getDate()).append("\n");
        sb.append("Location: ").append(mission.getLocation()).append("\n");
        sb.append("Outcome: ").append(mission.getOutcome()).append("\n");
        sb.append("Damage Cost: ").append(mission.getDamageCost()).append("\n");
        
        if (mission.getNote() != null && !mission.getNote().isEmpty()) {
            sb.append("Note: ").append(mission.getNote()).append("\n");
        }
        if (mission.getComment() != null && !mission.getComment().isEmpty()) {
            sb.append("Comment: ").append(mission.getComment()).append("\n");
        }
        
        if (mission.getCurse() != null) {
            sb.append("\n").append("*".repeat(100)).append("\n");
            sb.append("*".repeat(50)).append("CURSE").append("*".repeat(45)).append("\n");
            sb.append("Name: ").append(mission.getCurse().getName()).append("\n");
            sb.append("Threat Level: ").append(mission.getCurse().getThreatLevel()).append("\n");
        }
        
        if (!mission.getSorcerers().isEmpty()) {
            sb.append("\n").append("*".repeat(100)).append("\n");
            sb.append("*".repeat(50)).append("SORCERERS").append("*".repeat(41)).append("\n");
            for (Mission.Sorcerer s : mission.getSorcerers()) {
                sb.append("Name: ").append(s.getName()).append("\n");
                sb.append("Rank: ").append(s.getRank()).append("\n");
                sb.append("-".repeat(50)).append("\n");
            }
        }
        
        if (!mission.getTechniques().isEmpty()) {
            sb.append("\n").append("*".repeat(100)).append("\n");
            sb.append("*".repeat(50)).append("TECHNIQUES").append("*".repeat(40)).append("\n");
            for (Mission.Technique t : mission.getTechniques()) {
                sb.append("Name: ").append(t.getName()).append("\n");
                sb.append("Type: ").append(t.getType()).append("\n");
                if (t.getOwner() != null) {
                    sb.append("Owner: ").append(t.getOwner().getName()).append("\n");
                }
                sb.append("Damage: ").append(t.getDamage()).append("\n");
                sb.append("-".repeat(50)).append("\n");
            }
        }
        
        if (!builder.getAdditions().isEmpty()) {
            sb.append("\n").append("*".repeat(100)).append("\n");
            sb.append("*".repeat(50)).append("ADDITIONS").append("*".repeat(42)).append("\n");
            printAdditions(sb, builder.getAdditions());
        }
        
        sb.append("\n").append("*".repeat(100)).append("\n");
        
        return sb.toString();
    }
    
    private void printAdditions(StringBuilder sb, Map<String, Object> additions) {
    for (Map.Entry<String, Object> entry : additions.entrySet()) {
        sb.append("\n*** ").append(entry.getKey().toUpperCase()).append(" ***\n");
        String valueStr = entry.getValue().toString();
        valueStr = valueStr.replace("{", "").replace("}", "");
        valueStr = valueStr.replace(", ", "\n  ");
        sb.append("  ").append(valueStr).append("\n");
    }
}
}
