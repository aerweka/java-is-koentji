package com.aerweka.playground.services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.aerweka.playground.interfaces.MessengerService;

public class MessengerServiceImpl extends UnicastRemoteObject implements MessengerService{
    public MessengerServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String sendMessage(String message) {
        // RemoteException is not defined because it is reseved for RMI to raise communications error to the client. Not for the implementation error
        return "Test Hello World".equals(message) ? "Server Message" : null;
    }

    public String unexposedMethod() {
        // any additional methods defined in the service implementation (remote object) are not exposed to the clientq
        return "This method is not exposed to the client";
    }
}
