package com.htp.hometaskSemaphore.domain;

public class Client {
    private String clientName;

    public Client(String clientName) {
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return clientName != null ? clientName.equals(client.clientName) : client.clientName == null;
    }

    @Override
    public int hashCode() {
        return clientName != null ? clientName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientName='" + clientName + '\'' +
                '}';
    }
}
