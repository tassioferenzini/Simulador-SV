/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.puc_rio.inf.les.med.main;

import br.puc_rio.inf.les.med.generator.GeneratorPatientData;
import static java.lang.Thread.sleep;
import java.util.Random;
import org.apache.log4j.Logger;

/**
 *
 * @author tassio
 */
public class SimuladorSV {

    static Logger logger = Logger.getLogger("Main");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //PatientData Generator
        new Thread(genPatientData).start();

    }

    private static final Runnable genPatientData = new Runnable() {
        @Override
        public void run() {
            long StartTime = System.currentTimeMillis();
            GeneratorPatientData genPD = new GeneratorPatientData();
            try {
                for (int i = 0; i < 1000000; i++) {
                    genPD.PatientData();
                    sleep(fRandom.nextInt(8000));
                }
                System.gc();
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Imports - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
                System.exit(0);
            } catch (InterruptedException ex) {
                logger.error("Error" + ex);
            } catch (Throwable ex) {
                logger.error("Error" + ex);
            }
        }
    };

    private static final Random fRandom = new Random();

}
