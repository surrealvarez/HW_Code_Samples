import java.io.*;
public class HW4 {
    static void moveThreePegs(int disks, String sourcePeg, String targetPeg, String sparePeg, PrintWriter out) {
        if (disks == 1) { out.println( disks + " " + sourcePeg + " " + targetPeg); } else {
            moveThreePegs(disks -1, sourcePeg, sparePeg, targetPeg, out);
            out.println(disks + " " + sourcePeg + " " + targetPeg);
            moveThreePegs(disks -1, sparePeg, targetPeg, sourcePeg, out);
        }
    }
    static void moveFourPegs(int disks, String sourcePeg, String targetPeg, String sparePeg1, String sparePeg2, PrintWriter out) {
        if (disks == 0) { return; }
        if (disks == 1) { out.println( disks + " " + sourcePeg + " " + targetPeg); } else {
            moveFourPegs( disks - 2, sourcePeg, sparePeg2,  sparePeg1, targetPeg, out);
            out.println( disks - 1 + " " + sourcePeg + " " + sparePeg1);
            out.println( disks + " " + sourcePeg + " " + targetPeg);
            out.println( disks -1 +  " " + sparePeg1 + " " + targetPeg);
            moveFourPegs(disks -2 , sparePeg2, targetPeg, sourcePeg, sparePeg1, out);
        }
    }
    static int count = 0;
    static void moveFivePegs( int disks, String sourcePeg, String targetPeg, String sparePeg1, String sparePeg2, String sparePeg3, PrintWriter out) {
        count++;
        if ( disks == -1 || disks == 0) { return; }
        if (disks == 1) { out.println(disks + " " + sourcePeg + " " + targetPeg);
            return;
        }
        if ( disks == 2 & count == 1) {
            out.println(disks-1 + " " + sourcePeg + " " + sparePeg1);
            out.println(disks + " " + sourcePeg + " " + targetPeg);
            out.println(disks-1 + " " + sparePeg1 + " " + targetPeg);
            return;
        }
        if ( disks == 2) {
            out.println(disks-1 + " " + sourcePeg + " " + targetPeg);
            return;
        } else  {
            moveFivePegs( disks - 3, sourcePeg, sparePeg1, sparePeg2, sparePeg3, targetPeg, out);
            if (disks == 5) {
                out.println( disks - 3 + " " + sourcePeg + " " + targetPeg);
                out.println( disks - 2 + " " + sourcePeg + " " + sparePeg3);
                out.println( disks - 1 + " " + sourcePeg + " " + sparePeg2);
                out.println( disks - 3 + " " + targetPeg + " " + sparePeg3);
                out.println( disks + " " + sourcePeg + " " + targetPeg);
                out.println( disks - 3 + " " + sparePeg3 + " " + sourcePeg);
                out.println( disks - 1 + " " + sparePeg2 + " " + targetPeg);
                out.println( disks - 2 + " " + sparePeg3 + " " + targetPeg);
                out.println( disks - 3 + " " + sourcePeg + " " + targetPeg);
            } else {
            out.println( disks - 2 + " " + sourcePeg + " " + sparePeg3);
            out.println( disks - 1 + " " + sourcePeg + " " + sparePeg2);
            out.println( disks + " " + sourcePeg + " " + targetPeg);
            out.println( disks - 1 + " " + sparePeg2 + " " + targetPeg);
            out.println( disks - 2 + " " + sparePeg3 + " " + targetPeg);
            }
            moveFivePegs( disks - 3, sparePeg1, targetPeg, sourcePeg, sparePeg2, sparePeg3, out);
        }
    }
    public static void main(String args[]) {
        try {
            int disksAmount = Integer.parseInt(args[1]);
            PrintWriter out;
            String A = "A", B = "B", C = "C", D = "D", E = "E";
            switch (args[0]) {
                case "3":
                        out = new PrintWriter(args[2]);
                        moveThreePegs(disksAmount, A, C, B, out);
                        out.close();
                    break;
                case "4":
                        out = new PrintWriter(args[2]);
                        moveFourPegs(disksAmount, A, D, B, C, out);
                        out.close();
                    break;
                case "5":
                        out = new PrintWriter(args[2]);
                        moveFivePegs(disksAmount, A, E, B, C, D, out);
                        out.close();
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
