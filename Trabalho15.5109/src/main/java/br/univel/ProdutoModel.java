/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univel;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tgamer
 */
public class ProdutoModel extends AbstractTableModel {
    
    private List<Produto> lista;

    ProdutoModel(List<Produto> listap) {
        this.lista = listap;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
		return 3;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Produto p = lista.get(row);

		switch (col) {
		case 0:
			return p.getId();
		case 1:
			return p.getDescricao();
                case 2:
			return p.getPreco();
                }          
		return null;
    }
    
}

