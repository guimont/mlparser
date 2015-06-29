package com.models;

import com.influxdb.InfluxDB;
import com.influxdb.InfluxDBFactory;
import com.models.parser.ParserGeneral;
import com.models.parser.ParserHistory;
import com.models.parser.ScheduleParserGeneral;
import org.joda.time.DateTime;

/**
 * Created by gmo on 18/06/2015.
 */
public class test {

    public static void main(String[] args) {

        //ScheduleParserGeneral g = new ScheduleParserGeneral();
        //g.start();

        /*InfluxDB influxDB = InfluxDBFactory.connect("http://127.0.0.1:8086", "root", "root");
        String dbName = "aTimeSeries";
        influxDB.createDatabase(dbName);
        influxDB.deleteDatabase(dbName);*/

        ParserGeneral.loader();
        ParserHistory.loader();

        try {
            Thread.sleep(400000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }





    }

}
