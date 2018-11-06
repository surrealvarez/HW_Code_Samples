#pragma once
#include <iostream>
#include <string>
#include <iomanip>
#include <sstream>


using namespace std;

class stopwatch {
	
public:
	
	stopwatch(); // default constructor
	stopwatch(int hour, int minute, int second); // to set hour, minute, second
	void print_time(); // output
	int getHr();
	int getMin();
	int getSec();
	double totTimeDays(double x);

private:
	int hour, minute, second;

};