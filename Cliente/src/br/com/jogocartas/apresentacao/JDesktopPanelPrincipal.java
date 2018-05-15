package br.com.jogocartas.apresentacao;

import java.awt.Color;

import javax.swing.*;

public class JDesktopPanelPrincipal extends javax.swing.JFrame {
	
	private static final long serialVersionUID = 1L;
	                    
    private JButton jButtonEntrarPartida;
    private JDesktopPane jDektopPanelPrincipal;
    private JLabel jLabel1;
    private JLabel jLabelCoinValue;
    private JLabel jLabelEmail;
    private JList<String> jListPartidas;
    private JMenuBar jMenu;
    private JMenuItem jMenuCriarPartida;
    private JMenu jMenuPrincipal;
    private JMenuItem jMenuSairJogo;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTree jTree1;
    private javax.swing.JPanel jPanelCoinIcon;
    
	  /**
     * Creates new form FormPrincipal
     */
    public JDesktopPanelPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jDektopPanelPrincipal = new javax.swing.JDesktopPane();
        jLabelEmail = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListPartidas = new javax.swing.JList<>();
        jButtonEntrarPartida = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelCoinValue = new javax.swing.JLabel();
        jMenu = new javax.swing.JMenuBar();
        jMenuPrincipal = new javax.swing.JMenu();
        jMenuCriarPartida = new javax.swing.JMenuItem();
        jMenuSairJogo = new javax.swing.JMenuItem();
        jPanelCoinIcon = new javax.swing.JPanel();

        jScrollPane2.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDektopPanelPrincipal.setBackground(new java.awt.Color(65, 105, 170));

        jLabelEmail.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabelEmail.setForeground(new java.awt.Color(255, 255, 255));

        jListPartidas.setModel(new javax.swing.AbstractListModel<String>() {
     		private static final long serialVersionUID = 1L;
			
			String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListPartidas);

        jButtonEntrarPartida.setBackground(new java.awt.Color(255, 102, 102));
        jButtonEntrarPartida.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonEntrarPartida.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEntrarPartida.setText("ENTRAR NA PARTIDA");

        jLabelCoinValue.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabelCoinValue.setForeground(new java.awt.Color(255, 255, 0));
        jLabelCoinValue.setText("1000");
        
        jPanelCoinIcon.setBackground(new java.awt.Color(65, 105, 170));
        jPanelCoinIcon.setBackground(Color.BLACK); // s� para mostrar onde esta o painel depois tirar quando colocar a img de fundo
        
        javax.swing.GroupLayout jPanelCoinIconLayout = new javax.swing.GroupLayout(jPanelCoinIcon);
        jPanelCoinIcon.setLayout(jPanelCoinIconLayout);
        jPanelCoinIconLayout.setHorizontalGroup(
            jPanelCoinIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanelCoinIconLayout.setVerticalGroup(
            jPanelCoinIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jDektopPanelPrincipal.setLayer(jLabelEmail, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDektopPanelPrincipal.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDektopPanelPrincipal.setLayer(jButtonEntrarPartida, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDektopPanelPrincipal.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDektopPanelPrincipal.setLayer(jLabelCoinValue, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDektopPanelPrincipal.setLayer(jPanelCoinIcon, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDektopPanelPrincipalLayout = new javax.swing.GroupLayout(jDektopPanelPrincipal);
        jDektopPanelPrincipal.setLayout(jDektopPanelPrincipalLayout);
        jDektopPanelPrincipalLayout.setHorizontalGroup(
            jDektopPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDektopPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDektopPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonEntrarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jDektopPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jDektopPanelPrincipalLayout.createSequentialGroup()
                        .addGroup(jDektopPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDektopPanelPrincipalLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabelEmail))
                            .addGroup(jDektopPanelPrincipalLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanelCoinIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel1)))
                        .addGap(92, 92, 92))
                    .addGroup(jDektopPanelPrincipalLayout.createSequentialGroup()
                        .addGap(369, 369, 369)
                        .addComponent(jLabelCoinValue, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jDektopPanelPrincipalLayout.setVerticalGroup(
            jDektopPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDektopPanelPrincipalLayout.createSequentialGroup()
                .addGroup(jDektopPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDektopPanelPrincipalLayout.createSequentialGroup()
                        .addGroup(jDektopPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDektopPanelPrincipalLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jDektopPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabelCoinValue, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jDektopPanelPrincipalLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanelCoinIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(103, 103, 103)
                        .addComponent(jLabelEmail))
                    .addGroup(jDektopPanelPrincipalLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(jButtonEntrarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jMenu.setBackground(new java.awt.Color(153, 153, 153));
        jMenu.setToolTipText("Jogo de Cartas");

        ImageIcon image = new ImageIcon("file:///C:/Users/andrev/Documents/projeto-integrado-c/Cliente/imagens/menu_icon.png");
        jMenuPrincipal.setIcon(image);
        //jMenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto-integrado-c/Cliente/imagens/menu_icon.png"))); // NOI18N
        jMenuPrincipal.setText("Menu");

        //jMenuCriarPartida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto-integrado-c/Cliente/imagens/add_icon.png"))); // NOI18N
        jMenuCriarPartida.setText("Criar nova Partida");
        jMenuCriarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCriarPartidaActionPerformed(evt);
            }
        });
        jMenuPrincipal.add(jMenuCriarPartida);

        //jMenuSairJogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto-integrado-c/Cliente/imagens/exit.png"))); // NOI18N
        jMenuSairJogo.setText("Sair do Jogo");
        jMenuSairJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSairJogoActionPerformed(evt);
            }
        });
        jMenuPrincipal.add(jMenuSairJogo);

        jMenu.add(jMenuPrincipal);

        setJMenuBar(jMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDektopPanelPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDektopPanelPrincipal)
        );

        pack();
    }                     
  
    /**
     * Esse bot�o eh respons�vel por abrir a tela para cadastrar uma nova partida.
     * 
     * 
     */
    private void jMenuCriarPartidaActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        
    	JNovaPartidaFrame jNonaPartidaFrame = new JNovaPartidaFrame();
        jDektopPanelPrincipal.add(jNonaPartidaFrame);
        jNonaPartidaFrame.setVisible(true);
    }                                                 

    private void jMenuSairJogoActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(JDesktopPanelPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDesktopPanelPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDesktopPanelPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDesktopPanelPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JDesktopPanelPrincipal().setVisible(true);
            }
        });
    }
}