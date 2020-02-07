package net.ausiasmarch.connection;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;
import java.sql.Connection;
import java.sql.SQLException;

public class BoneCPImplementation implements ConnectionInterface {

    private BoneCP connectionPoolBoneCP = null;

    @Override
    public Connection newConnection() throws SQLException {

        BoneCPConfig boneCPConfig = new BoneCPConfig();

        boneCPConfig.setJdbcUrl(ConnectionSettings.getURL());
        boneCPConfig.setUsername(ConnectionSettings.getUsername());
        boneCPConfig.setPassword(ConnectionSettings.getPassword());

        connectionPoolBoneCP = new BoneCP(boneCPConfig);
        return connectionPoolBoneCP.getConnection();
    }

    @Override
    public void disposeConnection() {
        if (connectionPoolBoneCP != null) {
            connectionPoolBoneCP.close();
        }
    }
}
