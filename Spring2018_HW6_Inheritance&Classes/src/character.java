public class character {

    protected String Type;
    protected String name;
    protected char gender;
    protected int hitPoints;

    public character() {
        Type = null;
        name = null;
        gender = '\0';
        hitPoints = 0;
    }

    public character(String str_type,String str_name, char char_gender, int int_hitPoints)
    {
        Type = str_type;
        name = str_name;
        gender = char_gender;
        hitPoints = int_hitPoints;
    }

    public String toString() {

        return  String.format("%15s%15s%15s", name , gender, hitPoints);
        //return String.format("​\n​%15s%15s%15s​"​, "Name"​, "Gender"​, "Hit Points"​);
    }

    public String getType(){
        return Type;
    }
}
