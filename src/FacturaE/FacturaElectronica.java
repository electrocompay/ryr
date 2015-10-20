package FacturaE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLConnection;





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
    
    public String leer(String arg) throws MalformedURLException, IOException{
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
      while((response=in.readLine())!=null)
          System.out.println(response);
      in.close();
        return null;
    }
}
