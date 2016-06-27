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

public class H2Con {

	private Connection con;

	public void resetProduto() throws SQLException {

		String sql = "DELETE FROM PRODUTO";
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
        
	public void read() {
		
		Statement st = null;
		ResultSet result = null;
		try {
			try {
				st = con.createStatement();
				result = st.executeQuery("SELECT * FROM PRODUTO");
                                    while (result.next()) {
					int id = result.getInt(1);
					String nome = result.getString("nome");
					System.out.println(id + " " + nome);
				}
			} finally {
				if (st != null) st.close();
				if (result != null) result.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

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
