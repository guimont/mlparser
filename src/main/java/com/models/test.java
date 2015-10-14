package com.models;

import com.dao.InfluxDaoConnector;
import com.influxdb.InfluxDB;
import com.influxdb.InfluxDBFactory;
import com.influxdb.dto.BatchPoints;
import com.influxdb.dto.Point;
import com.models.parser.ParserGeneral;
import com.models.parser.ParserHistory;
import com.models.parser.ScheduleParserGeneral;
import org.joda.time.DateTime;

import com.influxdb.dto.Query;
import com.influxdb.dto.QueryResult;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by gmo on 18/06/2015.
 */
public class test {

    public static void main(String[] args) {

        //ScheduleParserGeneral g = new ScheduleParserGeneral();
        //g.start();


        /*InfluxDB influxDB = InfluxDBFactory.connect("http://127.0.0.1:8086", "root", "root");
        influxDB.ping();
        /*String dbName = "aTimeSeries";
        influxDB.createDatabase(dbName);
        influxDB.deleteDatabase(dbName);*/

        ParserGeneral.loader();
        ParserHistory.loader();
        System.out.println("parsing ok");


        /*QueryResult res =InfluxDaoConnector.getPoints("SELECT * FROM FR0000131708");

        int len = res.getResults().get(0).getSeries().get(0).getValues().size();
        List<Object> l = res.getResults().get(0).getSeries().get(0).getValues().get(len-50);

        System.out.print(l.get(0).toString());

        String  query= "SELECT mean(value) FROM FR0000131708 where time > '" + l.get(0)+"'";
        QueryResult meanQ =InfluxDaoConnector.getPoints(query);

        BatchPoints bp = InfluxDaoConnector.getBatchPoints();

        Point pt = Point.measurement("FR0000131708").time(new DateTime( res.getResults().get(0).getSeries().get(0).getValues().get(len-1).get(0)).getMillis(), TimeUnit.MILLISECONDS)
                .field("mm50",meanQ.getResults().get(0).getSeries().get(0).getValues().get(0).get(1))
                .build();
        bp.point(pt);

        InfluxDaoConnector.writePoints(bp);


        System.out.print(meanQ);*/







    }

}
