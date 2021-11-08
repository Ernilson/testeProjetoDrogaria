/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pro.delfino.drogaria.dao;

import br.pro.delfino.drogaria.domain.ItemVenda;
import br.pro.delfino.drogaria.domain.Produto;
import br.pro.delfino.drogaria.domain.Venda;
import br.pro.delfino.drogaria.util.HibernateUtil;
import br.pro.delfino.drogaria.dao.GenericDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author S60254831168
 */
public class VendaDAO extends GenericDAO<Venda> {
	public void salvar(Venda venda, List<ItemVenda> itensVenda){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
		
			sessao.save(venda);
			
			for(int posicao = 0; posicao < itensVenda.size(); posicao++){
				ItemVenda itemVenda = itensVenda.get(posicao);
				itemVenda.setVenda(venda);
				
				sessao.save(itemVenda);
				
				Produto produto = itemVenda.getProduto();
				produto.setQuantidade(new Short((produto.getQuantidade() - itemVenda.getQuantidade()) + ""));
				
				sessao.update(produto);
			}
			
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}
}