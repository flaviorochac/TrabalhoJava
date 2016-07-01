package br.univel;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.univel.Cliente;
import java.util.ArrayList;

public class H2Con {

	private Connection con;

	public void resetProduto() throws SQLException {

		String sql = "DELETE FROM PRODUTO";
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			int res = ps.executeUpdate();
			System.out.println(res + " tabela limpa!");
		}
		
		
	}
        
        public void DeleteProduto(int id) throws SQLException {

		String sql = "DELETE FROM PRODUTO WHERE ID = " + id;
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			int res = ps.executeUpdate();
			System.out.println(res + " tabela limpa!");
		}
		
		
	}
        
        public void resetVendas() throws SQLException {

		String sql = "DELETE FROM VENDAS";
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			int res = ps.executeUpdate();
			System.out.println(res + " tabela limpa!");
		}
		
		
	}
        
        public void resetCliente() throws SQLException {

		String sql = "DELETE FROM CLIENTE";
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			int res = ps.executeUpdate();
			System.out.println(res + " tabela limpa!");
		}
		
		
	}

	public void abrirConexao() throws SQLException {

		String url = "jdbc:h2:~/teste";
		String user = "sa";
		String pass = "sa";
		con = DriverManager.getConnection(url, user, pass);

	}

	public void fecharConexao() throws SQLException {
		con.close();
	}

	public void createProduto(List<Produto> listaPrd) throws SQLException {
		
                listaPrd.forEach(e -> {
                        PreparedStatement ps;
                    try {
                        
                        ps = con.prepareStatement("INSERT INTO PRODUTO (ID, DESCRICAO, PRECO) VALUES (?, ?, ?)");
                        ps.setInt(1, e.getId());
                        ps.setString(2, e.getDescricao());
                        ps.setBigDecimal(3, e.getPreco());
                        
                        int res = ps.executeUpdate();
                        ps.close();
                        // Aqui não garante que executa o close.
                    } catch (SQLException ex) {
                        Logger.getLogger(H2Con.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } );
                System.out.println(" registros alterados.");
           }
        
        public void ExportaVenda(Cliente c, float f) throws SQLException {
                        PreparedStatement ps;
                    try {
                        ps = con.prepareStatement("INSERT INTO VENDAS (CLIENTE, VALOR) VALUES (?, ?)");
                        ps.setString(1, c.getNome());
                        ps.setFloat(2, f);
                        int res = ps.executeUpdate();
                        ps.close();
                        // Aqui não garante que executa o close.
                    } catch (SQLException ex) {
                        Logger.getLogger(H2Con.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                System.out.println(" registros alterados.");
           }
        
        public void CadastrarProduto(int id, String descricao, BigDecimal preco) throws SQLException {
		
                        PreparedStatement ps;
                    try {
                        
                        ps = con.prepareStatement("INSERT INTO PRODUTO (ID, DESCRICAO, PRECO) VALUES (?, ?, ?)");
                        ps.setInt(1, id);
                        ps.setString(2, descricao);
                        ps.setBigDecimal(3, preco);
                        
                        int res = ps.executeUpdate();
                        ps.close();
                        // Aqui não garante que executa o close.
                    } catch (SQLException ex) {
                        Logger.getLogger(H2Con.class.getName()).log(Level.SEVERE, null, ex);
                        }
               
                System.out.println(" registros alterados.");
           }
        public void CadastrarCliente(int id, String nome, String end, int num, String comp, String bairro, String cid, String est, String
                cep, String tel, String celular) throws SQLException {
                        PreparedStatement ps;
                    try {
                        ps = con.prepareStatement("INSERT INTO CLIENTE (ID, NOME, ENDERECO, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, ESTADO, CEP, TELEFONE, "
                                + "CELULAR) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                        ps.setInt(1, id);
                        ps.setString(2, nome);
                        ps.setString(3, end);
                        ps.setInt(4, num);
                        ps.setString(5, comp);
                        ps.setString(6, bairro);
                        ps.setString(7, cid);
                        ps.setString(8, est);
                        ps.setString(9, cep);
                        ps.setString(10, tel);
                        ps.setString(11, celular);
                        int res = ps.executeUpdate();
                        ps.close();
                        // Aqui não garante que executa o close.
                    } catch (SQLException ex) {
                        Logger.getLogger(H2Con.class.getName()).log(Level.SEVERE, null, ex);
                        }
               
                System.out.println(" registros alterados.");
           }
        
        public void createCliente(List<Cliente> listaClt) throws SQLException {
		
                listaClt.forEach(e -> {
                        PreparedStatement ps;
                    try {
                        
                        ps = con.prepareStatement("INSERT INTO CLIENTE (ID, NOME, ENDERECO, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, "
                                + "ESTADO, CEP, TELEFONE, CELULAR) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                        ps.setInt(1, e.getId());
                        ps.setString(2, e.getNome());
                        ps.setString(3, e.getEndereco());
                        ps.setInt(4, e.getNumero());
                        ps.setString(5, e.getComplemento());
                        ps.setString(6, e.getBairro());
                        ps.setString(7, e.getCidade());
                        ps.setString(8, e.getEstado());
                        ps.setString(9, e.getCep());
                        ps.setString(10, e.getTelefone());
                        ps.setString(11, e.getCelular());
                        
                        int res = ps.executeUpdate();
                        ps.close();
                        // Aqui não garante que executa o close.
                    } catch (SQLException ex) {
                        Logger.getLogger(H2Con.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } );
                System.out.println(" registros alterados.");
           }
        
	public void readProduto() {
		
		Statement st = null;
		ResultSet result = null;
		try {
			try {
				st = con.createStatement();
				result = st.executeQuery("SELECT * FROM PRODUTO LIMIT 15000");
                                    while (result.next()) {
					int id = result.getInt(1);
					String descricao = result.getString(2);
                                        BigDecimal preco = result.getBigDecimal(3);
					System.out.println(id + " " + descricao + " " + preco);
				}
			} finally {
				if (st != null) st.close();
				if (result != null) result.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
        public List<Produto> readProdutoBanco() {
		
		Statement st = null;
		ResultSet result = null;
		List<Produto> listaPrd = new ArrayList<>();
                try {
			try {
				st = con.createStatement();
				result = st.executeQuery("SELECT * FROM PRODUTO LIMIT 15000");
                                    while (result.next()) {
                                        Produto p = new Produto();
					p.setId(result.getInt(1));
					p.setDescricao(result.getString(2));
                                        p.setPreco(result.getBigDecimal(3));
					//System.out.println(id + " " + descricao + " " + preco);
                                        listaPrd.add(p);
                            }
			} finally {
				if (st != null) st.close();
				if (result != null) result.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
                return listaPrd;

	}
        
        public void readCliente() {
		
		Statement st = null;
		ResultSet result = null;
		try {
			try {
				st = con.createStatement();
				result = st.executeQuery("SELECT * FROM CLIENTE LIMIT 15000");
                                    while (result.next()) {
					int id = result.getInt(1);
					String nome = result.getString(2);
                                        String endereco = result.getString(3);
                                        int numero = result.getInt(4);
                                        String complemento = result.getString(5);
                                        String bairro = result.getString(6);
                                        String cidade = result.getString(7);
                                        String estado = result.getString(8);
                                        String cep = result.getString(9);
                                        String telefone = result.getString(10);
                                        String celular = result.getString(11);
					System.out.println(id + " " + nome + " " + endereco + " " + numero + " " + complemento + " " + bairro + " " + cidade + " " + estado + " " + cep + " " + telefone + " " + celular);
				}
			} finally {
				if (st != null) st.close();
				if (result != null) result.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
        
        public List<Cliente> readClienteBanco() {
		
		Statement st = null;
		ResultSet result = null;
		List<Cliente> listaRetorno = new ArrayList<Cliente>();
                try {
			try {
				st = con.createStatement();
				result = st.executeQuery("SELECT * FROM CLIENTE LIMIT 15000");
                                    while (result.next()) {
                                        Cliente c = new Cliente();
                                        c.setId(result.getInt(1));
					c.setNome(result.getString(2));
                                        c.setEndereco(result.getString(3));
                                        c.setNumero(result.getInt(4));
                                        c.setComplemento(result.getString(5));
                                        c.setBairro(result.getString(6));
                                        c.setCidade(result.getString(7));
                                        c.setEstado(result.getString(8));
                                        c.setCep(result.getString(9));
                                        c.setTelefone(result.getString(10));
                                        c.setCelular(result.getString(11));
                                        listaRetorno.add(c);
                                    //System.out.println(id + " " + nome + " " + endereco + " " + numero + " " + complemento + " " + bairro + " " + cidade + " " + estado + " " + cep + " " + telefone + " " + celular);
                                }
			} finally {
				if (st != null) st.close();
				if (result != null) result.close();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
                return listaRetorno;

	}
        
        public Cliente BuscaClienteUnico(int id) {
		
		Statement st = null;
		ResultSet result = null;
		Cliente c = new Cliente();
                try {
			try {
				st = con.createStatement();
				result = st.executeQuery("SELECT * FROM CLIENTE WHERE ID = " + id);
                                    while (result.next()) {
                                        c.setId(result.getInt(1));
					c.setNome(result.getString(2));
                                        c.setEndereco(result.getString(3));
                                        c.setNumero(result.getInt(4));
                                        c.setComplemento(result.getString(5));
                                        c.setBairro(result.getString(6));
                                        c.setCidade(result.getString(7));
                                        c.setEstado(result.getString(8));
                                        c.setCep(result.getString(9));
                                        c.setTelefone(result.getString(10));
                                        c.setCelular(result.getString(11));
                                    //System.out.println(id + " " + nome + " " + endereco + " " + numero + " " + complemento + " " + bairro + " " + cidade + " " + estado + " " + cep + " " + telefone + " " + celular);
                                }
			} finally {
				if (st != null) st.close();
				if (result != null) result.close();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
                return c;

	}
        
        public Produto buscarProduto(int id){
                Statement st = null;
		ResultSet result = null;
		Produto p = new Produto();
                try {
			try {
				st = con.createStatement();
				result = st.executeQuery("SELECT * FROM PRODUTO WHERE ID = " + id);
                                    while (result.next()) {
                                        p.setId(result.getInt(1));
					p.setDescricao(result.getString(2));
                                        p.setPreco(result.getBigDecimal(3));
                                }
			} finally {
				if (st != null) st.close();
				if (result != null) result.close();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
                return p;
        }

	public void update() {

		String sql = "UPDATE PESSOA SET ID = ?, NOME = ? WHERE ID = ?";
	}

	public void delete() {
		
		String sql = "DELETE FROM PESSOA WHERE ID = ?";

	}

	public static void main(String[] args) {
            new H2Con();
	}


}
