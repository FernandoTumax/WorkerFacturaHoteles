package com.gestorhoteles.core.reports;

import com.gestorhoteles.core.beans.Root;
import com.gestorhoteles.core.db.Conexion;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerarReporte {

    private static GenerarReporte instances = null;

    public static GenerarReporte getInstances(){
        if(instances == null){
            instances = new GenerarReporte();
        }
        return instances;
    }

    public GenerarReporte(){

    }

    public void generar(String idReservacion) {
        String sourceFileName =
                "C:\\Users\\ferna\\IdeaProjects\\WorkerGestorHoteles\\src\\main\\java\\com\\gestorhoteles\\core\\reports\\FacturaGestorHoteles.jasper";
        Map parameters = new HashMap();
        parameters.put("SUBREPORT_DIR", "C:\\Users\\ferna\\IdeaProjects\\WorkerGestorHoteles\\src\\main\\java\\com\\gestorhoteles\\core\\reports");
        parameters.put("_idReservacion", idReservacion);
        try {
            JasperExportManager.exportReportToPdfFile(JasperFillManager.fillReportToFile(
                    sourceFileName, parameters, Conexion.getInstancia().getConexion()),
                     "C:\\Reporte\\FacturacionGestorHoteles" + ".pdf");
            ;
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

}
