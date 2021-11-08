/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pro.delfino.drogaria.beans;

import br.pro.delfino.drogaria.dao.FabricanteDAO;
import br.pro.delfino.drogaria.dao.ProdutoDAO;
import br.pro.delfino.drogaria.domain.Fabricante;
import br.pro.delfino.drogaria.domain.Produto;
import br.pro.delfino.drogaria.util.HibernateUtil;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.event.ActionEvent;
import javafx.scene.shape.Path;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author S60254831168
 */
@ManagedBean
@ViewScoped
public class ProdutoBeans implements Serializable {
	private Produto produto;
	private List<Produto> produtos;
	private List<Fabricante> fabricantes;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	@PostConstruct
	public void listar() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtos = produtoDAO.listar("descricao");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os produtos");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			produto = new Produto();

			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricantes = fabricanteDAO.listar("descricao");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar um novo produto");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");
			produto.setCaminho("C:/Programação Web com Java/Uploads/" + produto.getCodigo() + ".png");

			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricantes = fabricanteDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar selecionar um produto");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			if (produto.getCaminho() == null) {
				Messages.addGlobalError("O campo foto é obrigatório");
				return;
			}

			ProdutoDAO produtoDAO = new ProdutoDAO();
			Produto produtoRetorno = produtoDAO.merge(produto);

			Path origem = (Path) Paths.get(produto.getCaminho());
			Path destino = (Path) Paths.get("C:/Programação Web com Java/Uploads/" + produtoRetorno.getCodigo() + ".png");
//			Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);

			produto = new Produto();

			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricantes = fabricanteDAO.listar();

			produtos = produtoDAO.listar();

			Messages.addGlobalInfo("Produto salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar o produto");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");

			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.excluir(produto);

			Path arquivo = (Path) Paths.get("C:/Programação Web com Java/Uploads/" + produto.getCodigo() + ".png");
			Files.deleteIfExists((java.nio.file.Path) arquivo);

			produtos = produtoDAO.listar();

			Messages.addGlobalInfo("Produto removido com sucesso");
		} catch (RuntimeException | IOException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o produto");
			erro.printStackTrace();
		}
	}

	public void upload(FileUploadEvent evento) {
		try {
			UploadedFile arquivoUpload = evento.getFile();
			Path arquivoTemp = (Path) Files.createTempFile(null, null);
//			Files.copy(arquivoUpload.getInputstream(), arquivoTemp, StandardCopyOption.REPLACE_EXISTING);
			produto.setCaminho(arquivoTemp.toString());

			Messages.addGlobalInfo("Upload realizado com sucesso");
		} catch (IOException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao tentar realizar o upload de arquivo");
			erro.printStackTrace();
		}
	}

//	public void imprimir() {
//		try {
//			DataTable tabela = (DataTable) Faces.getViewRoot().findComponent("formListagem:tabela");
//			Map<String, Object> filtros = tabela.getFilters();
//
//			String proDescricao = (String) filtros.get("descricao");
//			String fabDescricao = (String) filtros.get("fabricante.descricao");
//
//			String caminho = Faces.getRealPath("/reports/produtos.jasper");
//
//			Map<String, Object> parametros = new HashMap<>();
//			if (proDescricao == null) {
//				parametros.put("PRODUTO_DESCRICAO", "%%");
//			} else {
//				parametros.put("PRODUTO_DESCRICAO", "%" + proDescricao + "%");
//			}
//			if (fabDescricao == null) {
//				parametros.put("FABRICANTE_DESCRICAO", "%%");
//			} else {
//				parametros.put("FABRICANTE_DESCRICAO", "%" + fabDescricao + "%");
//			}
//
//			Connection conexao = HibernateUtil.getConexao();
//
////			JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
//
////			JasperPrintManager.printReport(relatorio, true);
//		} catch (JRException erro) {
//			Messages.addGlobalError("Ocorreu um erro ao tentar gerar o relatório");
//			erro.printStackTrace();
//		}
//	}
}
