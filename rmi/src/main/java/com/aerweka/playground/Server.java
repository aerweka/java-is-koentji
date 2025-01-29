package com.aerweka.playground;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.aerweka.playground.interfaces.MessengerService;
import com.aerweka.playground.services.MessengerServiceImpl;

public class Server {
    public static void main(String[] args) throws RemoteException, NotBoundException, AlreadyBoundException {
        MessengerService server = new MessengerServiceImpl();
        // MessengerService stub = (MessengerService) UnicastRemoteObject.exportObject((MessengerService) server, 2001);
        // Remote exportObject = UnicastRemoteObject.exportObject((MessengerService) server, 2001);
        // UnicastRemoteObject.exportObject is to create a stub for the remote object
        // UnicastRemoteObject can be inheretd by the remote object class to create a stub for the remote object;
        // 0 in port number means the system will choose a port number for the server

        Registry registry = LocateRegistry.createRegistry(1099); // default port number for RMI is 1099
        System.out.println("Registry: " + registry);
        registry.bind("MessengerService", server);
    }
}
