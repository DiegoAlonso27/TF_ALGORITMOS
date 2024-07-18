package Views;

import Class.Actores;
import Class.Busqueda;
import Grafos.GrafoActores;
import Methods.Busca;
import Methods.Ordena;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrameActores extends javax.swing.JInternalFrame {

    LinkedList<Actores> listaActores = new LinkedList<>();
    DefaultTableModel dt = new DefaultTableModel();
    LinkedList<Actores> pilaEliminados = new LinkedList<>(); // Pila para almacenar elementos eliminados
    private List<Object[]> datosOriginales = new ArrayList<>(); // Lista de arrays de objetos para almacenar datos originales de la tabla
    private boolean datosGuardados = false; // Bandera para verificar si los datos originales han sido guardados

    GrafoActores grafoActores;

    public FrameActores() {
        initComponents();
        //setLocationRelativeTo(null);
        String cabecera[] = {"Nombre", "Apellidos", "Género", "Edad", "Pelicula",};
        dt.setColumnIdentifiers(cabecera);
        tblactores.setModel(dt);

        grafoActores = new GrafoActores(); // Inicialización del grafo
        cargarDatosDesdeArchivo();

    }

    private void limpiarCampos() {
        txtnombre.setText("");
        txtapellido.setText("");
        cbogenero.setSelectedIndex(0);
        txtedad.setText("");
        txtbuscar.setText("");
        cbotipo.setSelectedIndex(0);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtedad = new javax.swing.JTextField();
        cbogenero = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtnombre_pelicula = new javax.swing.JTextField();
        Grafo = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        btnagregar = new javax.swing.JToggleButton();
        btneditar = new javax.swing.JToggleButton();
        btneliminar = new javax.swing.JToggleButton();
        btndeshacer = new javax.swing.JToggleButton();
        jPanel4 = new javax.swing.JPanel();
        btnalfabeto = new javax.swing.JToggleButton();
        btnedad = new javax.swing.JToggleButton();
        jPanel5 = new javax.swing.JPanel();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JToggleButton();
        cbotipo = new javax.swing.JComboBox<>();
        btnlimpiar = new javax.swing.JToggleButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblactores = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Registro de Actores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Género");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Edad:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Apellidos:");

        cbogenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hombre", "Mujer", "No definido", "Otros" }));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Pelicula:");

        Grafo.setBackground(new java.awt.Color(51, 51, 51));
        Grafo.setForeground(new java.awt.Color(255, 255, 255));
        Grafo.setText("Verificar Relacion");
        Grafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GrafoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbogenero, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnombre_pelicula, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(txtnombre))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Grafo)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtnombre_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbogenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Grafo)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(51, 102, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Registrar Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnagregar, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(btneditar, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(btndeshacer, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnagregar)
                .addGap(18, 18, 18)
                .addComponent(btneditar)
                .addGap(18, 18, 18)
                .addComponent(btneliminar)
                .addGap(18, 18, 18)
                .addComponent(btndeshacer)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(51, 102, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Ordenar Actores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        btnalfabeto.setBackground(new java.awt.Color(51, 51, 51));
        btnalfabeto.setForeground(new java.awt.Color(255, 255, 255));
        btnalfabeto.setText("Ordenar por Alfabeto");
        btnalfabeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnalfabetoActionPerformed(evt);
            }
        });

        btnedad.setBackground(new java.awt.Color(51, 51, 51));
        btnedad.setForeground(new java.awt.Color(255, 255, 255));
        btnedad.setText("Ordenar por Edad");
        btnedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnedadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnalfabeto, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(btnedad, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnalfabeto)
                .addGap(37, 37, 37)
                .addComponent(btnedad)
                .addGap(67, 67, 67))
        );

        jPanel5.setBackground(new java.awt.Color(51, 102, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Buscar Actores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbotipo, 0, 212, Short.MAX_VALUE)
                    .addComponent(txtbuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbotipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlimpiar))
                .addGap(15, 15, 15))
        );

        jPanel6.setBackground(new java.awt.Color(51, 153, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblactores.setModel(new javax.swing.table.DefaultTableModel(
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
        tblactores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblactoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblactores);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel6.setFont(new java.awt.Font("Humnst777 BT", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Actores");

        jToggleButton1.setBackground(new java.awt.Color(51, 51, 51));
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setText("Regresar");
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton1)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnalfabetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnalfabetoActionPerformed
        try {
            //llamamos al metodo en la clase ordena para ordenar con el metodo sort
            Ordena.ordenarActoresPorNombre(listaActores);
            actualizarTabla();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al ordenar por nombre: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnalfabetoActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed

        String nombre = txtnombre.getText().trim();
        String apellido = txtapellido.getText().trim();
        String genero = cbogenero.getSelectedItem().toString();
        String edadStr = txtedad.getText().trim();
        String nombrePelicula = txtnombre_pelicula.getText().trim();

        if (nombre.isEmpty() || apellido.isEmpty() || nombrePelicula.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Los campos 'Nombre', 'Apellido' y 'Nombre Película' no pueden estar vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        grafoActores.agregarRelacion(nombre + " " + apellido, nombrePelicula);

        int edad;
        try {
            edad = Integer.parseInt(edadStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El campo 'Edad' debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Actores actor = new Actores(nombre, apellido, genero, edad, nombrePelicula);
        listaActores.add(actor);

        actualizarTabla();
        limpiarCampos();
        guardarDatosEnArchivo();

    }//GEN-LAST:event_btnagregarActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed

        int selectedRow = tblactores.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para editar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtiene los datos de la interfaz de usuario
        String nombre = txtnombre.getText().trim();
        String apellido = txtapellido.getText().trim();
        String genero = cbogenero.getSelectedItem().toString();
        String edadStr = txtedad.getText().trim();
        String nombrePelicula = txtnombre_pelicula.getText().trim();

        // Valida que el campo 'Nombre' no esté vacío
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo 'Nombre' no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Valida que el campo 'Apellido' no esté vacío
        if (apellido.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo 'Apellido' no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Valida y convierte el campo 'Edad' a número entero
        int edad;
        try {
            edad = Integer.parseInt(edadStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El campo 'Edad' debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Actualiza el actor en la lista y la tabla
        Actores actor = listaActores.get(selectedRow);
        actor.setNombre(nombre);
        actor.setApellido(apellido);
        actor.setSexo(genero);
        actor.setEdad(edad);
        actor.setNombrePelicula(nombrePelicula);

        // Actualiza la tabla con el actor editado
        dt.setValueAt(nombre, selectedRow, 0);
        dt.setValueAt(apellido, selectedRow, 1);
        dt.setValueAt(genero, selectedRow, 2);
        dt.setValueAt(edad, selectedRow, 3);
        dt.setValueAt(nombrePelicula, selectedRow, 4);

        // Guarda los cambios en el archivo de texto
        guardarDatosEnArchivo();
        limpiarCampos();

        // Muestra el mensaje de confirmación
        JOptionPane.showMessageDialog(this, "El actor se ha editado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);


    }//GEN-LAST:event_btneditarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        int selectedRow = tblactores.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Confirma si desea eliminar el actor
        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar este actor?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Obtiene el actor seleccionado
            Actores actor = listaActores.get(selectedRow);

            // Elimina al actor de la lista
            listaActores.remove(selectedRow);

            // Actualiza la tabla después de eliminar al actor
            actualizarTabla();

            // Muestra el mensaje de confirmación
            JOptionPane.showMessageDialog(this, "El actor se ha eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Guarda los cambios en el archivo de texto
            guardarDatosEnArchivo();
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btndeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeshacerActionPerformed
        if (pilaEliminados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay acciones para deshacer.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Obtiene el último actor eliminado de la pila
        Actores actorDeshacer = pilaEliminados.pop();

        // Añade el actor de vuelta a la lista principal
        listaActores.add(actorDeshacer);

        // Actualiza la tabla y guarda los cambios
        actualizarTabla();
        guardarDatosEnArchivo();

        JOptionPane.showMessageDialog(this, "Última acción deshecha exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btndeshacerActionPerformed

    private void btnedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnedadActionPerformed
        try {
            //llamamos al metodo en la clase ordena para ordenar con el metodo sort
            Ordena.ordenarActoresPorEdadBurbuja(listaActores);
            actualizarTabla();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al ordenar por nombre: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnedadActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
            LinkedList<Actores> resultados;
            // Realiza la búsqueda según el tipo seleccionado
            if (busqueda.getTipo().equalsIgnoreCase("Lineal")) {
                resultados = Busca.buscarActoresPorNombreLineal(listaActores, busqueda);
            } else if (busqueda.getTipo().equalsIgnoreCase("Binaria")) {
                // Ordena la lista antes de realizar la búsqueda binaria
                Collections.sort(listaActores, Comparator.comparing(Actores::getNombre, String.CASE_INSENSITIVE_ORDER));
                resultados = Busca.buscarActoresPorNombreBinarioRecursivo(listaActores, busqueda);
            } else {
                JOptionPane.showMessageDialog(this, "Tipo de búsqueda no válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Muestra los resultados de la búsqueda en la tabla
            if (resultados.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se encontraron actores que coincidan con la búsqueda.", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                dt.setRowCount(0); // Limpiar la tabla
                for (Actores actor : resultados) {
                    dt.addRow(new Object[]{actor.getNombre(), actor.getApellido(), actor.getSexo(), actor.getEdad(), actor.getNombrePelicula()});
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

    private void tblactoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblactoresMouseClicked
        int selectedRow = tblactores.getSelectedRow();
        if (selectedRow != -1) {
            Object nombre = dt.getValueAt(selectedRow, 0);
            Object apellido = dt.getValueAt(selectedRow, 1);
            Object genero = dt.getValueAt(selectedRow, 2);
            Object edad = dt.getValueAt(selectedRow, 3);
            Object nombrePelicula = dt.getValueAt(selectedRow, 4);

            // Verificar si alguno de los valores es null antes de convertirlo a String
            String nombreStr = (nombre != null) ? nombre.toString() : "";
            String apellidoStr = (apellido != null) ? apellido.toString() : "";
            String generoStr = (genero != null) ? genero.toString() : "";
            String edadStr = (edad != null) ? edad.toString() : "";
            String nombrePeliculaStr = (nombrePelicula != null) ? nombrePelicula.toString() : "";

            // Luego puedes usar estos valores en tu lógica de manejo de eventos
            // Por ejemplo, mostrarlos en campos de texto o realizar otras operaciones
            txtnombre.setText(nombreStr);
            txtapellido.setText(apellidoStr);
            cbogenero.setSelectedItem(generoStr);
            txtedad.setText(edadStr);
            txtnombre_pelicula.setText(nombrePeliculaStr);
        }

    }//GEN-LAST:event_tblactoresMouseClicked

    private void GrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GrafoActionPerformed
        int filaSeleccionada = tblactores.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un actor para ver sus películas.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtiene el nombre completo del actor seleccionado
        String nombreCompleto = dt.getValueAt(filaSeleccionada, 0).toString() + " " + dt.getValueAt(filaSeleccionada, 1).toString();

        // Obtiene las películas relacionadas con el actor
        List<String> peliculas = grafoActores.obtenerPeliculas(nombreCompleto);

        if (peliculas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El actor seleccionado no tiene películas asociadas.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Muestra las películas en un mensaje
            StringBuilder mensaje = new StringBuilder("Películas en las que ha participado " + nombreCompleto + ":\n");
            for (String pelicula : peliculas) {
                mensaje.append("- ").append(pelicula).append("\n");
            }
            JOptionPane.showMessageDialog(this, mensaje.toString(), "Películas del Actor", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_GrafoActionPerformed
    private void actualizarTabla() {
        dt.setRowCount(0);
        for (Actores actor : listaActores) {
            dt.addRow(new Object[]{actor.getNombre(), actor.getApellido(), actor.getSexo(), actor.getEdad(), actor.getNombrePelicula()});
        }
    }

    private void guardarDatosEnArchivo() {
        String rutaArchivo = "C:\\Files\\actores.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Actores actor : listaActores) {
                bw.write(actor.getNombre() + "," + actor.getApellido() + "," + actor.getSexo() + "," + actor.getEdad() + "," + actor.getNombrePelicula());
                bw.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar en el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarDatosDesdeArchivo() {
        String rutaArchivo = "C:\\Files\\actores.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 5) {
                    Actores actor = new Actores(datos[0], datos[1], datos[2], Integer.parseInt(datos[3]), datos[4]);
                    listaActores.add(actor);
                    grafoActores.agregarRelacion(datos[0] + " " + datos[1], datos[4]);
                }
            }
            actualizarTabla();
        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameActores.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameActores.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameActores.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameActores.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameActores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Grafo;
    private javax.swing.JToggleButton btnagregar;
    private javax.swing.JToggleButton btnalfabeto;
    private javax.swing.JToggleButton btnbuscar;
    private javax.swing.JToggleButton btndeshacer;
    private javax.swing.JToggleButton btnedad;
    private javax.swing.JToggleButton btneditar;
    private javax.swing.JToggleButton btneliminar;
    private javax.swing.JToggleButton btnlimpiar;
    private javax.swing.JComboBox<String> cbogenero;
    private javax.swing.JComboBox<String> cbotipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable tblactores;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtedad;
    private javax.swing.JTextField txtnombre;
    public static javax.swing.JTextField txtnombre_pelicula;
    // End of variables declaration//GEN-END:variables
}
