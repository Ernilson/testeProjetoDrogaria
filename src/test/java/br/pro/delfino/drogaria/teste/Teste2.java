/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pro.delfino.drogaria.teste;

import br.pro.delfino.drogaria.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

/**
 *
 * @author S60254831168
 */
public class Teste2 {

    public static void main(String[] args) {
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        sessao.close();
        HibernateUtil.getFabricaDeSessoes().close();
    }

//    @Test
//    public void conectar() {
//        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();        
//        sessao.close();
//        HibernateUtil.getFabricaDeSessoes().close();
//    }
}
