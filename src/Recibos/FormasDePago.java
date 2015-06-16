/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recibos;

import interfaceGraficas.Inicio;
import interfaces.Transaccionable;
import java.sql.ResultSet;
import objetos.Conecciones;

/**
 *
 * @author mauro di
 */
public class FormasDePago implements Formable{
    private Integer id;
    private String descripcion;
    private Double monto;
    private String banco;
    private String numero;
    private String vencimiento;
    private Integer idRecibo;
    private Integer idCliente;
    private static Transaccionable tra=new Conecciones();
    private static ResultSet rs;
    private String sql;

    public Integer getIdRecibo() {
        return idRecibo;
    }

    public void setIdRecibo(Integer idRecibo) {
        this.idRecibo = idRecibo;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }


    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }
    

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public Boolean guardarCheques(Object listado) {
        FormasDePago forma=new FormasDePago();
        forma=(FormasDePago)listado;
        sql="insert into cheques (banco,idcliente,monto,vencimiento,numero,idrecibo) values ('"+forma.getBanco()+"',"+forma.getIdCliente()+","+forma.getMonto()+",'"+forma.getVencimiento()+"',"+forma.getNumero()+","+forma.getIdRecibo()+")";
        tra.guardarRegistro(sql);
        return true;
    }

    @Override
    public Boolean guardarEfectivo(Object listado) {
        FormasDePago forma=new FormasDePago();
        forma=(FormasDePago)listado;
        sql="insert into movimientoscaja (numeroUsuario,numeroSucursal,numerocomprobante,tipocomprobante,monto,tipomovimiento,idcaja,cantidad,idcliente,tipocliente,pagado) values ("+Inicio.usuario.getNumeroId()+",1,"+forma.getId()+",8,"+forma.getMonto()+",1,"+Inicio.caja.getNumero()+",0,"+forma.getIdCliente()+",1,1)";
        tra.guardarRegistro(sql);
        return true;
    }
    
    
}
