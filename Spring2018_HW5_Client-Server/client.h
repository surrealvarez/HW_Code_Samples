#pragma once

#include <iostream>
#include <string>
using namespace std;

class  Client {
private:
	int id;
	string message = "";
	bool possesKey;
	static  char  key[26];
	
public:
	Client();
	Client (int x);
	int getID();
	int setID(int x);
	string getMessage();
	void setMessage(string x);
	void setPossesKey(bool x);
	string decode(string x);
	
};