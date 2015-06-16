package Remitos;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




import Conversores.Numeros;
import Depositos.RemitosInternos;
import Sucursales.Cajas;
import facturacion.clientes.Clientes;
import interfaceGraficas.Inicio;
import interfacesPrograma.Facturar;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import javax.imageio.ImageIO;
import Articulos.Articulos;




/**
 *
 * @author hernan
 */
public class ImprimirRemitos {

    Font fuente = new Font("Arial", Font.PLAIN, 9);
    Font fuente1=new Font("Arial",Font.BOLD,12);
    Font fuente3 = new Font("Arial", Font.PLAIN, 7);
    Font fuente4 = new Font("Arial", Font.BOLD,7);
    Font fuente5=new Font("Arial",Font.PLAIN,16);
    Font fuente6 = new Font("Arial", Font.BOLD, 9);
    Font fuente7=new Font("Sans Serif", Font.BOLD,7);
    Font fuente8=new Font("Arial",Font.PLAIN,8);
    Font fuente9 = new Font("Arial", Font.BOLD, 5);
    Font fuente10 = new Font("Arial", Font.PLAIN, 6);
    Font fuente11=new Font("Arial",Font.BOLD,11);
	PrintJob pj;	
	Graphics pagina;
	

	/********************************************************************
	*	A continuación el constructor de la clase. Aquí lo único que	*
	*	hago es tomar un objeto de impresion.							*
	********************************************************************/
	public ImprimirRemitos()
	{
		pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "SCAT", null);
               
	}
			
	/********************************************************************
	*	A continuación el método "imprimir(String)", el encargado de 	*
	*	colocar en el objeto gráfico la cadena que se le pasa como 		*
	*	parámetro y se imprime.											*
	********************************************************************/
        

    
    public void ImprimirRemito(Integer idCotizacion) throws IOException{
        Remitable cotizable=new Remitos();
        Remitos cotizacion=new Remitos();
        cotizacion=(Remitos)cotizable.carga(idCotizacion);
        ArrayList listadoDetalle=new ArrayList();
        DetalleRemitos detalleDeCotizacion=new DetalleRemitos();
        Remitable cotiz=new DetalleRemitos();
        listadoDetalle=cotiz.cargarDetalle(cotizacion.getId());
        Clientes cliente=new Clientes();
        Facturar factu=new Clientes();
        cliente=(Clientes)factu.cargarPorCodigoAsignado(cotizacion.getIdCliente());
        Calendar fecha=new GregorianCalendar();
        int dia=fecha.get(Calendar.DAY_OF_MONTH);
        int mes=fecha.get(Calendar.MONTH);
        mes++;
        int ano=fecha.get(Calendar.YEAR);
        int hora=fecha.get(Calendar.HOUR_OF_DAY);
        int minuto=fecha.get(Calendar.MINUTE);
        int segundo=fecha.get(Calendar.SECOND);
        String fec=dia+"/"+mes+"/"+ano;
        String hrs=hora+","+minuto+":"+segundo;
        // formulario izquierdo
        
        pagina = pj.getGraphics();
        try{
        //BufferedImage imagen= ImageIO.read(new File("C://Gestion//imagen//logo.png"));
        //pagina.drawImage(imagen,63,20,174,93,null);
        pagina.setFont(fuente6);
        pagina.setColor(Color.black);
        Double monto=0.00; //caja.getMontoMovimiento()* -1;
        
        pagina.setFont(fuente6);
        pagina.drawString("REMITO N° 001-0000000"+cotizacion.getNumeroDeRemito(), 420,80);
        pagina.drawString("FECHA: "+fec, 420,110);
        //pagina.drawString("ORIGINAL", 420,110);
        pagina.drawString("RAZON SOCIAL: "+cliente.getRazonSocial(),30,185);
        pagina.drawString("C.U.I.T.: "+cliente.getNumeroDeCuit(), 350,185);
        pagina.drawString("DIRECCION: "+cliente.getDireccion(),30,200);
        pagina.drawString("LOCALIDAD: "+cliente.getLocalidad(),350,200);
        pagina.drawString("COND IVA: "+cliente.getCondicionIva(),30,215);
        pagina.drawString("FC: "+cotizacion.getIdComprobante(),350,215);
        
        pagina.drawString("CODIGO",20,250);
        pagina.drawString("DESCRIPCION",160,250);
        pagina.drawString("CANTIDAD", 350,250);
        Double cantidadTotal=0.00;
        int renglon=260;
        Iterator it=listadoDetalle.listIterator();
        String unitario="";
        while(it.hasNext()){
            detalleDeCotizacion=(DetalleRemitos)it.next();
            pagina.drawString(String.valueOf(detalleDeCotizacion.getIdArticulo()),40,renglon);
            pagina.drawString(detalleDeCotizacion.getDescripcionArticulo(),80,renglon);
            pagina.drawString(String.valueOf(detalleDeCotizacion.getCantidadRemitida()),370,renglon);
            cantidadTotal=cantidadTotal + detalleDeCotizacion.getCantidadRemitida();
            renglon=renglon + 10;
        }
        //formulario derecho
        
        //pagina.drawImage(imagen,363,20,174,93,null);
        pagina.drawString("OBSERVACIONES: "+cotizacion.getObservaciones(),40,730);
        pagina.drawString("CANT. TOTAL", 450, 750);
        pagina.drawString(String.valueOf(cantidadTotal),440,760);
        
        pagina.dispose();
        //duplicado
        
         pagina = pj.getGraphics();
        
        //BufferedImage imagen= ImageIO.read(new File("C://Gestion//imagen//logo.png"));
        //pagina.drawImage(imagen,63,20,174,93,null);
        pagina.setFont(fuente6);
        pagina.setColor(Color.black);
        monto=0.00; //caja.getMontoMovimiento()* -1;
        
        pagina.setFont(fuente6);
        pagina.drawString("REMITO N° 001-0000000"+cotizacion.getNumeroDeRemito(), 420,80);
        pagina.drawString("FECHA: "+fec, 420,95);
        pagina.drawString("DUPLICADO", 420,110);
        pagina.drawString("RAZON SOCIAL: "+cliente.getRazonSocial(),30,185);
        pagina.drawString("C.U.I.T.: "+cliente.getNumeroDeCuit(), 350,185);
        pagina.drawString("DIRECCION: "+cliente.getDireccion(),30,200);
        pagina.drawString("LOCALIDAD: "+cliente.getLocalidad(),350,200);
        pagina.drawString("COND IVA: "+cliente.getCondicionIva(),30,215);
        pagina.drawString("FC: "+cotizacion.getIdComprobante(),350,215);
        
        pagina.drawString("CODIGO",20,250);
        pagina.drawString("DESCRIPCION",160,250);
        pagina.drawString("CANTIDAD", 350,250);
        cantidadTotal=0.00;
        renglon=260;
        it=listadoDetalle.listIterator();
        unitario="";
        while(it.hasNext()){
            detalleDeCotizacion=(DetalleRemitos)it.next();
            pagina.drawString(String.valueOf(detalleDeCotizacion.getIdArticulo()),40,renglon);
            pagina.drawString(detalleDeCotizacion.getDescripcionArticulo(),80,renglon);
            pagina.drawString(String.valueOf(detalleDeCotizacion.getCantidadRemitida()),370,renglon);
            cantidadTotal=cantidadTotal + detalleDeCotizacion.getCantidadRemitida();
            renglon=renglon + 10;
        }
        //formulario derecho
        
        //pagina.drawImage(imagen,363,20,174,93,null);
        pagina.drawString("OBSERVACIONES: "+cotizacion.getObservaciones(),40,730);
        pagina.drawString("CANT. TOTAL", 450, 750);
        pagina.drawString(String.valueOf(cantidadTotal),440,760);
        
        pagina.dispose();
        
        //triplicado
        
         pagina = pj.getGraphics();
        
        //BufferedImage imagen= ImageIO.read(new File("C://Gestion//imagen//logo.png"));
        //pagina.drawImage(imagen,63,20,174,93,null);
        pagina.setFont(fuente6);
        pagina.setColor(Color.black);
        monto=0.00; //caja.getMontoMovimiento()* -1;
        
        pagina.setFont(fuente6);
        pagina.drawString("REMITO N° 001-0000000"+cotizacion.getNumeroDeRemito(), 420,80);
        pagina.drawString("FECHA: "+fec, 420,95);
        pagina.drawString("TRIPLICADO", 420,110);
        pagina.drawString("RAZON SOCIAL: "+cliente.getRazonSocial(),30,185);
        pagina.drawString("C.U.I.T.: "+cliente.getNumeroDeCuit(), 350,185);
        pagina.drawString("DIRECCION: "+cliente.getDireccion(),30,200);
        pagina.drawString("LOCALIDAD: "+cliente.getLocalidad(),350,200);
        pagina.drawString("COND IVA: "+cliente.getCondicionIva(),30,215);
        pagina.drawString("FC: "+cotizacion.getIdComprobante(),350,215);
        
        pagina.drawString("CODIGO",20,250);
        pagina.drawString("DESCRIPCION",160,250);
        pagina.drawString("CANTIDAD", 350,250);
        cantidadTotal=0.00;
        renglon=260;
        it=listadoDetalle.listIterator();
        unitario="";
        while(it.hasNext()){
            detalleDeCotizacion=(DetalleRemitos)it.next();
            pagina.drawString(String.valueOf(detalleDeCotizacion.getIdArticulo()),40,renglon);
            pagina.drawString(detalleDeCotizacion.getDescripcionArticulo(),80,renglon);
            pagina.drawString(String.valueOf(detalleDeCotizacion.getCantidadRemitida()),370,renglon);
            cantidadTotal=cantidadTotal + detalleDeCotizacion.getCantidadRemitida();
            renglon=renglon + 10;
        }
        //formulario derecho
        
        //pagina.drawImage(imagen,363,20,174,93,null);
        pagina.drawString("OBSERVACIONES: "+cotizacion.getObservaciones(),40,730);
        pagina.drawString("CANT. TOTAL", 450, 750);
        pagina.drawString(String.valueOf(cantidadTotal),440,760);
        
        pagina.dispose();
        
        pj.end();
        }catch(Exception e)
	{
		System.out.println("LA IMPRESION HA SIDO CANCELADA..."+e);
	}

    }
    					
}//FIN DE LA CLASE Impresora

 

