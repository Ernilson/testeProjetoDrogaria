/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pro.delfino.drogaria.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author S60254831168
 */
public class HibernateContexto implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        HibernateUtil.getFabricaDeSessoes().close();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        HibernateUtil.getFabricaDeSessoes();
    }
    
}
