#pragma once
#include <iostream>
#include <string>
#include "client.h"
using namespace std;

class Server {

protected:
	Client * sender;
	Client * receiver;


public:
	virtual void establishConnection(Client *x, Client *y) = 0;
	virtual void sendMessage(string x) = 0;
	void swapClients();

};