/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FacturaE;

import Conversores.NumberToLetterConverter;
import Conversores.Numeros;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import facturacion.clientes.Clientes;
import facturacion.clientes.DetalleFacturas;
import facturacion.clientes.Facturable;
import facturacion.clientes.Facturas;
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
    private FacturaElectronica doc=new FacturaElectronica();
    private Clientes cliente=new Clientes();

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
    
    
    public void setDoc(FacturaElectronica doc) {
        this.doc = doc;
    }
    
    
    
    public void run(){
        Document documento=new Document();
        int i=1;
        String arch=doc.getIdCliente()+"_"+doc.getAfipPlastCbte()+"_factura.pdf";
        
        
        File fich=new File(arch);
        while(fich.exists()){
            i++;
            arch=doc.getIdCliente()+"_"+doc.getAfipPlastCbte()+i+"_factura.pdf";
            fich=new File(arch);
        }
        FileOutputStream fichero;
        Facturas factura=new Facturas();
        Facturable fac=new Facturas();
        factura=(Facturas)fac.cargarIdFactura(doc.getIdFactura());
        try {
            DetalleFacturas saldo=new DetalleFacturas();
            Facturable cotizable=new DetalleFacturas();
            ArrayList listado=new ArrayList();
            listado=cotizable.cargarDetallefactura(doc.getIdFactura());
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
            Integer comF=Integer.parseInt(doc.getTipoComprobante());
            switch (comF){
                case 1:
                    cb.showText("FACTURA A N°: "+doc.getAfipPlastCbte());
                    break;
                case 2:
                    cb.showText("NTA DE DEBITO A N°: "+doc.getAfipPlastCbte());
                    break;
                case 3:
                    cb.showText("NTA DE CREDITO A N°: "+doc.getAfipPlastCbte());
                    break;
                case 6:
                    cb.showText("FACTURA B N°: "+doc.getAfipPlastCbte());
                    break;
                case 7:
                    cb.showText("NTA DE DEBITO B N°: "+doc.getAfipPlastCbte());
                    break;
                case 8:
                    cb.showText("NTA DE CREDITO B N°: "+doc.getAfipPlastCbte());
                    break;
            }
            
            bf = BaseFont.createFont(BaseFont.COURIER,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
            cb.setFontAndSize(bf,10);
            cb.setTextMatrix(40,690);
            cb.showText("Razon Social :"+cliente.getRazonSocial());
            cb.setTextMatrix(410,690);
            cb.showText("Fecha "+doc.getFechaCae());
            cb.setTextMatrix(40,670);
            cb.showText("Direccion: "+cliente.getDireccion());
            cb.setTextMatrix(380,670);
            cb.showText("Mail :"+cliente.getCelular());
            cb.setTextMatrix(40,650);
            cb.showText("Telefono: "+cliente.getTelefono());
            cb.setTextMatrix(380,650);
            Integer tipo=Integer.parseInt(String.valueOf(doc.getCustomerTypeDoc()));
            switch (tipo){
                case 80:
                    cb.showText("Cuit: "+doc.getCustomerId());
                    break;
                case 86:
                    cb.showText("Cuil: "+doc.getCustomerId());
                    break;
                case 96:
                    cb.showText("Dni: "+doc.getCustomerId());
                    break;
            }
            
            
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
                cb.setTextMatrix(350,renglon);
                cb.showText("CANT.");
                cb.setTextMatrix(420,renglon);
                cb.showText("P. UNIT.");
                renglon=renglon - 20;
            
            //fin encabezados
            bf = BaseFont.createFont(BaseFont.COURIER,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
            cb.setFontAndSize(bf,10);
            Iterator itl=listado.listIterator();
            vencimiento="C.A.E.: "+doc.getCae()+"    C.A.E. vencimiento: "+doc.getCaeVto();
            while(itl.hasNext()){
                saldo=(DetalleFacturas)itl.next();
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
                cb.setTextMatrix(350,renglon);
                cb.showText(String.valueOf(saldo.getCantidad()));
                tot=saldo.getCantidad() * saldo.getPrecioUnitario();
                tot=tot * 1.21;
                cb.setTextMatrix(420,renglon);
                cb.showText(String.valueOf(tot));
                //cb.setTextMatrix(440,renglon);
                
                //cb.showText(Numeros.ConvertirNumero(tot));
                renglon=renglon - 20;
                
            }
            
            renglon=renglon - 40;
            String totalF=Numeros.ConvertirNumero(factura.getTotal());
            String letras=NumberToLetterConverter.convertNumberToLetter(factura.getTotal());
            cb.setTextMatrix(40,renglon);
            cb.showText("SON PESOS: "+letras);
            renglon=renglon -20;
            
            
            if(comF==1 || comF==2 || comF==3){
                cb.setTextMatrix(40,renglon);
            Double sub=factura.getTotal() / 1.21;
            Double iva=factura.getTotal() - sub;
            cb.showText("SUBTOTAL: "+Numeros.ConvertirNumero(sub));
            cb.setTextMatrix(200,renglon);
            cb.showText("IVA 21 %: "+Numeros.ConvertirNumero(iva));
            }else{
                cb.setTextMatrix(40,renglon);
            Double sub=factura.getTotal() / 1.21;
            Double iva=factura.getTotal() - sub;
            cb.showText("SUBTOTAL: "+totalF);
            }
            cb.setTextMatrix(340,renglon);
            cb.showText("TOTAL: "+totalF);
            
            /*
            totalFinal=doc.getImporteTotal();
            renglon=renglon - 20;
            cb.setTextMatrix(380,renglon);
            cb.showText("TOTAL NETO"+totalFinal);
            */
            
            //pie de documento
            renglon=renglon - 20;
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
