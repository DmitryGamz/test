package gamz.projects.pharmacyfair.util;

import gamz.projects.pharmacyfair.model.entity.projects.storage.*;
import java.util.Map;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String JWT_SECRET_KEY = "d1e4ac5de9a5ea6f101562c8ebf3f0364eed6c6d52bd0568806d5f1b8c6abed7" +
            "dea85411363909913cc5b3078d49f3e377f917ec1ac51114032a5dc4a7ddb5921b1fd1c724975694bc80e037e23b2efe9e40" +
            "e029915777a2fbd02fceb799a2280127d9a0576ef9d192b64ebedd44f0262739f15df8f644350513db6bcd1d931c";

    public static final Map<String, Class<?>> referenceNamesDeviceMap = Map.ofEntries(
            Map.entry("CommercialStatus", CommercialStatus.class),
            Map.entry("CompletionTime", CompletionTime.class),
            Map.entry("IprStatus", IprStatus.class),
            Map.entry("MarketPerspective", MarketPerspective.class),
            Map.entry("ProductionRequirement", ProductionRequirement.class),
            Map.entry("ProductType", ProductType.class),
            Map.entry("ProjectStatus", ProjectStatus.class),
            Map.entry("Scope", Scope.class),
            Map.entry("StudentsInvolved", StudentsInvolved.class),
            Map.entry("Nkmi", Nkmi.class),
            Map.entry("PriorityType", PriorityType.class),
            Map.entry("AssendDemand", AssendDemand.class),
            Map.entry("RiskClass", RiskClass.class),
            Map.entry("TechReadinessDevice", TechReadinessDevice.class)
    );

    public static final Map<String, Class<?>> referenceNamesMedicationMap = Map.ofEntries(
            Map.entry("CommercialStatus", CommercialStatus.class),
            Map.entry("CompletionTime", CompletionTime.class),
            Map.entry("IprStatus", IprStatus.class),
            Map.entry("MarketPerspective", MarketPerspective.class),
            Map.entry("ProductionRequirement", ProductionRequirement.class),
            Map.entry("ProductType", ProductType.class),
            Map.entry("ProjectStatus", ProjectStatus.class),
            Map.entry("Scope", Scope.class),
            Map.entry("StudentsInvolved", StudentsInvolved.class),
            Map.entry("ApplicationAreaMedication", ApplicationAreaMedication.class),
            Map.entry("PriorityType", PriorityType.class),
            Map.entry("MedicationForm", MedicationForm.class),
            Map.entry("TechReadinessMedication", TechReadinessMedication.class)
    );

    public enum SettingType {
        STRING, NUMBER, BOOLEAN, JSON
    }

    public static final String BASE_URL = "http://localhost:8080/";
}
