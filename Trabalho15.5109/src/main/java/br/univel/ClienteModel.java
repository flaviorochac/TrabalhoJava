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
public class ClienteModel extends AbstractTableModel {
    
    private List<Cliente> lista;

    ClienteModel(List<Cliente> listac) {
        this.lista = listac;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
		return 11;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Cliente c = lista.get(row);

		switch (col) {
		case 0:
			return c.getId();
		case 1:
			return c.getNome();
                case 2:
			return c.getEndereco();
                case 3:
			return c.getNumero();
                case 4:
			return c.getComplemento();
                case 5:
			return c.getBairro();
		case 6:
			return c.getCidade();
                case 7:
			return c.getEstado();
                case 8:
			return c.getCep();
                case 9:
			return c.getTelefone();
                case 10:
			return c.getCelular();
                }          
		return null;
    }
    
}

