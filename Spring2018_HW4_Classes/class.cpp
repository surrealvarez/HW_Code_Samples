#include "class.h"


stopwatch::stopwatch()
{
	hour = 0;
	minute = 0;
	second = 0;
}

stopwatch::stopwatch(int h, int m, int s)
{
	hour = h;
	minute = m;
	second = s;
}

void stopwatch::print_time()
{
		cout << setw(2) << setfill('0') << hour << ":" << setw(2) << setfill('0') << minute << ":" << setw(2) << setfill('0') << second << endl; // print out in format HR:MIN:SEC
	
}

int stopwatch::getHr()
{
	return hour;
}

int stopwatch::getMin()
{
	return minute;
}

int stopwatch::getSec()
{
	return second;
}

double stopwatch::totTimeDays(double x)
{
	double days;
	days = x / 86400;
	return days;
}


