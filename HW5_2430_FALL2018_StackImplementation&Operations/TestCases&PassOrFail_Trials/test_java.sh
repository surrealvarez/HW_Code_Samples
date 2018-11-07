#Compile the code
# if the file HW5 exits then remove it
if [ -f HW5 ]; then
    rm HW5
fi
javac *.java
# if the file HW5 does not exit then exit the test
if [ ! -f HW5.class ]; then
    echo   "\033[1;91mCompile FAILED.\033[0m"
    exit
fi
# clean
rm -f *.output *.stdcout *.stderr 

java HW5 2 "2-3*4+5/6" "itp_1.output" 1>itp_1.stdcout 2>itp_1.stderr
bash -c 'diff -iEBwu itp_1.output itp_1.txt >itp_1.diff'
if [ $? -ne 0 ]; then
    # display "test case 1 FAILED" to the screen. The word "FAILED" is highlighted in Red color
    echo -e "Test case itp_1    \033[1;91mFAILED.\033[0m"
else
    # display "test case 1 PASSED" to the screen. The word "PASSED" is highlighted in Green color
    echo -e  "Test case itp_1    \033[1;92mPASSED.\033[0m"
    # remove the file 1.diff
    rm -f itp_1.diff
fi

java HW5 2 "(2+3)^4*5" "itp_2.output" 1>itp_2.stdcout 2>itp_2.stderr
bash -c 'diff -iEBwu itp_2.output itp_2.txt >itp_2.diff'
if [ $? -ne 0 ]; then
    # display "test case 1 FAILED" to the screen. The word "FAILED" is highlighted in Red color
    echo -e "Test case itp_2    \033[1;91mFAILED.\033[0m"
else
    # display "test case 1 PASSED" to the screen. The word "PASSED" is highlighted in Green color
    echo -e  "Test case itp_2    \033[1;92mPASSED.\033[0m"
    # remove the file 1.diff
    rm -f itp_2.diff
fi

java HW5 3 "23+4^5*" "p_1.output" 1>p_1.stdcout 2>p_1.stderr
bash -c 'diff -iEBwu p_1.output p_1.txt >p_1.diff'
if [ $? -ne 0 ]; then
    # display "test case 1 FAILED" to the screen. The word "FAILED" is highlighted in Red color
    echo -e "Test case p_1    \033[1;91mFAILED.\033[0m"
else
    # display "test case 1 PASSED" to the screen. The word "PASSED" is highlighted in Green color
    echo -e  "Test case p_1    \033[1;92mPASSED.\033[0m"
    # remove the file 2.diff
    rm -f p_1.diff
fi

java HW5 3 "23+-" "p_2.output" 1>p_2.stdcout 2>p_2.stderr
bash -c 'diff -iEBwu p_2.output p_2.txt >p_2.diff'
if [ $? -ne 0 ]; then
    # display "test case 1 FAILED" to the screen. The word "FAILED" is highlighted in Red color
    echo -e "Test case p_2    \033[1;91mFAILED.\033[0m"
else
    # display "test case 1 PASSED" to the screen. The word "PASSED" is highlighted in Green color
    echo -e  "Test case p_2    \033[1;92mPASSED.\033[0m"
    # remove the file 2.diff
    rm -f p_2.diff
fi
