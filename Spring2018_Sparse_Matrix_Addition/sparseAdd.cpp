#include <iostream>
#include <string>
#include <fstream>
#include <sstream>

using namespace std;

struct element {
	int r;
	int c;
	double value;
};

int pos( int c, int rwanted, int cwanted) {
	int position = (rwanted*c) - c + cwanted;
	return position; //your technique
}


int main() {

	string file1, file2;
	string line = "";
	int size1 = 0;
	int size2 = 0;
	// ask user for the name of the file
	std::cout << "Type in the name of the file you want to open first:\n";
	cin >> file1;
	std::cout << "Type in the name of the second file you want to open:\n";
	cin >> file2;

	//COUNT THE NUMBER OF ENTRIES INSIDE INPUT MATRIX1
	ifstream counter;
	counter.open(file1);
		if (!counter.is_open())
	{
		exit(1);
	}
	while (getline(counter, line))
	{
		if (line.find("#") != line.npos) {
			line.clear();
		}
		else
		{
			size1++;			
		}		
	}
	size1 = size1 - 1;
	counter.close();

	//COUNT THE NUMBER OF ENTRIES INSIDE INPUT MATRIX2
	ifstream counter2;
	counter2.open(file2);
	if (!counter2.is_open())
	{
		exit(1);
	}

	while (getline(counter2, line))

	{
		if (line.find("#") != line.npos) {
			line.clear();
		}
		else
		{
			size2++;

		}

	}
	size2 = size2 - 1;
	counter2.close();



	ifstream inputfile;
	inputfile.open(file1);

	if (!inputfile.is_open()) {
		std::cout << "Could not open file!\n";
		exit(1);
	}


	//declare dynamic arrays
	element *m1 = new element[size1]();
	element *m2 = new element[size2]();
	int i = 0;
	int num1=0, num2=0;
	bool mforward = false;

	while (getline(inputfile, line))
	{
		if (line.find("#") != line.npos)
		{
			line.clear();
		}

		else if (mforward == false)
		{
			stringstream ss;

			ss.str(line);
			ss >> num1 >> num2;
			ss.clear();
			std::cout << line << endl;
			mforward = true;

		}
		else
		{
			stringstream ss;
			ss.str(line);
			ss >> m1[i].r >> m1[i].c >> m1[i].value;
			ss.clear();
			std::cout << line << endl;
			i++;
		}
	}
	inputfile.close();

	ifstream inputfile2;
	inputfile2.open(file2);
	int num1_2 =0, num2_2=0;
	bool mforward2 = false;
	int b = 0;

	while (getline(inputfile2, line))
	{
		if (line.find("#") != line.npos)
		{
			line.clear();
		}

		else if (mforward2 == false)
		{
			stringstream ss;

			ss.str(line);
			ss >> num1_2 >> num2_2;
			ss.clear();
			std::cout << line << endl;
			mforward2 = true;
			
		}
		else
		{
			stringstream ss;
			ss.str(line);
			ss >> m2[b].r >> m2[b].c >> m2[b].value;
			ss.clear();
			std::cout << line << endl;
			b++;
		}
	}
	inputfile2.close();
	
	//Open File for output:
	ofstream output;
	output.open("output.txt");
	cout << endl;
	bool something = false;
	double sum;
	
	if ((num1 == num1_2) && (num2 == num2_2))
	{
		output << num1 << " " << num2 << endl;


		//For-loop to check if any values of M1 match with M2
		for (int n = 0; n < size1; n++)
		{
			something = false;
			for (int m = 0; m < size2; m++)
			{
				if ((m1[n].r == m2[m].r) && (m1[n].c == m2[m].c))
				{
					sum = 0;
					sum = (m1[n].value) + (m2[m].value);
					output << m1[n].r << " " << m2[m].c << " " << sum << endl;
					something = true;
					break;
				}
			}
			if (something == false)
			{
				//does not match any value
				output << m1[n].r << " " << m1[n].c << " " << m1[n].value << endl;
			}
		}
	}
	something = false;
	if ((num1 == num1_2) && (num2 == num2_2))
	{
		//For-loop to check if any values of M2 are independent

		for (int n = 0; n < size2; n++)
		{
			something = false;
			for (int m = 0; m < size1; m++)
			{
				if ((m2[n].r == m1[m].r) && (m2[n].c == m1[m].c))
				{
					something = true;
					break;
				}
			}
			if (something == false)
			{
				//does not match any value
				output << m2[n].r << " " << m2[n].c << " " << m2[n].value << endl;
			}
		}
	}
	else {
		output << "Matrices are incompatible!!\n";
		exit(1);
	}

	output.close();
	cout << "SORTED STARTS HERE" << endl;
	int size3 = 0;
	ifstream countsorted;
	countsorted.open(file1);
	if (!countsorted.is_open())
	{
		exit(1);
	}
	while (getline(countsorted, line))
	{
		if (line.find("#") != line.npos) {
			line.clear();
		}
		else
		{
			size3++;

		}

	}
	countsorted.close();

	fstream sorted("output.txt", ios::in | ios::out | ios::app);
	if (!sorted.is_open()) {
		std::cout << "Could not open file!\n";
		exit(1);
	}
	element *sortedarr = new element[size3];
	int row = 0, column = 0, a =0;
	bool mforward3 = false;
	while (getline(sorted, line))
	{

		if (mforward3 == false)
		{
			stringstream ss;
			ss.str(line);
			ss >> row >> column;
			ss.clear();
			std::cout << line << endl;
			mforward3 = true;
		}
		else
		{
			stringstream ss;
			ss.str(line);
			ss >> sortedarr[a].r >> sortedarr[a].c >> sortedarr[a].value;
			ss.clear();
			std::cout << line << endl;
			a++;
		}
	}
	
	cout << endl << endl << endl;
	bool swapped = false;
	do {
		swapped = false; // reset before each scan
		for (int j = 1; j < size3; j++) {
			if (pos( column, sortedarr[j - 1].r, sortedarr[j - 1].c) > pos(column, sortedarr[j - 1].r, sortedarr[j - 1].c))
			{
				int tempr = sortedarr[j].r;
				int tempc = sortedarr[j].c;
				double tempv = sortedarr[j].value;
				sortedarr[j].r = sortedarr[j - 1].r;
				sortedarr[j].c = sortedarr[j - 1].c;
				sortedarr[j].value = sortedarr[j - 1].value;
				sortedarr[j - 1].r = tempr;
				sortedarr[j - 1].c = tempc;
				sortedarr[j - 1].value = tempv;
				swapped = true;
			}
		}
	} while (swapped);

	for (int j = 0; j < size3; j++) {
		cout << sortedarr[j].r << " " << sortedarr[j].c << " " << " " << sortedarr[j].value << endl;
	}
	
	std::system("pause");
	return 0;
}