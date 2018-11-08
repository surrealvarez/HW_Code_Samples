public class mob extends npc {

    private String classType;
    private boolean questMob;

    public mob() {
        super();
        classType = null;
        questMob = false;
    }

    public mob(String str_type,String str_name, char char_gender, int int_hitPoints, String str_zone, String str_classType, boolean bool_questMob) {

        super(str_type,str_name,char_gender,int_hitPoints,str_zone);
        classType = str_classType;
        questMob = bool_questMob;

    }
    @Override
    public String toString() {
        return (super.toString() + String.format("%15s%15s\n",classType,questMob));
        //return ( super.toString() +  String.format("%15s%15s\n", "Class", "Quest Mob") +  String.format("​\n​%15s%15s%15s%25s%15s%15s​\n​"​, name,  gender, hitPoints , zone, classType, questMob));
    }
}
