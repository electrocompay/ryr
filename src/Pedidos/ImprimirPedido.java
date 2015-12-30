package Pedidos;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import Conversores.Numeros;
import Impresiones.*;
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
import javax.print.attribute.standard.Copies;




/**
 *
 * @author hernan
 */
public class ImprimirPedido {

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
	public ImprimirPedido()
	{
		pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "SCAT",null);
               
	}
			
	/********************************************************************
	*	A continuación el método "imprimir(String)", el encargado de 	*
	*	colocar en el objeto gráfico la cadena que se le pasa como 		*
	*	parámetro y se imprime.											*
	********************************************************************/
        

    
    public void ImprimirOrdenDeTrabajo(Integer idCotizacion) throws IOException{
        Pedable cotizable=new Pedidos();
        Pedidos cotizacion=new Pedidos();
        cotizacion=(Pedidos)cotizable.cargarEncabezadoPedido(idCotizacion);
        ArrayList listadoDetalle=new ArrayList();
        DetallePedidos detalleDeCotizacion=new DetallePedidos();
        Pedable cotiz=new DetallePedidos();
        listadoDetalle=cotiz.cargarDetallePedido(cotizacion.getId());
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
        //new Copies(2);
        pagina = pj.getGraphics();
        
        try{
        //BufferedImage imagen= ImageIO.read(new File("C://Gestion//imagen//logo.png"));
        //pagina.drawImage(imagen,63,20,174,93,null);
        pagina.setFont(fuente6);
        pagina.setColor(Color.black);
        pagina.drawString("PEDIDO N° 00"+Inicio.sucursal.getNumero()+"-000"+cotizacion.getId(),20,20);
        pagina.setFont(fuente);
        pagina.drawString("FECHA IMPRESION:"+fec, 20,30);
        //pagina.drawString(" :"+Inicio.sucursal.getDescripcion(),20,150);
        pagina.drawString("USUARIO :"+Inicio.usuario.getNombre(),320,20);
        pagina.setFont(fuente6);
        Double monto=0.00; //caja.getMontoMovimiento()* -1;
        
        pagina.drawString("RAZON SOCIAL: "+cliente.getRazonSocial(),30,45);
        pagina.drawString("C.U.I.T.: "+cliente.getNumeroDeCuit(), 350,45);
        pagina.drawString("DIRECCION: "+cliente.getDireccion(),30,60);
        
        pagina.drawString("LOCALIDAD: "+cliente.getLocalidad(),350,60);
        pagina.drawString("COND IVA: "+cliente.getCondicionIva(),30,75);
        pagina.setFont(fuente);
        pagina.drawString("CODIGO",20,90);
        pagina.drawString("DESCRIPCION",100,90);
        pagina.drawString("CANTIDAD", 350,90);
        int renglon=100;
        Iterator it=listadoDetalle.listIterator();
        while(it.hasNext()){
            detalleDeCotizacion=(DetallePedidos)it.next();
            pagina.drawString(String.valueOf(detalleDeCotizacion.getIdArticulo()),40,renglon);
            pagina.drawString(detalleDeCotizacion.getDescripcionArticulo(),80,renglon);
            pagina.drawString(String.valueOf(detalleDeCotizacion.getCantidad()),370,renglon);
            renglon=renglon + 10;
        }
        //formulario derecho
        
        //pagina.drawImage(imagen,363,20,174,93,null);
        
        
        pagina.dispose();
        pj.end();
        }catch(Exception e)
	{
		System.out.println("LA IMPRESION HA SIDO CANCELADA..."+e);
	}

    }
    public void ImprimirOrdenDetallada(Pedidos idCotizacion) throws IOException{
        Pedable cotizable=new Pedidos();
        Pedidos cotizacion=new Pedidos();
        cotizacion=(Pedidos)idCotizacion;
        ArrayList listadoDetalle=new ArrayList();
        DetallePedidos detalleDeCotizacion=new DetallePedidos();
        Pedable cotiz=new DetallePedidos();
        listadoDetalle=cotiz.cargarDetallePedido(cotizacion.getId());
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
        pagina.drawString("PEDIDO N° 00"+Inicio.sucursal.getNumero()+"-000"+cotizacion.getId(),20,110);
        pagina.setFont(fuente);
        pagina.drawString("FECHA IMPRESION:"+fec, 20,120);
        //pagina.drawString(" :"+Inicio.sucursal.getDescripcion(),20,150);
        pagina.drawString("USUARIO :"+Inicio.usuario.getNombre(),320,110);
        pagina.setFont(fuente6);
        Double monto=0.00; //caja.getMontoMovimiento()* -1;
        
        pagina.drawString("RAZON SOCIAL: "+cliente.getRazonSocial(),30,185);
        pagina.drawString("C.U.I.T.: "+cliente.getNumeroDeCuit(), 350,185);
        pagina.drawString("DIRECCION: "+cliente.getDireccion(),30,200);
        
        pagina.drawString("LOCALIDAD: "+cliente.getLocalidad(),350,200);
        pagina.drawString("COND IVA: "+cliente.getCondicionIva(),30,215);
        pagina.setFont(fuente);
        pagina.drawString("CODIGO",20,250);
        pagina.drawString("DESCRIPCION",100,250);
        pagina.drawString("CANTIDAD", 350,250);
        pagina.drawString("PRECIO U",400,250);
        pagina.drawString("PRECIO",450,250);
        int renglon=260;
        Iterator it=listadoDetalle.listIterator();
        Double generalT=0.00;
        while(it.hasNext()){
            detalleDeCotizacion=(DetallePedidos)it.next();
            pagina.drawString(String.valueOf(detalleDeCotizacion.getIdArticulo()),40,renglon);
            pagina.drawString(detalleDeCotizacion.getDescripcionArticulo(),80,renglon);
            pagina.drawString(String.valueOf(detalleDeCotizacion.getCantidad()),370,renglon);
            pagina.drawString(Numeros.ConvertirNumero(detalleDeCotizacion.getPrecioUnitario() * 1.21),410,renglon);
            Double total=detalleDeCotizacion.getCantidad() * (detalleDeCotizacion.getPrecioUnitario() * 1.21);
            generalT=generalT + total;
            pagina.drawString(Numeros.ConvertirNumero(total),460,renglon);
            renglon=renglon + 10;
        }
        renglon=renglon + 10;
        pagina.setFont(fuente1);
        pagina.drawString("TOTAL: "+String.valueOf(generalT),40,renglon);
        //formulario derecho
        
        //pagina.drawImage(imagen,363,20,174,93,null);
        
        
        pagina.dispose();
        pj.end();
        }catch(Exception e)
	{
		System.out.println("LA IMPRESION HA SIDO CANCELADA..."+e);
	}

    }					
}//FIN DE LA CLASE Impresora

 

