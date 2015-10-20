package FacturaE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;





/* Ejemplo de Uso de Interfaz PyAfipWs para JAVA (componentes DLL en Windows)
   con Web Service Autenticación / Factura Electrónica AFIP (mercado interno)
   2014 (C) Mariano Reingart <reingart@gmail.com> Licencia: GPLv3
   
   Requerimientos: 
    * wsaa.py y wsfev1.py registrados (último instalador PyAfipWs homologación)
   
   Dependencias: 
    * JACOB - Java COM Bridge: http://sourceforge.net/projects/jacob-project/
   
   IMPORTANTE: 
    * Renombrar jacob-1.18-M2-x64.dll o jacob-1.18-M2-x86.dll -> jacob.dll
    * Mover jacob.dll al directorio windows\system o junto a esta clase
    * Agregar jacob.jar al CLASSPATH, ej SET CLASSPATH=Z:\ruta\jacob.jar;.
   
   Documentacion: 
    http://www.sistemasagiles.com.ar/trac/wiki/PyAfipWs
    http://www.sistemasagiles.com.ar/trac/wiki/ManualPyAfipWs
*/


public class FacturaElectronica {
    private String valor;
    private String resultado;
    private String respuesta;
    private String cae;
    private String caeVto;
    private String fechaCae;
    private String afipQty;
    private String afipPlastId;
    private String afipPlastCbte;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getCae() {
        return cae;
    }

    public void setCae(String cae) {
        this.cae = cae;
    }

    public String getCaeVto() {
        return caeVto;
    }

    public void setCaeVto(String caeVto) {
        this.caeVto = caeVto;
    }

    public String getFechaCae() {
        return fechaCae;
    }

    public void setFechaCae(String fechaCae) {
        this.fechaCae = fechaCae;
    }

    public String getAfipQty() {
        return afipQty;
    }

    public void setAfipQty(String afipQty) {
        this.afipQty = afipQty;
    }

    public String getAfipPlastId() {
        return afipPlastId;
    }

    public void setAfipPlastId(String afipPlastId) {
        this.afipPlastId = afipPlastId;
    }

    public String getAfipPlastCbte() {
        return afipPlastCbte;
    }

    public void setAfipPlastCbte(String afipPlastCbte) {
        this.afipPlastCbte = afipPlastCbte;
    }
    
    
    
    public Object leer(String arg) throws MalformedURLException, IOException, ParserConfigurationException, SAXException{
        URL url = new URL("https://tufacturaelectronica.net/api/v1/SANDBOX");
        String charSet="UTF-8";
        String tipo="xml";
        String key="NTYyNjI0ODI1OTUwMy0xNTEwMjAwODI0NTA=";
        String idCliente="20229053834";
        String tipoDocumento="80";
        String tipoComprobante="6";
        String importeTotal="121.00";
        String importeNeto="100.00";
        String importeEx="0.0";
        String impuestoLiq="21.00";
        
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        Authenticator au = new Authenticator() {
         @Override
         protected PasswordAuthentication
            getPasswordAuthentication() {
            return new PasswordAuthentication
               ("mauro@bambusoft.com.ar", "SUtter001".toCharArray());
         }
      };
      Authenticator.setDefault(au);
      con.setDoOutput(true);
      con.setRequestMethod("POST");
      
      OutputStreamWriter out=new OutputStreamWriter(
      con.getOutputStream());
      out.write("TYPE="+tipo);
      out.write("&PUBLIC_KEY="+key);
      out.write("&CUSTOMERID="+idCliente);
      out.write("&CUSTOMERTYPEDOC="+tipoDocumento);
      out.write("&TIPO_COMPROBANTE="+tipoComprobante);
      out.write("&IMPORTE_TOTAL="+importeTotal);
      out.write("&IMPORTE_NETO="+importeNeto);
      out.write("&IMP_OP_EX="+importeEx);
      out.write("&IMPTO_LIQ="+impuestoLiq);
      out.close();
      
      BufferedReader in=new BufferedReader(new InputStreamReader(con.getInputStream()));
      String response;
      String cadena="";
      while((response=in.readLine())!=null){
          System.out.println(response);
          cadena=response;
      }
          
                  
      //String cadena=response;
      //in.close();
      FacturaElectronica fE=new FacturaElectronica();
      DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        DocumentBuilder db=dbf.newDocumentBuilder();
        //System.err.println(cadena);
        InputSource archivo=new InputSource();
        
        archivo.setCharacterStream(new StringReader(cadena));
        Document documento=db.parse(archivo);
        //Document documento=db.parse(response);
        documento.getDocumentElement().normalize();
        org.w3c.dom.NodeList nodeLista=documento.getElementsByTagName("AFIP");
        int cantidad=nodeLista.getLength();
        System.out.println("Informacion de conecciones");
        
        for (int s = 0; s < cantidad; s++) {
            
	Node primerNodo = nodeLista.item(s);
	String titulo;
	String autor;
	String hits;
        System.err.println("numero nodo "+s);
        
	if (primerNodo.getNodeType() == Node.ELEMENT_NODE) {

	Element primerElemento = (Element) primerNodo;
        //Configuracion conf=new Configuracion();

	        org.w3c.dom.NodeList primerNombreElementoLista =primerElemento.getElementsByTagName("RESPONSE");
	Element primerNombreElemento =(Element) primerNombreElementoLista.item(0);
	        org.w3c.dom.NodeList primerNombre = primerNombreElemento.getChildNodes();
	 fE.setRespuesta(((Node) primerNombre.item(0)).getNodeValue().toString());
	System.out.println("respuesta : "  + fE.getRespuesta());
        //conf.setNombreConeccion(nombreConeccion);
	        org.w3c.dom.NodeList segundoNombreElementoLista =primerElemento.getElementsByTagName("CAE");
	Element segundoNombreElemento =(Element) segundoNombreElementoLista.item(0);
	        org.w3c.dom.NodeList segundoNombre = segundoNombreElemento.getChildNodes();

	fE.setCae(((Node) segundoNombre.item(0)).getNodeValue().toString());
	System.out.println("cae : "  + fE.getCae());
        //conf.setStringDeUrl(stringDeUrl);
	        org.w3c.dom.NodeList tercerNombreElementoLista =primerElemento.getElementsByTagName("CAE_VTO");
	Element tercerNombreElemento =(Element) tercerNombreElementoLista.item(0);
	        org.w3c.dom.NodeList tercerNombre = tercerNombreElemento.getChildNodes();
    	fE.setCaeVto(((Node) tercerNombre.item(0)).getNodeValue().toString());
	System.out.println("cae vencimiento : "  + fE.getCaeVto());
        //conf.setUsuario(usuario);
        org.w3c.dom.NodeList cuartoNombreElementoLista =primerElemento.getElementsByTagName("FECHA_CAE");
	Element cuartoNombreElemento =(Element) cuartoNombreElementoLista.item(0);
	        org.w3c.dom.NodeList cuartoNombre = cuartoNombreElemento.getChildNodes();
    	fE.setFechaCae(((Node) cuartoNombre.item(0)).getNodeValue().toString());
	System.out.println("fecha cae : "  + fE.getFechaCae());
        //conf.setUsuario(usuario);
        org.w3c.dom.NodeList quintoNombreElementoLista =primerElemento.getElementsByTagName("AFIPQTY");
	Element quintoNombreElemento =(Element) quintoNombreElementoLista.item(0);
	        org.w3c.dom.NodeList quintoNombre = quintoNombreElemento.getChildNodes();
    	fE.setAfipQty(((Node) quintoNombre.item(0)).getNodeValue().toString());
	System.out.println("fecha cae : "  + fE.getAfipQty());
        //conf.setUsuario(usuario);
        org.w3c.dom.NodeList sextoNombreElementoLista =primerElemento.getElementsByTagName("AFIPLASTID");
	Element sextoNombreElemento =(Element) sextoNombreElementoLista.item(0);
	        org.w3c.dom.NodeList sextoNombre = sextoNombreElemento.getChildNodes();
    	fE.setAfipPlastId(((Node) sextoNombre.item(0)).getNodeValue().toString());
	System.out.println("fecha cae : "  + fE.getAfipPlastId());
        //conf.setUsuario(usuario);
        org.w3c.dom.NodeList septimoNombreElementoLista =primerElemento.getElementsByTagName("AFIPLASTCBTE");
	Element septimoNombreElemento =(Element) septimoNombreElementoLista.item(0);
	        org.w3c.dom.NodeList septimoNombre = septimoNombreElemento.getChildNodes();
    	fE.setAfipPlastCbte(((Node) septimoNombre.item(0)).getNodeValue().toString());
	System.out.println("fecha cae : "  + fE.getAfipPlastCbte());
        //conf.setClave(clave);
        //listadoConecciones.add(conf);
	}
        }  
        in.close();
      return fE;
    }
}
