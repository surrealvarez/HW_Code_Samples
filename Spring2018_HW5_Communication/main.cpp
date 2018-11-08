#include <iostream>
#include "client.h"
#include "server.h"
#include "encodedServer.h"
#include "messageServer.h"
#include <fstream>
#include <string>
using namespace std;

int main() {
	

	Client * client1 = new Client();
	Client * client2 = new Client (2);

	//client2->setID(2);

	messageServer mssgServ;
	encodedServer encServ;

	//ESTABLISH CONNECTION
	char response1, response2, encryptResponse, responseKey1, responseKey2;
	bool Posses_Key, Posses_Key2;
	cout << "Client 1, make a connection? (y/n)";
	cin >> response1;
	cout << "Client 2, make a connection? (y/n)";
	cin >> response2;
	
	int count = 0;
	string input, input2;

	ofstream MyStream;
	MyStream.open("out.txt");
	bool stopornot = true;
	string messageDecoded;
	if ((response1 == 'y') && (response2 == 'y')) {
		//ESTABLISH CONNECTION BEGINS
		cout << "Encryped Connection? (y/n)";
		cin >> encryptResponse;
		if (encryptResponse == 'y')
		{	
									// sender  ,  receiver
			//ESTABLISH ENCRYPTED SERVER
			encServ.establishConnection(client1, client2);
			cout << "Client 1, does Client 2 get the key? (y/n)";
			cin >> responseKey1;
			if (responseKey1 == 'y') {
				Posses_Key = true;
				client1->setPossesKey(Posses_Key);
			}
			else if (responseKey1 == 'n') {
				Posses_Key = false;
				client1->setPossesKey(Posses_Key);
			}

			cout << "Client 2, does Client 1 get the key? (y/n)";
			cin >> responseKey2;
			if (responseKey2 == 'y') {
				Posses_Key2 = true;
				client2->setPossesKey(Posses_Key2);
			}
			else if (responseKey2 == 'n') {
				Posses_Key2 = false;
				client2->setPossesKey(Posses_Key2);
			}		
			
			cin.ignore();

			//ACCEPT USER INPUT ON AN ENCRYPTED SERVER
			while (stopornot != false)
			{
				//CLIENT 1
				//WHEN COUNT = EVEN, CLIENT1 IS THE SENDER WHILE CLIENT2 IS THE RECEIVER
				if (count % 2 == 0) {
					cout << "Client 1 (End with blank line): ";
					getline(cin, input);
					if (input.empty()) {
						delete client1;
						delete client2;
						client1 = nullptr;
						client2 = nullptr;
						//DELETE PTRS
						MyStream.close();
						stopornot = false;
					}
					//SEND MESSAGE TO ENCODED SERVER
					encServ.sendMessage(input);

					//GET THE DECODED MESSAGE
					//RECEIVER(CLIENT2) GETS THE MESSAGE
					messageDecoded = client2->getMessage();
					MyStream << "Client 1: " << messageDecoded << endl;
					encServ.swapClients();
					count++;
				}
				// CLIENT 2
				// WHEN COUNT = ODD, CLIENT2 IS THE SENDER WHILE CLIENT1 IS THE RECEIVER
				else if ((count % 2) != 0) {
					cout << "Client 2 (End with blank line): ";
					getline(cin, input2);
					if (input2.empty()) {
						//DELETE PTRS
						delete client1;
						delete client2;
						client1 = nullptr;
						client2 = nullptr;
						MyStream.close();
						stopornot = false;
					}
					//SEND MESSAGE TO ENCODED SERVER
					encServ.sendMessage(input2);
					//GET THE Decoded message
					messageDecoded = client1->getMessage();
					MyStream << "Client 2: " << messageDecoded << endl;
					encServ.swapClients();
					count++;
				}				
			}
		}

		//IF USER DOES NOT WANT AN ENCRYPTED CONNECTION
		else if (encryptResponse == 'n')
		{
			mssgServ.establishConnection(client1, client2);
			//Posses_Key = false;
			//Posses_Key2 = false;
			cin.ignore();
			while (stopornot != false)
			{

				if (count % 2 == 0) {
					cout << "Client 1: ";
					getline(cin, input);
					if (input.empty()) {
						//DELETE PTRS
						delete client1;
						delete client2;
						client1 = nullptr;
						client2 = nullptr;
						MyStream.close();
						stopornot = false;
					}
					mssgServ.sendMessage(input);
					messageDecoded = client2->getMessage();
					MyStream << "Client 1: " << messageDecoded << endl;
					mssgServ.swapClients();
					count++;
				}
				else if ((count % 2) != 0) {
					cout << "Client 2: ";
					getline(cin, input2);
					if (input2.empty()) {
						//DELETE PTRS
						delete client1;
						delete client2;
						client1 = nullptr;
						client2 = nullptr;
						MyStream.close();
						stopornot = false;
					}

					mssgServ.sendMessage(input2);
					messageDecoded = client1->getMessage();
					MyStream << "Client 2: " << messageDecoded << endl;
					mssgServ.swapClients();
					count++;
				}
			}
		}
	}
	else
	{
		// PRINT TO OUT.TXT CONNECTION COULD NOT BE MADE
		MyStream << "No connection made.\n";
		delete client1;
		delete client2;
		client1 = nullptr;
		client2 = nullptr;
		MyStream.close();
	}
	
	return 0;
}