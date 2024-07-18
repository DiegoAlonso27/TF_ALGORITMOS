package Views;

import Class.Busqueda;
import Methods.Busca;
import Methods.Ordena;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class FrameFavoritos extends javax.swing.JInternalFrame {

    DefaultTableModel dt;
    Queue<String[]> colaFavoritos;
    List<Object[]> datosOriginales;
    Stack<String[]> pilaEliminados;

    private boolean busquedaRealizada = false;

    public FrameFavoritos() {
        initComponents();
        String cabecera[] = {"Pelicula", "Duración", "Género", "Fecha de Estreno"};
        dt = new DefaultTableModel(cabecera, 0); // Crear el DefaultTableModel con la cabecera
        tblfavoritos.setModel(dt); // Asignar el modelo a la tabla

        colaFavoritos = new LinkedList<>(); // Inicializar la cola
        datosOriginales = new LinkedList<>();
        pilaEliminados = new Stack<>(); // Inicializar la pila de eliminados
        cargarDatosDesdeArchivo(); // Cargar datos desde el archivo al abrir el formulario
    }

    // Método para agregar una película a la tabla de favoritos y guardar en archivo
    public void agregarPelicula(String nombre, String duracion, String genero, String fechaEstreno) {
        String[] datosPelicula = {nombre, duracion, genero, fechaEstreno};
        colaFavoritos.add(datosPelicula); // Añadir a la cola
        dt.addRow(datosPelicula); // Añadir a la tabla
        guardarDatosEnArchivo(); // Guardar los datos de la cola en el archivo
    }

    // Método para cargar los datos desde el archivo de texto
    private void cargarDatosDesdeArchivo() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Files\\favoritos.txt"));
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                colaFavoritos.add(datos); // Añadir a la cola
                dt.addRow(datos); // Añadir a la tabla
            }
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos desde favoritos.txt: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para guardar los datos de la cola en un archivo de texto
    private void guardarDatosEnArchivo() {
        try {
            FileWriter writer = new FileWriter("C:\\Files\\favoritos.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            for (String[] datos : colaFavoritos) {
                bufferedWriter.write(String.join(",", datos));
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar los datos en favoritos.txt: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para guardar los datos originales de la tabla
    private void guardarDatosOriginales() {
        DefaultTableModel dt = (DefaultTableModel) tblfavoritos.getModel();
        datosOriginales.clear();
        for (int i = 0; i < dt.getRowCount(); i++) {
            Object[] fila = new Object[dt.getColumnCount()];
            for (int j = 0; j < dt.getColumnCount(); j++) {
                fila[j] = dt.getValueAt(i, j);
            }
            datosOriginales.add(fila);
        }
    }

    // Método para restaurar los datos originales de la tabla
    private void restaurarDatosOriginales() {
        DefaultTableModel dt = (DefaultTableModel) tblfavoritos.getModel();
        dt.setRowCount(0);
        for (Object[] fila : datosOriginales) {
            dt.addRow(fila);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btndeshacer = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JToggleButton();
        cbotipo = new javax.swing.JComboBox<>();
        btnlimpiar = new javax.swing.JToggleButton();
        btneliminar = new javax.swing.JToggleButton();
        btndeshacer1 = new javax.swing.JToggleButton();
        btnordenar_alfabeto = new javax.swing.JToggleButton();
        btnordenar_fecha = new javax.swing.JToggleButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblfavoritos = new javax.swing.JTable();

        btndeshacer.setBackground(new java.awt.Color(51, 51, 51));
        btndeshacer.setForeground(new java.awt.Color(255, 255, 255));
        btndeshacer.setText("Deshacer");
        btndeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeshacerActionPerformed(evt);
            }
        });

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Favoritos");

        jPanel5.setBackground(new java.awt.Color(51, 102, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Buscar Favoritos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel5.setForeground(new java.awt.Color(0, 0, 0));

        btnbuscar.setBackground(new java.awt.Color(51, 51, 51));
        btnbuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        cbotipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de Busqueda", "Lineal", "Binaria" }));

        btnlimpiar.setBackground(new java.awt.Color(51, 51, 51));
        btnlimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        btneliminar.setBackground(new java.awt.Color(51, 51, 51));
        btneliminar.setForeground(new java.awt.Color(255, 255, 255));
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btndeshacer1.setBackground(new java.awt.Color(0, 0, 0));
        btndeshacer1.setForeground(new java.awt.Color(255, 255, 255));
        btndeshacer1.setText("Deshacer");
        btndeshacer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeshacer1ActionPerformed(evt);
            }
        });

        btnordenar_alfabeto.setBackground(new java.awt.Color(51, 51, 51));
        btnordenar_alfabeto.setForeground(new java.awt.Color(255, 255, 255));
        btnordenar_alfabeto.setText("Ordenar Por alfabeto");
        btnordenar_alfabeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnordenar_alfabetoActionPerformed(evt);
            }
        });

        btnordenar_fecha.setBackground(new java.awt.Color(51, 51, 51));
        btnordenar_fecha.setForeground(new java.awt.Color(255, 255, 255));
        btnordenar_fecha.setText("Ordenar por Fecha");
        btnordenar_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnordenar_fechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtbuscar)
                    .addComponent(btnordenar_alfabeto, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnordenar_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbotipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btndeshacer1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbotipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar)
                    .addComponent(btnlimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btneliminar)
                    .addComponent(btndeshacer1)
                    .addComponent(btnordenar_alfabeto)
                    .addComponent(btnordenar_fecha))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(51, 153, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblfavoritos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblfavoritos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblfavoritosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblfavoritos);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        guardarDatosOriginales();

        String nombreBus = txtbuscar.getText();
        String tipoBusqueda = cbotipo.getSelectedItem().toString(); // Suponiendo que tienes un JComboBox para seleccionar el tipo de búsqueda

        Busqueda busqueda = new Busqueda(nombreBus, tipoBusqueda);
        Busca busca = new Busca();
        int indice = -1;

        DefaultTableModel dt = (DefaultTableModel) tblfavoritos.getModel();

        if (busqueda.getTipo().equalsIgnoreCase("Lineal")) {
            indice = busca.busquedaLineal(dt, busqueda.getNombreBus());
        } else if (busqueda.getTipo().equalsIgnoreCase("Binaria")) {
            indice = busca.busquedaBinaria(dt, busqueda.getNombreBus());
        }

        if (indice != -1) {
            Object[] filaEncontrada = new Object[dt.getColumnCount()];
            for (int i = 0; i < dt.getColumnCount(); i++) {
                filaEncontrada[i] = dt.getValueAt(indice, i);
            }

            dt.setRowCount(0);
            dt.addRow(filaEncontrada);

            JOptionPane.showMessageDialog(this, "Película encontrada en la fila: " + (indice + 1));
        } else {
            JOptionPane.showMessageDialog(this, "Película no encontrada.");
        }
        busquedaRealizada = true;
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        if (busquedaRealizada) {
            restaurarDatosOriginales();
            busquedaRealizada = false; // Restablecer a false después de restaurar los datos originales
        } else {
            JOptionPane.showMessageDialog(this, "No se ha realizado ninguna búsqueda para restaurar.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        int filaSeleccionada = tblfavoritos.getSelectedRow();
        if (filaSeleccionada != -1) {
            DefaultTableModel dt = (DefaultTableModel) tblfavoritos.getModel();
            String[] datosEliminados = new String[dt.getColumnCount()];
            for (int i = 0; i < dt.getColumnCount(); i++) {
                datosEliminados[i] = dt.getValueAt(filaSeleccionada, i).toString();
            }
            pilaEliminados.push(datosEliminados);
            dt.removeRow(filaSeleccionada);
            actualizarColaFavoritos();
            guardarDatosEnArchivo();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.");
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void tblfavoritosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblfavoritosMouseClicked

    }//GEN-LAST:event_tblfavoritosMouseClicked

    private void btndeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeshacerActionPerformed

    }//GEN-LAST:event_btndeshacerActionPerformed

    private void btndeshacer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeshacer1ActionPerformed

        if (!pilaEliminados.isEmpty()) {
            String[] datosRestaurados = pilaEliminados.pop();
            colaFavoritos.add(datosRestaurados);
            dt.addRow(datosRestaurados);
            guardarDatosEnArchivo();
        } else {
            JOptionPane.showMessageDialog(this, "No hay operaciones de eliminación para deshacer.");
        }
    }//GEN-LAST:event_btndeshacer1ActionPerformed

    private void btnordenar_alfabetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnordenar_alfabetoActionPerformed
        if (dt.getRowCount() > 0) {
            Ordena.ordenarAlfabeticamente(dt);
        } else {
            JOptionPane.showMessageDialog(this, "No hay datos para ordenar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnordenar_alfabetoActionPerformed

    private void btnordenar_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnordenar_fechaActionPerformed
        if (dt.getRowCount() > 0) {
            Ordena.ordenarPorFechaEstreno(dt);
        } else {
            JOptionPane.showMessageDialog(this, "No hay datos para ordenar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnordenar_fechaActionPerformed
    // Método para actualizar la cola de favoritos después de una eliminación

    private void actualizarColaFavoritos() {
        colaFavoritos.clear();
        DefaultTableModel dt = (DefaultTableModel) tblfavoritos.getModel();
        for (int i = 0; i < dt.getRowCount(); i++) {
            String[] datos = new String[dt.getColumnCount()];
            for (int j = 0; j < dt.getColumnCount(); j++) {
                datos[j] = dt.getValueAt(i, j).toString();
            }
            colaFavoritos.add(datos);
        }
    }

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
            java.util.logging.Logger.getLogger(FrameFavoritos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameFavoritos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameFavoritos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameFavoritos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameFavoritos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnbuscar;
    private javax.swing.JToggleButton btndeshacer;
    private javax.swing.JToggleButton btndeshacer1;
    private javax.swing.JToggleButton btneliminar;
    private javax.swing.JToggleButton btnlimpiar;
    private javax.swing.JToggleButton btnordenar_alfabeto;
    private javax.swing.JToggleButton btnordenar_fecha;
    private javax.swing.JComboBox<String> cbotipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblfavoritos;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
