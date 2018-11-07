// JOSE CARLOS ALVAREZ
// PEOPLESOFT: 1587271
// UNIVERSITY OF HOUSTON: COSC 24430 HW ASSIGNMENT 3

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HW3 {


    public static class timerClass {
        public long  startTimer; // initialize the startTimer

        private  timerClass () {
            newTimer(); // default constructor is called and newTimer is called
        }
        public static timerClass startTimer() {
            return new timerClass(); // since inner class cannot resolve a static context, we make a new timerClass
            // which then calls the default constructor
        }

        public timerClass newTimer () {
            startTimer = System.nanoTime(); //startTimer starts with nanoSeconds as units
            return  this;
        }
        public long elapsedTime() {
            long endTimer = System.nanoTime();
            return endTimer - startTimer; // calculate elapsed time
        }
    }
    // The following algorithm/code fragment, was taken from the textbook:
    public static double [] p1(double[] list) {

        int n = list.length;
        double[] a = new double[n];
        for (int j = 0; j < n; j++) {
            double total = 0;
            for(int i = 0; i <= j; i ++) {
                total += list[i];
            }
            a[j] = total / (j + 1);
        }
        return a;
    }

    // The following algorithm/code fragment, was taken from the textbook:
    public static double [] p2(double[] list) {
        int n = list.length;
        double[] a = new double[n];
        double total = 0;
        for (int j = 0; j < n ; j++) {
            total += list[j];
            a[j] = total / (j + 1) ;
        }
        return a;
    }
    // The following algorithm/code fragment, was taken from the textbook:
    // As stated in  the book "Returns the sum of the integers in given array".
    public static int e1(int[] arr) {
        int n = arr.length;
        int total = 0;
        for ( int j = 0; j < n ; j ++) {
            total +=arr[j];
        }
        return total;
    }
    // The following algorithm/code fragment, was taken from the textbook:
    // As stated in the book "Returns the sum of the integers with even index in given array".
    public static int e2(int[] arr) {
        int n = arr.length;
        int total = 0;
        for (int j = 0; j < n; j+= 2) {
            total += arr[j];
        }
        return total;
    }
    // The following algorithm/code fragment, was taken from the textbook:
    // As stated in the book "Returns the sum of the prefix sums of given array".
    public static int e3(int[] arr) {
        int n = arr.length;
        int total = 0;
        for (int j = 0; j < n; j ++) {
            for (int k = 0; k <= j; k++) {
                total += arr[j];
            }
        }
        return total;
    }
    // The following algorithm/code fragment, was taken from the textbook:
    // As stated in the book "Returns the sum of the prefix sums of given array".
    public static int e4(int[] arr) {
        int n = arr.length;
        int prefix = 0;
        int total = 0;
        for (int j = 0; j < n; j++) {
            prefix += arr[j];
            total += prefix;
        }
        return total;
    }
    // The following algorithm/code fragment, was taken from the textbook:
    // As stated in the book "Returns the number of times second array stores sum of prefix  sums from first"
    public  static int e5(int[] first, int [] second) {
        int n = first.length;
        int count = 0;
        for (int i = 0; i < n; i ++) {
            int total = 0;
            for (int j = 0; j < n; j ++) {
                for(int k = 0; k <= j; k++) {
                    total += first[k];
                }
            }
            if (second[i] == total) { count ++;}
        }
        return  count;
    }

    // MAIN STARTS HERE
    public static void main(String[] args) {

        switch (args[0]) {
            case "p1":
                //because the arguments from the command line are type string, convert to int type
                int sizePower = Integer.parseInt(args[2]);
                //EXCEPTION HANDLING FOR BUFFERED WRITER
                try(FileWriter fw = new FileWriter(args[1], false); // for p1.txt file

                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw)) {

                    int i = 0;
                    while (i < sizePower) // this while loop will run according the third input from command line
                    // and it will repeat accordingly to the input size of the array from 10^1 all the way to 10^(args[2])
                    {
                        double power = Math.pow(10, (i + 1));
                        double[] list = new double[(int) power];
                        //System.nanoTime is used due to higher precision
                        timerClass timer = timerClass.startTimer();
                        p1(list); // runs PrefixAverage1() algorithm
                        long timeElapsed1 = timer.elapsedTime();
                        double elapsed1 = timeElapsed1 ; //UNITS WILL BE NANOSECS AS TA INSTRUCTED
                        //the double is  used to meet the requirements for Math.log10(elapsed) double type
                        elapsed1 = Math.log10(elapsed1);

                        Double result = elapsed1;
                        if (result.isInfinite()) {
                            elapsed1 = 0;
                        }
                        //System.out.println("Time elapsed for p1 is: " + elapsed1);
                        out.println(elapsed1);
                        i++;

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "p2":
                //because the arguments from the command line are type string, convert to int type
                sizePower = Integer.parseInt(args[2]);
                //EXCEPTION HANDLING FOR BUFFERED WRITER
                try(FileWriter fw = new FileWriter(args[1], false);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw)) {
                    int i = 0;
                    while (i < sizePower) // this while loop will run according the third input from command line
                    // and it will repeat accordingly to the input size of the array from 10^1 all the way to 10^(args[2])
                    {
                        double power = Math.pow(10, (i + 1));
                        double[] list = new double[(int) power];
                        //System.nanoTime is used due to higher precision
                        timerClass timer = timerClass.startTimer();
                        p2(list); // runs PrefixAverage2() algorithm
                        long timeElapsed2 = timer.elapsedTime();
                        double elapsed2 = timeElapsed2 ; //UNITS WILL BE NANOSECS AS TA INSTRUCTED
                        //the double is  used to meet the requirements for Math.log10(elapsed) double type
                        elapsed2 = Math.log10(elapsed2);

                        Double result = elapsed2;
                        if (result.isInfinite()) {
                            elapsed2 = 0;
                        }
                       // System.out.println("Time elapsed for p2 is: " + elapsed2);
                        out.println(elapsed2);
                        i++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
            case "e1":
                sizePower = Integer.parseInt(args[2]);
                //EXCEPTION HANDLING FOR BUFFERED WRITER
                try(FileWriter fw = new FileWriter(args[1], false);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw)) {
                    int i = 0;
                    while (i < sizePower) // this while loop will run according the third input from command line
                    // and it will repeat accordingly to the input size of the array from 10^1 all the way to 10^(args[2])
                    {
                        double power = Math.pow(10, (i + 1));
                        int[] list = new int[(int) power];
                        timerClass timer = timerClass.startTimer();
                        e1(list); // runs example1() algorithm

                        long timeElapsed3 = timer.elapsedTime();
                        double elapsed3 = timeElapsed3 ; //UNITS WILL BE NANOSECS AS TA INSTRUCTED
                        //the double is  used to meet the requirements for Math.log10(elapsed) double type
                        elapsed3 = Math.log10(elapsed3);

                        Double result = elapsed3;
                        if (result.isInfinite()) {
                            elapsed3 = 0;
                        }
                        //System.out.println("Time elapsed for e1 is: " + elapsed3);
                        out.println(elapsed3);
                        i++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "e2":
                sizePower = Integer.parseInt(args[2]);
                //EXCEPTION HANDLING FOR BUFFERED WRITER
                try(FileWriter fw = new FileWriter(args[1], false);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw)) {
                    int i = 0;
                    while (i < sizePower) // this while loop will run according the third input from command line
                    // and it will repeat accordingly to the input size of the array from 10^1 all the way to 10^(args[2])
                    {
                        double power = Math.pow(10, (i + 1));
                        int[] list = new int[(int) power];
                        timerClass timer = timerClass.startTimer();
                        e2(list); // runs example2() algorithm
                        long timeElapsed4 = timer.elapsedTime();
                        double elapsed4 = timeElapsed4 ; //UNITS WILL BE NANOSECS AS TA INSTRUCTED
                        //the double is  used to meet the requirements for Math.log10(elapsed) double type
                        elapsed4 = Math.log10(elapsed4);

                        Double result = elapsed4;
                        if (result.isInfinite()) {
                            elapsed4 = 0;
                        }
                       // System.out.println("Time elapsed for e2 is: " + elapsed4);
                        out.println(elapsed4);
                        i++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "e3":
                sizePower = Integer.parseInt(args[2]);
                //EXCEPTION HANDLING FOR BUFFERED WRITER
                try(FileWriter fw = new FileWriter(args[1], false);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw)) {
                    int i = 0;
                    while (i < sizePower) // this while loop will run according the third input from command line
                    // and it will repeat accordingly to the input size of the array from 10^1 all the way to 10^(args[2])
                    {
                        double power = Math.pow(10, (i + 1));
                        int[] list = new int[(int) power];
                        timerClass timer = timerClass.startTimer();
                        e3(list); // runs example3() algorithm
                        long timeElapsed5 = timer.elapsedTime();
                        double elapsed5 = timeElapsed5; //UNITS WILL BE NANOSECS AS TA INSTRUCTED
                        //the double is  used to meet the requirements for Math.log10(elapsed) double type
                        elapsed5 = Math.log10(elapsed5);

                        Double result = elapsed5;
                        if (result.isInfinite()) {
                            elapsed5 = 0;
                        }
                       // System.out.println("Time elapsed for e3 is: " + elapsed5);
                        out.println(elapsed5);
                        i++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "e4":
                sizePower = Integer.parseInt(args[2]);
                //EXCEPTION HANDLING FOR BUFFERED WRITER
                try(FileWriter fw = new FileWriter(args[1], false);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw)) {
                    int i = 0;
                    while (i < sizePower) // this while loop will run according the third input from command line
                    // and it will repeat accordingly to the input size of the array from 10^1 all the way to 10^(args[2])
                    {
                        double power = Math.pow(10, (i + 1));
                        int[] list = new int[(int) power];
                        timerClass timer = timerClass.startTimer();
                        e4(list); // runs example4() algorithm
                        long timeElapsed6 = timer.elapsedTime();
                        double elapsed6 = timeElapsed6 ; //UNITS WILL BE NANOSECS AS TA INSTRUCTED
                        //the double is  used to meet the requirements for Math.log10(elapsed) double type
                        elapsed6 = Math.log10(elapsed6);

                        Double result = elapsed6;
                        if (result.isInfinite()) {
                            elapsed6 = 0;
                        }
                       //System.out.println("Time elapsed for e4 is: " + elapsed6);
                        out.println(elapsed6);
                        i++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "e5":
                sizePower = Integer.parseInt(args[2]);
                //EXCEPTION HANDLING FOR BUFFERED WRITER
                try(FileWriter fw = new FileWriter(args[1], false);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw)) {
                    int i = 0;
                    while (i < sizePower) // this while loop will run according the third input from command line
                    // and it will repeat accordingly to the input size of the array from 10^1 all the way to 10^(args[2])
                    {
                        double power = Math.pow(10, (i + 1));
                        int[] list1 = new int[(int) power];
                        int[] list2 = new int[(int) power];
                        timerClass timer = timerClass.startTimer();
                        e5(list1, list2); // runs example5() algorithm
                        long timeElapsed7 = timer.elapsedTime();
                        double elapsed7 = timeElapsed7 ; //UNITS WILL BE NANOSECS AS TA INSTRUCTED
                        //the double is  used to meet the requirements for Math.log10(elapsed) double type
                        elapsed7 = Math.log10(elapsed7);

                        Double result = elapsed7;
                        if (result.isInfinite()) {
                            elapsed7 = 0;
                        }
                        //System.out.println("Time elapsed for e4 is: " + elapsed7);
                        out.println(elapsed7);
                        i++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
                // done
        }
    }
}
