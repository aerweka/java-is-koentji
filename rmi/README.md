Hereby I put my notes on what I have been learning about Java RMI

### What is RMI?
The goal To create Java distributed applications. RMI is for 2 JVM to communicate each other as server and client
- RMI needs port to call the object and hold the registry
- By default, the port is 1099, but it can be customized when creating the registry. As a consequence, the client need to provide the same port when looking up at the registries

### RMI Architecture
![The RMI architecture](https://images.javatpoint.com/images/rmi/stubandskeleton.jpg)

RMI use stub and skeleton object to communicate with the remote object. Remote object is an object whose method registered and later on can be invoked from another JVM.

Stub is an object who acts as a gateway/representation of remote object for the client. Whenever client invoke the method of stub, it does these:
- Init connection to remote VM (JVM)
- Write and transmit (marshals) the param to remote VM
- Wait the result
- Read (unmarshals) the returned value or exception
- Return the value to the caller (client)

Skeleton

Between client and server there has to be a shared object to determine the remote object type. This is usually done by ***sharing the interface*** which is used by the server to define the logic and the client to determine the object type and call it


##### Questions
- Can RMI connect 2 remote (different server) JVMs?
	- Yes it can, provide the host and port when getting the registries