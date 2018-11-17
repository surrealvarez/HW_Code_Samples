#include "server.h"

void Server::swapClients()
{
	Client *temp = sender;
	sender = receiver;
	receiver = temp;
	temp = nullptr;
}
