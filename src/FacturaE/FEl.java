package FacturaE;

import Configuracion.Propiedades;
import Conversores.Numeros;
import facturacion.clientes.Clientes;
import facturacion.clientes.Facturable;
import facturacion.clientes.MovimientoProveedores;
import interfaces.Transaccionable;
import interfacesPrograma.Facturar;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import objetos.Comprobantes;
import objetos.Conecciones;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;






public class FEl implements FacturableE{
    private String valor;
    private String resultado;
    private String respuesta;
    private String cae;
    private String caeVto;
    private String fechaCae;
    private String afipQty;
    private String afipPlastId;
    private String afipPlastCbte;
    private Integer id;
    private Integer idFactura;
    private Integer idCliente;
    private String fecha;
    private String customerId;
    private String customerTypeDoc;
    private String tipoComprobante;
    private String importeTotal;
    private String importeNeto;
    private String impuestoLiquido;
    private String condVta;
    private Integer estado;

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    
    public String getCondVta() {
        return condVta;
    }

    public void setCondVta(String condVta) {
        this.condVta = condVta;
    }

    
    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerTypeDoc() {
        return customerTypeDoc;
    }

    public void setCustomerTypeDoc(String customerTypeDoc) {
        this.customerTypeDoc = customerTypeDoc;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(String importeTotal) {
        this.importeTotal = importeTotal;
    }

    public String getImporteNeto() {
        return importeNeto;
    }

    public void setImporteNeto(String importeNeto) {
        this.importeNeto = importeNeto;
    }

    public String getImpuestoLiquido() {
        return impuestoLiquido;
    }

    public void setImpuestoLiquido(String impuestoLiquido) {
        this.impuestoLiquido = impuestoLiquido;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
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
    
    
    
    public Object leer(Object comp) throws MalformedURLException, IOException, ParserConfigurationException, SAXException, InterruptedException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object recuperar(Object Fe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer guardar(Object Fe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object modificar(Object Fe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listarPorEstado(Integer estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object cargar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel mostrarListado(ArrayList listadoC) {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object reEnviar(Object fe) {
        FEl fE=new FEl();
            fE=(FEl)fe;
        try {
            
            URL url = new URL("https://tufacturaelectronica.net/api/v1/SANDBOX");
            String charSet="UTF-8";
            String tipo="xml";
            String key="NTYyNjI0ODI1OTUwMy0xNTEwMjAwODI0NTA=";
            //String cuit=compro;
            Integer tipDocumento=0;
            Integer tipComprobante=0;
            
            String idCliente=fE.getCustomerId();
            
            String tipoDocumento=fE.getCustomerTypeDoc();
            
            String tipoComprobante=fE.getTipoComprobante();
            String importeTotal=fE.getImporteTotal();
            String importeNeto=fE.getImporteNeto();
            String importeEx="0.0";
            String impuestoLiq=fE.getImpuestoLiquido();
            
            
            HttpURLConnection con;
            
                con = (HttpURLConnection)url.openConnection();
            
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
            try{
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
                        System.out.println("afipqty : "  + fE.getAfipQty());
                        //conf.setUsuario(usuario);
                        org.w3c.dom.NodeList sextoNombreElementoLista =primerElemento.getElementsByTagName("AFIPLASTID");
                        Element sextoNombreElemento =(Element) sextoNombreElementoLista.item(0);
                        org.w3c.dom.NodeList sextoNombre = sextoNombreElemento.getChildNodes();
                        fE.setAfipPlastId(((Node) sextoNombre.item(0)).getNodeValue().toString());
                        System.out.println("afipplastid : "  + fE.getAfipPlastId());
                        //conf.setUsuario(usuario);
                        org.w3c.dom.NodeList septimoNombreElementoLista =primerElemento.getElementsByTagName("AFIPLASTCBTE");
                        Element septimoNombreElemento =(Element) septimoNombreElementoLista.item(0);
                        org.w3c.dom.NodeList septimoNombre = septimoNombreElemento.getChildNodes();
                        fE.setAfipPlastCbte(((Node) septimoNombre.item(0)).getNodeValue().toString());
                        System.out.println("afipplastcbte : "  + fE.getAfipPlastCbte());
                        //conf.setClave(clave);
                        //listadoConecciones.add(conf);
                    }
                }
                in.close();
            }catch(java.net.UnknownHostException ex){
                Logger.getLogger(FEl.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("En factura electronica: "+ex);
                fE.setRespuesta("ERROR");
            }catch(java.lang.NullPointerException ey){
                Logger.getLogger(FEl.class.getName()).log(Level.SEVERE, null, ey);
                System.err.println("Parametros invalidos: "+ey);
                fE.setRespuesta("PARAMETROS");
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(FEl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(FEl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(FEl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FEl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fE;
        
    }

    @Override
    public void eliminar(Object fe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String reimprimir(Object fe) {
        FEl fE=new FEl();
        fE=(FEl)fe;
        pdfsJavaGenerador pdf=new pdfsJavaGenerador();
        Clientes cliente=new Clientes();
        Facturar fac=new Clientes();
        cliente=(Clientes)fac.cargarPorCodigoAsignado(fE.getIdCliente());
        pdf.setCliente(cliente);
        pdf.setDoc(fE);
        pdf.run();
        return null;
        
    }

    @Override
    public String imprimir(Object fe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
