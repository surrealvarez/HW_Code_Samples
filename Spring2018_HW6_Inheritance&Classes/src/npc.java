import javax.naming.Name;

public class npc extends character {

    protected String zone;

    public npc() {
        super();
        zone = null;
    }
    public npc(String str_type,String str_name, char char_gender, int int_hitPoints, String str_zone) {
        super(str_type,str_name,char_gender,int_hitPoints);

        zone = str_zone;
    }
    @Override
    public String toString() {

        return ( super.toString() + String.format("%25s", zone));
        //return super.toString() + String.format("​%25s​"​, zone);
    }
}
