import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Scanner;
public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int quantity = sc.nextInt();
        character[] array = new character[quantity];

        String whatType;
        for(int i = 0; i < quantity; i++) {
            whatType =  sc.next();
            switch (whatType) {
                case "Player":
                    String pType = "Player";
                    String pName = sc.next();
                    char pGender = sc.next().charAt(0);
                    int pPoints = sc.nextInt();
                    String pClassType = sc.next();
                    String pGear = "";
                    if (pClassType.equals("Mage")) {
                        pGear = "Cloth";
                    }
                    else if (pClassType.equals("Rogue")) {
                        pGear = "Leather";
                    }
                    else if (pClassType.equals("Warrior")) {pGear = "Platemail";
                    }
                    array[i] = new player(pType ,pName, pGender, pPoints, pClassType,pGear);
                    break;
                case "Mob":
                    String mType = "Mob";
                    String mName = sc.next();
                    char mGender = sc.next().charAt(0);
                    int mPoints = sc.nextInt();
                    String mZone = sc.next();
                    String mClassType = sc.next();
                    String mBool = sc.next();
                    Boolean mQuestMob;
                    if (mBool.equals("true")) { mQuestMob = true;}
                    else {mQuestMob = false;}
                    array[i] = new mob(mType,mName,mGender,mPoints,mZone,mClassType,mQuestMob);
                    break;
                case "Townsperson":
                    String tType = "Townsperson";
                    String tName = sc.next();
                    char tGender = sc.next().charAt(0);
                    int tPoints = sc.nextInt();
                    String tZone = sc.next();
                    String tBool = sc.next();
                    Boolean tHasQuest;
                    if (tBool.equals("true")) { tHasQuest = true;}
                    else {tHasQuest = false;}
                    array[i] = new townsperson(tType,tName,tGender,tPoints,tZone,tHasQuest);
                    break;
                default:

                    break;


            }

        }
        int countP = 0, countM = 0, countT = 0;
        for ( int i = 0; i < quantity; i ++) {
            //System.out.print(array[i].toString());
            if(array[i].getType().equals("Player")) {
                if(countP == 0) {
                    System.out.print("Player Characters");
                    System.out.format("\n%15s%15s%15s%15s%25s\n", "Name", "Gender", "Hit Points", "Class", "Equipable Gear");
                    countP = 1;
                }
                System.out.print(array[i].toString());
            }
            else if (array[i].getType().equals("Mob")) {
                if (countM == 0) {
                    System.out.print("\n\nNPC's - Mobs");
                    System.out.format("\n%15s%15s%15s%25s%15s%15s\n", "Name", "Gender", "Hit Points", "Zone", "Class", "Quest Mob:");
                    countM = 1;
                }
                System.out.print(array[i].toString());
            }
            else if (array[i].getType().equals("Townsperson")) {
                if (countT == 0) {
                    System.out.print("\n\nNPC's- Towns People");
                    System.out.format("\n%15s%15s%15s%25s%15s\n", "Name", "Gender", "Hit Points", "Zone", "Has Quest?");
                    countT = 1;
                }
                System.out.print(array[i].toString());
            }
        }

    }
}
