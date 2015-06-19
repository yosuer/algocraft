package fiuba.algo3.algocraft.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fiuba.algo3.algocraft.modelo.Estatico;
import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.modelo.ObjetoMultiforma;
import fiuba.algo3.algocraft.modelo.Tierra;
import fiuba.algo3.titiritero.dibujables.Circulo;
import fiuba.algo3.titiritero.dibujables.Figura;
import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class VentanaPrincipal {

	private JFrame frame;
	private GameLoop gameLoop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		try {
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setForeground(new Color(0, 0, 0));
		frame.setBounds(120, 5, 1000, 760);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameLoop.iniciarEjecucion();
			}
		});
		btnIniciar.setBounds(42, 16, 77, 25);
		frame.getContentPane().add(btnIniciar);
		
		
		JButton btnDetener = new JButton("Detener");
		btnDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameLoop.detenerEjecucion();
			}
		});
		btnDetener.setBounds(325, 16, 92, 25);
		frame.getContentPane().add(btnDetener);
		
		
		JPanel panel = new SuperficiePanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(150, 50, 600, 600);
		frame.getContentPane().add(panel);
		
		Mapa mapa = new Mapa();
		
		this.gameLoop = new GameLoop((SuperficieDeDibujo) panel);
		
		final ObjetoMultiforma modelo = new ObjetoMultiforma();
		this.gameLoop.agregar(modelo);
		Circulo circulo = new VistaObjetoMultiforma(modelo);
		this.gameLoop.agregar(circulo);
		
//		for (int x=1; x<=20; x++){
//			for (int y=1; y<=20; y++){
//				Estatico elemento = (Estatico)mapa.getElemento(x, y, 0);
//				//modelo2.mutar();
//				this.gameLoop.agregar(elemento);
//				Imagen imagen = new VistaIElemento(elemento);
//				this.gameLoop.agregar(imagen);
//			}
//		}
		

		ObjetoMultiforma modelo3 = new ObjetoMultiforma();
		modelo3.inmutar();
		this.gameLoop.agregar(modelo3);
		Imagen imagen = new Vista3ObjetoMultiforma(modelo3);
		this.gameLoop.agregar(imagen);
		
		panel.addMouseListener(new MouseAdapter() {
					
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//modelo.moverA(arg0.getX(), arg0.getY());
					
			}});

		frame.setFocusable(true);
		btnDetener.setFocusable(false);
		btnIniciar.setFocusable(false);
				
		frame.addKeyListener(new KeyListener(
				) {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				System.out.println("Key pressed");
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
			
				System.out.println("Ping");
				
			}  
			 	
		});
		
		
		
	}
}
