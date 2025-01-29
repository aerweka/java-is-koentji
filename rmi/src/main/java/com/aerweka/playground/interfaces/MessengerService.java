package com.aerweka.playground.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MessengerService extends Remote {
    String sendMessage(String message) throws RemoteException;
}