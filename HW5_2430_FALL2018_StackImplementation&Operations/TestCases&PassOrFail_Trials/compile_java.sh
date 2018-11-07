#Compile the code
# if the file HW5 exits then remove it
if [ -f HW5 ]; then
    rm HW5
fi
javac HW5.java
# if the file HW5 does not exit then exit the test
if [ ! -f HW5.class ]; then
    echo   "\033[1;91mCompile FAILED.\033[0m"
    exit
fi