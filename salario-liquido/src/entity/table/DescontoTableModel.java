package entity.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Desconto;

/**
 * Classe com propriedades da tabela Desconto
 * @author Michel Mendes 	10/06/2019
 */
public class DescontoTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private static final int COL_ID = 0;
	private static final int COL_DESCONTO = 1;
	private List<Desconto> list;
	
	public DescontoTableModel() {
		super();
	}
	
	public DescontoTableModel(List<Desconto> list) {
		super();
		this.list = list;
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		Desconto desc = list.get(row);
		if (column == COL_ID)
			return desc.getIdDesconto();
		if (column == COL_DESCONTO)
			return desc.getVlDesconto();
		return null;
	}

	@Override
	public String getColumnName(int column) {
		if (column == COL_ID)
			return "ID";
		if (column == COL_DESCONTO)
			return "Descontos";
		return "";
	}
	
	

}
