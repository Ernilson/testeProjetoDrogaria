/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pro.delfino.drogaria.teste;


import br.pro.delfino.drogaria.dao.FabricanteDAO;
import br.pro.delfino.drogaria.dao.ProdutoDAO;
import br.pro.delfino.drogaria.domain.Fabricante;
import br.pro.delfino.drogaria.domain.Produto;
import java.math.BigDecimal;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author S60254831168
 */
public class TesteDAO {

    //    -- Metodo para Adicionar
    @Test
	@Ignore
	public void salvar(){
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(new Long("3"));
		
		Produto produto = new Produto();
		produto.setDescricao("Cataflan 50mg com 20 Comprimidos");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal("13.70"));
		produto.setQuantidade(new Short("7"));
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);
		
		System.out.println("Produto salvo com sucesso");
	}
//}

//    }
    //    -- Metodo para Listar
//    @Test
//    public void listar() {
//        ProdutoDAO pdao = new ProdutoDAO();
//        List<Produtos> resultado = pdao.listar();
//        System.out.println("Total de Registros" + resultado.size());
//        for (Produtos produtos : resultado) {
//            System.out.println(produtos.getDescricao()+" - "+ produtos.getCodProduto());
//        }
//    @Test
//    public void listar() {
//        VendaDAO pdao = new VendaDAO();
//        List<Venda> resultado = pdao.ListaTodos();
//        System.out.println("Total de Registros" + resultado.size());
//        for (Venda produtos : resultado) {
//            System.out.println(produtos.getDescricao() + " - " + produtos.getNome());
//        }
//        
//    }
        //    -- Metodo para Bucar por id
//    @Test
//    public void buscar() {
//        ProdutoDAO pdao = new ProdutoDAO();
//        Long codigo = 9L;
//        Produtos p = pdao.buscar(codigo);
//         System.out.println(p.getCodProduto()+" - "+p.getDescricao()+" - "+ p.getCodProduto());
//    }
        //    -- Metodo para Excluir
//    @Test
//    public void excluir(){
//        ProdutoDAO pdao = new ProdutoDAO();
//        Long codigo = 9L;
//        Produtos p = pdao.buscar(codigo);
//        pdao.excluir(p);
//    }
//    -- Metodo para Editar
//    @Test
//    public void Editar() {
//        ProdutoDAO pdao = new ProdutoDAO();
//        Long codigo = 8L;
//        Produtos p = pdao.buscar(codigo);             
//        p.setPreco(20);
//        p.setDescricao("outro");
//        p.setQtd(2);
//        pdao.editar(p);
//        -- Metodo para Listar

//    @Test
//    public void testeVoluntario(){       
//       VendaDAO vdao = new VendaDAO();
//       Venda venda = vdao.buscar(17L);
//       ProdutoDAO pdao = new ProdutoDAO();
//       Produtos produto = pdao.buscar(11L);
//       Voluntario vl = new Voluntario();
//       VoluntarioDAO vldao = new VoluntarioDAO();       
//       ClienteDAO cldao = new ClienteDAO();
//       Cliente cliente = cldao.buscar(1L);
//       
//        vl.setNome("Teste2");
//        vl.setVenda(venda);
//        vl.setProduto(produto);
//        vl.setCliente(cliente);
//       
//        vldao.salvar(vl);
//    }
}
