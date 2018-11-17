#include "encodedServer.h"
#include <string>
#include <algorithm>

encodedServer::encodedServer()
{
	sender = nullptr;
	receiver = nullptr;
}

void encodedServer::establishConnection(Client * s, Client * r)
{
	sender = s;
	receiver = r;

}

void encodedServer::sendMessage(string x)
{
	string ecodedMess = encodeMessage(x);
	receiver->setMessage(ecodedMess);
}

string encodedServer::encodeMessage(string x)
{
	std::transform(x.begin(), x.end(), x.begin(), ::toupper);
		// ENCODE THE MESSAGE
		for (int i = 0; i < x.length(); i++)
		{
			//Encoding through the letters
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
	

	return string(x);
}
