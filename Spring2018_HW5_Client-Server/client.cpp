
#include "client.h"

char  Client::key[] = { 'B','A','D','C','F','E','H','G','J','I','L','K','N','M','P','O','R','Q','T','S','V','U','X','W','Z','Y' };

Client::Client()
{
	cout << "Enter Client ID Number (Any # works): ";
	int createdID;
	cin >> createdID;
	setID(createdID);
}

Client::Client(int x)
{
	setID(x);
}

int Client::getID()
{
	return id;
}

int Client::setID(int x)
{
	id = x;
	return 0;
}

string Client::getMessage()
{
	string decoded = decode(message);
	return string(decoded);
}

void Client::setMessage(string x)
{
	message = x;
	int y = 0;
	
}

void Client::setPossesKey(bool x)
{
	possesKey = x;
}

string Client::decode(string x)
{
	if (possesKey == true) 
	{
		// DECODE THE MESSAGE
		for (int i= 0; i < x.length(); i++)
		{
			//Decoding through the letters
			for (int j = 0; j < 26; j++)
			{
				if ((x[i] == key[j]) && (j % 2 == 0))
				{
					x[i] = key[j + 1];
					break;
				}
				else if ((x[i] == key[j]) && (j % 2 != 0))
				{
					x[i] = key[j - 1];
					break;
				}
			}
		}
	}
	else {
		return x;
	}
	return x;
}
