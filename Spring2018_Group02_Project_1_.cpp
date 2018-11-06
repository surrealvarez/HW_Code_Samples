// Zachary Armstrong
// Jose Carlos Alvarez
// John Blankenburg
// COSC 1430: Group Assignment 1



#include <iostream>


int dotProduct(int array1[], int array2[], int size) {
	int sumOfDotPr = 0;
	for (int i = 0; i < size; i++) {
		sumOfDotPr += array1[i] * array2[i];
	}
	return sumOfDotPr;
}


void alternate(int array1[], int array2[], int size) {
	std::cout << "[";
	for (int i = 0; i < size; i++) {
		std::cout << array1[i] << "," << array2[i] << ",";
	}
	std::cout << "]";
}

void negatives(int array1[], int array2[], int size)
{
	int * mArray1 = array1;
	int * mArray2 = array2;

	for (int i = 0; i < size; i++)
	{
		mArray1[i] = (mArray1[i] / -1);
		mArray2[i] = (mArray2[i] / -1);
	}
}

int main()
{
	int sizeinput = 0;
	int numberinput = 0;
	while (sizeinput <= 0) {
		std::cout << "Enter Array Size: ";
		std::cin >> sizeinput;
		std::cout << std::endl; //new line
		if (sizeinput <= 0) {
			std::cout << "Incorrect array size. Try Again\n";
		}
	}
	int const arraySize = sizeinput;
	int *array1 = new int[arraySize];
	int *array2 = new int[arraySize];

	std::cout << "Array 1: \n";
	for (int i = 0; i < arraySize; i++) {
		std::cout << "Enter element: ";
		std::cin >> numberinput;
		array1[i] = numberinput;

	}
	std::cout << std::endl; // new line

	std::cout << "Array 2: \n";
	for (int i = 0; i < arraySize; i++) {
		std::cout << "Enter element: ";
		std::cin >> numberinput;
		array2[i] = numberinput;

	}
	std::cout << std::endl; // new line

	std::cout << "The Dot Product of These Arrays is: " << dotProduct(array1, array2, arraySize) << std::endl << std::endl;

	alternate(array1, array2, arraySize);
	std::cout << std::endl << std::endl;

	negatives(array1, array2, arraySize);
	std::cout << std::endl;

	//sorry
	for (int i = 0; i < arraySize; i++)
	{
		if (i == 0)
		{
			std::cout << "Negative Array 1: [";
		}

		std::cout << array1[i] << ",";

		if (i == (arraySize - 1))
		{
			std::cout << "]" << std::endl;
		}
	}

	for (int i = 0; i < arraySize; i++)
	{
		if (i == 0)
		{
			std::cout << "Negative Array 2: [";
		}

		std::cout << array2[i] << ",";

		if (i == (arraySize - 1))
		{
			std::cout << "]" << std::endl;
		}
	}
	delete array1;
	delete array2;

	array1 = nullptr;
	array2 = nullptr;

	system("pause");
}
