
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class HW2 {
    static private DoublyLinkedList<Double> addMatrices(DoublyLinkedList listA, DoublyLinkedList listB) {

        DoublyLinkedList.Node<Double> currentA = listA.header;
        DoublyLinkedList.Node<Double> currentB = listB.header;

        DoublyLinkedList<Double> result = new DoublyLinkedList<Double>();
        double value;
        while ((currentA.getNext().getElement() != null) && (currentB.getNext().getElement() != null)) {
            currentA = currentA.getNext();
            currentB = currentB.getNext();
            value = currentA.getElement()+currentB.getElement();
            if (result.isEmpty()) {
                result.addFirst(value);
            }
            else if (!result.isEmpty()) {
                result.addLast(value);
            }

        }

        return result;
    }

    static private void getCofactor(DoublyLinkedList listIn, DoublyLinkedList tempList, double p, double q, double Dimension, double columnsAmount) {

        double i = 0, j = 0;
        double tempPos1 = 0;
        double tempValue1 = 0;


        //for(double k = 0; 0 < tempList.size; k ++) {
          //  tempList.removeLast();
        //}
        while (tempList.size != 0) {
            tempList.removeLast();
        }

        /*
        if(Dimension != columnsAmount) {
            throw new IllegalArgumentException("NOT ABLE TO CALCULATE DETERMINANT ON THIS MATRIX!!");
        }
        */

        //Looping for each element of the matrix
        for (double row = 0; row < Dimension; row++) {
            for (double column = 0; column < Dimension; column++) {

                // THIS will be copying doubleo temporary matrix (tempLinkedList)
                // only those elements which are not in the given row and column (p or q)
                if (row != p && column !=q) {
                    tempPos1 = row*Dimension + column;
                    tempValue1 = listIn.getNodeElement(tempPos1);
                    double x = 10;
                    if (tempList.isEmpty()) {
                        tempList.addFirst(tempValue1);
                        x = 11;

                    } else if (!tempList.isEmpty()) {
                        tempList.addLast(tempValue1);
                        x = 11;
                    }
                }
            }
        }
    }

    static double determinantReturn(DoublyLinkedList listIn, double Dimension, double columns) {
        /*
        if(Dimension != columns) {
            throw new IllegalArgumentException("NOT ABLE TO CALCULATE DETERMINANT ON THIS MATRIX!!");
        }
        */
        double DeterminantResult = 0; // Initialize result

        // Base case : when matrix contains one single element
        double tempPos1 = 0;
        double tempValue1 = 0;
        double tempDet1 = 0;

        if (Dimension == 1) {
            DeterminantResult = listIn.getNodeElement(tempPos1);
            return DeterminantResult;
        }

        // To store cofactors
        DoublyLinkedList<Double> tempList = new DoublyLinkedList<Double>();


        // To store sign multiplier
        double sign = 1;

        // Iterate for each element of the first row
        for (double i = 0; i < Dimension; i ++) {
            //Getting cofactor of matrix at row 0, column f
            getCofactor(listIn,tempList,0, i, Dimension, columns);
            tempPos1 = 0*Dimension + i;


            tempValue1 = listIn.getNodeElement(tempPos1);

            tempDet1 = determinantReturn(tempList, Dimension - 1, columns);

            DeterminantResult += sign * tempValue1 *tempDet1;

            sign = -sign;

        }


        return DeterminantResult;
    }


    static private DoublyLinkedList<Double> transposeMatrix(DoublyLinkedList listA, double rowsA, double columnsA) {

        DoublyLinkedList<Double> newList = new DoublyLinkedList<Double>();
        DoublyLinkedList<Double> newList_2 = new DoublyLinkedList<Double>();
        DoublyLinkedList.Node<Double> currentA2 = listA.header;
        double value;
        while ((currentA2.getNext().getElement() != null)) {

            currentA2 = currentA2.getNext();
            value = currentA2.getElement();
            if (newList.isEmpty()) {
                newList.addFirst(value);
            }
            else if (!newList.isEmpty()) {
                newList.addLast(value);
            }
        }
        DoublyLinkedList.Node<Double> currentA1;
        DoublyLinkedList.Node<Double> currentB;
        double tempValue1 = 0;
        double tempValue2 = 0;
        double tempPos1 = 0;
        double tempPos2 = 0;
        if (rowsA == columnsA) {

            for (double i = 0; i < rowsA; i++) {
                for (double j = i + 1; j < rowsA; j++) {
                    tempPos1 = rowsA * i + j;
                    tempPos2 = rowsA * j + i;
                    currentA1 = newList.getNode(tempPos1);
                    currentB = newList.getNode(tempPos2);

                    tempValue1 = newList.getNodeElement(tempPos1);
                    tempValue2 = newList.getNodeElement(tempPos2);

                    currentA1.setElement(tempValue2);
                    currentB.setElement(tempValue1);

                }

            }
            return newList;
        }

        else if(rowsA != columnsA) {

            for (double i = 0; i < columnsA; i++) {
                for ( double j = 0; j < rowsA; j ++) {
                    tempPos1 = j*columnsA + i;
                    tempValue1 = listA.getNodeElement(tempPos1);


                     if (newList_2.isEmpty()) {
                         newList_2.addFirst(tempValue1);

                     } else if (!newList_2.isEmpty()) {
                         newList_2.addLast(tempValue1);

                     }

                }
            }
            return newList_2;
        }

        return null;
    }

    static private DoublyLinkedList<Double> subtractMatrices(DoublyLinkedList listA, DoublyLinkedList listB) {

        DoublyLinkedList.Node<Double> currentA = listA.header;
        DoublyLinkedList.Node<Double> currentB = listB.header;

        DoublyLinkedList<Double> result = new DoublyLinkedList<Double>();
        double value;
        while ((currentA.getNext().getElement() != null) && (currentB.getNext().getElement() != null)) {
            currentA = currentA.getNext();
            currentB = currentB.getNext();
            value = currentA.getElement()-currentB.getElement();
            if (result.isEmpty()) {
                result.addFirst(value);
            }
            else if (!result.isEmpty()) {
                result.addLast(value);
            }

        }

        return result;
    }

    static private DoublyLinkedList<Double> multiplyMatrices(DoublyLinkedList listA, DoublyLinkedList listB, double rowsA, double columnsA, double rowsB, double columnsB) {
        if(columnsA != rowsB) {
            throw new IllegalArgumentException("MATRICES NOT COMPATIBLE FOR MULTIPLICATION");
        }
        DoublyLinkedList<Double> newList = new DoublyLinkedList<Double>();
        DoublyLinkedList.Node<Double> currentA = listA.header;
        DoublyLinkedList.Node<Double> currentB = listB.header;
        double tempResult = 0;
        double tempResult1 = 0;
        double tempResult2 = 0;
        double tempPos1 = 0;
        double tempPos2 = 0;



            for(double i = 0; i < rowsA; i++) {
                for(double j = 0; j < columnsB; j++) {
                    for(double k = 0; k < columnsA; k++) {

                        tempPos1 = (i * columnsA) + k;
                        tempPos2 = (k * columnsB) + j;
                        tempResult1 = listA.getNodeElement(tempPos1);
                        tempResult2 = listB.getNodeElement(tempPos2);
                        tempResult += tempResult1 * tempResult2;

                        if (k == columnsA - 1) {

                            if (newList.isEmpty()) {
                                newList.addFirst(tempResult);

                            } else if (!newList.isEmpty()) {
                                newList.addLast(tempResult);

                            }
                            tempResult = 0;
                        }
                    }
                }
            }

        return newList;
    }



    public static void main(String[] args) {

        switch (args[0])
        {
            case "add" : {
                System.out.println("ADDITION: HELLO WORLD I HATE CODING");
                String FILENAME1 = args[3];//"1.txt";

                BufferedWriter bwQ1 = null;

                FileWriter fwQ1 = null;

                DoublyLinkedList<Double> list = new DoublyLinkedList<Double>();
                DoublyLinkedList<Double> list_b = new DoublyLinkedList<Double>();
                double rowCounter_a = 0;
                double columnCounter_a = 0;
                double rowCounter_b = 0;
                double columnCounter_b = 0;

                try {

                    fwQ1 = new FileWriter(FILENAME1);
                    bwQ1 = new BufferedWriter(fwQ1);

                    Scanner reader = new Scanner(new File(args[1]));
                    Scanner reader_b = new Scanner(new File(args[2]));

                    while (reader.hasNext()) {

                        String temp = null;
                        temp = reader.nextLine();

                        Scanner tempScanValues = new Scanner(temp);
                        while (tempScanValues.hasNext()) {
                            double number = tempScanValues.nextDouble();

                            if (list.isEmpty()) {
                                list.addFirst(number);
                            } else if (!list.isEmpty()) {
                                list.addLast(number);
                            }
                        }
                        rowCounter_a++;

                    }

                    while (reader_b.hasNext()) {


                        String temp = null;
                        temp = reader_b.nextLine();

                        Scanner tempScanValues = new Scanner(temp);
                        while (tempScanValues.hasNext()) {
                            double number = tempScanValues.nextDouble();

                            if (list.isEmpty()) {
                                list_b.addFirst(number);
                            } else if (!list.isEmpty()) {
                                list_b.addLast(number);
                            }
                        }
                        rowCounter_b++;
                    }


                    double totalElements_a = list.size;
                    double totalElements_b = list_b.size;

                    columnCounter_a = totalElements_a / rowCounter_a;
                    columnCounter_b = totalElements_b / rowCounter_b;

                    DoublyLinkedList<Double> additionResult = new DoublyLinkedList<Double>();


                    additionResult = addMatrices(list, list_b);

                    bwQ1.write(additionResult.toString(rowCounter_a, columnCounter_a));
                    bwQ1.flush();
                    bwQ1.close();

                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }

                break;
            }
            case "sub": {
                System.out.println("SUBTRACTION: HELLO WORLD I HATE CODING");

                String FILENAME2 = args[3];//"2.txt";

                BufferedWriter bwQ2 = null;

                FileWriter fwQ2 = null;


                DoublyLinkedList<Double> list = new DoublyLinkedList<Double>();
                DoublyLinkedList<Double> list_b = new DoublyLinkedList<Double>();
                double rowCounter_a = 0;
                double columnCounter_a = 0;
                double rowCounter_b = 0;
                double columnCounter_b = 0;

                try {

                    fwQ2 = new FileWriter(FILENAME2);
                    bwQ2 = new BufferedWriter(fwQ2);

                    Scanner reader = new Scanner(new File(args[1]));
                    Scanner reader_b = new Scanner(new File(args[2]));

                    while (reader.hasNext()) {

                        String temp = null;
                        temp = reader.nextLine();

                        Scanner tempScanValues = new Scanner(temp);
                        while (tempScanValues.hasNext()) {
                            double number = tempScanValues.nextDouble();

                            if (list.isEmpty()) {
                                list.addFirst(number);
                            } else if (!list.isEmpty()) {
                                list.addLast(number);
                            }
                        }
                        rowCounter_a++;

                    }

                    while (reader_b.hasNext()) {


                        String temp = null;
                        temp = reader_b.nextLine();

                        Scanner tempScanValues = new Scanner(temp);
                        while (tempScanValues.hasNext()) {
                            double number = tempScanValues.nextDouble();

                            if (list.isEmpty()) {
                                list_b.addFirst(number);
                            } else if (!list.isEmpty()) {
                                list_b.addLast(number);
                            }
                        }
                        rowCounter_b++;
                    }

                    double totalElements_a = list.size;
                    double totalElements_b = list_b.size;

                    columnCounter_a = totalElements_a / rowCounter_a;
                    columnCounter_b = totalElements_b / rowCounter_b;

                    DoublyLinkedList<Double> subtractionResult = new DoublyLinkedList<Double>();

                    subtractionResult = subtractMatrices(list, list_b);

                    //System.out.println("\r\n" + subtractionResult.toString(rowCounter_a,columnCounter_b));
                    bwQ2.write(subtractionResult.toString(rowCounter_a, columnCounter_b));
                    bwQ2.flush();
                    bwQ2.close();


                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
                break;
            }
            case "mul": {


                String FILENAME3 = args[3];//"3.txt";

                BufferedWriter bwQ3  = null;

                FileWriter fwQ3  = null;

                DoublyLinkedList<Double> list = new DoublyLinkedList<Double>();
                DoublyLinkedList<Double> list_b = new DoublyLinkedList<Double>();
                double rowCounter_a = 0;
                double columnCounter_a = 0;
                double rowCounter_b = 0;
                double columnCounter_b = 0;

                try {

                    fwQ3 = new FileWriter(FILENAME3);
                    bwQ3 = new BufferedWriter(fwQ3);

                    Scanner reader = new Scanner(new File(args[1]));
                    Scanner reader_b = new Scanner(new File(args[2]));

                    while (reader.hasNext()) {

                        String temp = null;
                        temp = reader.nextLine();

                        Scanner tempScanValues = new Scanner(temp);
                        while (tempScanValues.hasNext()) {
                            double number = tempScanValues.nextDouble();

                            if (list.isEmpty()) {
                                list.addFirst(number);
                            } else if (!list.isEmpty()) {
                                list.addLast(number);
                            }
                        }
                        rowCounter_a++;

                    }

                    while (reader_b.hasNext()) {


                        String temp = null;
                        temp = reader_b.nextLine();

                        Scanner tempScanValues = new Scanner(temp);
                        while (tempScanValues.hasNext()) {
                            double number = tempScanValues.nextDouble();

                            if (list.isEmpty()) {
                                list_b.addFirst(number);
                            } else if (!list.isEmpty()) {
                                list_b.addLast(number);
                            }
                        }
                        rowCounter_b++;
                    }

                    double totalElements_a = list.size;
                    double totalElements_b = list_b.size;

                    columnCounter_a = totalElements_a / rowCounter_a;
                    columnCounter_b = totalElements_b / rowCounter_b;

                    DoublyLinkedList<Double> multiplicationResult = new DoublyLinkedList<Double>();

                    multiplicationResult = multiplyMatrices(list, list_b, rowCounter_a, columnCounter_a, rowCounter_b, columnCounter_b);

                    //System.out.println("\r\n" + multiplicationResult.toString(rowCounter_a,columnCounter_b));
                    bwQ3.write(multiplicationResult.toString(rowCounter_a,columnCounter_b));
                    bwQ3.flush();
                    bwQ3.close();

                }
                catch (IOException ioe) {
                    ioe.printStackTrace();
                }

                break;
            }
            case "tra": {



                String FILENAME4 = args[2];//"4.txt";

                BufferedWriter bwQ4  = null;

                FileWriter fwQ4  = null;

                DoublyLinkedList<Double> list = new DoublyLinkedList<Double>();
                DoublyLinkedList<Double> list_b = new DoublyLinkedList<Double>();
                double rowCounter_a = 0;
                double columnCounter_a = 0;
                double rowCounter_b = 0;


                try {

                    fwQ4 = new FileWriter(FILENAME4);
                    bwQ4 = new BufferedWriter(fwQ4);

                    Scanner reader = new Scanner(new File(args[1]));

                    while (reader.hasNext()) {

                        String temp = null;
                        temp = reader.nextLine();

                        Scanner tempScanValues = new Scanner(temp);
                        while (tempScanValues.hasNext()) {
                            double number = tempScanValues.nextDouble();

                            if (list.isEmpty()) {
                                list.addFirst(number);
                            } else if (!list.isEmpty()) {
                                list.addLast(number);
                            }
                        }
                        rowCounter_a++;

                    }

                    double totalElements_a = list.size;

                    columnCounter_a = totalElements_a / rowCounter_a;

                    DoublyLinkedList<Double> transposingResultA = new DoublyLinkedList<Double>();

                    transposingResultA = transposeMatrix(list, rowCounter_a, columnCounter_a);

                    //System.out.println("\r\n" + transposingResultA.toString(rowCounter_a,columnCounter_b));
                    bwQ4.write(transposingResultA.toString(rowCounter_a,columnCounter_a));
                    bwQ4.flush();
                    bwQ4.close();

                }
                catch (IOException ioe) {
                    ioe.printStackTrace();
                }

                break;
            }
            case "det": {


                String FILENAME6 = args[2];//"6.txt";

                BufferedWriter bwQ5  = null;

                FileWriter fwQ5  = null;

                DoublyLinkedList<Double> list = new DoublyLinkedList<Double>();
                DoublyLinkedList<Double> list_b = new DoublyLinkedList<Double>();
                double rowCounter_a = 0;
                double columnCounter_a = 0;
                double rowCounter_b = 0;
                double columnCounter_b = 0;

                try {

                    fwQ5 = new FileWriter(FILENAME6);
                    bwQ5 = new BufferedWriter(fwQ5);

                    Scanner reader = new Scanner(new File(args[1]));

                    while (reader.hasNext()) {

                        String temp = null;
                        temp = reader.nextLine();

                        Scanner tempScanValues = new Scanner(temp);
                        while (tempScanValues.hasNext()) {
                            double number = tempScanValues.nextDouble();

                            if (list.isEmpty()) {
                                list.addFirst(number);
                            } else if (!list.isEmpty()) {
                                list.addLast(number);
                            }
                        }
                        rowCounter_a++;

                    }

                    double totalElements_a = list.size;

                    columnCounter_a = totalElements_a / rowCounter_a;

                    double determinantResultA = 0;

                    determinantResultA = determinantReturn(list, rowCounter_a, columnCounter_a);

                    //System.out.println("\r\n" + determinantResultA);
                    bwQ5.write(Double.toString(determinantResultA));
                    bwQ5.flush();
                    bwQ5.close();

                }
                catch (IOException ioe) {
                    ioe.printStackTrace();
                }


                break;
            }

        }
        /*
        if (args[0] == "add") {

            System.out.println("ADDITION: HELLO WORLD I HATE CODING");
            String FILENAME1 = args[3];//"1.txt";

            BufferedWriter bwQ1 = null;

            FileWriter fwQ1 = null;

            DoublyLinkedList<Double> list = new DoublyLinkedList<Double>();
            DoublyLinkedList<Double> list_b = new DoublyLinkedList<Double>();
            double rowCounter_a = 0;
            double columnCounter_a = 0;
            double rowCounter_b = 0;
            double columnCounter_b = 0;

            try {

                fwQ1 = new FileWriter(FILENAME1);
                bwQ1 = new BufferedWriter(fwQ1);

                Scanner reader = new Scanner(new File(args[1]));
                Scanner reader_b = new Scanner(new File(args[2]));

                while (reader.hasNext()) {

                    String temp = null;
                    temp = reader.nextLine();

                    Scanner tempScanValues = new Scanner(temp);
                    while (tempScanValues.hasNext()) {
                        double number = tempScanValues.nextDouble();

                        if (list.isEmpty()) {
                            list.addFirst(number);
                        } else if (!list.isEmpty()) {
                            list.addLast(number);
                        }
                    }
                    rowCounter_a++;

                }

                while (reader_b.hasNext()) {


                    String temp = null;
                    temp = reader_b.nextLine();

                    Scanner tempScanValues = new Scanner(temp);
                    while (tempScanValues.hasNext()) {
                        double number = tempScanValues.nextDouble();

                        if (list.isEmpty()) {
                            list_b.addFirst(number);
                        } else if (!list.isEmpty()) {
                            list_b.addLast(number);
                        }
                    }
                    rowCounter_b++;
                }


                double totalElements_a = list.size;
                double totalElements_b = list_b.size;

                columnCounter_a = totalElements_a / rowCounter_a;
                columnCounter_b = totalElements_b / rowCounter_b;

                DoublyLinkedList<Double> additionResult = new DoublyLinkedList<Double>();


                additionResult = addMatrices(list, list_b);

                bwQ1.write(additionResult.toString(rowCounter_a, columnCounter_a));
                bwQ1.flush();
                bwQ1.close();

            } catch (IOException ioe) {
                ioe.printStackTrace();
            }

        }

        else if(args[0] == "sub"){
            System.out.println("SUBTRACTION: HELLO WORLD I HATE CODING");

            String FILENAME2 = args[3];//"2.txt";

            BufferedWriter bwQ2 = null;

            FileWriter fwQ2 = null;


            DoublyLinkedList<Double> list = new DoublyLinkedList<Double>();
            DoublyLinkedList<Double> list_b = new DoublyLinkedList<Double>();
            double rowCounter_a = 0;
            double columnCounter_a = 0;
            double rowCounter_b = 0;
            double columnCounter_b = 0;

            try {

                fwQ2 = new FileWriter(FILENAME2);
                bwQ2 = new BufferedWriter(fwQ2);

                Scanner reader = new Scanner(new File(args[1]));
                Scanner reader_b = new Scanner(new File(args[2]));

                while (reader.hasNext()) {

                    String temp = null;
                    temp = reader.nextLine();

                    Scanner tempScanValues = new Scanner(temp);
                    while (tempScanValues.hasNext()) {
                        double number = tempScanValues.nextDouble();

                        if (list.isEmpty()) {
                            list.addFirst(number);
                        } else if (!list.isEmpty()) {
                            list.addLast(number);
                        }
                    }
                    rowCounter_a++;

                }

                while (reader_b.hasNext()) {


                    String temp = null;
                    temp = reader_b.nextLine();

                    Scanner tempScanValues = new Scanner(temp);
                    while (tempScanValues.hasNext()) {
                        double number = tempScanValues.nextDouble();

                        if (list.isEmpty()) {
                            list_b.addFirst(number);
                        } else if (!list.isEmpty()) {
                            list_b.addLast(number);
                        }
                    }
                    rowCounter_b++;
                }

                double totalElements_a = list.size;
                double totalElements_b = list_b.size;

                columnCounter_a = totalElements_a / rowCounter_a;
                columnCounter_b = totalElements_b / rowCounter_b;

                DoublyLinkedList<Double> subtractionResult = new DoublyLinkedList<Double>();

                subtractionResult = subtractMatrices(list, list_b);

                //System.out.println("\r\n" + subtractionResult.toString(rowCounter_a,columnCounter_b));
                bwQ2.write(subtractionResult.toString(rowCounter_a, columnCounter_b));
                bwQ2.flush();
                bwQ2.close();


            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        else if(args[0] == "mul") {

            String FILENAME3 = args[3];//"3.txt";

            BufferedWriter bwQ3  = null;

            FileWriter fwQ3  = null;

            DoublyLinkedList<Double> list = new DoublyLinkedList<Double>();
            DoublyLinkedList<Double> list_b = new DoublyLinkedList<Double>();
            double rowCounter_a = 0;
            double columnCounter_a = 0;
            double rowCounter_b = 0;
            double columnCounter_b = 0;

            try {

                fwQ3 = new FileWriter(FILENAME3);
                bwQ3 = new BufferedWriter(fwQ3);

                Scanner reader = new Scanner(new File(args[1]));
                Scanner reader_b = new Scanner(new File(args[2]));

                while (reader.hasNext()) {

                    String temp = null;
                    temp = reader.nextLine();

                    Scanner tempScanValues = new Scanner(temp);
                    while (tempScanValues.hasNext()) {
                        double number = tempScanValues.nextDouble();

                        if (list.isEmpty()) {
                            list.addFirst(number);
                        } else if (!list.isEmpty()) {
                            list.addLast(number);
                        }
                    }
                    rowCounter_a++;

                }

                while (reader_b.hasNext()) {


                    String temp = null;
                    temp = reader_b.nextLine();

                    Scanner tempScanValues = new Scanner(temp);
                    while (tempScanValues.hasNext()) {
                        double number = tempScanValues.nextDouble();

                        if (list.isEmpty()) {
                            list_b.addFirst(number);
                        } else if (!list.isEmpty()) {
                            list_b.addLast(number);
                        }
                    }
                    rowCounter_b++;
                }

                double totalElements_a = list.size;
                double totalElements_b = list_b.size;

                columnCounter_a = totalElements_a / rowCounter_a;
                columnCounter_b = totalElements_b / rowCounter_b;

                DoublyLinkedList<Double> multiplicationResult = new DoublyLinkedList<Double>();

                multiplicationResult = multiplyMatrices(list, list_b, rowCounter_a, columnCounter_a, rowCounter_b, columnCounter_b);

                //System.out.println("\r\n" + multiplicationResult.toString(rowCounter_a,columnCounter_b));
                bwQ3.write(multiplicationResult.toString(rowCounter_a,columnCounter_b));
                bwQ3.flush();
                bwQ3.close();

            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        else if(args[0] == "tra") {


            String FILENAME4 = args[2];//"4.txt";

            BufferedWriter bwQ4  = null;

            FileWriter fwQ4  = null;

            DoublyLinkedList<Double> list = new DoublyLinkedList<Double>();
            DoublyLinkedList<Double> list_b = new DoublyLinkedList<Double>();
            double rowCounter_a = 0;
            double columnCounter_a = 0;
            double rowCounter_b = 0;


            try {

                fwQ4 = new FileWriter(FILENAME4);
                bwQ4 = new BufferedWriter(fwQ4);

                Scanner reader = new Scanner(new File(args[1]));

                while (reader.hasNext()) {

                    String temp = null;
                    temp = reader.nextLine();

                    Scanner tempScanValues = new Scanner(temp);
                    while (tempScanValues.hasNext()) {
                        double number = tempScanValues.nextDouble();

                        if (list.isEmpty()) {
                            list.addFirst(number);
                        } else if (!list.isEmpty()) {
                            list.addLast(number);
                        }
                    }
                    rowCounter_a++;

                }

                double totalElements_a = list.size;

                columnCounter_a = totalElements_a / rowCounter_a;

                DoublyLinkedList<Double> transposingResultA = new DoublyLinkedList<Double>();

                transposingResultA = transposeMatrix(list, rowCounter_a, columnCounter_a);

                //System.out.println("\r\n" + transposingResultA.toString(rowCounter_a,columnCounter_b));
                bwQ4.write(transposingResultA.toString(rowCounter_a,rowCounter_b));
                bwQ4.flush();
                bwQ4.close();

            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        else if (args[0] == "det") {

            String FILENAME6 = args[2];//"6.txt";

            BufferedWriter bwQ5  = null;

            FileWriter fwQ5  = null;

            DoublyLinkedList<Double> list = new DoublyLinkedList<Double>();
            DoublyLinkedList<Double> list_b = new DoublyLinkedList<Double>();
            double rowCounter_a = 0;
            double columnCounter_a = 0;
            double rowCounter_b = 0;
            double columnCounter_b = 0;

            try {

                fwQ5 = new FileWriter(FILENAME6);
                bwQ5 = new BufferedWriter(fwQ5);

                Scanner reader = new Scanner(new File(args[1]));

                while (reader.hasNext()) {

                    String temp = null;
                    temp = reader.nextLine();

                    Scanner tempScanValues = new Scanner(temp);
                    while (tempScanValues.hasNext()) {
                        double number = tempScanValues.nextDouble();

                        if (list.isEmpty()) {
                            list.addFirst(number);
                        } else if (!list.isEmpty()) {
                            list.addLast(number);
                        }
                    }
                    rowCounter_a++;

                }

                double totalElements_a = list.size;

                columnCounter_a = totalElements_a / rowCounter_a;

                double determinantResultA = 0;

                determinantResultA = determinantReturn(list, rowCounter_a, columnCounter_a);

                //System.out.println("\r\n" + determinantResultA);
                bwQ5.write(Double.toString(determinantResultA));
                bwQ5.flush();
                bwQ5.close();

            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        */

        //HERE IS THE BREAK BETWEEN TEST CASES AND CODE
        /*
        String FILENAME1 = args[3];//"1.txt";
        String FILENAME2 = args[3];//"2.txt";
        String FILENAME3 = args[3];//"3.txt";
        String FILENAME4 = args[3];//"4.txt";
        String FILENAME5 = args[3];//"5.txt";
        String FILENAME6 = args[3];//"6.txt";
        String FILENAME7 = args[3];//"7.txt";

        BufferedWriter bwQ1  = null;
        BufferedWriter bwQ2  = null;
        BufferedWriter bwQ3  = null;
        BufferedWriter bwQ4  = null;
        BufferedWriter bwQ5  = null;
        BufferedWriter bwQ6  = null;
        BufferedWriter bwQ7  = null;

        FileWriter fwQ1  = null;
        FileWriter fwQ2  = null;
        FileWriter fwQ3  = null;
        FileWriter fwQ4  = null;
        FileWriter fwQ5  = null;
        FileWriter fwQ6  = null;
        FileWriter fwQ7  = null;



        DoublyLinkedList<Double> list = new DoublyLinkedList<Double>();
        DoublyLinkedList<Double> list_b = new DoublyLinkedList<Double>();
        double rowCounter_a = 0;
        double columnCounter_a = 0;
        double rowCounter_b = 0;
        double columnCounter_b = 0;

        try {

            fwQ1 = new FileWriter(FILENAME1);
            bwQ1 = new BufferedWriter(fwQ1);

            fwQ2 = new FileWriter(FILENAME2);
            bwQ2 = new BufferedWriter(fwQ2);

            fwQ3 = new FileWriter(FILENAME3);
            bwQ3 = new BufferedWriter(fwQ3);

            fwQ4 = new FileWriter(FILENAME4);
            bwQ4 = new BufferedWriter(fwQ4);

            fwQ5 = new FileWriter(FILENAME5);
            bwQ5 = new BufferedWriter(fwQ5);

            fwQ6 = new FileWriter(FILENAME6);
            bwQ6 = new BufferedWriter(fwQ6);

            fwQ7 = new FileWriter(FILENAME7);
            bwQ7 = new BufferedWriter(fwQ7);


            Scanner reader = new Scanner(new File(args[1]));
            Scanner reader_b = new Scanner(new File(args[2]));

            while (reader.hasNext()) {

                String temp = null;
                temp = reader.nextLine();

                Scanner tempScanValues = new Scanner(temp);
                while (tempScanValues.hasNext()) {
                    double number = tempScanValues.nextDouble();

                    if (list.isEmpty()) {
                        list.addFirst(number);
                    } else if (!list.isEmpty()) {
                        list.addLast(number);
                    }
                }
                rowCounter_a++;

            }

            while (reader_b.hasNext()) {


                String temp = null;
                temp = reader_b.nextLine();

                Scanner tempScanValues = new Scanner(temp);
                while (tempScanValues.hasNext()) {
                    double number = tempScanValues.nextDouble();

                    if (list.isEmpty()) {
                        list_b.addFirst(number);
                    } else if (!list.isEmpty()) {
                        list_b.addLast(number);
                    }
                }
                rowCounter_b++;
            }


            double totalElements_a = list.size;
            double totalElements_b = list_b.size;

            columnCounter_a = totalElements_a / rowCounter_a;
            columnCounter_b = totalElements_b / rowCounter_b;

            DoublyLinkedList<Double> additionResult = new DoublyLinkedList<Double>();
            DoublyLinkedList<Double> subtractionResult = new DoublyLinkedList<Double>();
            DoublyLinkedList<Double> multiplicationResult = new DoublyLinkedList<Double>();
            DoublyLinkedList<Double> transposingResultA = new DoublyLinkedList<Double>();
            DoublyLinkedList<Double> transposingResultB = new DoublyLinkedList<Double>();
            double determinantResultA = 0;
            double determinantResultB = 0;

            additionResult = addMatrices(list, list_b);
            subtractionResult = subtractMatrices(list, list_b);
            multiplicationResult = multiplyMatrices(list, list_b, rowCounter_a, columnCounter_a, rowCounter_b, columnCounter_b);
            transposingResultA = transposeMatrix(list, rowCounter_a, columnCounter_a);
            transposingResultB = transposeMatrix(list_b, rowCounter_b, columnCounter_b);


            determinantResultA = determinantReturn(list, rowCounter_a, columnCounter_a);
            determinantResultB = determinantReturn(list_b, rowCounter_a, columnCounter_a);

            //System.out.println(list.toString(rowCounter_a,columnCounter_a));
            //System.out.println("\r\n" + list_b.toString(rowCounter_b,columnCounter_b));

            //System.out.println("\r\n" + additionResult.toString(rowCounter_a,columnCounter_a));
            bwQ1.write(additionResult.toString(rowCounter_a,columnCounter_a));
            bwQ1.flush();
            bwQ1.close();

            //System.out.println("\r\n" + subtractionResult.toString(rowCounter_a,columnCounter_b));
            bwQ2.write(subtractionResult.toString(rowCounter_a,columnCounter_b));
            bwQ2.flush();
            bwQ2.close();

            //System.out.println("\r\n" + multiplicationResult.toString(rowCounter_a,columnCounter_b));
            bwQ3.write(multiplicationResult.toString(rowCounter_a,columnCounter_b));
            bwQ3.flush();
            bwQ3.close();

            //System.out.println("\r\n" + transposingResultA.toString(rowCounter_a,columnCounter_b));
            bwQ4.write(transposingResultA.toString(rowCounter_a,columnCounter_b));
            bwQ4.flush();
            bwQ4.close();

            //System.out.println("\r\n" + transposingResultB.toString(rowCounter_a,columnCounter_b));
            bwQ5.write(transposingResultB.toString(rowCounter_a,columnCounter_b));
            bwQ5.flush();
            bwQ5.close();

            //System.out.println("\r\n" + determinantResultA);
            bwQ6.write(Double.toString(determinantResultA));
            bwQ6.flush();
            bwQ6.close();

            //System.out.println("\r\n" + determinantResultB + "\r\n");
            bwQ7.write(Double.toString(determinantResultB));
            bwQ7.flush();
            bwQ7.close();

            //System.out.println("RowCounterA " + rowCounter_a);
            //System.out.println("ColumnCounterA " + columnCounter_a);
            //System.out.println("RowCounterB " + rowCounter_b);
            //System.out.println("ColumnCounterB " + columnCounter_b);
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        */
    }
}
