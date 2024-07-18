package Views;

import Class.Busqueda;
import Class.Usuario;
import Methods.Busca;
import Methods.Ordena;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrameUsuarios extends javax.swing.JInternalFrame {

    DefaultTableModel dt = new DefaultTableModel(); // Modelo de tabla por defecto
    LinkedList<Usuario> pilaEliminados = new LinkedList<>(); // Pila para almacenar elementos eliminados
    LinkedList<Usuario> listaUsuarios = new LinkedList<>(); // Lista enlazada de usuarios
    private List<Object[]> datosOriginales = new ArrayList<>(); // Lista de arrays de objetos para almacenar datos originales de la tabla
    private boolean datosGuardados = false; // Bandera para verificar si los datos originales han sido guardados

    public FrameUsuarios() {
        initComponents();
        // setLocationRelativeTo(null);

        // Define las columnas de la tabla
        String cabecera[] = {"Usuario", "Contraseña", "Correo"};
        dt.setColumnIdentifiers(cabecera);
        tblusuario.setModel(dt);

        // Cargar datos desde el archivo al iniciar la aplicación
        cargarDatosDesdeArchivoUsuarios();

    }

    private void limpiarCampos() {
        txtcorreo.setText("");
        txtusuario.setText("");
        txtcontraseña.setText("");
    }

    // Método para guardar los datos originales de la tabla
    private void guardarDatosOriginales() {
        if (!datosGuardados) {
            datosOriginales.clear(); // Limpia la lista de datos originales
            // Itera sobre cada fila de la tabla
            for (int i = 0; i < dt.getRowCount(); i++) {
                Object[] fila = new Object[dt.getColumnCount()]; // Crea un nuevo array de objetos para almacenar los datos de la fila
                // Itera sobre cada columna de la fila
                for (int j = 0; j < dt.getColumnCount(); j++) {
                    fila[j] = dt.getValueAt(i, j); // Obtiene el valor de la celda y lo agrega al array de objetos
                }
                datosOriginales.add(fila); // Agrega el array de objetos a la lista de datos originales
            }
            datosGuardados = true; // Establece la bandera de datos guardados a verdadero
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtcorreo = new javax.swing.JTextField();
        txtusuario = new javax.swing.JTextField();
        txtcontraseña = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnagregar = new javax.swing.JToggleButton();
        btneditar = new javax.swing.JToggleButton();
        btneliminar = new javax.swing.JToggleButton();
        btndeshacer = new javax.swing.JToggleButton();
        btnguardar = new javax.swing.JToggleButton();
        jPanel5 = new javax.swing.JPanel();
        btnalfabeto = new javax.swing.JToggleButton();
        jPanel6 = new javax.swing.JPanel();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JToggleButton();
        cbotipo = new javax.swing.JComboBox<>();
        btnlimpiar = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblusuario = new javax.swing.JTable();
        jToggleButton1 = new javax.swing.JToggleButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuarios");

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Registro de Usuarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Correo:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuario:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contraseña:");

        txtcorreo.setBackground(new java.awt.Color(255, 255, 255));

        txtusuario.setBackground(new java.awt.Color(255, 255, 255));

        txtcontraseña.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcorreo)
                    .addComponent(txtusuario)
                    .addComponent(txtcontraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(51, 102, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Registradar Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        btnagregar.setBackground(new java.awt.Color(51, 51, 51));
        btnagregar.setForeground(new java.awt.Color(255, 255, 255));
        btnagregar.setText("Agregar");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        btneditar.setBackground(new java.awt.Color(51, 51, 51));
        btneditar.setForeground(new java.awt.Color(255, 255, 255));
        btneditar.setText("Editar");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
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

        btndeshacer.setBackground(new java.awt.Color(51, 51, 51));
        btndeshacer.setForeground(new java.awt.Color(255, 255, 255));
        btndeshacer.setText("Deshacer");
        btndeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeshacerActionPerformed(evt);
            }
        });

        btnguardar.setBackground(new java.awt.Color(0, 0, 0));
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndeshacer, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnagregar)
                .addGap(12, 12, 12)
                .addComponent(btnguardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btneditar)
                .addGap(18, 18, 18)
                .addComponent(btneliminar)
                .addGap(12, 12, 12)
                .addComponent(btndeshacer)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(51, 102, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Ordenar Usuarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        btnalfabeto.setBackground(new java.awt.Color(51, 51, 51));
        btnalfabeto.setForeground(new java.awt.Color(255, 255, 255));
        btnalfabeto.setText("Ordenar por Alfabeto");
        btnalfabeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnalfabetoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(btnalfabeto, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnalfabeto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(51, 102, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Bucar Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        txtbuscar.setBackground(new java.awt.Color(255, 255, 255));

        btnbuscar.setBackground(new java.awt.Color(51, 51, 51));
        btnbuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        cbotipo.setBackground(new java.awt.Color(255, 255, 255));
        cbotipo.setForeground(new java.awt.Color(0, 0, 0));
        cbotipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de Busqueda", "Lineal", "Binaria" }));

        btnlimpiar.setBackground(new java.awt.Color(51, 51, 51));
        btnlimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(cbotipo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbotipo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlimpiar))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tblusuario.setModel(new javax.swing.table.DefaultTableModel(
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
        tblusuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblusuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblusuario);

        jToggleButton1.setBackground(new java.awt.Color(51, 51, 51));
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setText("Salir");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(237, 237, 237))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton1))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        // Obtiene los datos de la interfaz de usuario
        String usuario = txtusuario.getText().trim();
        String contraseña = txtcontraseña.getText().trim();
        String correo = txtcorreo.getText().trim();

        // Valida que los campos no estén vacíos
        if (usuario.isEmpty() || contraseña.isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crea un nuevo usuario y lo añade a la lista de usuarios
        Usuario nuevoUsuario = new Usuario(usuario, contraseña, correo);
        listaUsuarios.add(nuevoUsuario);

        // Actualiza la tabla con el nuevo usuario y limpia los campos
        actualizarTablaUsuarios();
        limpiarCampos();


    }//GEN-LAST:event_btnagregarActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed

        int selectedRow = tblusuario.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para editar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

// Obtiene los datos de la interfaz de usuario
        String usuario = txtusuario.getText().trim();
        String contraseña = txtcontraseña.getText().trim();
        String correo = txtcorreo.getText().trim();

// Valida que los campos no estén vacíos
        if (usuario.isEmpty() || contraseña.isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Actualiza el usuario en la lista y la tabla
        Usuario usuarioSeleccionado = listaUsuarios.get(selectedRow);
        usuarioSeleccionado.setUsuario(usuario);
        usuarioSeleccionado.setContraseña(contraseña);
        usuarioSeleccionado.setCorreo(correo);

        // Actualiza la tabla con el usuario editado
        dt.setValueAt(usuario, selectedRow, 0);
        dt.setValueAt(contraseña, selectedRow, 1); // Aquí se muestra la contraseña
        dt.setValueAt(correo, selectedRow, 2);

        // Guarda los cambios en el archivo de texto
        guardarDatosEnArchivoUsuarios();

        // Limpia los campos de entrada
        limpiarCampos();

        // Muestra el mensaje de confirmación
        JOptionPane.showMessageDialog(this, "El usuario se ha editado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btneditarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        int selectedRow = tblusuario.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Confirma si desea eliminar el usuario
        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar este usuario?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        // Obtiene el usuario seleccionado
        Usuario usuarioEliminado = listaUsuarios.get(selectedRow);

        // Elimina el usuario de la lista
        listaUsuarios.remove(selectedRow);

        // Guarda la acción en la pila de eliminados (para posible deshacer)
        pilaEliminados.push(usuarioEliminado);

        // Actualiza la tabla y guarda los cambios
        actualizarTablaUsuarios();
        guardarDatosEnArchivoUsuarios();

        // Limpia los campos de entrada
        limpiarCampos();

        // Muestra el mensaje de confirmación
        JOptionPane.showMessageDialog(this, "El usuario se ha eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btneliminarActionPerformed

    private void btndeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeshacerActionPerformed
        if (pilaEliminados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay acciones para deshacer.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Obtiene el último usuario eliminado de la pila
        Usuario usuarioDeshacer = pilaEliminados.pop();

        // Añade el usuario de vuelta a la lista principal
        listaUsuarios.add(usuarioDeshacer);

        // Actualiza la tabla y guarda los cambios
        actualizarTablaUsuarios();
        guardarDatosEnArchivoUsuarios();

        // Muestra el mensaje de confirmación
        JOptionPane.showMessageDialog(this, "Última acción deshecha exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);


    }//GEN-LAST:event_btndeshacerActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        try {
            FileWriter writer = new FileWriter("C:\\Files\\usuarios.txt"); // Cambia el nombre del archivo a usuarios.txt
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            for (Usuario usuario : listaUsuarios) {
                bufferedWriter.write(usuario.getUsuario() + ","
                        + usuario.getContraseña() + ","
                        + usuario.getCorreo());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            writer.close();
            JOptionPane.showMessageDialog(this, "Datos guardados correctamente en C:\\Files\\usuarios.txt.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnalfabetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnalfabetoActionPerformed
        try {
            // Llamamos al método en la clase Ordena para ordenar por correo
            Ordena.ordenarUsuariosPorCorreoSeleccion(listaUsuarios);
            actualizarTablaUsuarios(); // Asumiendo que actualizas la tabla de usuarios
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al ordenar por correo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnalfabetoActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // Obtiene el término de búsqueda ingresado por el usuario
        String terminoBusqueda = txtbuscar.getText().trim();

        // Verifica si los datos originales han sido guardados
        if (!datosGuardados) {
            guardarDatosOriginales();
        }

        // Verifica si el término de búsqueda está vacío
        if (terminoBusqueda.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un término de búsqueda.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // Crea un objeto de búsqueda con el término de búsqueda y el tipo seleccionado
            Busqueda busqueda = new Busqueda(terminoBusqueda, cbotipo.getSelectedItem().toString());
            LinkedList<Usuario> resultados;
            // Realiza la búsqueda según el tipo seleccionado
            if (busqueda.getTipo().equalsIgnoreCase("Lineal")) {
                resultados = Busca.buscarUsuariosPorNombreLineal(listaUsuarios, busqueda);
            } else if (busqueda.getTipo().equalsIgnoreCase("Binaria")) {
                resultados = Busca.buscarUsuariosPorNombreBinarioRecursivo(listaUsuarios, busqueda);
            } else {
                JOptionPane.showMessageDialog(this, "Tipo de búsqueda no válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Muestra los resultados de la búsqueda en la tabla
            if (resultados.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se encontraron usuarios que coincidan con la búsqueda.", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                dt.setRowCount(0); // Limpiar la tabla
                for (Usuario usuario : resultados) {
                    dt.addRow(new Object[]{usuario.getUsuario(), usuario.getContraseña(), usuario.getCorreo()});
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al realizar la búsqueda: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed

        // Verifica si los datos originales han sido guardados
        if (datosGuardados) {
            dt.setRowCount(0); // Limpiar la tabla
            // Restaura los datos originales en la tabla
            for (Object[] fila : datosOriginales) {
                dt.addRow(fila);
            }
            // Limpia los campos de entrada de datos
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "No hay datos originales guardados.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void tblusuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblusuarioMouseClicked
        int selectedRow = tblusuario.getSelectedRow();
        if (selectedRow != -1) {
            txtusuario.setText(dt.getValueAt(selectedRow, 0).toString());
            txtcontraseña.setText(dt.getValueAt(selectedRow, 1).toString()); // Mostrar la contraseña
            txtcorreo.setText(dt.getValueAt(selectedRow, 2).toString());
        }
    }//GEN-LAST:event_tblusuarioMouseClicked

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed
    private void actualizarTablaUsuarios() {
        // Borra todas las filas del modelo de tabla
        dt.setRowCount(0);

        // Añade los usuarios de la lista al modelo de tabla
        for (Usuario usuario : listaUsuarios) {
            dt.addRow(new Object[]{usuario.getUsuario(), usuario.getContraseña(), usuario.getCorreo()});
        }
    }

    // Método para guardar los datos de usuarios en el archivo de texto
    private void guardarDatosEnArchivoUsuarios() {
        try {
            FileWriter writer = new FileWriter("C:\\Files\\usuarios.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            for (Usuario usuario : listaUsuarios) {
                bufferedWriter.write(usuario.getUsuario() + ","
                        + usuario.getContraseña() + ","
                        + usuario.getCorreo());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar los datos de usuarios: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarDatosDesdeArchivoUsuarios() {
        try {
            FileReader reader = new FileReader("C:\\Files\\usuarios.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                String usuario = parts[0];
                String contraseña = parts[1];
                String correo = parts[2];

                Usuario nuevoUsuario = new Usuario(usuario, contraseña, correo);
                listaUsuarios.add(nuevoUsuario);
            }

            bufferedReader.close();
            reader.close();
            actualizarTablaUsuarios();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(FrameUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnagregar;
    private javax.swing.JToggleButton btnalfabeto;
    private javax.swing.JToggleButton btnbuscar;
    private javax.swing.JToggleButton btndeshacer;
    private javax.swing.JToggleButton btneditar;
    private javax.swing.JToggleButton btneliminar;
    private javax.swing.JToggleButton btnguardar;
    private javax.swing.JToggleButton btnlimpiar;
    private javax.swing.JComboBox<String> cbotipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable tblusuario;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcontraseña;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
