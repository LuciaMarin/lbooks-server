package net.ausiasmarch.connection;

public class ConnectionFactory {

    public static ConnectionInterface getConnection() {
        return new BoneCPImplementation();
    }
}
