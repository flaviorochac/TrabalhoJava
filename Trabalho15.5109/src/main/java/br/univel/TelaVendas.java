
package br.univel;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Tgamer
 */
public class TelaVendas extends javax.swing.JFrame {

    protected static TelaPrincipal tp;
    H2Con h2 = new H2Con();
    Cliente c = new Cliente();
    Produto ptemp = new Produto();
    List<Produto> listaPrd = new ArrayList<>();
    float total;
    
    
    public TelaVendas(TelaPrincipal tp) {
        initComponents();
        this.tp = tp;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlIdProduto = new javax.swing.JLabel();
        jlIdCliente = new javax.swing.JLabel();
        tfIdProduto = new javax.swing.JTextField();
        tfIdCliente = new javax.swing.JTextField();
        jbAddLista = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        tfNomeProduto = new javax.swing.JTextField();
        tfNomeCliente = new javax.swing.JTextField();
        tfPrecoProduto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelavendas = new javax.swing.JTable();
        tfValorRecebido = new javax.swing.JTextField();
        tfValorTotal = new javax.swing.JTextField();
        tfTroco = new javax.swing.JTextField();
        jbFinalizarCompra = new javax.swing.JButton();
        jlIdCliente1 = new javax.swing.JLabel();
        jlIdCliente2 = new javax.swing.JLabel();
        jlIdCliente3 = new javax.swing.JLabel();
        jlIdProduto1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vendas");
        setLocation(new java.awt.Point(0, 0));

        jlIdProduto.setText("Produto:");

        jlIdCliente.setText("Cliente:");

        tfIdProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfIdProdutoKeyPressed(evt);
            }
        });

        tfIdCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfIdClienteKeyPressed(evt);
            }
        });

        jbAddLista.setText("Adicionar a Lista");
        jbAddLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbAddListaMouseClicked(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbCancelarMouseClicked(evt);
            }
        });

        tfNomeProduto.setEditable(false);

        tfNomeCliente.setEditable(false);

        tfPrecoProduto.setEditable(false);
        tfPrecoProduto.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        tabelavendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelavendas);

        tfValorRecebido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfValorRecebidoKeyPressed(evt);
            }
        });

        tfValorTotal.setEditable(false);

        tfTroco.setEditable(false);

        jbFinalizarCompra.setText("Finalizar Venda!");
        jbFinalizarCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbFinalizarCompraMouseClicked(evt);
            }
        });

        jlIdCliente1.setText("Total:");

        jlIdCliente2.setText("Valor Recebido:");

        jlIdCliente3.setText("Troco:");

        jlIdProduto1.setText("R$:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbAddLista)
                        .addGap(178, 178, 178)
                        .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfIdCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(tfIdProduto))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfNomeProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                            .addComponent(tfNomeCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jlIdProduto1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPrecoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jlIdCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jlIdCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfValorRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jlIdCliente3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jbFinalizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlIdProduto)
                    .addComponent(tfIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPrecoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlIdProduto1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlIdCliente)
                    .addComponent(tfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbAddLista))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfValorRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTroco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlIdCliente1)
                    .addComponent(jlIdCliente2)
                    .addComponent(jlIdCliente3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jbFinalizarCompra)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCancelarMouseClicked
        tp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbCancelarMouseClicked

    private void tfIdProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfIdProdutoKeyPressed
        switch(evt.getKeyCode()){
        case KeyEvent.VK_ENTER:
        {
            try {
                buscarProduto(Integer.parseInt(tfIdProduto.getText()));
                this.tfNomeProduto.setText(ptemp.getDescricao());
                this.tfPrecoProduto.setText((ptemp.getPreco().toPlainString()));
            } catch (SQLException ex) {
                Logger.getLogger(TelaVendas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        break;
        }
    }//GEN-LAST:event_tfIdProdutoKeyPressed

    private void tfIdClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfIdClienteKeyPressed
       switch(evt.getKeyCode()){
        case KeyEvent.VK_ENTER:
        {
            try {
                buscarCliente(Integer.parseInt(tfIdCliente.getText()));
                this.tfNomeCliente.setText(c.getNome());
            } catch (SQLException ex) {
                Logger.getLogger(TelaVendas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        break;
       }
    }//GEN-LAST:event_tfIdClienteKeyPressed

    private void jbAddListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbAddListaMouseClicked
        listaPrd.add(this.ptemp);
        AtualizarTabela(listaPrd);
        listaPrd.forEach(e -> {
            this.total += e.getPreco().floatValue();
        });
        String totaltemp = String.valueOf(this.total);
        this.tfValorTotal.setText(totaltemp);
 
        /*this.total = this.total.add(this.ptemp.getPreco());
        this.total = this.total.setScale(2, RoundingMode.CEILING);
        this.tfValorTotal.setText(this.total.toString());*/
        
    }//GEN-LAST:event_jbAddListaMouseClicked

    private void tfValorRecebidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfValorRecebidoKeyPressed
          switch(evt.getKeyCode()){
        case KeyEvent.VK_ENTER:
        {
            float a = Float.parseFloat(tfValorTotal.getText());
            float b = Float.parseFloat(tfValorRecebido.getText());
            float fc = b - a;
            if (fc >= 0) {
                String fcs = String.valueOf(fc);
                this.tfTroco.setText(fcs);
            } else {
                this.tfTroco.setText("Falta");
            }
        }
        break;
       }
    }//GEN-LAST:event_tfValorRecebidoKeyPressed

    private void jbFinalizarCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbFinalizarCompraMouseClicked
        if (tfIdProduto.getText().isEmpty()){
            showMessageDialog(null, "Favor inserir a ID do produto!");
        }
        if (tfIdCliente.getText().isEmpty()) {
            showMessageDialog(null, "Favor inserir a ID do Cliente!");
        } 
        if (tfValorRecebido.getText().isEmpty()) {
            showMessageDialog(null, "Favor inserir o valor recebido!");
        } else {
            try {
                h2.abrirConexao();
                h2.ExportaVenda(this.c, this.total);
                h2.fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(TelaVendas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jbFinalizarCompraMouseClicked

    private Produto buscarProduto(int id) throws SQLException {
        h2.abrirConexao();
        this.ptemp = h2.buscarProduto(id);  
        h2.fecharConexao();
        return ptemp;
        
    }

    private Cliente buscarCliente(int id) throws SQLException {
        h2.abrirConexao();
        this.c= h2.BuscaClienteUnico(id);  
        h2.fecharConexao();
        return c;      
    }
    
    private void AtualizarTabela(List<Produto> listaPrd){
    ProdutoModel model = new ProdutoModel(listaPrd);
    tabelavendas.setModel(model);
    }
    
    public static void main(String args[]){
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new TelaVendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAddLista;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbFinalizarCompra;
    private javax.swing.JLabel jlIdCliente;
    private javax.swing.JLabel jlIdCliente1;
    private javax.swing.JLabel jlIdCliente2;
    private javax.swing.JLabel jlIdCliente3;
    private javax.swing.JLabel jlIdProduto;
    private javax.swing.JLabel jlIdProduto1;
    private javax.swing.JTable tabelavendas;
    private javax.swing.JTextField tfIdCliente;
    private javax.swing.JTextField tfIdProduto;
    private javax.swing.JTextField tfNomeCliente;
    private javax.swing.JTextField tfNomeProduto;
    private javax.swing.JTextField tfPrecoProduto;
    private javax.swing.JTextField tfTroco;
    private javax.swing.JTextField tfValorRecebido;
    private javax.swing.JTextField tfValorTotal;
    // End of variables declaration//GEN-END:variables

}
