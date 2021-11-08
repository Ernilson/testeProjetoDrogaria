/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pro.delfino.drogaria.util;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class DrogariaResourceConfig extends ResourceConfig {
	public DrogariaResourceConfig(){
		packages("br.pro.delfino.drogaria.service");
	}
}
