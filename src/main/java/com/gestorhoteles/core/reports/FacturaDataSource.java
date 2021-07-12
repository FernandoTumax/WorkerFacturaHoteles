package com.gestorhoteles.core.reports;

import com.gestorhoteles.core.beans.Root;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import java.util.ArrayList;

public class FacturaDataSource implements JRDataSource{

    private ArrayList<Root> lista = null;
    private int index = -1;

    public FacturaDataSource(ArrayList<Root> lista){
        this.lista = lista;
    }

    @Override
    public boolean next() throws JRException {
        return ++index < lista.size();
    }

    @Override
    public Object getFieldValue(JRField campo) throws JRException {
        Object resultado = "";
        if("fechaIngreso".equals(campo.getName())){
            resultado = this.lista.get(index).getFechaIngreso();
        }else if("fechaSalida".equals((campo.getName()))){
            resultado = this.lista.get(index).getFechaSalida();
            }else if("numeroTarjeta".equals((campo.getName()))){
            resultado = this.lista.get(index).getNumeroTarjeta();
        }else if("totalPagar".equals((campo.getName()))){
            resultado = this.lista.get(index).getTotalPagar();
        }
        return resultado;
    }
}
