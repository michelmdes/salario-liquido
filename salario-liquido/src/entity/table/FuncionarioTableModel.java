package entity.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Funcionario;

/**
 * Classe com propriedades da tabela Funcionario
 * @author Michel Mendes 	10/06/2019
 */
public class FuncionarioTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private static final int COL_ID = 0;
	private static final int COL_DESCRICAO = 1;
	private static final int COL_SALARIO_BRUTO = 2;
	private List<Funcionario> list;
	
	public FuncionarioTableModel() {
		super();
	}
	
	public FuncionarioTableModel(List<Funcionario> list) {
		super();
		this.list = list;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		Funcionario func = list.get(row);
		if (column == COL_ID)
			return func.getIdCliente();
		if (column == COL_DESCRICAO)
			return func.getNmCliente();
		if (column == COL_SALARIO_BRUTO)
			return func.getVlSalarioBruto();
		return null;
	}

	@Override
	public String getColumnName(int column) {
		if (column == COL_ID)
			return "ID";
		if (column == COL_DESCRICAO)
			return "Funcionario";
		if (column == COL_SALARIO_BRUTO)
			return "Salario Bruto";
		return "";
	}
	
	

}
