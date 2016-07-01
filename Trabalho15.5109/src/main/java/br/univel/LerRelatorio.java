package br.univel;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class LerRelatorio {	

public void imprimirProdutos() throws JRException {
		
		String arq = "C:\\Users\\luiz_\\git\\TrabalhoJava155591\\Trabalho15.5109\\src\\main\\java\\br\\univel\\Relatorio_Produto.jasper";
		H2Con d = new H2Con();
		// produtos container
		try {
			d.abrirConexao();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Produto> listaPrd = d.readProdutoBanco();
		// data source
		JasperPrint jp;
		try {
			jp = JasperFillManager.fillReport(arq, null,d.getCon());
			JasperViewer jasperViewer = new JasperViewer(jp);
			jasperViewer.setBounds(50, 50, 320, 240);
			jasperViewer.setLocationRelativeTo(null);
			jasperViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
			
			jasperViewer.setVisible(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void imprimirClientes() throws JRException {
		
		String arq = "C:\\Users\\luiz_\\git\\TrabalhoJava155591\\Trabalho15.5109\\src\\main\\java\\br\\univel\\Relatorio_Clientes.jasper";
		H2Con d = new H2Con();
		// produtos container
		try {
			d.abrirConexao();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Cliente> listaClt = d.readClienteBanco();
		// data source
		JasperPrint jp;
		try {
			jp = JasperFillManager.fillReport(arq, null,d.getCon());
			JasperViewer jasperViewer = new JasperViewer(jp);
			jasperViewer.setBounds(50, 50, 320, 240);
			jasperViewer.setLocationRelativeTo(null);
			jasperViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
			
			jasperViewer.setVisible(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void imprimirVendas() throws JRException {
		
		String arq = "C:\\Users\\luiz_\\git\\TrabalhoJava155591\\Trabalho15.5109\\src\\main\\java\\br\\univel\\RelatorioVendas.jasper";
		H2Con d = new H2Con();
		// produtos container
		try {
			d.abrirConexao();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Vendas> lista = d.readVendasBanco();
		// data source
		JasperPrint jp;
		try {
			jp = JasperFillManager.fillReport(arq, null,d.getCon());
			JasperViewer jasperViewer = new JasperViewer(jp);
			jasperViewer.setBounds(50, 50, 320, 240);
			jasperViewer.setLocationRelativeTo(null);
			jasperViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
			
			jasperViewer.setVisible(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}