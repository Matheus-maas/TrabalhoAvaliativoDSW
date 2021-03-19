/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;
import javax.persistence.Table;

/**
 *
 * @author Matheus
 */
@Entity
@Table(name="produto")
public class Produto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idproduto")
    private int integer;
    @Column(name="descricao")
    private String descricao;
    @Column(name="valor")
    private double valor;
    @Column(name="qtdeestoque")
    private double qtdeEstoque;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idcategoria")
    private Categoria idcategoria;

    public Produto() {
    }

    
    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setQtdeEstoque(double qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }

    public Categoria getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Categoria idcategoria) {
        this.idcategoria = idcategoria;
    }

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trabalho1RESTAPIPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    
}
