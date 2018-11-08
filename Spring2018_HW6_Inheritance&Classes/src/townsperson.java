public class townsperson extends npc {
    private boolean hasQuest;

    public townsperson() {
        super();
        hasQuest = false;
    }
    public townsperson(String str_type,String str_name, char char_gender, int int_hitPoints, String str_zone, boolean bool_hasQuest) {
        super(str_type, str_name,char_gender,int_hitPoints,str_zone);
        hasQuest = bool_hasQuest;
    }
    @Override
    public String toString() {
       return ( super.toString() + String.format("%15s\n", hasQuest));
        //return ( super.toString() + String.format("%15s%25s\n", "Has Quest?") + String.format("​%15s%15s%15s%25s%15s​\n​"​, name, gender, hitPoints, zone ,hasQuest));
    }
}
