package Views;

import java.awt.Dimension;
import javax.swing.JOptionPane;

public class FrameInicio extends javax.swing.JFrame {

    public FrameInicio() {
        initComponents();
        setLocationRelativeTo(null);
        this.setTitle("Agenda de Peliculas");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        btnactores = new javax.swing.JToggleButton();
        btnfavoritos = new javax.swing.JToggleButton();
        btnpeliculas = new javax.swing.JToggleButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        editMenu = new javax.swing.JMenu();
        cofig_usuarios = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N

        btnactores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/actor.png"))); // NOI18N
        btnactores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactoresActionPerformed(evt);
            }
        });

        btnfavoritos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/favorito.png"))); // NOI18N
        btnfavoritos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfavoritosActionPerformed(evt);
            }
        });

        btnpeliculas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Pelicula.png"))); // NOI18N
        btnpeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpeliculasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnfavoritos, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnactores, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(btnpeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(btnactores, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(btnfavoritos, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(225, Short.MAX_VALUE))
        );

        escritorio.add(jPanel1);
        jPanel1.setBounds(0, 0, 180, 740);

        fileMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/casa.png"))); // NOI18N
        fileMenu.setMnemonic('f');
        fileMenu.setText("Inicio");
        menuBar.add(fileMenu);

        editMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/tuerca.png"))); // NOI18N
        editMenu.setMnemonic('e');
        editMenu.setText("Herramientas");

        cofig_usuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        cofig_usuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/usuarios.png"))); // NOI18N
        cofig_usuarios.setMnemonic('t');
        cofig_usuarios.setText("Usuarios");
        cofig_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cofig_usuariosActionPerformed(evt);
            }
        });
        editMenu.add(cofig_usuarios);

        copyMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        copyMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/informacion.png"))); // NOI18N
        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Información");
        editMenu.add(copyMenuItem);

        menuBar.add(editMenu);

        helpMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/ayuda.png"))); // NOI18N
        helpMenu.setMnemonic('h');
        helpMenu.setText("Ayuda");

        contentMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK));
        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contactanos");
        contentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_DOWN_MASK));
        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("Nosotros");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Salir.png"))); // NOI18N
        jMenu1.setText("Salir");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 1188, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentMenuItemActionPerformed

    }//GEN-LAST:event_contentMenuItemActionPerformed

    private void btnpeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpeliculasActionPerformed
        FramePelículas frame = new FramePelículas();
        escritorio.add(frame);
        frame.setVisible(true);
        try {
            frame.setSelected(true); // Asegura que el frame esté seleccionado y activo
        } catch (java.beans.PropertyVetoException e) {
            JOptionPane.showMessageDialog(this, "Error al abrir la ventana de películas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Centra el frame en el escritorio
        Dimension desktopSize = escritorio.getSize();
        Dimension frameSize = frame.getSize();
        int posX = (desktopSize.width - frameSize.width) / 2;
        int posY = (desktopSize.height - frameSize.height) / 2;
        frame.setLocation(posX, posY);
    }//GEN-LAST:event_btnpeliculasActionPerformed

    private void cofig_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cofig_usuariosActionPerformed
        FrameUsuarios form = new FrameUsuarios();
        escritorio.add(form);
        form.setVisible(true);
        form.toFront(); // Asegura que el formulario esté al frente

        // Centra el formulario en el escritorio
        Dimension desktopSize = escritorio.getSize();
        Dimension formSize = form.getSize();
        int posX = (desktopSize.width - formSize.width) / 2;
        int posY = (desktopSize.height - formSize.height) / 2;
        form.setLocation(posX, posY);


    }//GEN-LAST:event_cofig_usuariosActionPerformed

    private void btnactoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactoresActionPerformed
        FrameActores frame = new FrameActores();
        escritorio.add(frame);
        frame.setVisible(true);
        try {
            frame.setSelected(true); // Asegura que el formulario esté seleccionado
        } catch (java.beans.PropertyVetoException e) {
            JOptionPane.showMessageDialog(this, "Error al abrir la ventana de actores: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Centra el formulario en el escritorio
        Dimension desktopSize = escritorio.getSize();
        Dimension formSize = frame.getSize();
        int posX = (desktopSize.width - formSize.width) / 2;
        int posY = (desktopSize.height - formSize.height) / 2;
        frame.setLocation(posX, posY);
    }//GEN-LAST:event_btnactoresActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void btnfavoritosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfavoritosActionPerformed
                                          
        FrameFavoritos frame = new FrameFavoritos();
        escritorio.add(frame);
        frame.setVisible(true);
        try {
            frame.setSelected(true); // Asegura que el formulario esté seleccionado
        } catch (java.beans.PropertyVetoException e) {
            JOptionPane.showMessageDialog(this, "Error al abrir la ventana de actores: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Centra el formulario en el escritorio
        Dimension desktopSize = escritorio.getSize();
        Dimension formSize = frame.getSize();
        int posX = (desktopSize.width - formSize.width) / 2;
        int posY = (desktopSize.height - formSize.height) / 2;
        frame.setLocation(posX, posY);
    }//GEN-LAST:event_btnfavoritosActionPerformed

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
            java.util.logging.Logger.getLogger(FrameInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JToggleButton btnactores;
    private javax.swing.JToggleButton btnfavoritos;
    private javax.swing.JToggleButton btnpeliculas;
    private javax.swing.JMenuItem cofig_usuarios;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenu editMenu;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
