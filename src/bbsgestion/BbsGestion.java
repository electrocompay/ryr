/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bbsgestion;

import Compras.Remitos;
import Configuracion.Propiedades;
import Sucursales.Usuarios;
import interfaceGraficas.Inicio;
import interfaceGraficas.LoguinBbsGestion;
import interfaces.Comprobable;
import interfaces.Transaccionable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import objetos.ConeccionLocal;
import objetos.Conecciones;

/**
 *
 * @author mauro
 */
public class BbsGestion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        /*
        ArrayList usuariosList=new ArrayList();
        Usuarios usuarios=new Usuarios();
        usuariosList=usuarios.listarUsuario();
        */
        File folder=new File("C:\\GestionRyR");
        File archivos=new File("C:\\Informes");
        File bases=new File("C:\\GestionRyR\\DB");
        File configuracion=new File("Configuracion");
        //File imagenes=new File("C:\\Gestion\\imagenes\\saynomore.jpg");
        File bk;
        //FileInputStream fregis = new FileInputStream("C:\\Users\\mauro\\Pictures\\Camera Uploads\\snm.jpg"); 
        

        File archivo=null;
        FileReader fr=null;
        BufferedReader br=null;
        if(!bases.isDirectory()){
            JOptionPane.showMessageDialog(null,"INICIANDO CONFIGURACION Y CREACION DE LA BASE DE DATOS");
            bases.mkdirs();
            //ConeccionLocal.CrearDb();
            
        }
        if(!folder.isDirectory()){
            //System.out.println("EXISTE EL DIRECTORIO");
            folder.mkdirs();
        }else{
            //System.out.println("NOOOOOOOOOOOOOOO EXISTE EL DIRECTORIO");
            
        }
        if(!archivos.isDirectory())archivos.mkdirs();
        if(!configuracion.isDirectory())configuracion.mkdirs();
        /*
        if(!imagenes.isFile()){
            //imagenes.mkdirs();
            FileOutputStream fsalida = new FileOutputStream("C:\\Gestion\\imagenes\\saynomore.jpg", true); 
        int b = fregis.read(); 
        while (b != -1) { 
        fsalida.write(b); 
        b = fregis.read(); 

        } 
        
        fsalida.flush(); 
        fsalida.close();
         
       
            
        }
          
        fregis.close();
        */
        bk=new File("C:\\Gestion\\backUp.sql");
        //String sql="select * from movimientoscaja into outfile "+bk+" FIELDS TERMINATED BY ';' OPTIONALLY ENCLOSED BY '\"' LINES TERMINATED BY '\n\r'";
       // Transaccionable tra=new Conecciones();
        //tra.guardarRegistro(sql);
        
        try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File ("C:\\Gestion\\erroresDeConeccion.txt");
         if(archivo.exists()){
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
 
         // Lectura del fichero
         String linea;
          //Transaccionable tra=new Conecciones();
         while((linea=br.readLine())!=null){
             
            //System.out.println(linea);
           
           // if(tra.guardarRegistro(linea));
      }
        }
        }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
         }
          File archivo1=null;
        
         archivo = new File ("C:\\Gestion\\idEquipo.txt");
        try {
            /*
            if(archivo1.exists()){
            fr = new FileReader (archivo1);
            br = new BufferedReader(fr);
            
            Lectura del fichero
            Integer numeroEquipo;
            String linea;
            String host;
            String usuario;
            String clv;
            int a=0;
            Transaccionable tra=new Conecciones();
            while((linea=br.readLine())!=null){
            a++;
            System.out.println("Equipo Numero :"+linea);
            switch (a){
            case 1:
            numeroEquipo=Integer.parseInt(linea);
            break;
            case 2:
            host=linea;
            break;
            case 3:
            usuario=linea;
            break;
            case 4:
            clv=linea;
            break;
            }
           
            if(tra.guardarRegistro(linea));
            }
            }
            */
            Propiedades.CargarPropiedades();
        } catch (ParseException ex) {
            Logger.getLogger(BbsGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        LoguinBbsGestion lBb=new LoguinBbsGestion();
        lBb.setVisible(true);
        lBb.pack();
    }
}
