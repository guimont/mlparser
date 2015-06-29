package com.dao;

import com.dao.impl.InfluxDaoImpl;
import com.influxdb.dto.BatchPoints;

/**
 * Created by gmo on 29/06/2015.
 */
public class InfluxDaoConnector {

    private InfluxDao dao;
    static String dbName = "history";

    private InfluxDaoConnector() {
        dao = new InfluxDaoImpl();
        dao.createConnection();
        dao.createDB(dbName);
    }

    private static class InfluxDaoConnectorHolder {
        /** Instance unique non pre-initialise */
        private final static InfluxDaoConnector instance = new InfluxDaoConnector();
    }

    public static InfluxDaoConnector getInstance() {
        return InfluxDaoConnectorHolder.instance;
    }

    public static void writePoints(final BatchPoints batchPoints) {
        getInstance().dao.getDB().write(batchPoints);
    }


    public static BatchPoints getBatchPoints() {
        return BatchPoints
                .database(dbName)
                .tag("async", "true")
                .retentionPolicy("default")
                .build();
    }


}
