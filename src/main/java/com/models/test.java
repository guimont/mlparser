package com.models;

import com.dao.InfluxDaoConnector;
import com.influxdb.InfluxDB;
import com.influxdb.InfluxDBFactory;
import com.models.parser.ParserGeneral;
import com.models.parser.ParserHistory;
import com.models.parser.ScheduleParserGeneral;
import org.joda.time.DateTime;

import com.influxdb.dto.Query;
import com.influxdb.dto.QueryResult;

import java.util.ArrayList;

/**
 * Created by gmo on 18/06/2015.
 */
public class test {

    public static void main(String[] args) {

        //ScheduleParserGeneral g = new ScheduleParserGeneral();
        //g.start();

        InfluxDB influxDB = InfluxDBFactory.connect("http://127.0.0.1:8086", "root", "root");
        /*String dbName = "aTimeSeries";
        influxDB.createDatabase(dbName);
        influxDB.deleteDatabase(dbName);

        ParserGeneral.loader();
        ParserHistory.loader();
System.out.println("parsing ok");*/


        QueryResult res =InfluxDaoConnector.getPoints("SELECT * FROM FR0000131708");

        int len = res.getResults().size();
        Object l = res.getResults().get(0).getSeries().get(0).getValues().get(len).get(0);



        System.out.print(l);







    }

}
