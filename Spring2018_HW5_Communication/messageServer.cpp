#include "messageServer.h"
#pragma once

messageServer::messageServer()
{
	//make pointer point to NULL 
	sender = nullptr;
	receiver = nullptr;
}

void messageServer::establishConnection(Client * s, Client * r)
{
	sender = s;
	receiver = r;
}

void messageServer::sendMessage(string x)
{
	receiver->setMessage(x);
}
