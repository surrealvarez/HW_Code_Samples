//Jose Alvarez COSC HW 2
// Improve skillset upon dynamic arrays and pointers.

#include <iostream>
#include <cstdlib>
using namespace std;


int main() {
	int size = 2;
	int i = 0;
	int *array1 = new int[size]();
	int *orgArray = new int[size]();

	int something = 0;
	int inputchoice;


	while (something != 5) {
		bool cond = true;
		cout << "1. Print Elements" << endl;
		cout << "2. Add Element" << endl;
		cout << "3. Delete Element" << endl;
		cout << "4. Return Size" << endl;
		cout << "5. Exit" << endl;
		while (cond == true) {

			cin >> inputchoice;
			switch (inputchoice) {

			case 1:
				
				for (int j = 0; j < size; j++) {
					orgArray[j] = array1[j];
				}

				for (int k = 0; k < size - 1; k++) 
				{
					for (int j = k + 1; j < size; j++)
					{
						int temporary;
						if (orgArray[k] > orgArray[j]) 
						{
							temporary = orgArray[k];
							orgArray[k] = orgArray[j];
							orgArray[j] = temporary;
						}
					}
				}
				
				for (int l = 0; l < size; l++) {
					cout << orgArray[l] << ",";
				}

				cout << endl;
				break;
			case 2:
				cout << "Element to add: ";
				int input;
				cin >> input;
				cout << "\n";
				if (i >= size) {
					int newSize = size * 2;
					int* largerArray = new int[newSize]();
					for (int k = 0; k < size; k++) {
						largerArray[k] = (array1)[k];
					}
					size = newSize;
					//copy(array1, array1 + size, largerArray);
					delete[]array1;
					array1 = largerArray;
					array1[i] = input;
					cout << "Array size Expanded to " << size << " \n";
					i++;
					break;
				}
				else {
					array1[i] = input;
					//array1[i] = input;
					//size = sizeof(array1);
					i++;
				}
				
				break;
			case 3:
				cout << "Element to Delete" << endl;
				cin >> input;
				cout << endl;
				if (i < size)
				{
					//Half
					int newSize = size / 2;
					int *new_array = new int[newSize]();
					for (int i = 0; i < size; i++)
					{
						new_array[i] = array1[i];
					}
					size = newSize;
					delete[] array1;
					//original

					array1 = new_array;
					array1[i] = input;
					i++;
					cout << "New array size is " << size << endl;
				}
				//Continue if not half
				else
				{
					//input in range
					if ((input > size) || (input < 1))
					{
						cout << "Out of range. Try again" << endl;
					}
					else
					{
						//deletes previous inputs
						for (int i = 0; i < size; i++){
							if (input == array1[i])	{
								for (int j = i; i < size; j++)	{
									array1[i] = array1[i + 1];
									break;
								}
							}
						}
						//returns back
						i -= 1;

					}
				}

				break;
			case 4:
				cout << " The size of the array is " << size << endl;
				break;
			case 5:
				delete[]array1;
				delete[]orgArray;
				array1 = nullptr;
				orgArray = nullptr;
				exit(0);
				break;
			default:
				cout << "Invalid menu choice entered. Please Try Again.\n";
				continue;
			}
			cond = false;

		}
	}
	system("pause");
	return 0;
}
