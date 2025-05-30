package interface_swing;

import java.awt.EventQueue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.unifei.ecot13.trabalho.Humano;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class alterar extends JFrame {
	private static final long serialVersionUID = 8749944474496072440L;
	private EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("horaaventura");
	private EntityManager em = emf.createEntityManager();
	private Humano humano;

	private JPanel contentPane;
	private JTextField textField_nome;
	private JTextField textField_especie;
	private JTextField textField_genero;
	private JTextField textField_moradia;
	private JTextField textField_ocupacao;
	private JTextField textField_habilidadefisica;
	private JTextField textField_habilidademental;
	private JLabel lblNewLabel;
	private JLabel lblEspcie;
	private JLabel lblGnero;
	private JLabel lblIdade;
	private JLabel lblMoradia;
	private JLabel lblOcupao;
	private JLabel lblHabilidadeFsica;
	private JLabel lblHabilidadeMental;
	private JLabel lblNewLabel_1;
	private JButton btnAlterar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					alterar frame = new alterar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public alterar() {
		setTitle("Alterar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 822);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JSpinner spinner_idade = new JSpinner();
		spinner_idade.setForeground(new Color(255, 228, 188));
		spinner_idade.setBackground(new Color(255, 228, 188));
		spinner_idade.setBounds(365, 348, 167, 20);
		contentPane.add(spinner_idade);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				humano.setNome(textField_nome.getText());
				humano.setEspecie(textField_especie.getText());
				humano.setGenero(textField_genero.getText());
				humano.setHabilidadeFisica(textField_habilidadefisica.getText());
				humano.setHabilidadeMental(textField_habilidademental.getText());
				humano.setIdade((Integer)spinner_idade.getValue());
				humano.setMoradia(textField_moradia.getText());
				humano.setOcupacao(textField_ocupacao.getText());
				em.getTransaction().begin();
				em.merge(humano);
				em.getTransaction().commit();
				JOptionPane.showMessageDialog(null, "Alterado Com Sucesso");
			}
		});
		btnAlterar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnAlterar.setBackground(new Color(255, 228, 188));
		btnAlterar.setBounds(301, 543, 104, 23);
		contentPane.add(btnAlterar);
		
		textField_nome = new JTextField();
		textField_nome.setBackground(new Color(255, 228, 188));
		textField_nome.setBounds(247, 255, 186, 20);
		contentPane.add(textField_nome);
		textField_nome.setColumns(10);
		
		textField_especie = new JTextField();
		textField_especie.setBackground(new Color(255, 228, 188));
		textField_especie.setBounds(365, 286, 167, 20);
		textField_especie.setColumns(10);
		contentPane.add(textField_especie);
		
		textField_genero = new JTextField();
		textField_genero.setBackground(new Color(255, 228, 188));
		textField_genero.setBounds(365, 317, 167, 20);
		textField_genero.setColumns(10);
		contentPane.add(textField_genero);
		
		textField_moradia = new JTextField();
		textField_moradia.setBackground(new Color(255, 228, 188));
		textField_moradia.setBounds(365, 379, 167, 20);
		textField_moradia.setColumns(10);
		contentPane.add(textField_moradia);
		
		textField_ocupacao = new JTextField();
		textField_ocupacao.setBackground(new Color(255, 228, 188));
		textField_ocupacao.setBounds(365, 410, 167, 20);
		textField_ocupacao.setColumns(10);
		contentPane.add(textField_ocupacao);
		
		textField_habilidadefisica = new JTextField();
		textField_habilidadefisica.setBackground(new Color(255, 228, 188));
		textField_habilidadefisica.setBounds(365, 441, 167, 20);
		textField_habilidadefisica.setColumns(10);
		contentPane.add(textField_habilidadefisica);
		
		textField_habilidademental = new JTextField();
		textField_habilidademental.setBackground(new Color(255, 228, 188));
		textField_habilidademental.setBounds(365, 472, 167, 20);
		textField_habilidademental.setColumns(10);
		contentPane.add(textField_habilidademental);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(255, 228, 188));
		btnBuscar.setBounds(443, 254, 89, 23);
		btnBuscar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String nome = textField_nome.getText();
		        Query query = em.createQuery("SELECT h FROM Humano h WHERE h.nome = :nome");
		        query.setParameter("nome", nome);
		        try {
		            humano = (Humano) query.getSingleResult();

		            // Set the retrieved values in the text fields and spinners
		            textField_nome.setText(humano.getNome());
		            textField_especie.setText(humano.getEspecie());
		            textField_genero.setText(humano.getGenero());
		            textField_habilidadefisica.setText(humano.getHabilidadeFisica());
		            textField_habilidademental.setText(humano.getHabilidadeMental());
		            spinner_idade.setValue(humano.getIdade());
		            textField_moradia.setText(humano.getMoradia());
		            textField_ocupacao.setText(humano.getOcupacao());

		            // Enable the "Alterar" button
		            btnAlterar.setEnabled(true);
		        } catch (NoResultException ex) {
		            JOptionPane.showMessageDialog(null, "Humano não existe");
		        }
		    }
		});



		contentPane.add(btnBuscar);
		
		lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(180, 261, 83, 14);
		contentPane.add(lblNewLabel);
		
		lblEspcie = new JLabel("Espécie:");
		lblEspcie.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEspcie.setBounds(180, 286, 104, 20);
		contentPane.add(lblEspcie);
		
		lblGnero = new JLabel("Gênero:");
		lblGnero.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGnero.setBounds(180, 317, 83, 14);
		contentPane.add(lblGnero);
		
		lblIdade = new JLabel("Idade:");
		lblIdade.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblIdade.setBounds(180, 348, 83, 14);
		contentPane.add(lblIdade);
		
		lblMoradia = new JLabel("Moradia:");
		lblMoradia.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMoradia.setBounds(180, 379, 104, 14);
		contentPane.add(lblMoradia);
		
		lblOcupao = new JLabel("Ocupação:");
		lblOcupao.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblOcupao.setBounds(180, 410, 104, 20);
		contentPane.add(lblOcupao);
		
		lblHabilidadeFsica = new JLabel("Habilidade Física:");
		lblHabilidadeFsica.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHabilidadeFsica.setBounds(180, 444, 162, 14);
		contentPane.add(lblHabilidadeFsica);
		
		lblHabilidadeMental = new JLabel("Habilidade Mental:");
		lblHabilidadeMental.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHabilidadeMental.setBounds(180, 472, 177, 17);
		contentPane.add(lblHabilidadeMental);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\eduar\\Downloads\\horaAventura.jpg"));
		lblNewLabel_1.setBounds(0, 0, 626, 783);
		contentPane.add(lblNewLabel_1);
		
	}
}
