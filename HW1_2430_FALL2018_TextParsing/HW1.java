import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class HW1 {

    static String mostFrequent(String arr[], int size)
    {

        String temp;
        //SORT THE ARRAY IN ALPHABETICAL ORDER
        for (int i = 0; i < size; i ++)
        {
            for (int j = i + 1; j < size; j++)
            {
                if (arr[i].compareTo(arr[j]) > 0)
                {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        // COMPARING FOR MOST FREQUENT STRING
        int maxCount = 1; //current max qty of word
        String currentWord = arr[0]; // starts with first word in array
        int currCount = 1;

        for (int i = 1; i < size; i ++)
        {
            if(arr[i].equals(arr[i - 1])) //if the current word matches the previous
            {
                currCount++; //increase the count (qty) of current word
            }
            else // Otherwise if words do not match anymore
            {
                if(currCount > maxCount) // if the currentMax is greater than the MaxCount
                {
                    maxCount = currCount; // change the max
                    currentWord = arr[i - 1]; // went to the next word (i increased), so change current max word to previous!
                }
                currCount = 1;
            }
        }

        //LAST ELEMENT BEING MOST FREQUENT
        if (currCount > maxCount)
        {
            maxCount = currCount;
            currentWord = arr[size - 1];
        }

        return (currentWord + ":" + maxCount);

    }

    static String thirdMostFrequent(String arr[], int size)
    {
        String temp;
        //SORT THE ARRAY IN ALPHABETICAL ORDER
        for (int i = 0; i < size; i ++)
        {
            for (int j = i + 1; j < size; j++)
            {
                if (arr[i].compareTo(arr[j]) > 0)
                {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        // COMPARING FOR MOST FREQUENT STRING
        int maxCount = 1;
        String currentWord = arr[0];
        int currCount = 1;

        String[] maxWordsSorted = new String[0];
        int[] countsSorted = new int[0];

        for (int i = 1; i < size; i ++)
        {
            if(arr[i].equals(arr[i - 1]))
            {
                currCount++;
            }
            else
            {
                if(currCount > maxCount)
                {
                    maxCount = currCount;
                    currentWord = arr[i - 1];

                    String[] tempArray1 = maxWordsSorted;
                    int[] tempCounts1 = countsSorted;
                    int newSize = maxWordsSorted.length+1;

                    String[] tempArray2 = new String[newSize];
                    int[] tempCounts2 = new int[newSize];

                    for (int j = newSize-1; j > 0 ; j--)
                    {
                        tempArray2[j] = tempArray1[j-1];
                        tempCounts2[j] = tempCounts1[j-1];
                    }

                    tempArray2[0] = currentWord;
                    tempCounts2[0] = maxCount;

                    countsSorted = tempCounts2;
                    maxWordsSorted = tempArray2;

                }
                currCount = 1;
            }
        }

        //LAST ELEMENT BEING MOST FREQUENT
        if (currCount > maxCount)
        {
            maxCount = currCount;
            currentWord = arr[size - 1];
        }

        return (maxWordsSorted[2]+ ":" + countsSorted[2]);

    }

    static String thirdQuestion(String arr[])
    {
        String [] words = null;
        String[] maxWordsSorted = new String[0];
        int[] countsSorted = new int[0];
        int[] sentencesNumsStored = null;

        for(int i = 0; i < arr.length; i++)
        {

            words = arr[i].trim().split("\\s+");
            String temp;
            //SORT THE ARRAY IN ALPHABETICAL ORDER
            for (int k = 0; k < words.length; k ++)
            {
                for (int l = k + 1; l < words.length; l++)
                {
                    if (words[k].compareTo(words[l]) > 0)
                    {
                        temp = words[k];
                        words[k] = words[l];
                        words[l] = temp;
                    }
                }
            }

            int maxCount = 1;
            String currentWord = words[0];
            int currentCount = 1;

            //Sorted by alphabetical order
            for(int j = 1 ; j < words.length; j++)
            {
                //System.out.println(words[j]);
                if (words[j].equals(words[j-1]))
                {
                    currentCount++;
                }
                else
                {
                    if(currentCount > maxCount)
                    {
                        maxCount = currentCount;
                        currentWord = words[j-1];

                        String[] tempArray1 = maxWordsSorted;
                        int[] tempCounts1 = countsSorted;
                        int[] tempSentNums1 = sentencesNumsStored;
                        int newSize = maxWordsSorted.length+1;

                        String[] tempArray2 = new String[newSize];
                        int[] tempCounts2 = new int[newSize];
                        int[] tempSentNums2 = new int[newSize];

                        for(int k = newSize - 1; k > 0 ; k-- )
                        {
                            tempArray2[k] = tempArray1[k-1];
                            tempCounts2[k] = tempCounts1[k-1];
                            tempSentNums2[k] = tempSentNums1[k-1];
                        }

                        tempArray2[0] = currentWord;
                        tempCounts2[0] = maxCount;
                        tempSentNums2[0] = i;

                        countsSorted = tempCounts2;
                        maxWordsSorted = tempArray2;
                        sentencesNumsStored = tempSentNums2;

                    }

                    else if(currentCount == maxCount &&( currentCount !=1) && (maxCount != 1))
                    {
                        //String otherWord = currentWord;
                        currentWord = words[j-1];
                        String[] tempArray1 = maxWordsSorted;
                        int[] tempCounts1 = countsSorted;
                        int[] tempSentNums1 = sentencesNumsStored;
                        int newSize = maxWordsSorted.length+1;

                        String[] tempArray2 = new String[newSize];
                        int[] tempCounts2 = new int[newSize];
                        int[] tempSentNums2 = new int[newSize];

                        for(int k = newSize - 1; k > 0 ; k-- )
                        {
                            tempArray2[k] = tempArray1[k-1];
                            tempCounts2[k] = tempCounts1[k-1];
                            tempSentNums2[k] = tempSentNums1[k-1];
                        }

                        tempArray2[0] = currentWord;
                        tempCounts2[0] = maxCount;
                        tempSentNums2[0] = i;

                        countsSorted = tempCounts2;
                        maxWordsSorted = tempArray2;
                        sentencesNumsStored = tempSentNums2;

                    }
                    currentCount = 1;
                }
            }
            //each sentence is sorted here
        }

        //SORT ARRAY IN DECREASING ORDER TO SHOW HIGHEST OCCURING WORDS
        int temp;
        String tempWord;
        int tempSentNum;

        for(int i= 0 ; i < countsSorted.length; i++)
        {
            for(int j = i + 1 ; j < countsSorted.length; j++)
            {
                if (countsSorted[i] < countsSorted[j])
                {
                    temp = countsSorted[i];
                    tempWord = maxWordsSorted[i];
                    tempSentNum = sentencesNumsStored[i];

                    countsSorted[i] = countsSorted[j];
                    maxWordsSorted[i] = maxWordsSorted[j];
                    sentencesNumsStored[i] = sentencesNumsStored[j];

                    countsSorted[j] = temp;
                    maxWordsSorted[j] = tempWord;
                    sentencesNumsStored[j] = tempSentNum;

                }
            }

        }

        int size = 0;
        int maxNumber = countsSorted[0];
        for(int i= 0 ; i < countsSorted.length; i++)
        {
            if(countsSorted[i] == maxNumber)
            {
                size++;
            }

        }
        String[] finalMaxWord = new String [size];
        String text = null;
        for (int i = 0; i < size; i ++)
        {
            if ( i ==0) {
                finalMaxWord[i] = (maxWordsSorted[i] + ":" + countsSorted[i] + ":" + arr[sentencesNumsStored[i]] + "\r\n");
                text = finalMaxWord[i];
            }
            else if ( i >0) {
                finalMaxWord[i] = (maxWordsSorted[i] + ":" + countsSorted[i] + ":" + arr[sentencesNumsStored[i]] + "\r\n");
                text += finalMaxWord[i];
            }

        }


        return text;
    }

    static String fourthQuestion(String arr[]) {
        String [] words = null;
        int [] sentenceNumbers = new int [0];
        int [] sentenceCounts = new int [0];

        for(int i = 0; i < arr.length; i++)
        {

            String findstr = " the ";
            int count = 0;
            int lastIndex = 0;

            while(lastIndex != -1)
            {
                lastIndex = arr[i].indexOf(findstr ,lastIndex);

                if(lastIndex != -1)
                {
                    count++;
                    lastIndex += findstr.length();
                }
            }
            if ((lastIndex == -1)) {
                int[] tempCounts1 = sentenceCounts;
                int[] tempSentNums1 = sentenceNumbers;

                int[] tempCounts2 = new int[sentenceCounts.length + 1];
                int[] tempSentNums2 = new int[sentenceNumbers.length + 1];

                for (int k = sentenceCounts.length - 1; k > 0; k--) {
                    tempCounts2[k] = tempCounts1[k - 1];
                    tempSentNums2[k] = tempSentNums1[k - 1];
                }

                tempCounts2[0] = count;
                tempSentNums2[0] = i;

                sentenceCounts = tempCounts2;
                sentenceNumbers = tempSentNums2;
            }
        }

        int temp;
        int tempSentNum;

        for(int i= 0 ; i < sentenceCounts.length; i++)
        {
            for(int j = i + 1 ; j < sentenceCounts.length; j++)
            {
                if (sentenceCounts[i] < sentenceCounts[j])
                {
                    temp = sentenceCounts[i];
                    tempSentNum = sentenceNumbers[i];

                    sentenceCounts[i] = sentenceCounts[j];
                    sentenceNumbers[i] = sentenceNumbers[j];

                    sentenceCounts[j] = temp;
                    sentenceNumbers[j] = tempSentNum;

                }
            }

        }

        int size = 0;
        int maxNumber = sentenceCounts[0];
        for(int i= 0 ; i < sentenceCounts.length; i++)
        {
            if(sentenceCounts[i] == maxNumber)
            {
                size++;
            }
        }

        String[] finalFourthQuestion = new String[size];
        String text = null;

        for (int i = 0; i < size; i ++)
        {
            if (i == 0)
            {
                finalFourthQuestion[i] = ("the:" + sentenceCounts[i] + ":" + arr[sentenceNumbers[i]] + "\r\n");
                text = finalFourthQuestion[i];
            }
            else if (i > 0)
            {
                finalFourthQuestion[i] = ("the:" + sentenceCounts[i] + ":" + arr[sentenceNumbers[i]] + "\r\n");
                text += finalFourthQuestion[i];
            }
        }

        return text;

    }

    static String fifthQuestion(String arr[]) {
        String[] words = null;
        int[] sentenceNumbers = new int[0];
        int[] sentenceCounts = new int[0];

        for (int i = 0; i < arr.length; i++) {

            String findstr = " of ";
            int count = 0;
            int lastIndex = 0;

            while (lastIndex != -1) {
                lastIndex = arr[i].indexOf(findstr, lastIndex);

                if (lastIndex != -1) {
                    count++;
                    lastIndex += findstr.length();
                }
            }
            if ((lastIndex == -1)) {
                int[] tempCounts1 = sentenceCounts;
                int[] tempSentNums1 = sentenceNumbers;

                int[] tempCounts2 = new int[sentenceCounts.length + 1];
                int[] tempSentNums2 = new int[sentenceNumbers.length + 1];

                for (int k = sentenceCounts.length - 1; k > 0; k--) {
                    tempCounts2[k] = tempCounts1[k - 1];
                    tempSentNums2[k] = tempSentNums1[k - 1];
                }

                tempCounts2[0] = count;
                tempSentNums2[0] = i;

                sentenceCounts = tempCounts2;
                sentenceNumbers = tempSentNums2;
            }
        }

        int temp;
        int tempSentNum;

        for (int i = 0; i < sentenceCounts.length; i++) {
            for (int j = i + 1; j < sentenceCounts.length; j++) {
                if (sentenceCounts[i] < sentenceCounts[j]) {
                    temp = sentenceCounts[i];
                    tempSentNum = sentenceNumbers[i];

                    sentenceCounts[i] = sentenceCounts[j];
                    sentenceNumbers[i] = sentenceNumbers[j];

                    sentenceCounts[j] = temp;
                    sentenceNumbers[j] = tempSentNum;

                }
            }

        }

        int size = 0;
        int maxNumber = sentenceCounts[0];
        for (int i = 0; i < sentenceCounts.length; i++) {
            if (sentenceCounts[i] == maxNumber) {
                size++;
            }
        }

        String[] finalString = new String[size];
        String text = null;

        for (int i = 0; i < size; i++) {
            if (i == 0) {
                finalString[i] = ("of:" + sentenceCounts[i] + ":" + arr[sentenceNumbers[i]] + "\r\n");
                text = finalString[i];
            } else if (i > 0) {
                finalString[i] = ("of:" + sentenceCounts[i] + ":" + arr[sentenceNumbers[i]] + "\r\n");
                text += finalString[i];
            }
        }

        return text;
    }

    static String sixthQuestion(String arr[]) {
        String[] words = null;
        int[] sentenceNumbers = new int[0];
        int[] sentenceCounts = new int[0];

        for (int i = 0; i < arr.length; i++) {

            String findstr = " was ";
            int count = 0;
            int lastIndex = 0;

            while (lastIndex != -1) {
                lastIndex = arr[i].indexOf(findstr, lastIndex);

                if (lastIndex != -1) {
                    count++;
                    lastIndex += findstr.length();
                }
            }
            if ((lastIndex == -1)) {
                int[] tempCounts1 = sentenceCounts;
                int[] tempSentNums1 = sentenceNumbers;

                int[] tempCounts2 = new int[sentenceCounts.length + 1];
                int[] tempSentNums2 = new int[sentenceNumbers.length + 1];

                for (int k = sentenceCounts.length - 1; k > 0; k--) {
                    tempCounts2[k] = tempCounts1[k - 1];
                    tempSentNums2[k] = tempSentNums1[k - 1];
                }

                tempCounts2[0] = count;
                tempSentNums2[0] = i;

                sentenceCounts = tempCounts2;
                sentenceNumbers = tempSentNums2;
            }
        }

        int temp;
        int tempSentNum;

        for (int i = 0; i < sentenceCounts.length; i++) {
            for (int j = i + 1; j < sentenceCounts.length; j++) {
                if (sentenceCounts[i] < sentenceCounts[j]) {
                    temp = sentenceCounts[i];
                    tempSentNum = sentenceNumbers[i];

                    sentenceCounts[i] = sentenceCounts[j];
                    sentenceNumbers[i] = sentenceNumbers[j];

                    sentenceCounts[j] = temp;
                    sentenceNumbers[j] = tempSentNum;

                }
            }

        }

        int size = 0;
        int maxNumber = sentenceCounts[0];
        for (int i = 0; i < sentenceCounts.length; i++) {
            if (sentenceCounts[i] == maxNumber) {
                size++;
            }
        }

        String[] finalString = new String[size];
        String text = null;

        for (int i = 0; i < size; i++) {
            if (i == 0) {
                finalString[i] = ("was:" + sentenceCounts[i] + ":" + arr[sentenceNumbers[i]] + "\r\n");
                text = finalString[i];
            } else if (i > 0) {
                finalString[i] = ("was:" + sentenceCounts[i] + ":" + arr[sentenceNumbers[i]] + "\r\n");
                text += finalString[i];
            }
        }

        return text;
    }

    static String seventhQuestion(String arr[]) {
        String[] words = null;
        int[] sentenceNumbers = new int[0];
        int[] sentenceCounts = new int[0];

        for (int i = 0; i < arr.length; i++) {

            String findstr = "but the";
            int count = 0;
            int lastIndex = 0;

            while (lastIndex != -1) {
                lastIndex = arr[i].indexOf(findstr, lastIndex);

                if (lastIndex != -1) {
                    count++;
                    lastIndex += findstr.length();
                }
            }
            if ((lastIndex == -1)) {
                int[] tempCounts1 = sentenceCounts;
                int[] tempSentNums1 = sentenceNumbers;

                int[] tempCounts2 = new int[sentenceCounts.length + 1];
                int[] tempSentNums2 = new int[sentenceNumbers.length + 1];

                for (int k = sentenceCounts.length - 1; k > 0; k--) {
                    tempCounts2[k] = tempCounts1[k - 1];
                    tempSentNums2[k] = tempSentNums1[k - 1];
                }

                tempCounts2[0] = count;
                tempSentNums2[0] = i;

                sentenceCounts = tempCounts2;
                sentenceNumbers = tempSentNums2;
            }
        }

        int temp;
        int tempSentNum;

        for (int i = 0; i < sentenceCounts.length; i++) {
            for (int j = i + 1; j < sentenceCounts.length; j++) {
                if (sentenceCounts[i] < sentenceCounts[j]) {
                    temp = sentenceCounts[i];
                    tempSentNum = sentenceNumbers[i];

                    sentenceCounts[i] = sentenceCounts[j];
                    sentenceNumbers[i] = sentenceNumbers[j];

                    sentenceCounts[j] = temp;
                    sentenceNumbers[j] = tempSentNum;

                }
            }

        }

        int size = 0;
        int maxNumber = sentenceCounts[0];
        for (int i = 0; i < sentenceCounts.length; i++) {
            if (sentenceCounts[i] == maxNumber) {
                size++;
            }
        }

        String[] finalString = new String[size];
        String text = null;

        for (int i = 0; i < size; i++) {
            if (i == 0) {
                finalString[i] = ("but the:" + sentenceCounts[i] + ":" + arr[sentenceNumbers[i]] + "\r\n");
                text = finalString[i];
            } else if (i > 0) {
                finalString[i] = ("but the:" + sentenceCounts[i] + ":" + arr[sentenceNumbers[i]] + "\r\n");
                text += finalString[i];
            }
        }

        return text;
    }

    static String eigthQuestion(String arr[]) {
        String[] words = null;
        int[] sentenceNumbers = new int[0];
        int[] sentenceCounts = new int[0];

        for (int i = 0; i < arr.length; i++) {

            String findstr = "it was";
            int count = 0;
            int lastIndex = 0;

            while (lastIndex != -1) {
                lastIndex = arr[i].indexOf(findstr, lastIndex);

                if (lastIndex != -1) {
                    count++;
                    lastIndex += findstr.length();
                }
            }
            if ((lastIndex == -1)) {
                int[] tempCounts1 = sentenceCounts;
                int[] tempSentNums1 = sentenceNumbers;

                int[] tempCounts2 = new int[sentenceCounts.length + 1];
                int[] tempSentNums2 = new int[sentenceNumbers.length + 1];

                for (int k = sentenceCounts.length - 1; k > 0; k--) {
                    tempCounts2[k] = tempCounts1[k - 1];
                    tempSentNums2[k] = tempSentNums1[k - 1];
                }

                tempCounts2[0] = count;
                tempSentNums2[0] = i;

                sentenceCounts = tempCounts2;
                sentenceNumbers = tempSentNums2;
            }
        }

        int temp;
        int tempSentNum;

        for (int i = 0; i < sentenceCounts.length; i++) {
            for (int j = i + 1; j < sentenceCounts.length; j++) {
                if (sentenceCounts[i] < sentenceCounts[j]) {
                    temp = sentenceCounts[i];
                    tempSentNum = sentenceNumbers[i];

                    sentenceCounts[i] = sentenceCounts[j];
                    sentenceNumbers[i] = sentenceNumbers[j];

                    sentenceCounts[j] = temp;
                    sentenceNumbers[j] = tempSentNum;

                }
            }

        }

        int size = 0;
        int maxNumber = sentenceCounts[0];
        for (int i = 0; i < sentenceCounts.length; i++) {
            if (sentenceCounts[i] == maxNumber) {
                size++;
            }
        }

        String[] finalString = new String[size];
        String text = null;

        for (int i = 0; i < size; i++) {
            if (i == 0) {
                finalString[i] = ("it was:" + sentenceCounts[i] + ":" + arr[sentenceNumbers[i]] + "\r\n");
                text = finalString[i];
            } else if (i > 0) {
                finalString[i] = ("it was:" + sentenceCounts[i] + ":" + arr[sentenceNumbers[i]] + "\r\n");
                text += finalString[i];
            }
        }

        return text;
    }

    static String ninthQuestion(String arr[]) {
        String[] words = null;
        int[] sentenceNumbers = new int[0];
        int[] sentenceCounts = new int[0];

        for (int i = 0; i < arr.length; i++) {

            // string to find
            String findstr = "in my";
            // counts the phrase frequency
            int count = 0;
            // keeps track of position
            int lastIndex = 0;

            while (lastIndex != -1) {
                //looks for phrase until lastIndex position
                lastIndex = arr[i].indexOf(findstr, lastIndex);

                if (lastIndex != -1) {
                    count++;
                    lastIndex += findstr.length();
                }
            }
            if ((lastIndex == -1)) {
                int[] tempCounts1 = sentenceCounts;
                int[] tempSentNums1 = sentenceNumbers;

                int[] tempCounts2 = new int[sentenceCounts.length + 1];
                int[] tempSentNums2 = new int[sentenceNumbers.length + 1];

                for (int k = sentenceCounts.length - 1; k > 0; k--) {
                    tempCounts2[k] = tempCounts1[k - 1];
                    tempSentNums2[k] = tempSentNums1[k - 1];
                }

                tempCounts2[0] = count;
                tempSentNums2[0] = i;

                sentenceCounts = tempCounts2;
                sentenceNumbers = tempSentNums2;
            }
        }

        int temp;
        int tempSentNum;

        for (int i = 0; i < sentenceCounts.length; i++) {
            for (int j = i + 1; j < sentenceCounts.length; j++) {
                if (sentenceCounts[i] < sentenceCounts[j]) {
                    temp = sentenceCounts[i];
                    tempSentNum = sentenceNumbers[i];

                    sentenceCounts[i] = sentenceCounts[j];
                    sentenceNumbers[i] = sentenceNumbers[j];

                    sentenceCounts[j] = temp;
                    sentenceNumbers[j] = tempSentNum;

                }
            }

        }

        int size = 0;
        int maxNumber = sentenceCounts[0];
        for (int i = 0; i < sentenceCounts.length; i++) {
            if (sentenceCounts[i] == maxNumber) {
                size++;
            }
        }

        String[] finalString = new String[size];
        String text = null;

        for (int i = 0; i < size; i++) {
            if (i == 0) {
                finalString[i] = ("in my:" + sentenceCounts[i] + ":" + arr[sentenceNumbers[i]] + "\r\n");
                text = finalString[i];
            } else if (i > 0) {
                finalString[i] = ("in my:" + sentenceCounts[i] + ":" + arr[sentenceNumbers[i]] + "\r\n");
                text += finalString[i];
            }
        }

        return text;
    }

        public static void main(String[] args ) {

        // main method begins here

            BufferedReader br = null;
            BufferedReader br2 = null;

            String FILENAME1 = args[1] +"1.txt";
            String FILENAME2 = args[1] +"2.txt";
            String FILENAME3 = args[1] +"3.txt";
            String FILENAME4 = args[1] +"4.txt";
            String FILENAME5 = args[1] +"5.txt";
            String FILENAME6 = args[1] +"6.txt";
            String FILENAME7 = args[1] +"7.txt";
            String FILENAME8 = args[1] +"8.txt";
            String FILENAME9 = args[1] +"9.txt";


            BufferedWriter bwQ1  = null;
            BufferedWriter bwQ2  = null;
            BufferedWriter bwQ3  = null;
            BufferedWriter bwQ4  = null;
            BufferedWriter bwQ5  = null;
            BufferedWriter bwQ6  = null;
            BufferedWriter bwQ7  = null;
            BufferedWriter bwQ8  = null;
            BufferedWriter bwQ9  = null;

            FileWriter fwQ1  = null;
            FileWriter fwQ2  = null;
            FileWriter fwQ3  = null;
            FileWriter fwQ4  = null;
            FileWriter fwQ5  = null;
            FileWriter fwQ6  = null;
            FileWriter fwQ7  = null;
            FileWriter fwQ8  = null;
            FileWriter fwQ9  = null;

        try {

            fwQ1 =  new FileWriter(FILENAME1);
            bwQ1 = new BufferedWriter(fwQ1);

            fwQ2 =  new FileWriter(FILENAME2);
            bwQ2 = new BufferedWriter(fwQ2);

            fwQ3 =  new FileWriter(FILENAME3);
            bwQ3 = new BufferedWriter(fwQ3);

            fwQ4 =  new FileWriter(FILENAME4);
            bwQ4 = new BufferedWriter(fwQ4);

            fwQ5 =  new FileWriter(FILENAME5);
            bwQ5 = new BufferedWriter(fwQ5);

            fwQ6 =  new FileWriter(FILENAME6);
            bwQ6 = new BufferedWriter(fwQ6);

            fwQ7 =  new FileWriter(FILENAME7);
            bwQ7 = new BufferedWriter(fwQ7);

            fwQ8 =  new FileWriter(FILENAME8);
            bwQ8 = new BufferedWriter(fwQ8);

            fwQ9 =  new FileWriter(FILENAME9);
            bwQ9 = new BufferedWriter(fwQ9);

            // Creating a Buffered Reader to read the file
            br = new BufferedReader(new FileReader(args[0]));
            String currentLine;
            String[] words =  null;
            String[] sentences = null;

            while ((currentLine = br.readLine())!= null) {
                //FIRST TIME IT LOOPS AND THERE IS NO WORDS STORED INSIDE ARRAY
                if (words == null)
                {
                    words = currentLine.toLowerCase().split("[ .,!]+");
                    sentences = currentLine.toLowerCase().split("[.\n/,!]+");

                }
                //WHEN THERE IS WORDS STORED AND NO LONGER EMPTY
                else if (words != null)
                {
                    int currentSize = words.length;
                    int sentenceCurrentSize = sentences.length;

                    String[] tempArray = words;
                    String[] tempSentenceArray = sentences;

                    // Splitting the line into words separated by space, commas, periods, etc.
                    words = currentLine.toLowerCase().split("[ .,!]+");
                    sentences = currentLine.toLowerCase().split("[.\n/,!]+");

                    int lineLength = words.length;
                    int sentenceLength = sentences.length;

                    int newSize = lineLength + currentSize;
                    int newSentArrLength = sentenceLength + sentenceCurrentSize;

                    String[] tempArray2 = new String[newSize];
                    String[] sentenceTempArray2 = new String[newSentArrLength];

                    for (int i = 0; i < currentSize; i++)
                    {
                        tempArray2[i] = tempArray[i];
                    }

                    int j = 0;
                    for (int i = currentSize; i < newSize; i++)
                    {
                        tempArray2[i] = words[j];
                        j++;
                    }
                    words = tempArray2;

                    for (int i = 0; i < sentenceCurrentSize; i++)
                    {
                        sentenceTempArray2[i] = tempSentenceArray[i];
                    }

                    int l = 0;
                    for (int i = sentenceCurrentSize; i < newSentArrLength; i++)
                    {
                        sentenceTempArray2[i] = sentences[l];
                        l++;
                    }
                    sentences = sentenceTempArray2;

                }
            }

            String mostFrequentword= null;
            mostFrequentword = mostFrequent(words, words.length);
            bwQ1.write(mostFrequentword);
            bwQ1.flush();
            bwQ1.close();

            String thirdMostFrequentWord = null;
            thirdMostFrequentWord = thirdMostFrequent(words, words.length);
            bwQ2.write(thirdMostFrequentWord);
            bwQ2.flush();
            bwQ2.close();

            String thirdQuestionAnswer = null;
            thirdQuestionAnswer = thirdQuestion(sentences);
            bwQ3.write(thirdQuestionAnswer);
            bwQ3.flush();
            bwQ3.close();

            String fourthQuestionAnswer = null;
            fourthQuestionAnswer = fourthQuestion(sentences);
            bwQ4.write(fourthQuestionAnswer);
            bwQ4.flush();
            bwQ4.close();

            String fifthQuestionAnswer = null;
            fifthQuestionAnswer = fifthQuestion(sentences);
            bwQ5.write(fifthQuestionAnswer);
            bwQ5.flush();
            bwQ5.close();

            String sixthQuestionAnswer = null;
            sixthQuestionAnswer = sixthQuestion(sentences);
            bwQ6.write(sixthQuestionAnswer);
            bwQ6.flush();
            bwQ6.close();

            String seventhQuestionAnswer = null;
            seventhQuestionAnswer = seventhQuestion(sentences);
            bwQ7.write(seventhQuestionAnswer);
            bwQ7.flush();
            bwQ7.close();

            String eightQuestionAnswer = null;
            eightQuestionAnswer = eigthQuestion(sentences);
            bwQ8.write(eightQuestionAnswer);
            bwQ8.flush();
            bwQ8.close();

            String ninthQuestionAnswer = null;
            ninthQuestionAnswer = ninthQuestion(sentences);
            bwQ9.write(ninthQuestionAnswer);
            bwQ9.flush();
            bwQ9.close();

            /*
            System.out.println(mostFrequentword);
            System.out.println(thirdMostFrequentWord);
            System.out.println(thirdQuestionAnswer);
            System.out.println(fourthQuestionAnswer);
            System.out.println(fifthQuestionAnswer);
            System.out.println(sixthQuestionAnswer);
            System.out.println(seventhQuestionAnswer);
            System.out.println(eightQuestionAnswer);
            System.out.println(ninthQuestionAnswer);
            */
        }



        catch (IOException ioe){
            ioe.printStackTrace();
        }
        finally {
            try {
                if (br !=null)
                    br.close();
            }
            catch (IOException ioe)
            {
                System.out.println("Error in closing the BufferedReader");
            }

        }

    }
}