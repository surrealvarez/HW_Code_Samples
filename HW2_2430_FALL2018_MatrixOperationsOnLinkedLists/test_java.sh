#Compile the code
# if the file HW2 exits then remove it
if [ -f HW2 ]; then
    rm HW2
fi
javac HW2.java
# if the file HW2 does not exit then exit the test
if [ ! -f HW2.class ]; then
    echo   "\033[1;91mCompile FAILED.\033[0m"
    exit
fi
# clean
rm -f *.output *.stdcout *.stderr 

java HW2 add "1_a.txt" "1_b.txt" "1_add.output" 1>1_add.stdcout 2>1_add.stderr
bash -c 'diff -iEBwu 1_add.output 1_add.txt >1_add.diff'
if [ $? -ne 0 ]; then
    # display "test case 1 FAILED" to the screen. The word "FAILED" is highlighted in Red color
    echo -e "Test case 1_add    \033[1;91mFAILED.\033[0m"
else
    # display "test case 1 PASSED" to the screen. The word "PASSED" is highlighted in Green color
    echo -e  "Test case 1_add    \033[1;92mPASSED.\033[0m"
    # remove the file 1.diff
    rm -f 1_add.diff
fi

java HW2 sub "1_a.txt" "1_b.txt" "1_sub.output" 1>1_sub.stdcout 2>1_sub.stderr
bash -c 'diff -iEBwu 1_sub.output 1_sub.txt >1_sub.diff'
if [ $? -ne 0 ]; then
    # display "test case 1 FAILED" to the screen. The word "FAILED" is highlighted in Red color
    echo -e "Test case 1_sub    \033[1;91mFAILED.\033[0m"
else
    # display "test case 1 PASSED" to the screen. The word "PASSED" is highlighted in Green color
    echo -e  "Test case 1_sub    \033[1;92mPASSED.\033[0m"
    # remove the file 1.diff
    rm -f 1_sub.diff
fi

java HW2 mul "1_a.txt" "1_b.txt" "1_mul.output" 1>1_mul.stdcout 2>1_mul.stderr
bash -c 'diff -iEBwu 1_mul.output 1_mul.txt >1_mul.diff'
if [ $? -ne 0 ]; then
    # display "test case 1 FAILED" to the screen. The word "FAILED" is highlighted in Red color
    echo -e "Test case 1_mul    \033[1;91mFAILED.\033[0m"
else
    # display "test case 1 PASSED" to the screen. The word "PASSED" is highlighted in Green color
    echo -e  "Test case 1_mul    \033[1;92mPASSED.\033[0m"
    # remove the file 1.diff
    rm -f 1_mul.diff
fi

java HW2 tra "1_a.txt" "1_a_tra.output" 1>1_a_tra.stdcout 2>1_a_tra.stderr
bash -c 'diff -iEBwu 1_a_tra.output 1_a_tra.txt >1_a_tra.diff'
if [ $? -ne 0 ]; then
    # display "test case 1 FAILED" to the screen. The word "FAILED" is highlighted in Red color
    echo -e "Test case 1_a_tra    \033[1;91mFAILED.\033[0m"
else
    # display "test case 1 PASSED" to the screen. The word "PASSED" is highlighted in Green color
    echo -e  "Test case 1_a_tra    \033[1;92mPASSED.\033[0m"
    # remove the file 1.diff
    rm -f 1_a_tra.diff
fi

java HW2 det "1_a.txt" "1_a_det.output" 1>1_a_det.stdcout 2>1_a_det.stderr
bash -c 'diff -iEBwu 1_a_det.output 1_a_det.txt >1_a_det.diff'
if [ $? -ne 0 ]; then
    # display "test case 1 FAILED" to the screen. The word "FAILED" is highlighted in Red color
    echo -e "Test case 1_a_det    \033[1;91mFAILED.\033[0m"
else
    # display "test case 1 PASSED" to the screen. The word "PASSED" is highlighted in Green color
    echo -e  "Test case 1_a_det    \033[1;92mPASSED.\033[0m"
    # remove the file 1.diff
    rm -f 1_a_det.diff
fi


java HW2 add "2_a.txt" "2_b.txt" "2_add.output" 1>2_add.stdcout 2>2_add.stderr
bash -c 'diff -iEBwu 2_add.output 2_add.txt >2_add.diff'
if [ $? -ne 0 ]; then
    # display "test case 2 FAILED" to the screen. The word "FAILED" is highlighted in Red color
    echo -e "Test case 2_add    \033[1;91mFAILED.\033[0m"
else
    # display "test case 2 PASSED" to the screen. The word "PASSED" is highlighted in Green color
    echo -e  "Test case 2_add    \033[1;92mPASSED.\033[0m"
    # remove the file 2.diff
    rm -f 2_add.diff
fi

java HW2 sub "2_a.txt" "2_b.txt" "2_sub.output" 1>2_sub.stdcout 2>2_sub.stderr
bash -c 'diff -iEBwu 2_sub.output 2_sub.txt >2_sub.diff'
if [ $? -ne 0 ]; then
    # display "test case 2 FAILED" to the screen. The word "FAILED" is highlighted in Red color
    echo -e "Test case 2_sub    \033[1;91mFAILED.\033[0m"
else
    # display "test case 2 PASSED" to the screen. The word "PASSED" is highlighted in Green color
    echo -e  "Test case 2_sub    \033[1;92mPASSED.\033[0m"
    # remove the file 2.diff
    rm -f 2_sub.diff
fi

java HW2 mul "2_a.txt" "2_b.txt" "2_mul.output" 1>2_mul.stdcout 2>2_mul.stderr
bash -c 'diff -iEBwu 2_mul.output 2_mul.txt >2_mul.diff'
if [ $? -ne 0 ]; then
    # display "test case 2 FAILED" to the screen. The word "FAILED" is highlighted in Red color
    echo -e "Test case 2_mul    \033[1;91mFAILED.\033[0m"
else
    # display "test case 2 PASSED" to the screen. The word "PASSED" is highlighted in Green color
    echo -e  "Test case 2_mul    \033[1;92mPASSED.\033[0m"
    # remove the file 2.diff
    rm -f 2_mul.diff
fi

java HW2 tra "2_a.txt" "2_a_tra.output" 1>2_a_tra.stdcout 2>2_a_tra.stderr
bash -c 'diff -iEBwu 2_a_tra.output 2_a_tra.txt >2_a_tra.diff'
if [ $? -ne 0 ]; then
    # display "test case 2 FAILED" to the screen. The word "FAILED" is highlighted in Red color
    echo -e "Test case 2_a_tra    \033[1;91mFAILED.\033[0m"
else
    # display "test case 2 PASSED" to the screen. The word "PASSED" is highlighted in Green color
    echo -e  "Test case 2_a_tra    \033[1;92mPASSED.\033[0m"
    # remove the file 2.diff
    rm -f 2_a_tra.diff
fi

java HW2 det "2_a.txt" "2_a_det.output" 1>2_a_det.stdcout 2>2_a_det.stderr
bash -c 'diff -iEBwu 2_a_det.output 2_a_det.txt >2_a_det.diff'
if [ $? -ne 0 ]; then
    # display "test case 2 FAILED" to the screen. The word "FAILED" is highlighted in Red color
    echo -e "Test case 2_a_det    \033[1;91mFAILED.\033[0m"
else
    # display "test case 2 PASSED" to the screen. The word "PASSED" is highlighted in Green color
    echo -e  "Test case 2_a_det    \033[1;92mPASSED.\033[0m"
    # remove the file 2.diff
    rm -f 2_a_det.diff
fi