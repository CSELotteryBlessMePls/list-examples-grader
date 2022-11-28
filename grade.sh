# Create your grading script here

#set -e

#clear the folder for each now run of the bash file
rm -rf student-submission 
#clone the repository to the root of the directory
git clone $1 student-submission
#copy the file TestListExamples.java into the main folder (that we just cloned everything into)
cp TestListExamples.java student-submission/
cp -r lib student-submission/
#change the directory into the foler
cd student-submission

#if ListExamples.java exists within the folder
if [[ -f ListExamples.java ]]
then #file found, move on
    echo "file found"
else #file not found, tell that, print the grade which is still zero, exit with the error exit code
    echo "file not found"
    echo "failed"
    exit 1
fi
#comple the java files, report the output to compile-out.txt
javac -cp ".:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar" *.java 2> compile-output.txt
#if no errors
if [[ $? -eq 0 ]]
then
    echo "compiled fine"
    java -cp ".:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore TestListExamples > errors.txt
    ERROR=$(grep "FAILURES" errors.txt)
    if [[ $ERROR == "FAILURES!!!" ]]
    then
        echo "failed"
        echo "errors:"
        cat errors.txt
        exit 
    fi
    echo "Tests Passed! Congrats!"
    exit
else
    cat compile-output.txt
    echo "compile error"
    echo "failed"
    exit 1
fi