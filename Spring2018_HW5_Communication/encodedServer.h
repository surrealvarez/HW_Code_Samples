#pragma once
#include "server.h"


class encodedServer : public Server {

private:
	char  key[26]{ 'B','A','D','C','F','E','H','G','J','I','L','K','N','M','P','O','R','Q','T','S','V','U','X','W','Z','Y' };
public:
	encodedServer();
	void establishConnection(Client *s, Client *r);
	void sendMessage(string x);
	string encodeMessage(string x);

};