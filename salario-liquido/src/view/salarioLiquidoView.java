package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import entity.Desconto;
import entity.Funcionario;
import entity.table.DescontoTableModel;
import entity.table.FuncionarioTableModel;
import service.DescontoService;
import service.FuncionarioService;

/**
 * Classe que monta a tela de salario liquido
 * @author Michel Mendes 	10/06/2019
 */
public class salarioLiquidoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private FuncionarioService funcionarioService;
	private DescontoService descontoService;
	private List<Desconto> descontos;
	private List<Funcionario> funcionarios;
	private JPanel contentPane;
	private JTable tbFuncionario;
	private JTable tbDesconto;
	private JScrollPane scrollFuncionario;
	private JScrollPane scrollDesconto;
	private JTextField txSalarioBruto;
	private JLabel lbDesc;
	private JTextField txTotalDescontos;
	private JLabel lbSalarioLiquido;
	private JTextField txSalarioLiquido;
	private JLabel label;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					salarioLiquidoView frame = new salarioLiquidoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public salarioLiquidoView() throws SQLException, ClassNotFoundException {
		
		funcionarioService = new FuncionarioService();
		descontoService = new DescontoService();
		funcionarios = funcionarioService.findAll();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 403);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbFuncionrios = new JLabel("Funcionários");
		lbFuncionrios.setBounds(12, 12, 204, 15);
		contentPane.add(lbFuncionrios);
		
		tbFuncionario = new JTable();
		tbFuncionario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object id = tbFuncionario.getValueAt(tbFuncionario.getSelectedRow(), 0);
				Long idFuncionario = Long.valueOf(id.toString());
				
				String sal = tbFuncionario.getValueAt(tbFuncionario.getSelectedRow(), 2).toString();
				Double salarioBruto = Double.valueOf(sal);
				txSalarioBruto.setText(sal);
				
				Double totalDescontos = descontoService.totalDescontosByFuncionario(idFuncionario);
				txTotalDescontos.setText(totalDescontos.toString());
				
				Double salarioLiquido = salarioBruto - totalDescontos;
				txSalarioLiquido.setText(salarioLiquido.toString());
				
				preencheDesconto(idFuncionario);
				
			}
		});
		tbFuncionario.setBounds(12, 39, 426, 92);
		tbFuncionario.setModel(new FuncionarioTableModel(funcionarios));
		//contentPane.add(tbFuncionario);
		
		scrollFuncionario = new JScrollPane();
		scrollFuncionario.setBounds(12, 39, 426, 101);
		scrollFuncionario.setViewportView(tbFuncionario);
		contentPane.add(scrollFuncionario);
		
		JLabel lbDescontos = new JLabel("Lista de Descontos");
		lbDescontos.setBounds(12, 233, 204, 15);
		contentPane.add(lbDescontos);
		
		tbDesconto = new JTable();
		tbDesconto.setBounds(12, 181, 426, 92);
		tbDesconto.setModel(new DescontoTableModel(new ArrayList<Desconto>()));
		
		scrollDesconto = new JScrollPane();
		scrollDesconto.setBounds(12, 260, 426, 101);
		scrollDesconto.setViewportView(tbDesconto);
		contentPane.add(scrollDesconto);
		
		JLabel lbSalario = new JLabel("Cálculo Salário Líquido");
		lbSalario.setBounds(12, 152, 204, 15);
		contentPane.add(lbSalario);
		
		txSalarioBruto = new JTextField();
		txSalarioBruto.setBounds(12, 195, 110, 19);
		contentPane.add(txSalarioBruto);
		txSalarioBruto.setColumns(10);
		
		JLabel lblSalarioBruto = new JLabel("Salario Bruto");
		lblSalarioBruto.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblSalarioBruto.setBounds(12, 179, 124, 15);
		contentPane.add(lblSalarioBruto);
		
		lbDesc = new JLabel("Total Descontos");
		lbDesc.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbDesc.setBounds(161, 179, 124, 15);
		contentPane.add(lbDesc);
		
		txTotalDescontos = new JTextField();
		txTotalDescontos.setColumns(10);
		txTotalDescontos.setBounds(161, 195, 110, 19);
		contentPane.add(txTotalDescontos);
		
		lbSalarioLiquido = new JLabel("Salário Líquido");
		lbSalarioLiquido.setFont(new Font("Dialog", Font.BOLD, 12));
		lbSalarioLiquido.setBounds(309, 179, 124, 15);
		contentPane.add(lbSalarioLiquido);
		
		txSalarioLiquido = new JTextField();
		txSalarioLiquido.setFont(new Font("Dialog", Font.BOLD, 14));
		txSalarioLiquido.setColumns(10);
		txSalarioLiquido.setBounds(309, 195, 110, 19);
		contentPane.add(txSalarioLiquido);
		
		label = new JLabel("-");
		label.setFont(new Font("Dialog", Font.BOLD, 18));
		label.setBounds(137, 195, 27, 17);
		contentPane.add(label);
		
		label_1 = new JLabel("=");
		label_1.setFont(new Font("Dialog", Font.BOLD, 18));
		label_1.setBounds(282, 195, 27, 17);
		contentPane.add(label_1);
	}
	
	private void preencheDesconto(Long idFuncionario) {
		try {
			descontos = descontoService.findByFuncionario(idFuncionario);
			if (descontos == null)
				descontos = new ArrayList<Desconto>();
			tbDesconto.setModel(new DescontoTableModel(descontos));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
}
