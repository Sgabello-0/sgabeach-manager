package com.sgabello.sgabeachmanager.services;

import com.sgabello.sgabeachmanager.modules.Client;
import com.sgabello.sgabeachmanager.services.databasemanagers.DatabaseManager;

import java.util.ArrayList;

public class ClientManager {

    private ArrayList<Client> clients = DatabaseManager.getClientList();
}
