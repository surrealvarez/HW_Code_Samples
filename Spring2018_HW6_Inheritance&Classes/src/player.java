public class player extends character {
    private String classType;
    private String armorType;

    public player() {
        super();
        classType = null;
        armorType = null;

    }

    public player(String str_type, String str_name, char char_gender, int int_hitPoints, String str_classType, String str_armorType) {
        super(str_type, str_name, char_gender, int_hitPoints);
        classType = str_classType;
        armorType = str_armorType;

    }
    @Override
    public String toString() {
        return ( super.toString() + String.format("%15s%25s\n" , classType, armorType));
        //return (super.toString() + String.format("\n%15s%15s%25s", "Class", "Equipable Gear") + String.format("​\n​%15s%15s%15s%15s%25s​\n​"​, name, gender, hitPoints, classType, armorType));
    }
}
