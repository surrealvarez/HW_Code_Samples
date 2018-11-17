#pragma once
#include "server.h"

class messageServer : public Server {
public:
	messageServer();
	void establishConnection(Client *s, Client *r);
	void sendMessage(string);



};