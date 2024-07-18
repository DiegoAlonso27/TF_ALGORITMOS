package Views;

import Arbol.ArbolBinarioBusqueda;
import Class.Busqueda;
import Class.Peliculas;
import Methods.Busca;
import Methods.Ordena;
import static Views.FrameInicio.escritorio;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class FramePelículas extends javax.swing.JInternalFrame {

    DefaultTableModel dt = new DefaultTableModel();
    LinkedList<Peliculas> listaPeliculas = new LinkedList<>();
    LinkedList<Peliculas> pilaEliminados = new LinkedList<>();
    private List<Object[]> datosOriginales = new ArrayList<>();
    private boolean datosGuardados = false;

    public FramePelículas() {
        initComponents();
        //setLocationRelativeTo(null);

        // Define las columnas de la tabla
        String cabecera[] = {"Nombre", "Duración", "Género", "Total Recaudado $", "Fecha de Estreno"};
        dt.setColumnIdentifiers(cabecera); // Establece las cabeceras de las columnas en el modelo de tabla
        tblpeliculas.setModel(dt);

        // Cargar datos desde el archivo al iniciar la aplicación
        cargarDatosDesdeArchivo();
    }

    private void limpiarCampos() {
        txtnombre.setText("");
        txtduracion.setText("");
        cbogenero.setSelectedIndex(0);
        txtrecaudo.setText("");
        jdfecha.setDate(null);
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

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtduracion = new javax.swing.JTextField();
        cbogenero = new javax.swing.JComboBox<>();
        txtrecaudo = new javax.swing.JTextField();
        jdfecha = new com.toedter.calendar.JDateChooser();
        btnfavoritos = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblpeliculas = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnagregar = new javax.swing.JToggleButton();
        btneditar = new javax.swing.JToggleButton();
        btneliminar = new javax.swing.JToggleButton();
        btndeshacer = new javax.swing.JToggleButton();
        jPanel5 = new javax.swing.JPanel();
        btnalfabeto = new javax.swing.JToggleButton();
        btnestreno = new javax.swing.JToggleButton();
        btnrecaudo = new javax.swing.JToggleButton();
        Actores = new javax.swing.JToggleButton();
        jPanel6 = new javax.swing.JPanel();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JToggleButton();
        cbotipo = new javax.swing.JComboBox<>();
        btnlimpiar = new javax.swing.JToggleButton();
        jLabel6 = new javax.swing.JLabel();
        Regresar = new javax.swing.JToggleButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Registro de Películas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setText("Duración:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Fecha de Estreno:");

        jLabel4.setText("Género:");

        jLabel5.setText("Total Recuadado:");

        cbogenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Acción", "Terror", "Romance", "Drama", "Comedia", "Ficcion", "Aventura" }));

        btnfavoritos.setBackground(new java.awt.Color(51, 51, 51));
        btnfavoritos.setForeground(new java.awt.Color(255, 255, 255));
        btnfavoritos.setText("Añadir a Favoritos");
        btnfavoritos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfavoritosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(txtduracion, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(cbogenero, 0, 160, Short.MAX_VALUE)
                    .addComponent(txtrecaudo, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(jdfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnfavoritos, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(txtduracion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbogenero, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtrecaudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnfavoritos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(102, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblpeliculas.setBackground(new java.awt.Color(51, 51, 51));
        tblpeliculas.setForeground(new java.awt.Color(255, 255, 255));
        tblpeliculas.setModel(new javax.swing.table.DefaultTableModel(
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
        tblpeliculas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblpeliculasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblpeliculas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(btndeshacer, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnagregar)
                .addGap(18, 18, 18)
                .addComponent(btneditar)
                .addGap(27, 27, 27)
                .addComponent(btneliminar)
                .addGap(18, 18, 18)
                .addComponent(btndeshacer)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(51, 102, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Ordenar Películas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        btnalfabeto.setBackground(new java.awt.Color(51, 51, 51));
        btnalfabeto.setForeground(new java.awt.Color(255, 255, 255));
        btnalfabeto.setText("Ordenar por Alfabeto");
        btnalfabeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnalfabetoActionPerformed(evt);
            }
        });

        btnestreno.setBackground(new java.awt.Color(51, 51, 51));
        btnestreno.setForeground(new java.awt.Color(255, 255, 255));
        btnestreno.setText("Ordenar por Estreno");
        btnestreno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnestrenoActionPerformed(evt);
            }
        });

        btnrecaudo.setBackground(new java.awt.Color(51, 51, 51));
        btnrecaudo.setForeground(new java.awt.Color(255, 255, 255));
        btnrecaudo.setText("Ordenar Por Recuado");
        btnrecaudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrecaudoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnalfabeto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnestreno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnrecaudo, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnalfabeto)
                .addGap(34, 34, 34)
                .addComponent(btnestreno)
                .addGap(33, 33, 33)
                .addComponent(btnrecaudo)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        Actores.setBackground(new java.awt.Color(51, 51, 51));
        Actores.setForeground(new java.awt.Color(255, 255, 255));
        Actores.setText("Actores");
        Actores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActoresActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(51, 102, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Bucar Película", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

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
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbotipo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbotipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlimpiar))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Películas");

        Regresar.setBackground(new java.awt.Color(51, 51, 51));
        Regresar.setForeground(new java.awt.Color(255, 255, 255));
        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(270, 270, 270))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Actores, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Regresar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Actores)
                .addGap(70, 70, 70))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 718, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed

        // Obtiene los datos de la interfaz de usuario
        String nombre = txtnombre.getText().trim();
        String duracionStr = txtduracion.getText().trim();
        String genero = cbogenero.getSelectedItem().toString();
        String totalRecaudadoStr = txtrecaudo.getText().trim();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Valida que el campo 'Nombre' no esté vacío
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo 'Nombre' no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Convierte y valida el formato de la duración
        Duration duracion;
        try {
            String[] durParts = duracionStr.split(":");
            if (durParts.length != 2) {
                throw new NumberFormatException();
            }
            int horas = Integer.parseInt(durParts[0]);
            int minutos = Integer.parseInt(durParts[1]);
            duracion = Duration.ofHours(horas).plusMinutes(minutos);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El formato de la duración debe ser HH:MM.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Convierte y valida el formato del total recaudado
        double totalRecaudado;
        try {
            totalRecaudado = Double.parseDouble(totalRecaudadoStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El campo 'Total Recaudado' debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Convierte y valida la fecha de estreno
        LocalDate fechaEstreno;
        try {
            fechaEstreno = jdfecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "La fecha de estreno no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Formatea la fecha de estreno y la duración
        String fechaEstrenoStr = fechaEstreno.format(formatter);
        Date fechaEstrenoDate = Date.from(fechaEstreno.atStartOfDay(ZoneId.systemDefault()).toInstant());
        String duracionFormatted = String.format("%02d:%02d", duracion.toHours(), duracion.toMinutesPart());

        // Crea una nueva película y la añade a la lista de películas
        Peliculas pelicula = new Peliculas(nombre, duracion, genero, totalRecaudado, fechaEstrenoDate);
        listaPeliculas.add(pelicula);

        // Actualiza la tabla con la nueva película y limpia los campos
        guardarDatosEnArchivo();
        actualizarTabla();
        limpiarCampos();

    }//GEN-LAST:event_btnagregarActionPerformed

    private void btnalfabetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnalfabetoActionPerformed
        try {
            //llamamos al metodo en la clase ordena para ordenar con el metodo sort
            Ordena.ordenarPeliculasPorNombre(listaPeliculas);
            actualizarTabla();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al ordenar por nombre: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnalfabetoActionPerformed

    private void btnestrenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnestrenoActionPerformed
        try {
            //llamamos al metodo en la clase ordena para ordenar con el metodo Quick Sort
            Ordena.ordenarPeliculasPorFechaEstreno(listaPeliculas);
            actualizarTabla();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al ordenar por fecha de estreno: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnestrenoActionPerformed

    private void btnrecaudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrecaudoActionPerformed
        try {
            //llamamos al metodo en la clase ordena para ordenar con el metodo Merge Sort
            Ordena.ordenarPeliculasPorMayorRecaudacion(listaPeliculas);
            actualizarTabla();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al ordenar por mayor recaudación: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnrecaudoActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        int selectedRow = tblpeliculas.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para editar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtiene los datos de la interfaz de usuario
        String nombre = txtnombre.getText().trim();
        String duracionStr = txtduracion.getText().trim();
        String genero = cbogenero.getSelectedItem().toString();
        String totalRecaudadoStr = txtrecaudo.getText().trim();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Valida que el campo 'Nombre' no esté vacío
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo 'Nombre' no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Convierte y valida el formato de la duración
        Duration duracion;
        try {
            String[] durParts = duracionStr.split(":");
            if (durParts.length != 2) {
                throw new NumberFormatException();
            }
            int horas = Integer.parseInt(durParts[0]);
            int minutos = Integer.parseInt(durParts[1]);
            duracion = Duration.ofHours(horas).plusMinutes(minutos);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El formato de la duración debe ser HH:MM.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Convierte y valida el formato del total recaudado
        double totalRecaudado;
        try {
            totalRecaudado = Double.parseDouble(totalRecaudadoStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El campo 'Total Recaudado' debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Convierte y valida la fecha de estreno
        LocalDate fechaEstreno;
        try {
            fechaEstreno = jdfecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "La fecha de estreno no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Formatea la fecha de estreno y la duración
        String fechaEstrenoStr = fechaEstreno.format(formatter);
        Date fechaEstrenoDate = Date.from(fechaEstreno.atStartOfDay(ZoneId.systemDefault()).toInstant());
        String duracionFormatted = String.format("%02d:%02d", duracion.toHours(), duracion.toMinutesPart());

        // Actualiza la película en la lista y la tabla
        Peliculas pelicula = listaPeliculas.get(selectedRow);
        pelicula.setNombre(nombre);
        pelicula.setDuracion(duracion);
        pelicula.setGenero(genero);
        pelicula.setTotalRecaudado(totalRecaudado);
        pelicula.setFecheEstreno(fechaEstrenoDate);

        // Actualiza la tabla con la película editada
        dt.setValueAt(nombre, selectedRow, 0);
        dt.setValueAt(duracionFormatted, selectedRow, 1);
        dt.setValueAt(genero, selectedRow, 2);
        dt.setValueAt(totalRecaudado, selectedRow, 3);
        dt.setValueAt(fechaEstrenoStr, selectedRow, 4);

        // Guarda los cambios en el archivo de texto
        guardarDatosEnArchivo();
        limpiarCampos();

        // Muestra el mensaje de confirmación
        JOptionPane.showMessageDialog(this, "La película se ha editado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);


    }//GEN-LAST:event_btneditarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        int selectedRow = tblpeliculas.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Confirma si desea eliminar la película
        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar esta película?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        // Obtiene la película seleccionada
        Peliculas peliculaEliminada = listaPeliculas.get(selectedRow);

        // Elimina la película de la lista
        listaPeliculas.remove(selectedRow);

        // Guarda la acción en la pila de eliminados (para posible deshacer)
        pilaEliminados.push(peliculaEliminada);

        // Actualiza la tabla y guarda los cambios
        actualizarTabla();
        guardarDatosEnArchivo();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btndeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeshacerActionPerformed
        if (pilaEliminados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay acciones para deshacer.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Obtiene la última película eliminada de la pila
        Peliculas peliculaDeshacer = pilaEliminados.pop();

        // Añade la película de vuelta a la lista principal
        listaPeliculas.add(peliculaDeshacer);

        // Actualiza la tabla y guarda los cambios
        actualizarTabla();
        guardarDatosEnArchivo();

        JOptionPane.showMessageDialog(this, "Última acción deshecha exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);


    }//GEN-LAST:event_btndeshacerActionPerformed

    private void ActoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActoresActionPerformed
        int selectedRow = tblpeliculas.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para continuar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombrePelicula = (String) dt.getValueAt(selectedRow, 0); // Obtiene el nombre de la película

        // Crear una instancia del JInternalFrame FrameActores
        FrameActores frameActores = new FrameActores();
        frameActores.txtnombre_pelicula.setText(nombrePelicula); // Establece el nombre en el campo txtnombre_pelicula

        // Añadir el JInternalFrame al JDesktopPane principal
        FrameInicio parentFrame = (FrameInicio) SwingUtilities.getWindowAncestor(this); // Obtener el formulario principal
        parentFrame.escritorio.add(frameActores); // Agregar el JInternalFrame al JDesktopPane

        // Mostrar el JInternalFrame
        frameActores.setVisible(true);

    }//GEN-LAST:event_ActoresActionPerformed

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_RegresarActionPerformed

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
            LinkedList<Peliculas> resultados;

            // Realiza la búsqueda según el tipo seleccionado
            if (busqueda.getTipo().equalsIgnoreCase("Lineal")) {
                resultados = Busca.buscarPeliculasPorNombreLineal(listaPeliculas, busqueda);
            } else if (busqueda.getTipo().equalsIgnoreCase("Binaria")) {
                ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
                for (Peliculas pelicula : listaPeliculas) {
                    arbol.insertar(pelicula);
                }
                resultados = arbol.buscar(terminoBusqueda);
            } else {
                JOptionPane.showMessageDialog(this, "Tipo de búsqueda no válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Muestra los resultados de la búsqueda en la tabla
            if (resultados.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se encontraron películas que coincidan con la búsqueda.", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                dt.setRowCount(0); // Limpiar la tabla
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                for (Peliculas pelicula : resultados) {
                    String duracionFormatted = String.format("%02d:%02d", pelicula.getDuracion().toHours(), pelicula.getDuracion().toMinutesPart());
                    String fechaEstrenoStr = pelicula.getFecheEstreno().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(formatter);
                    dt.addRow(new Object[]{pelicula.getNombre(), duracionFormatted, pelicula.getGenero(), pelicula.getTotalRecaudado(), fechaEstrenoStr});
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al realizar la búsqueda: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        txtbuscar.setText("");
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

    private void tblpeliculasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblpeliculasMouseClicked
        int selectedRow = tblpeliculas.getSelectedRow();
        if (selectedRow != -1) {
            txtnombre.setText(dt.getValueAt(selectedRow, 0).toString());
            txtduracion.setText(dt.getValueAt(selectedRow, 1).toString());
            cbogenero.setSelectedItem(dt.getValueAt(selectedRow, 2).toString());
            txtrecaudo.setText(dt.getValueAt(selectedRow, 3).toString());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha = LocalDate.parse(dt.getValueAt(selectedRow, 4).toString(), formatter);
            jdfecha.setDate(Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        }
    }//GEN-LAST:event_tblpeliculasMouseClicked

    private void btnfavoritosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfavoritosActionPerformed
        int selectedRow = tblpeliculas.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una película para agregar a favoritos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener los datos de la película seleccionada
        String nombre = (String) dt.getValueAt(selectedRow, 0);
        String duracion = (String) dt.getValueAt(selectedRow, 1);
        String genero = (String) dt.getValueAt(selectedRow, 2);
        String fechaEstreno = (String) dt.getValueAt(selectedRow, 4);

        // Crear una instancia de FrameFavoritos y pasar los datos
        FrameFavoritos frameFavoritos = new FrameFavoritos();
        frameFavoritos.agregarPelicula(nombre, duracion, genero, fechaEstreno);

        // Mostrar el formulario FrameFavoritos si no está visible
        if (!frameFavoritos.isVisible()) {
            escritorio.add(frameFavoritos);
            frameFavoritos.setVisible(true);
        }
    }//GEN-LAST:event_btnfavoritosActionPerformed

    // Método para actualizar la tabla de películas
    private void actualizarTabla() {
        dt.setRowCount(0); // Elimina todas las filas existentes en el modelo de tabla
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Itera sobre la lista de películas y agrega cada película como una nueva fila en la tabla
        for (Peliculas pelicula : listaPeliculas) {
            String duracionFormatted = String.format("%02d:%02d", pelicula.getDuracion().toHours(), pelicula.getDuracion().toMinutesPart());
            String fechaEstrenoStr = pelicula.getFecheEstreno().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(formatter);
            dt.addRow(new Object[]{pelicula.getNombre(), duracionFormatted, pelicula.getGenero(), pelicula.getTotalRecaudado(), fechaEstrenoStr});
        }
    }

    // Método para guardar los datos en el archivo de texto
    private void guardarDatosEnArchivo() {
        try {
            FileWriter writer = new FileWriter("C:\\Files\\peliculas.txt"); // Sobrescribe el archivo en lugar de añadir al final
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            for (Peliculas pelicula : listaPeliculas) {
                bufferedWriter.write(pelicula.getNombre() + ","
                        + String.format("%02d:%02d", pelicula.getDuracion().toHours(), pelicula.getDuracion().toMinutesPart()) + ","
                        + pelicula.getGenero() + ","
                        + pelicula.getTotalRecaudado() + ","
                        + pelicula.getFecheEstreno().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para cargar los datos desde el archivo al iniciar la aplicación
    private void cargarDatosDesdeArchivo() {
        try {
            FileReader reader = new FileReader("C:\\Files\\peliculas.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                String nombre = parts[0];
                String duracionStr = parts[1];
                String genero = parts[2];
                double totalRecaudado = Double.parseDouble(parts[3]);
                LocalDate fechaEstreno = LocalDate.parse(parts[4], formatter);
                Duration duracion = Duration.ofHours(Integer.parseInt(duracionStr.split(":")[0]))
                        .plusMinutes(Integer.parseInt(duracionStr.split(":")[1]));
                Date fechaEstrenoDate = Date.from(fechaEstreno.atStartOfDay(ZoneId.systemDefault()).toInstant());

                Peliculas pelicula = new Peliculas(nombre, duracion, genero, totalRecaudado, fechaEstrenoDate);
                listaPeliculas.add(pelicula);
            }

            bufferedReader.close();
            reader.close();
            actualizarTabla();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePelículas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Actores;
    private javax.swing.JToggleButton Regresar;
    private javax.swing.JToggleButton btnagregar;
    private javax.swing.JToggleButton btnalfabeto;
    private javax.swing.JToggleButton btnbuscar;
    private javax.swing.JToggleButton btndeshacer;
    private javax.swing.JToggleButton btneditar;
    private javax.swing.JToggleButton btneliminar;
    private javax.swing.JToggleButton btnestreno;
    private javax.swing.JToggleButton btnfavoritos;
    private javax.swing.JToggleButton btnlimpiar;
    private javax.swing.JToggleButton btnrecaudo;
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
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdfecha;
    private javax.swing.JTable tblpeliculas;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtduracion;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtrecaudo;
    // End of variables declaration//GEN-END:variables
}
