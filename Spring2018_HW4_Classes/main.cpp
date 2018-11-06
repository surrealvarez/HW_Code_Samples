
#include "class.h"

int main() {
	
	int h = 0, m= 0, s=0;
	//stopwatch object;
	string sizeS;
	cout << "Please enter how many times you would like to store:";
	cin >> sizeS;
	int size = stoi(sizeS); // Convert String to integer , in order to utilize in dynamic array

	if (size <= 0) {
		exit(0);
	}

	stopwatch *ArrObjects = new stopwatch[size]; // Create  a dynamic array of size objects

	for (int i = 0; i < size; i++) {
		cout << "Please enter hour: "; // INPUTING HOUR
		cin >> h;
		cout << "Please enter minute "; // INPUTING MINUTE
		cin >> m;
		cout << "Please enter second "; 
		cin >> s;
		if ((h >= 0) && ((m < 60) && (m >= 0)) && ((s < 60) && (s >= 0))) // If conditions are met
		{ 
			ArrObjects[i] = stopwatch(h, m, s);
		}
		else
		{
			ArrObjects[i] = stopwatch();
		}
	}

	//object.sizeArray();
	//object.inputTime();

	int something = 0;
	string inputchoice;
	double days = 0 , sumDays = 0;
	int totHour = 0, totMin = 0, totSec = 0, sum = 0; // Initializing variables to add them 
	int totHour2 = 0, totMin2 = 0, totSec2 = 0;
	int  secs = 0, mins = 0, hrs = 0;
	bool condition = true;
	while (condition == true) {		
	cout << "1) Print the Individual Stored Times\n";
	cout << "2) Print the Total Time\n";
	cout << "3) Print Days in Total Time\n";
	cout << "0) Exit  the Program\n";
		cin >> inputchoice;
		int input_c = stoi(inputchoice);

		switch (input_c) {
				
		case 1:
			//PRINT THE TIMES INPUTED
			for (int i = 0; i < size; i++) {
				cout << "Time " << i + 1 << " - ";
				ArrObjects[i].print_time();
			}
			
			break;
		case 2:
			//ADDING STOPWATCH OBJECTS ALL TOGETHER AND PRINT THEM IN HOUR:TIME:SECOND FORMAT
			for (int j = 0; j < size; j++) {
				totHour += ArrObjects[j].getHr();
				totMin += ArrObjects[j].getMin();
				totSec += ArrObjects[j].getSec();
			}

			sum = totHour * 3600 + totMin * 60 + totSec;
			secs = sum % 60; // Remaining amount of seconds after
			sum = sum / 60;
			mins = sum % 60;
			hrs = sum / 60;
			cout << "Total Time - ";
			cout << setw(2) << setfill('0') << hrs << ":" << setw(2) << setfill('0') << mins << ":" << setw(2) << setfill('0') << secs << endl;
			totHour = 0;
			totMin = 0;
			totSec = 0;
			break;
		case 3:
			for (int j = 0; j < size; j++) {
				totHour2 += ArrObjects[j].getHr();
				totMin2 += ArrObjects[j].getMin();
				totSec2 += ArrObjects[j].getSec();
			}
			sumDays = totHour2 * 3600 + totMin2 * 60 + totSec2;
			days = ArrObjects->totTimeDays(sumDays);
			cout << "Total Time in Days - " << fixed << setprecision(2) << days << endl;

			totHour2 = 0;
			totMin2 = 0;
			totSec2 = 0;
			break;
		case 0:
			delete [] ArrObjects;
			ArrObjects = nullptr;
			condition = false;
			// exit and delete allocated memory
			break;
		default:
		cout << "Invalid menu choice entered. Please Try Again!\n";
		}
	}

	return 0;
}