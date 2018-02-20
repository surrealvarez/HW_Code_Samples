//Author: Jose Alvarez
//Homework 1: Arrays

#include <iostream>
#include <stdlib.h>
#include <time.h>
#include "Source.h"

using namespace std;

//function selects student from array and outputs the grade received by the student
int StudentSelection(double arr[], int size) 
{
	cout << "Enter the student number, between 1 and 10, that you would like to grade for: "; 
	int input;
	cin >> input;
	if ((input > size) || (input <= 0)) {
		cout << "\nFATAL ERROR 101 - The Student Index number you entered is invalid\n";
		
	}
	else {
		cout << "Student " << input<< ": " << arr[input - 1] << endl << endl;
	}

	return 0;
} 

//function calculates the average of the generated arrays
double CalculateAvg(double arr[], int size) {
	double sum = 0.0;
	int i;
	for (i = 0; i < size; i++) {
		sum += arr[i];
	}
	double average;
	average = (sum / size);
	cout << "The Average is: ";
	return(printf("%.2f",average));
}

//function prints all the grades received by the 10 students in the class
int PrintClassGrades(double arr[], int size)
{
	int i;
	for (i = 0; i < size; i++) {
		cout << "Student " << i + 1 << " | Grade: " << arr[i] << endl;

	}
	cout << endl<<endl;
	return 0;
}

//function sorts the grades in ascending order
int* Sort(double arr[], int size) {
	int i = 0;
	bool swapped = false;
	cout << "Original Array: ";
	for (i; i < size; i++) {
		cout << arr[i] << ", ";
	}
	cout << endl;
	do {
		swapped = false;
		for (int i = 0; i < size; i++) {
			if (arr[i - 1] > arr[i]) {
				int lower = arr[i];
				arr[i] = arr[i - 1];
				arr[i - 1] = lower;
				swapped = true;
			}
		}
	} while (swapped);
	cout << "Sorted: ";
	for (i = 0; i < size; i++) {
		cout << arr[i] << ", ";
	}
	cout << endl << endl;
	return 0;
}

int main() {
	int const size = 10;
	double classA[size]; //condition to satisfy which class is chosen
	double classB[size]; //same as above
	int i;
	char inputchoice = 'a';
	srand((unsigned)time(0));
	for (i = 0; i < size; i++) {     //create random values for class A
		classA[i] = rand() % 101;	
	}
	int j;
	for (j = 0; j < size; j++) {    // vice versa for class B
		classB[j] = rand() % 101;
	}

	bool caseA = true;
	bool caseB = true;

	while (inputchoice != '0') {
	
		//creates a menu satisfying the condition for class A to be true, unless class is switched it jumps to class B
		while (caseA ==true) {
			
			cout << "This is Class A\n";
			cout << "1. Print Class Grades" << endl;
			cout << "2. Select A Student" << endl;
			cout << "3. Calculate Average" << endl;
			cout << "4. Switch Class" << endl;
			cout << "5. Sort grades in Ascending Order" << endl;
			cout << "0. Exit" << endl;
			cin >> inputchoice;

			//menu satisfying the cases down below, indicated by the options above
			switch (inputchoice) {

			case '1':
				PrintClassGrades(classA, size);
				break;
			case '2':
				StudentSelection(classA, size);
				break;
			case '3':
				CalculateAvg(classA, size);
				cout << endl << endl;
				break;
			case '4':
				caseA = false;
				break;
			case '5':
				Sort(classA, size);
				break;
			case '0':
				exit(0);
				break;
			default:
				cout << "Invalid menu choice entered. Please Try Again.\n";
				continue;
			}
		} 
		caseA = true; //resets back to true

		//caseA was marked false, indicating change of class
		while (caseB == true) {
			cout << "This is Class B\n";
			cout << "1. Print Class Grades" << endl;
			cout << "2. Select A Student" << endl;
			cout << "3. Calculate Average" << endl;
			cout << "4. Switch Class" << endl;
			cout << "5. Sort grades in Ascending Order" << endl;
			cout << "0. Exit" << endl;
			cin >> inputchoice;

			//menu satisfying the cases down below, indicated by the options above
			switch (inputchoice) {

			case '1':
				PrintClassGrades(classB, size);
				break;
			case '2':
				StudentSelection(classB, size);
				break;
			case '3':
				CalculateAvg(classB, size);
				cout << endl << endl;
				break;
			case '4':
				caseB = false;
				break;
			case '5':
				Sort(classB, size);
				break;
			case '0':
				exit(0);
			default:
				cout << "Invalid menu choice entered. Please Try Again.\n";
				continue;
			}
		}
		caseB = true;

	}
	
	system("PAUSE");
	return 0;
}
