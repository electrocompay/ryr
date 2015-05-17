/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cotizaciones;

import Conversores.Numeros;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import facturacion.clientes.Clientes;
import interfaceGraficas.Inicio;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mauro di
 */
public class pdfsJavaGenerador {
    private Cotizacion doc=new Cotizacion();
    private Clientes cliente=new Clientes();

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
    
    
    public void setDoc(Cotizacion doc) {
        this.doc = doc;
    }
    
    
    
    public void run(){
        Document documento=new Document();
        int i=1;
        String arch=doc.getIdCliente()+"_"+doc.getId()+"_Cotizacion.pdf";
        
        
        File fich=new File(arch);
        while(fich.exists()){
            i++;
            arch=doc.getIdCliente()+"_"+doc.getId()+i+"_Cotizacion.pdf";
            fich=new File(arch);
        }
        FileOutputStream fichero;
        try {
            DetalleCotizacion saldo=new DetalleCotizacion();
            Cotizable cotizable=new DetalleCotizacion();
            ArrayList listado=new ArrayList();
            listado=cotizable.cargarDetalle(doc.getId());
            fichero=new FileOutputStream(arch);
            PdfWriter writer=PdfWriter.getInstance(documento, fichero);
            documento.open();
            PdfContentByte cb=writer.getDirectContent();
            BaseFont bf = BaseFont.createFont(BaseFont.COURIER_BOLD,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
            cb.setFontAndSize(bf,16);
            cb.beginText();
            cb.setTextMatrix(100,750);
            cb.showText("eR&Re");
            
            cb.setFontAndSize(bf,10);
            cb.setTextMatrix(100, 740);
            cb.showText("PAPELES");
            bf = BaseFont.createFont(BaseFont.COURIER,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
            cb.setFontAndSize(bf,8);
            cb.setTextMatrix(40,720);
            cb.showText("de Rivadeneira Enrique y Rivadeneira Jorge S.H.");
            bf = BaseFont.createFont(BaseFont.COURIER_BOLD,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
            cb.setFontAndSize(bf,14);
            cb.setTextMatrix(300,750);
            cb.showText("COTIZACION N°: "+doc.getId());
            bf = BaseFont.createFont(BaseFont.COURIER,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
            cb.setFontAndSize(bf,10);
            cb.setTextMatrix(40,690);
            cb.showText("Razon Social :"+cliente.getRazonSocial());
            cb.setTextMatrix(410,690);
            cb.showText("Fecha "+Numeros.ConvertirFecha(doc.getFecha()));
            cb.setTextMatrix(40,670);
            cb.showText("Direccion: "+cliente.getDireccion());
            cb.setTextMatrix(380,670);
            cb.showText("Mail :"+cliente.getCelular());
            cb.setTextMatrix(40,650);
            cb.showText("Telefono: "+cliente.getTelefono());
            cb.setTextMatrix(380,650);
            cb.showText("Cuit: "+cliente.getNumeroDeCuit());
            
            int renglon=610;
            String vencimiento;
            String descripcion;
            String monto;
            String recargo;
            String total;
            String totalFinal;
            Double tot=0.00;
            //aca empieza la iteracion
            
            //encabezados
            bf = BaseFont.createFont(BaseFont.COURIER_BOLD,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
            cb.setFontAndSize(bf,10);
            cb.setTextMatrix(40,renglon);
                cb.showText("COD");
                cb.setTextMatrix(70,renglon);
                cb.showText("DESCRIPCION");
                cb.setTextMatrix(330,renglon);
                cb.showText("P. UNIT.");
                cb.setTextMatrix(380,renglon);
                cb.showText("CANT.");
                cb.setTextMatrix(440,renglon);
                //tot=saldo.getCantidad() * saldo.getPrecioUnitario();
                cb.showText("TOTAL");
                renglon=renglon - 20;
            
            //fin encabezados
            bf = BaseFont.createFont(BaseFont.COURIER,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
            cb.setFontAndSize(bf,10);
            Iterator itl=listado.listIterator();
            vencimiento="Esta cotización tendrá vigencia 30 días ";
            while(itl.hasNext()){
                saldo=(DetalleCotizacion)itl.next();
                //vencimiento=saldo.getVencimientoString();
                
                descripcion="Numero Resumen de cta ";
                monto=Numeros.ConvertirNumero(saldo.getPrecioUnitario());
                recargo="10%";
                total="nada";
                //recargo=String.valueOf(saldo.getRecargo());
                //tot=tot + saldo.getTotal();
                //total=String.valueOf(saldo.getTotal());
                cb.setTextMatrix(40,renglon);
                cb.showText(String.valueOf(saldo.getIdArticulo()));
                cb.setTextMatrix(70,renglon);
                cb.showText(saldo.getDescripcionArticulo());
                cb.setTextMatrix(330,renglon);
                cb.showText(monto);
                cb.setTextMatrix(380,renglon);
                cb.showText(String.valueOf(saldo.getCantidad()));
                cb.setTextMatrix(440,renglon);
                tot=saldo.getCantidad() * saldo.getPrecioUnitario();
                tot=tot * 1.21;
                cb.showText(Numeros.ConvertirNumero(tot));
                renglon=renglon - 20;
                
            }
            totalFinal=Numeros.ConvertirNumero(doc.getTotal());
            cb.setTextMatrix(380,renglon);
            cb.showText("TOTAL "+totalFinal);
            
            //pie de documento
            renglon=renglon - 60;
            cb.setTextMatrix(40,renglon);
            cb.showText(vencimiento);
            cb.endText();
            documento.close();
            
            File f=new File(arch);
            if(f.exists()){
            
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+arch);
            }
            int confirmacion=0;
            /*
            if(doc.getArchivo().isEmpty()){
                
            }else{
                confirmacion=JOptionPane.showConfirmDialog(null, "DESEA NOTIFICAR POR MAIL?");
            if(confirmacion==0){
                //JOptionPane.showMessageDialog(null,"acepto");
                
            }
            }
                    */
            System.out.println("eligio "+confirmacion);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(pdfsJavaGenerador.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (DocumentException ex) {
            Logger.getLogger(pdfsJavaGenerador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(pdfsJavaGenerador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
