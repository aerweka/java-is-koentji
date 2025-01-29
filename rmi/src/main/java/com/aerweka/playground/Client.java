package com.aerweka.playground;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.aerweka.playground.interfaces.MessengerService;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        // with LocateRegistry.getRegistry(), the client will connect to the default port number 1099.
        // Define the port number if the server is running on a different port getRegistry(<port>)
        /**
         * Registry registry = LocateRegistry.getRegistry();
         * MessengerService lookup = (MessengerService) registry.lookup("MessengerService");
         */

        // However, i can use Naming object to lookup the remote object. Basically, Naming object is a wrapper for the Registry object
        // with this single line of code, I have done the same thing as the above line of code
        // the thing is i have to provide the complete url of the remote object to lookup method
        // MessengerService lookup = (MessengerService) Naming.lookup("rmi://192.168.1.16:1099/MessengerService");
        // MessengerService lookup = (MessengerService) Naming.lookup("rmi://localhost:1099/MessengerService");
        // MessengerService lookup = (MessengerService) Naming.lookup("rmi://127.0.0.1:1099/MessengerService");
        // MessengerService lookup = (MessengerService) Naming.lookup("MessengerService");
        MessengerService lookup = (MessengerService) Naming.lookup("//localhost:1099/MessengerService");

        String sendMessage = lookup.sendMessage("Test Hello World");
        String expecteString = "Server Message";
        System.out.println(sendMessage + " == " + expecteString + " ? " + sendMessage.equals(expecteString));
        assert sendMessage.equals(expecteString) : "Expected " + expecteString + " but got " + sendMessage;
    }
}
