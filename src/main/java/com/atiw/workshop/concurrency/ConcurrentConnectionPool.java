import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * This implementation of connection pool provides simplified solution for concurrency
 * in connection pool
 */
public class ConcurrentConnectionPool {
    private final int poolSize;
    private final LinkedList<Connection> pool = new LinkedList<>();
    private final Object lock = new Object();

    public Connection getConnection() throws Exception {
        Connection con = null;
        while (true) {
            if (!pool.isEmpty()) {
                synchronized (lock) {
                    if (!pool.isEmpty()) {
                        // Critical
                        con = pool.getFirst();
                        return con;
                    }
                }
            }
            wait();
        }
    }

    public boolean releaseConnection(Connection conn) {
        pool.add(conn);
        lock.notify();
        return true;
    }

    public ConcurrentConnectionPool(int poolSize, String connStr) throws SQLException {
        this.poolSize = poolSize;
        for(int i=0 ; i< poolSize ; i++) {
            pool.add(DriverManager.getConnection(connStr));
        }
    }

}

