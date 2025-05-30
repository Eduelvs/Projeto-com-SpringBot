package interface_swing;

import java.awt.EventQueue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.unifei.ecot13.trabalho.Humano;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

public class incluir extends JFrame {
	private static final long serialVersionUID = -1965577729372740284L;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					incluir frame = new incluir();
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
	public incluir() {
		setTitle("Incluir");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 822);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JSpinner spinner_idade = new JSpinner();
		spinner_idade.setForeground(new Color(255, 228, 188));
		spinner_idade.setBackground(new Color(255, 228, 188));
		spinner_idade.setBounds(362, 355, 167, 20);
		contentPane.add(spinner_idade);
		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				humano=new Humano();
				humano.setNome(textField_nome.getText());
				humano.setEspecie(textField_especie.getText());
				humano.setGenero(textField_genero.getText());
				humano.setHabilidadeFisica(textField_habilidadefisica.getText());
				humano.setHabilidadeMental(textField_habilidademental.getText());
				humano.setIdade((Integer)spinner_idade.getValue());
				humano.setMoradia(textField_moradia.getText());
				humano.setOcupacao(textField_ocupacao.getText());
				em.getTransaction().begin();
				em.persist(humano);
				em.getTransaction().commit();
				JOptionPane.showMessageDialog(null, "Inserido Com Sucesso");
			}
		});
		btnNewButton.setIcon(null);
		btnNewButton.setSelectedIcon(null);
		btnNewButton.setBackground(new Color(255, 228, 188));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(309, 552, 89, 23);
		contentPane.add(btnNewButton);
		
		textField_nome = new JTextField();
		textField_nome.setBackground(new Color(255, 228, 188));
		textField_nome.setBounds(362, 264, 167, 20);
		contentPane.add(textField_nome);
		textField_nome.setColumns(10);
		
		textField_especie = new JTextField();
		textField_especie.setBackground(new Color(255, 228, 188));
		textField_especie.setBounds(362, 295, 167, 20);
		textField_especie.setColumns(10);
		contentPane.add(textField_especie);
		
		textField_genero = new JTextField();
		textField_genero.setBackground(new Color(255, 228, 188));
		textField_genero.setBounds(362, 326, 167, 20);
		textField_genero.setColumns(10);
		contentPane.add(textField_genero);
		
		textField_moradia = new JTextField();
		textField_moradia.setBackground(new Color(255, 228, 188));
		textField_moradia.setBounds(362, 386, 167, 20);
		textField_moradia.setColumns(10);
		contentPane.add(textField_moradia);
		
		textField_ocupacao = new JTextField();
		textField_ocupacao.setBackground(new Color(255, 228, 188));
		textField_ocupacao.setBounds(362, 417, 167, 20);
		textField_ocupacao.setColumns(10);
		contentPane.add(textField_ocupacao);
		
		textField_habilidadefisica = new JTextField();
		textField_habilidadefisica.setBackground(new Color(255, 228, 188));
		textField_habilidadefisica.setBounds(362, 448, 167, 20);
		textField_habilidadefisica.setColumns(10);
		contentPane.add(textField_habilidadefisica);
		
		textField_habilidademental = new JTextField();
		textField_habilidademental.setBackground(new Color(255, 228, 188));
		textField_habilidademental.setBounds(362, 479, 167, 20);
		textField_habilidademental.setColumns(10);
		contentPane.add(textField_habilidademental);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(191, 264, 70, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblEspcie = new JLabel("Espécie:");
		lblEspcie.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEspcie.setBounds(191, 293, 104, 20);
		contentPane.add(lblEspcie);
		
		JLabel lblGnero = new JLabel("Gênero:");
		lblGnero.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGnero.setBounds(191, 326, 104, 17);
		contentPane.add(lblGnero);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblIdade.setBounds(191, 357, 86, 17);
		contentPane.add(lblIdade);
		
		JLabel lblMoradia = new JLabel("Moradia:");
		lblMoradia.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMoradia.setBounds(191, 388, 114, 17);
		contentPane.add(lblMoradia);
		
		JLabel lblOcupao = new JLabel("Ocupação:");
		lblOcupao.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblOcupao.setBounds(191, 419, 114, 20);
		contentPane.add(lblOcupao);
		
		JLabel lblHabilidadeFsica = new JLabel("Habilidade Física:");
		lblHabilidadeFsica.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHabilidadeFsica.setBounds(191, 448, 168, 20);
		contentPane.add(lblHabilidadeFsica);
		
		JLabel lblHabilidadeMental = new JLabel("Habilidade Mental:");
		lblHabilidadeMental.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHabilidadeMental.setBounds(191, 479, 194, 20);
		contentPane.add(lblHabilidadeMental);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\eduar\\Downloads\\horaAventura.jpg"));
		lblNewLabel_1.setBounds(0, 0, 626, 796);
		contentPane.add(lblNewLabel_1);
	}
}
