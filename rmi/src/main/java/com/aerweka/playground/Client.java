package com.aerweka.playground;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.aerweka.playground.interfaces.MessengerService;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        // with LocateRegistry.getRegistry(), the client will connect to the default port number 1099.
        // Define the port number if the server is running on a different port getRegistry(<port>)
        Registry registry = LocateRegistry.getRegistry();
        System.out.println("Registry: " + registry);
        MessengerService lookup = (MessengerService) registry.lookup("MessengerService");
        String sendMessage = lookup.sendMessage("Test Hello World");
        String expecteString = "Server Message";
        System.out.println(sendMessage + " == " + expecteString + " : " + sendMessage.equals(expecteString));
        assert sendMessage.equals(expecteString) : "Expected " + expecteString + " but got " + sendMessage;
    }
}
