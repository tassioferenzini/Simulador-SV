/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.puc_rio.inf.les.med.generator;

import br.puc_rio.inf.les.med.dao.TbPatientDataDAO;
import br.puc_rio.inf.les.med.model.TbMonitoringHasSensor;
import br.puc_rio.inf.les.med.model.TbPatientData;
import static java.lang.Thread.sleep;
import java.sql.Timestamp;
import java.util.Random;
import org.apache.log4j.Logger;

/**
 *
 * @author tassio
 */
public class GeneratorPatientData {

    Logger logger = Logger.getLogger("Functions");

    public void PatientData() throws InterruptedException {
        logger.trace("Initiating the patient data simulation method");

        TbMonitoringHasSensor mhs = new TbMonitoringHasSensor();
        mhs.setPkId(1);

        TbPatientData pd = new TbPatientData();
        pd.setFkMonitoringHasSensorId(mhs);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        pd.setDtmTimestamp(timestamp);
        double MEAN = 37.0f;
        double VARIANCE = 1.0f;
        pd.setStrValue(getValue(MEAN, VARIANCE));

        TbPatientDataDAO.getInstance().save(pd);

        Thread.sleep(fRandom.nextInt(10000));

        TbMonitoringHasSensor mhs2 = new TbMonitoringHasSensor();
        mhs2.setPkId(2);

        TbPatientData pd2 = new TbPatientData();
        pd2.setFkMonitoringHasSensorId(mhs2);
        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
        pd2.setDtmTimestamp(timestamp2);
        double MEAN2 = 12.0f;
        double VARIANCE2 = 3.0f;
        pd2.setStrValue(getValue(MEAN2, VARIANCE2));

        TbPatientDataDAO.getInstance().save(pd2);

        sleep(fRandom.nextInt(10000));

        TbMonitoringHasSensor mhs3 = new TbMonitoringHasSensor();
        mhs3.setPkId(3);

        TbPatientData pd3 = new TbPatientData();
        pd3.setFkMonitoringHasSensorId(mhs3);
        Timestamp timestamp3 = new Timestamp(System.currentTimeMillis());
        pd3.setDtmTimestamp(timestamp3);
        double MEAN3 = 80.0f;
        double VARIANCE3 = 25.0f;
        pd3.setStrValue(getValue(MEAN3, VARIANCE3));

        TbPatientDataDAO.getInstance().save(pd3);

        logger.trace("Finalizing the patient data simulation method");
    }

    private final Random fRandom = new Random();

    private String getValue(double aMean, double aVariance) {
        return Double.toString(aMean + fRandom.nextGaussian() * aVariance);
    }
}
