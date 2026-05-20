import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;

public class Frame extends JFrame {
    JButton bAltas;
    JButton bCons;
    JButton bVolver;
    JTextArea iClave;
    JTextArea iMarca;
    JTextArea iModelo;
    JTextArea iPrecio;
    JLabel textoClave;
    JLabel textoMarca;
    JLabel textoModelo;
    JLabel textoPrecio;
    JLabel textoRegistro1;
    JLabel textoRegistro2;
    JButton bRegistrar;
    JLabel imagenRegistro;
    JLabel textoConsultaGeneral;
    JLabel textoConsultaModelo;
    JLabel textoConsultaModelo2;
    JLabel textoConsultaClave;
    JLabel textoConsultaClave2;
    JButton bConsultaGen;
    JButton bConsultaEsp;
    JButton bConsultaClave;
    JTable jt;
    JScrollPane sp;
    JTextArea iBusqueda;
    JButton bBuscarBE;
    JButton bBuscarBC;
    JButton bBajas;
    JLabel textoBajas;
    JLabel textoBajas2;
    JTextArea iClaveEliminar;
    JButton bEliminarClave;
    JLabel imagenPrincipal;
    JLabel imagenBajas;
    JSpinner sCantidad;
    JLabel textoCantidad;
    JLabel textoYear;
    JTextArea iYear;
    JButton bMod;
    JButton bModificar;
    JLabel textoModificacion;
    JLabel textoModificacion2;
    JButton bCancelarMod;
    JLabel textoModificacion21;
    JLabel textoModificacion22;
    JButton bGuardar;
    JButton bVistaAdmin;
    JButton bVistaPersonal;
    JButton bLogout;
    JLabel textocodigoProducto;
    JTextArea iCodigoProducto;
    JLabel textoCliente;
    JTextArea iCliente;
    JLabel textoStock;
    JTextArea infoStock;
    JLabel vtextoMarca;
    JTextArea infoMarca;
    JLabel vtextoModelo;
    JTextArea infoModelo;
    JLabel vtextoPrecio;
    JTextArea infoPrecio;
    JLabel vtextoYear;
    JTextArea infoYear;
    JButton ventasBuscar;
    JSpinner sCantidadVenta;
    JLabel textoCantidadAgregar;
    JPanel panelVentas;
    JButton bVentas;
    JButton bCierreCaja;
    JButton bCancelarVenta;
    JTable TablaVenta;
    JScrollPane TablaVentaSP;
    JButton bAgregarCarrito;
    JLabel textoTotalCompra;
    JLabel totalCompra;
    JButton bConcretarCompra;
    JButton bConsultaReportes;
    JPanel panelConsultaReportes;
    JComboBox<String> selectorReportes;
    JComboBox<String> selectorVenta;
    JButton bVolverConsultaR;
    JTable TablaConsultarReportes;
    JScrollPane TablaConsultarSP;
    JLabel textoClienteReporte;
    JLabel textoFechaCompraReporte;
    JLabel textoTotalCompraReporte;
    JTextArea infoClienteReporte;
    JTextArea infoFechaCompraReporte;
    JTextArea infoTotalCompraReporte;

    //GenerarCliente y AtenderCliente
    JButton bGenerarCliente;
    JButton bAtenderCliente;
    

    Gestion archivo = new Gestion();

    public Frame(){
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(500,320);
        setLocationRelativeTo(null);
        setTitle("PriceAuto");
        setResizable(false);
        Image icono = new ImageIcon("nissanlogo.png").getImage();
        setIconImage(icono);
        Image registroFoto = new ImageIcon(getClass().getResource("registroauto.png")).getImage();
        Image registroFotoescalada = registroFoto.getScaledInstance(175, 175,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon registroFinal = new ImageIcon(registroFotoescalada);

        Image principalFoto = new ImageIcon(getClass().getResource("logocentral.png")).getImage();
        Image principalFotoEscalada = principalFoto.getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon principalFinal = new ImageIcon(principalFotoEscalada);

        Image bajasFoto = new ImageIcon(getClass().getResource("bajasfoto.png")).getImage();
        Image bajasFotoEscalada = bajasFoto.getScaledInstance(250, 250,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon bajasFinal = new ImageIcon(bajasFotoEscalada);

        Image logoutFoto = new ImageIcon(getClass().getResource("volver.png")).getImage();
        Image logoutEscalada = logoutFoto.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon logoutFinal = new ImageIcon(logoutEscalada);

        SpinnerModel propiedadesCantidad =  new SpinnerNumberModel(0,0,1000,1); //step  

        bAltas = new JButton();
        bCons = new JButton();
        bVolver = new JButton();
        textoClave=new JLabel("Clave:");
        textoMarca=new JLabel("Marca:");
        textoModelo=new JLabel("Modelo:");
        textoPrecio=new JLabel("Precio:");
        textoRegistro1=new JLabel("REGISTRO");
        textoRegistro2=new JLabel("Porfavor ingresa los siguientes datos.");
        iClave=new JTextArea();
        iMarca=new JTextArea();
        iModelo=new JTextArea();
        iPrecio=new JTextArea();
        bRegistrar = new JButton();
        imagenRegistro = new JLabel(registroFinal);
        textoConsultaGeneral = new JLabel("CONSULTA GENERAL");
        textoConsultaModelo = new JLabel("CONSULTA POR MODELO");
        textoConsultaClave = new JLabel("CONSULTA POR CLAVE");
        bConsultaClave = new JButton();
        bConsultaEsp = new JButton();
        bConsultaGen = new JButton();
        iBusqueda = new JTextArea();
        bBuscarBC= new JButton();
        bBuscarBE= new JButton();
        bBajas= new JButton();
        textoConsultaModelo2 = new JLabel("Introduce el nombre de modelo a buscar:");
        textoConsultaClave2 = new JLabel("Introduce la clave a buscar:");
        textoBajas = new JLabel("Bajas");
        textoBajas2 = new JLabel("Introduce numero clave del coche a eliminar: ");
        iClaveEliminar=new JTextArea();
        bEliminarClave = new JButton();
        imagenPrincipal = new JLabel(principalFinal);
        imagenBajas = new JLabel(bajasFinal);
        sCantidad = new JSpinner(propiedadesCantidad);
        textoCantidad = new JLabel("Cantidad:");
        iYear = new JTextArea();
        textoYear = new JLabel("A\u00f1o:");
        bMod = new JButton();
        bModificar = new JButton();
        textoModificacion=new JLabel("MODIFICACIONES");
        textoModificacion2=new JLabel("Porfavor selecciona en la tabla el carro a modificar.");
        textoModificacion21=new JLabel("MODIFICACIONES");
        textoModificacion22=new JLabel("Editalo y guardalo con el boton Guardar");
        bCancelarMod = new JButton();
        bGuardar = new JButton();
        bVistaAdmin = new JButton();
        bVistaPersonal = new JButton();
        bLogout = new JButton();
        bVentas = new JButton("Ventas");
        bAtenderCliente = new JButton("Atender Cliente");
        bGenerarCliente = new JButton("Generar Cliente");
        bCierreCaja = new JButton("Cierre caja");
        bConsultaReportes = new JButton("Consulta Reportes");

        bLogout.setIcon(logoutFinal);

        add(bAltas);
        add(bCons);
        add(bVolver);
        add(textoClave);
        add(textoMarca);
        add(textoModelo);
        add(textoPrecio);
        add(textoRegistro1);
        add(textoRegistro2);
        add(iClave);
        add(iMarca);
        add(iModelo);
        add(iPrecio);
        add(bRegistrar);
        add(imagenRegistro);
        add(textoConsultaGeneral);
        add(textoConsultaModelo);
        add(textoConsultaClave);
        add(textoConsultaModelo2);
        add(textoConsultaClave2);
        add(bConsultaClave);
        add(bConsultaEsp);
        add(bConsultaGen);
        add(bBuscarBE);
        add(bBuscarBC);
        add(iBusqueda);
        add(bBajas);
        add(textoBajas);
        add(textoBajas2);
        add(iClaveEliminar);
        add(bEliminarClave);
        String data[][]={{"","","",""}};  
        String column[]={"CLAVE","MARCA","MODELO","A\u00d1O","PRECIO","CANTIDAD"};
        jt=new JTable(data,column);
        jt.getTableHeader().setResizingAllowed(false);
        jt.getTableHeader().setReorderingAllowed(false);
        sp=new JScrollPane(jt);    
        add(sp);   
        add(imagenPrincipal); 
        add(imagenBajas); 
        add(sCantidad);
        add(textoCantidad);
        add(textoYear);
        add(iYear);
        add(bMod);
        add(bModificar);
        add(textoModificacion);
        add(textoModificacion2);
        add(bCancelarMod);
        add(textoModificacion21);
        add(textoModificacion22);
        add(bGuardar);
        add(bVistaAdmin);
        add(bVistaPersonal);
        add(bLogout);
        add(bVentas);
        add(bAtenderCliente);
        add(bGenerarCliente);
        add(bCierreCaja);
        add(bConsultaReportes);

        //PANEL VENTAS
        textocodigoProducto = new JLabel("CODIGO AUTO:");
        iCodigoProducto = new JTextArea();
        textoCliente = new JLabel("Cliente:");
        iCliente = new JTextArea();
        vtextoMarca = new JLabel("Marca:");
        infoMarca = new JTextArea();
        vtextoModelo = new JLabel("Modelo:");
        infoModelo = new JTextArea();
        vtextoPrecio = new JLabel("Precio:");
        infoPrecio = new JTextArea();
        vtextoYear = new JLabel("A\u00f1o:");
        infoYear = new JTextArea();
        textoStock = new JLabel("STOCK:");
        infoStock = new JTextArea();
        panelVentas = new JPanel();
        ventasBuscar = new JButton("Buscar"); 
        SpinnerModel propiedadeSpinnerVentas =  new SpinnerNumberModel(0,0,0,1);
        sCantidadVenta = new JSpinner(propiedadeSpinnerVentas);
        textoCantidadAgregar = new JLabel("Cantidad para agregar al carrito:");
        bCancelarVenta = new JButton("Volver");
        TablaVenta= new JTable(data,column);
        TablaVenta.getTableHeader().setResizingAllowed(false);
        TablaVenta.getTableHeader().setReorderingAllowed(false);
        TablaVentaSP= new JScrollPane(TablaVenta);
        bAgregarCarrito = new JButton("Agregar al carrito"); 
        textoTotalCompra = new JLabel("Total:");
        totalCompra = new JLabel();
        bConcretarCompra = new JButton("Concretar compra");  

        panelVentas.add(textocodigoProducto);
        panelVentas.add(iCodigoProducto);
        panelVentas.add(textoCliente);
        panelVentas.add(iCliente);
        panelVentas.add(vtextoMarca);
        panelVentas.add(infoMarca);
        panelVentas.add(vtextoModelo);
        panelVentas.add(infoModelo);
        panelVentas.add(vtextoPrecio);
        panelVentas.add(infoPrecio);
        panelVentas.add(vtextoYear);
        panelVentas.add(infoYear);
        panelVentas.add(textoStock);
        panelVentas.add(infoStock);
        panelVentas.add(ventasBuscar);
        panelVentas.add(textoCantidadAgregar);
        panelVentas.add(sCantidadVenta);
        panelVentas.add(bCancelarVenta);
        panelVentas.add(TablaVentaSP);
        panelVentas.add(bAgregarCarrito);
        panelVentas.add(textoTotalCompra);
        panelVentas.add(totalCompra);
        panelVentas.add(bConcretarCompra);

        add(panelVentas);

        //Panel consulta reportes
        panelConsultaReportes = new JPanel();
        selectorReportes = new JComboBox<>();
        selectorVenta = new JComboBox<>();
        bVolverConsultaR = new JButton("Volver");
        TablaConsultarReportes= new JTable(data,column);
        TablaConsultarReportes.getTableHeader().setResizingAllowed(false);
        TablaConsultarReportes.getTableHeader().setReorderingAllowed(false);
        TablaConsultarSP= new JScrollPane(TablaConsultarReportes);
        textoClienteReporte = new JLabel("Cliente:");
        textoFechaCompraReporte = new JLabel("Fecha compra:");
        textoTotalCompraReporte = new JLabel("Total de compra:");
        infoClienteReporte = new JTextArea();
        infoFechaCompraReporte= new JTextArea();
        infoTotalCompraReporte = new JTextArea();

        panelConsultaReportes.add(selectorReportes);
        panelConsultaReportes.add(selectorVenta);
        panelConsultaReportes.add(bVolverConsultaR);
        panelConsultaReportes.add(TablaConsultarSP);
        panelConsultaReportes.add(textoClienteReporte);
        panelConsultaReportes.add(textoFechaCompraReporte);
        panelConsultaReportes.add(textoTotalCompraReporte);
        panelConsultaReportes.add(infoClienteReporte);
        panelConsultaReportes.add(infoFechaCompraReporte);
        panelConsultaReportes.add(infoTotalCompraReporte);
        add(panelConsultaReportes);

        start();
    }

    public void start(){

        archivo.setNombre();
        try {
            archivo.recopilarDatos();
            archivo.leerReportesArchivo();
        } catch (Exception e) {
            
        }

        //Panel Ventas
        panelVentas.setVisible(false);
        panelVentas.setLayout(null);
        panelVentas.setBounds(0, 0, 500, 320);
        textocodigoProducto.setBounds(10,10,95,15);
        iCodigoProducto.setBounds(100,10,85,15);
        iCodigoProducto.addKeyListener(new KeyAdapter() { 
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == '\n' || e.getKeyChar() == '\t') {
                    e.consume();
                }
            }
        });
        ventasBuscar.setBounds(190,7,85,20);
        ventasBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    String clave = iCodigoProducto.getText();
                    if(clave.isEmpty()==true){
                        throw new EspacioVacio();
                    }
                    int claveconvertida = Integer.parseInt(clave);
                    if(archivo.recargarTablaBusquedaBinariaR(claveconvertida) == null){
                        JOptionPane.showMessageDialog(null, "No se encontro la clave: "+claveconvertida,"ERROR", JOptionPane.ERROR_MESSAGE);
                    }else{
                        String[][] datos = archivo.recargarTablaBusquedaBinariaR(claveconvertida);
                        infoMarca.setText(datos[0][1]);
                        infoModelo.setText(datos[0][2]);
                        infoYear.setText(datos[0][3]);
                        infoPrecio.setText(datos[0][4]);
                        infoStock.setText(datos[0][5]);
                        sCantidadVenta.setValue(0);
                        SpinnerModel propiedadeSpinnerVentas = new SpinnerNumberModel(0,0,Integer.parseInt(datos[0][5]),1);
                        sCantidadVenta.setModel(propiedadeSpinnerVentas);
                    }
                } catch (EspacioVacio error) {
                    JOptionPane.showMessageDialog(null, "Porfavor introduce una clave","ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (InputMismatchException error) {
                    JOptionPane.showMessageDialog(null, "Porfavor ingresa la clave solamente con numeros","ERROR", JOptionPane.ERROR_MESSAGE);
                } catch(NumberFormatException error){
                    JOptionPane.showMessageDialog(null, "Porfavor ingresa la clave solamente con numeros","ERROR", JOptionPane.ERROR_MESSAGE);
                }catch(Exception error){
                    
                }
            }
        });
        textoCliente.setBounds(285, 10, 45, 15);
        iCliente.setBounds(330,10,130,15);
        iCliente.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == '\n' || e.getKeyChar() == '\t') {
                    e.consume();
                }
            }
        });
        vtextoMarca.setBounds(289, 35, 90, 15);
        infoMarca.setBounds(330,35,130,15);
        infoMarca.setEnabled(false);
        infoMarca.setDisabledTextColor(Color.DARK_GRAY);
        vtextoModelo.setBounds(283, 60, 90, 15);
        infoModelo.setBounds(330,60,130,15);
        infoModelo.setEnabled(false);
        infoModelo.setDisabledTextColor(Color.DARK_GRAY);
        vtextoPrecio.setBounds(287, 85, 90, 15);
        infoPrecio.setBounds(330,85,130,15);
        infoPrecio.setEnabled(false);
        infoPrecio.setDisabledTextColor(Color.DARK_GRAY);
        vtextoYear.setBounds(303, 110, 90, 15);
        infoYear.setBounds(330,110,130,15);
        infoYear.setEnabled(false);
        infoYear.setDisabledTextColor(Color.DARK_GRAY);
        textoStock.setBounds(10,30,85,15);
        infoStock.setBounds(55,30,50,15);
        infoStock.setEnabled(false);
        infoStock.setDisabledTextColor(Color.DARK_GRAY);

        textoCantidadAgregar.setBounds(10,50,190,15);
        sCantidadVenta.setBounds(200,50,45,20);

        bCancelarVenta.setBounds(25, 235, 120, 30);
        bCancelarVenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                infoMarca.setText(null);
                infoModelo.setText(null);
                infoYear.setText(null);
                infoPrecio.setText(null);
                infoStock.setText(null);
                sCantidadVenta.setValue(0);
                iCodigoProducto.setText(null);
                bVentas.setVisible(true);
                bGenerarCliente.setVisible(true);
                bAtenderCliente.setVisible(true);
                imagenPrincipal.setVisible(true);
                bCierreCaja.setVisible(true);
                bLogout.setVisible(true);
                bConsultaReportes.setVisible(true);
                panelVentas.setVisible(false);
                archivo.carritoCompras.clear();
                totalCompra.setText(null);
                iCliente.setText(null);
            }
        });

        TablaVentaSP.setBounds(15, 130, 450, 100);
        DefaultTableModel model = new DefaultTableModel(null, new String[]{"CLAVE","MARCA","MODELO","A\u00d1O","PRECIO","CANTIDAD"}){
                    //Evitar que el usuario edite las celdas
                    @Override
                    public boolean isCellEditable(int row, int column){
                        return false;
                    }
                };
        TablaVenta.setModel(model);
        TablaVentaSP.setVisible(true);

        bAgregarCarrito.setBounds(35,80,200,40);
        bAgregarCarrito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                    try {
                        int pos = archivo.busquedaBinariaRecursiva(archivo.getClaveCarrito(), 0, archivo.inventario.size()-1);
                        if(archivo.inventario.get(pos).getCantidad() == 0){
                            throw new NoStock();
                        }
                        if((Integer)sCantidadVenta.getValue() == 0){
                            throw new SpinnerVacio();
                        }
                        if(archivo.ValidarStock((Integer)sCantidadVenta.getValue())==false){
                            throw new NoStock();
                        }
                        archivo.CarritoCompras((Integer)sCantidadVenta.getValue());
                        DefaultTableModel model = new DefaultTableModel(archivo.recargarTablaCarrito(), new String[]{"CLAVE","MARCA","MODELO","A\u00d1O","PRECIO","CANTIDAD"}){
                        @Override
                        public boolean isCellEditable(int row, int column){
                            return false;
                        }
                    };
                    TablaVenta.setModel(model);
                    float precioFinal = 0;
                    for(int y=0;y<archivo.carritoCompras.size();y++){
                        precioFinal = precioFinal + (archivo.carritoCompras.get(y).getPrecio()*archivo.carritoCompras.get(y).getCantidad());
                    }
                    totalCompra.setText(Float.toString(precioFinal));    
                    }catch (NoStock error) {
                         JOptionPane.showMessageDialog(null, "Sin stock del producto","ERROR", JOptionPane.ERROR_MESSAGE);
                    }catch (SpinnerVacio error) {
                         JOptionPane.showMessageDialog(null, "La cantidad minima de un articulo en una compra es 1","ERROR", JOptionPane.ERROR_MESSAGE);
                    }catch (Exception error) {
                         
                    }
                        
            }
        });

        textoTotalCompra.setBounds(160, 245, 80, 15);
        totalCompra.setBounds(230, 245, 80, 15);
        bConcretarCompra.setBounds(330, 235, 140, 30);
        bConcretarCompra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    if(archivo.carritoCompras.size() == 0){
                        throw new ModeloVacio();
                    }
                    String cliente = iCliente.getText();
                    if(cliente.isEmpty()){
                        throw new EspacioVacio();
                    }
                    float totalCompraConvertida = Float.valueOf(totalCompra.getText());
                    archivo.HacerFactura(cliente,totalCompraConvertida);
                    infoMarca.setText(null);
                    infoModelo.setText(null);
                    infoYear.setText(null);
                    infoPrecio.setText(null);
                    infoStock.setText(null);
                    sCantidadVenta.setValue(0);
                    iCodigoProducto.setText(null);
                    iCliente.setText(null);
                    archivo.carritoCompras.clear();
                    DefaultTableModel model = new DefaultTableModel(archivo.recargarTablaCarrito(), new String[]{"CLAVE","MARCA","MODELO","A\u00d1O","PRECIO","CANTIDAD"}){
                        @Override
                        public boolean isCellEditable(int row, int column){
                            return false;
                        }
                    };
                    TablaVenta.setModel(model);
                    totalCompra.setText(null);
                    JOptionPane.showMessageDialog(null, "Compra realizada correctamente");
                } catch (EspacioVacio error) {
                    JOptionPane.showMessageDialog(null, "Se tiene que introducir un nombre de cliente","ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (ModeloVacio error) {
                    JOptionPane.showMessageDialog(null, "Se tiene que agregar objetos al carrito para poder concretar una compra","ERROR", JOptionPane.ERROR_MESSAGE);
                }  catch (Exception error) {
                    JOptionPane.showMessageDialog(null, error);
                }
            }
        });
        //

        //Vista Personal
        bVentas.setBounds(50,75,100,35);
        bVentas.setVisible(false);
        bVentas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                bVentas.setVisible(false);
                imagenPrincipal.setVisible(false);
                bCierreCaja.setVisible(false);
                bLogout.setVisible(false);
                panelVentas.setVisible(true);
                bConsultaReportes.setVisible(false);
                DefaultTableModel model = new DefaultTableModel(null, new String[]{"CLAVE","MARCA","MODELO","A\u00d1O","PRECIO","CANTIDAD"}){
                    //Evitar que el usuario edite las celdas
                    @Override
                    public boolean isCellEditable(int row, int column){
                        return false;
                    }
                };
                TablaVenta.setModel(model);
            }
        });

        bAtenderCliente.setBounds(50,100,100,35);
        bAtenderCliente.setVisible(false);
        bAtenderCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                bAtenderCliente.setVisible(false);
                imagenPrincipal.setVisible(false);
                bCierreCaja.setVisible(false);
                bLogout.setVisible(false);
                panelVentas.setVisible(true);
                bConsultaReportes.setVisible(false);
                DefaultTableModel model = new DefaultTableModel(null, new String[]{"CLAVE","MARCA","MODELO","A\u00d1O","PRECIO","CANTIDAD"}){
                    //Evitar que el usuario edite las celdas
                    @Override
                    public boolean isCellEditable(int row, int column){
                        return false;
                    }
                };
                TablaVenta.setModel(model);
            }
        });

        bCierreCaja.setBounds(50,125,100,35);
        bCierreCaja.setVisible(false);
        bCierreCaja.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(archivo.facturas.size() == 0){
                    JOptionPane.showMessageDialog(null, "No hay ninguna venta para registrar","ERROR", JOptionPane.ERROR_MESSAGE);
                }else{
                    float sumadeldia = 0;
                    for(int x=0;x<archivo.facturas.size();x++){
                        sumadeldia = sumadeldia + archivo.facturas.get(x).getTotalCompra();
                    }
                    JOptionPane.showMessageDialog(null, "Ventas de hoy " + LocalDate.now() + ":"+archivo.facturas.size()+"\nTotal de dinero obtenido:"+sumadeldia);
                    archivo.HacerReporte();
                    archivo.facturas.clear();
                    archivo.carritoCompras.clear();                    
                }
            }
        });

        //Panel Consultar Reportes
        panelConsultaReportes.setVisible(false);
        panelConsultaReportes.setLayout(null);
        panelConsultaReportes.setBounds(0, 0, 500, 320);

        selectorReportes.setBounds(30, 20, 200, 30);
        selectorVenta.setBounds(250, 20, 200, 30);
        bVolverConsultaR.setBounds(25, 235, 120, 30);
        bVolverConsultaR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                bVentas.setVisible(true);
                imagenPrincipal.setVisible(true);
                bCierreCaja.setVisible(true);
                bLogout.setVisible(true);
                bConsultaReportes.setVisible(true);
                panelConsultaReportes.setVisible(false);
                DefaultTableModel model = new DefaultTableModel(null, new String[]{"CLAVE","MARCA","MODELO","A\u00d1O","PRECIO","CANTIDAD"}){
                    //Evitar que el usuario edite las celdas
                    @Override
                    public boolean isCellEditable(int row, int column){
                        return false;
                    }
                };
                TablaConsultarReportes.setModel(model);
                infoClienteReporte.setText(null);
                infoFechaCompraReporte.setText(null);
                infoTotalCompraReporte.setText(null);
            }
        });

        bConsultaReportes.setBounds(33,175,145,35);
        bConsultaReportes.setVisible(false);
        Font nuevaFuenteConsultasReportes = new Font(bConsultaReportes.getFont().getName(), bConsultaReportes.getFont().getStyle(), 12);
        bConsultaReportes.setFont(nuevaFuenteConsultasReportes);
        bConsultaReportes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                panelConsultaReportes.setVisible(true);
                bLogout.setVisible(false);
                bVentas.setVisible(false);
                imagenPrincipal.setVisible(false);
                bCierreCaja.setVisible(false);
                bConsultaReportes.setVisible(false);
                try {
                    DefaultComboBoxModel<String> nuevoModelo = new DefaultComboBoxModel<>();
                    String[] modelo = archivo.comboBoxReportes();
                    for(int x=0;x<modelo.length;x++){
                        nuevoModelo.addElement(modelo[x]);
                    }
                    selectorReportes.setModel(nuevoModelo);
                } catch (Exception error) {
                    
                }
            }
        });

        selectorReportes.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                int seleccionado=selectorReportes.getSelectedIndex();
                DefaultComboBoxModel<String> nuevoModelo = new DefaultComboBoxModel<>();
                String[] modelo = archivo.comboBoxVentas(seleccionado);
                for(int x=0;x<modelo.length;x++){
                    nuevoModelo.addElement(modelo[x]);
                }
                selectorVenta.setModel(nuevoModelo);
            }
        });
        
        TablaConsultarSP.setBounds(15, 130, 450, 100);
        TablaConsultarReportes.setModel(model);
        TablaConsultarSP.setVisible(true);

        textoClienteReporte.setBounds(15, 80, 50, 15);
        textoTotalCompraReporte.setBounds(15, 100, 100, 15);
        textoFechaCompraReporte.setBounds(260, 80, 100, 15);
        infoClienteReporte.setBounds(65, 80, 190, 15);
        infoTotalCompraReporte.setBounds(120, 100, 100, 15);
        infoFechaCompraReporte.setBounds(350, 80, 120, 15);
        infoClienteReporte.setEnabled(false);
        infoClienteReporte.setDisabledTextColor(Color.DARK_GRAY);
        infoTotalCompraReporte.setEnabled(false);
        infoTotalCompraReporte.setDisabledTextColor(Color.DARK_GRAY);
        infoFechaCompraReporte.setEnabled(false);
        infoFechaCompraReporte.setDisabledTextColor(Color.DARK_GRAY);

        selectorVenta.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                int reporteSeleccionado=selectorReportes.getSelectedIndex();
                int ventaSeleccionada=selectorVenta.getSelectedIndex();
                DefaultTableModel model = new DefaultTableModel(archivo.recargarTablaConsultaReportes(reporteSeleccionado, ventaSeleccionada), new String[]{"CLAVE","MARCA","MODELO","A\u00d1O","PRECIO","CANTIDAD"}){
                    //Evitar que el usuario edite las celdas
                    @Override
                    public boolean isCellEditable(int row, int column){
                        return false;
                    }
                };
                TablaConsultarReportes.setModel(model);
                infoTotalCompraReporte.setText(Float.toString(archivo.reportes.get(reporteSeleccionado).getListasFacturas().get(ventaSeleccionada).getTotalCompra()));
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
                infoFechaCompraReporte.setText(archivo.reportes.get(reporteSeleccionado).getListasFacturas().get(ventaSeleccionada).getFechaDeCompra().format(dateTimeFormatter));
                infoClienteReporte.setText(archivo.reportes.get(reporteSeleccionado).getListasFacturas().get(ventaSeleccionada).getCliente());
            }
        });
        //

        //INICIO 2 BOTONES
        bVistaAdmin.setBounds(50,100,100,35);
        bVistaAdmin.setText("Admin");
        bVistaAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                bAltas.setVisible(true);
                bCons.setVisible(true);
                bBajas.setVisible(true);
                bMod.setVisible(true);
                bLogout.setVisible(true);
                bVistaAdmin.setVisible(false);
                bVistaPersonal.setVisible(false);
            }
        });

        bVistaPersonal.setBounds(50,150,100,35);
        bVistaPersonal.setText("Personal");
        bVistaPersonal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                bVistaAdmin.setVisible(false);
                bVistaPersonal.setVisible(false);
                bVentas.setVisible(true);
                bCierreCaja.setVisible(true);
                bConsultaReportes.setVisible(true);
                imagenPrincipal.setVisible(true);
                bLogout.setVisible(true);
            }
        });
        //
        bLogout.setBounds(5,5,35,35);
        bLogout.setOpaque(false);
        bLogout.setVisible(false);
        bLogout.setContentAreaFilled(false);
        bLogout.setBorderPainted(false);
        bLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                bAltas.setVisible(false);
                bCons.setVisible(false);
                bBajas.setVisible(false);
                bMod.setVisible(false);
                bLogout.setVisible(false);
                bVistaAdmin.setVisible(true);
                bVentas.setVisible(false);
                bCierreCaja.setVisible(false);
                bConsultaReportes.setVisible(false);
                bVistaPersonal.setVisible(true);
            }
        });

        //REGISTRO;
        imagenRegistro.setBounds(275, 40, 175, 175);
        imagenRegistro.setVisible(false);
        textoRegistro1.setBounds(200, 0, 100, 40);
        textoRegistro1.setVisible(false);
        Font nuevaFuente = new Font(textoRegistro1.getFont().getName(), textoRegistro1.getFont().getStyle(), 15);
        textoRegistro1.setFont(nuevaFuente);
        textoRegistro2.setBounds(100, 30, 300, 30);
        textoRegistro2.setVisible(false);
        textoClave.setBounds(100, 55, 40, 30);
        textoClave.setVisible(false);
        textoMarca.setBounds(100, 85, 50, 30);
        textoMarca.setVisible(false);
        textoModelo.setBounds(100, 115, 50, 30);
        textoModelo.setVisible(false);
        textoPrecio.setBounds(100, 165, 50, 30);
        textoPrecio.setVisible(false);
        textoYear.setBounds(100, 142, 50, 30);
        textoYear.setVisible(false);
        textoCantidad.setBounds(100, 188, 56, 30);
        textoCantidad.setVisible(false);
        sCantidad.setBounds(160, 193, 55, 20);
        sCantidad.setVisible(false);
        ((JSpinner.DefaultEditor) sCantidad.getEditor()).getTextField().setEditable(false); // Deshabilita el poder escribir en el Spinner
        ((JSpinner.DefaultEditor) sCantidad.getEditor()).getTextField().setBackground(Color.WHITE); // Deshabilita el poder escribir en el Spinner

        iClave.setBounds(148,63,100,15);
        iClave.setVisible(false);
        iClave.addKeyListener(new KeyAdapter() { //evita el tab y enter al momento de escribir
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == '\n' || e.getKeyChar() == '\t') {
                    e.consume();
                }
            }
        });

        iMarca.setBounds(148,93,100,15);
        iMarca.setVisible(false);
        iMarca.addKeyListener(new KeyAdapter() { //evita el tab y enter al momento de escribir
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == '\n' || e.getKeyChar() == '\t') {
                    e.consume();
                }
            }
        });

        iModelo.setBounds(148,125,100,15);
        iModelo.setVisible(false);
        iModelo.addKeyListener(new KeyAdapter() { //evita el tab y enter al momento de escribir
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == '\n' || e.getKeyChar() == '\t') {
                    e.consume();
                }
            }
        });

        iPrecio.setBounds(148,173,100,15);
        iPrecio.setVisible(false);
        iPrecio.addKeyListener(new KeyAdapter() { //evita el tab y enter al momento de escribir
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == '\n' || e.getKeyChar() == '\t') {
                    e.consume();
                }
            }
        });

        iYear.setBounds(148,150,100,15);
        iYear.setVisible(false);
        iYear.addKeyListener(new KeyAdapter() { //evita el tab y enter al momento de escribir
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == '\n' || e.getKeyChar() == '\t') {
                    e.consume();
                }
            }
        });
        //

        //Consultas
        //General
        bConsultaGen.setBounds(20,10,140,35);
        bConsultaGen.setText("Consulta General");
        bConsultaGen.setVisible(false);
        textoConsultaGeneral.setBounds(180, 45, 150, 30);
        textoConsultaGeneral.setVisible(false);
        sp.setBounds(25,90,440,120);   
        sp.setVisible(false);
        bConsultaGen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                textoConsultaGeneral.setVisible(true);
                DefaultTableModel model = new DefaultTableModel(archivo.recargarTabla(), new String[]{"CLAVE","MARCA","MODELO","A\u00d1O","PRECIO","CANTIDAD"}){
                    //Evitar que el usuario edite las celdas
                    @Override
                    public boolean isCellEditable(int row, int column){
                        return false;
                    }
                };
                jt.setModel(model);
                sp.setVisible(true);
                textoConsultaModelo.setVisible(false);
                bBuscarBE.setVisible(false);
                bBuscarBC.setVisible(false);
                textoConsultaClave.setVisible(false);
                textoConsultaModelo2.setVisible(false);
                textoConsultaClave2.setVisible(false);
                iBusqueda.setText(null);
                iBusqueda.setVisible(false);
            }
        });

        //Especifica
        bConsultaEsp.setBounds(165,10,155,35);
        bConsultaEsp.setText("Consulta por modelo");
        bConsultaEsp.setVisible(false);
        textoConsultaModelo.setBounds(170, 45, 200, 30);
        textoConsultaModelo.setVisible(false);
        textoConsultaModelo2.setBounds(25, 60, 235, 30);
        textoConsultaModelo2.setVisible(false);
        bConsultaEsp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                textoConsultaGeneral.setVisible(false);
                sp.setVisible(false);
                textoConsultaModelo.setVisible(true);
                bBuscarBE.setVisible(true);
                bBuscarBC.setVisible(false);
                textoConsultaClave.setVisible(false);
                textoConsultaModelo2.setVisible(true);
                textoConsultaClave2.setVisible(false);
                iBusqueda.setText(null);
                iBusqueda.setVisible(true);
            }
        });
        bBuscarBE.setBounds(350,220,100,35);
        bBuscarBE.setText("Buscar");
        bBuscarBE.setVisible(false);
        bBuscarBE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                String modelo = iBusqueda.getText();
                if(modelo.isEmpty()){
                    throw new EspacioVacio();
                }
                if(archivo.recargarTablaBusqueda(modelo) == null){
                    JOptionPane.showMessageDialog(null, "No se encontro el modelo: "+modelo,"ERROR", JOptionPane.ERROR_MESSAGE);
                }else{
                    DefaultTableModel model = new DefaultTableModel(archivo.recargarTablaBusqueda(modelo), new String[]{"CLAVE","MARCA","MODELO","A\u00d1O","PRECIO","CANTIDAD"}){
                        //Evitar que el usuario edite las celdas
                        @Override
                        public boolean isCellEditable(int row, int column){
                            return false;
                        }
                    };
                    jt.setModel(model);
                    sp.setVisible(true);
                }       
                }  catch (EspacioVacio error) {
                    JOptionPane.showMessageDialog(null, "Porfavor introduce un modelo","ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //Clave
        bConsultaClave.setBounds(325,10,140,35);
        bConsultaClave.setText("Consulta por clave");
        bConsultaClave.setVisible(false);
        textoConsultaClave.setBounds(180, 45, 150, 30);
        textoConsultaClave.setVisible(false);
        textoConsultaClave2.setBounds(100, 60, 158, 30);
        textoConsultaClave2.setVisible(false);
        bConsultaClave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                textoConsultaGeneral.setVisible(false);
                sp.setVisible(false);
                textoConsultaModelo.setVisible(false);
                bBuscarBE.setVisible(false);
                bBuscarBC.setVisible(true);
                textoConsultaClave.setVisible(true);
                textoConsultaModelo2.setVisible(false);
                textoConsultaClave2.setVisible(true);
                iBusqueda.setText(null);
                iBusqueda.setVisible(true);
            }
        });

        //Matematicas Discretas
        bBuscarBC.setBounds(350,220,100,35);
        bBuscarBC.setText("Buscar");
        bBuscarBC.setVisible(false);
        bBuscarBC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

                try {
                    String clave = iBusqueda.getText();
                    if(clave.isEmpty()){
                        throw new EspacioVacio();
                    }
                    int claveconvertida = Integer.parseInt(clave);
                    if(archivo.recargarTablaBusquedaBinariaR(claveconvertida) == null){
                        JOptionPane.showMessageDialog(null, "No se encontro la clave: "+claveconvertida,"ERROR", JOptionPane.ERROR_MESSAGE);
                    }else{
                        DefaultTableModel model = new DefaultTableModel(archivo.recargarTablaBusquedaBinariaR(claveconvertida), new String[]{"CLAVE","MARCA","MODELO","A\u00d1O","PRECIO","CANTIDAD"}){
                            //Evitar que el usuario edite las celdas
                            @Override
                            public boolean isCellEditable(int row, int column){
                                return false;
                            }
                        };
                        jt.setModel(model);
                        sp.setVisible(true);
                    }
                } catch (EspacioVacio error) {
                    JOptionPane.showMessageDialog(null, "Porfavor introduce una clave","ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (InputMismatchException error) {
                    JOptionPane.showMessageDialog(null, "Porfavor ingresa la clave solamente con numeros","ERROR", JOptionPane.ERROR_MESSAGE);
                } catch(NumberFormatException error){
                    JOptionPane.showMessageDialog(null, "Porfavor ingresa la clave solamente con numeros","ERROR", JOptionPane.ERROR_MESSAGE);
                }catch(Exception error){
                    
                }
            }
        });

        iBusqueda.setBounds(270,68,100,15);
        iBusqueda.setVisible(false);
        iBusqueda.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == '\n' || e.getKeyChar() == '\t') {
                    e.consume();
                }
            }
        });
        //

        //Bajas
        imagenBajas.setBounds(150, 30, 200, 200);
        imagenBajas.setVisible(false);
        textoBajas.setBounds(225, 0, 100, 40);
        textoBajas.setVisible(false);
        Font nuevaFuenteBajas = new Font(textoBajas.getFont().getName(), textoBajas.getFont().getStyle(), 15);
        textoBajas.setFont(nuevaFuenteBajas);
        textoBajas2.setBounds(25, 30, 260, 30);
        textoBajas2.setVisible(false);

        iClaveEliminar.setBounds(283,38,100,15);
        iClaveEliminar.setVisible(false);
        iClaveEliminar.addKeyListener(new KeyAdapter() { 
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == '\n' || e.getKeyChar() == '\t') {
                    e.consume();
                }
            }
        });

        bEliminarClave.setBounds(350,220,100,35);
        bEliminarClave.setText("Eliminar");
        bEliminarClave.setVisible(false);
        bEliminarClave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String clave = iClaveEliminar.getText();
                try {
                    int claveconvertida = Integer.parseInt(clave);
                    if(archivo.eliminar(claveconvertida)==false){
                        JOptionPane.showMessageDialog(null, "No se encontro la clave: "+claveconvertida,"ERROR", JOptionPane.ERROR_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "Se elimino con exito: "+claveconvertida);
                    }
                    iClaveEliminar.setText("");
                } catch (InputMismatchException error) {
                    JOptionPane.showMessageDialog(null, "Porfavor ingresa la clave solamente con numeros","ERROR", JOptionPane.ERROR_MESSAGE);
                } catch(NumberFormatException error){
                    JOptionPane.showMessageDialog(null, "Porfavor ingresa la clave solamente con numeros","ERROR", JOptionPane.ERROR_MESSAGE);
                }catch(Exception error){
                    
                }
            }
        });
        //
        
        imagenPrincipal.setBounds(225, 75, 200, 200);
        imagenPrincipal.setVisible(true); //cambiar a true

        bAltas.setBounds(50,50,100,35);
        bAltas.setText("Registro");
        bAltas.setVisible(false);
        bAltas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                bAltas.setVisible(false);
                bCons.setVisible(false);
                bBajas.setVisible(false);
                bMod.setVisible(false);
                bVolver.setVisible(true);
                textoClave.setVisible(true);
                textoMarca.setVisible(true);
                textoModelo.setVisible(true);
                textoPrecio.setVisible(true);
                textoRegistro1.setVisible(true);
                textoRegistro2.setVisible(true);
                iClave.setVisible(true);
                iMarca.setVisible(true);
                iModelo.setVisible(true);
                iPrecio.setVisible(true);
                bRegistrar.setVisible(true);
                imagenRegistro.setVisible(true);
                imagenPrincipal.setVisible(false);
                textoCantidad.setVisible(true);
                sCantidad.setVisible(true);
                textoYear.setVisible(true);
                iYear.setVisible(true);
                bLogout.setVisible(false);
            }
        });

        bCons.setBounds(50,100,100,35);
        bCons.setText("Consultas");
        bCons.setVisible(false);
        bCons.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                bAltas.setVisible(false);
                bCons.setVisible(false);
                bBajas.setVisible(false);
                bMod.setVisible(false);
                bVolver.setVisible(true);
                bConsultaGen.setVisible(true);
                bConsultaEsp.setVisible(true);
                bConsultaClave.setVisible(true);
                imagenPrincipal.setVisible(false);
                bLogout.setVisible(false);
            }
        });

        Font nuevaFuenteMod = new Font(bMod.getFont().getName(), bMod.getFont().getStyle(), 12);
        bMod.setBounds(50,200,100,35);
        bMod.setText("Modificar");
        bMod.setVisible(false);
        bMod.setFont(nuevaFuenteMod);
        bMod.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                DefaultTableModel model = new DefaultTableModel(archivo.recargarTabla(), new String[]{"CLAVE","MARCA","MODELO","A\u00d1O","PRECIO","CANTIDAD"}){
                            //Evitar que el usuario edite las celdas
                            @Override
                            public boolean isCellEditable(int row, int column){
                                return false;
                            }
                        };
                jt.setModel(model);
                sp.setVisible(true);
                bAltas.setVisible(false);
                bCons.setVisible(false);
                bBajas.setVisible(false);
                bMod.setVisible(false);
                imagenPrincipal.setVisible(false);
                bVolver.setVisible(true);
                bModificar.setVisible(true);
                textoModificacion.setVisible(true);
                textoModificacion2.setVisible(true);
                bLogout.setVisible(false);
            }
        });

        //Seccion Modificar
        bModificar.setBounds(350,220,100,35);
        bModificar.setText("Modificar");
        bModificar.setVisible(false);
        bModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    String[][] carro = archivo.infoModificaciones(jt.getSelectedRow());
                    sp.setVisible(false);
                    bVolver.setVisible(false);
                    bModificar.setVisible(false);
                    textoModificacion.setVisible(false);
                    textoModificacion2.setVisible(false);
                    textoModificacion21.setVisible(false);
                    textoModificacion22.setVisible(false);
                    textoClave.setVisible(true);
                    textoMarca.setVisible(true);
                    textoModelo.setVisible(true);
                    textoPrecio.setVisible(true);
                    textoModificacion21.setVisible(true);
                    textoModificacion22.setVisible(true);
                    iClave.setVisible(true);
                    iMarca.setVisible(true);
                    iModelo.setVisible(true);
                    iPrecio.setVisible(true);
                    textoCantidad.setVisible(true);
                    sCantidad.setVisible(true);
                    textoYear.setVisible(true);
                    iYear.setVisible(true);
                    iClave.setText(carro[0][0]);
                    iMarca.setText(carro[0][1]);
                    iModelo.setText(carro[0][2]);
                    iYear.setText(carro[0][3]);
                    iPrecio.setText(carro[0][4]);
                    int valorConvertido = Integer.parseInt(carro[0][5]);
                    sCantidad.setValue(valorConvertido);
                    bCancelarMod.setVisible(true);
                    bGuardar.setVisible(true);
                }catch (IndexOutOfBoundsException a) {
                    JOptionPane.showMessageDialog(null, "Porfavor selecciona un carro de la lista.","ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (Exception a) {

                }

            }
        });

        textoModificacion.setBounds(185, 0, 150, 40);
        textoModificacion.setVisible(false);
        Font nuevaFuenteModificacion = new Font(textoModificacion.getFont().getName(), textoModificacion.getFont().getStyle(), 15);
        textoModificacion.setFont(nuevaFuenteModificacion);
        textoModificacion2.setBounds(100, 30, 350, 30);
        textoModificacion2.setVisible(false);

        textoModificacion21.setBounds(185, 0, 150, 40);
        textoModificacion21.setVisible(false);
        Font nuevaFuenteModificacion2 = new Font(textoModificacion21.getFont().getName(), textoModificacion21.getFont().getStyle(), 15);
        textoModificacion21.setFont(nuevaFuenteModificacion2);
        textoModificacion22.setBounds(100, 30, 350, 30);
        textoModificacion22.setVisible(false);

        bCancelarMod.setBounds(50,220,100,35);
        bCancelarMod.setText("Cancelar");
        bCancelarMod.setVisible(false);
        bCancelarMod.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                DefaultTableModel model = new DefaultTableModel(archivo.recargarTabla(), new String[]{"CLAVE","MARCA","MODELO","A\u00d1O","PRECIO","CANTIDAD"}){
                            //Evitar que el usuario edite las celdas
                            @Override
                            public boolean isCellEditable(int row, int column){
                                return false;
                            }
                        };
                jt.setModel(model);
                sp.setVisible(true);
                bAltas.setVisible(false);
                bCons.setVisible(false);
                bBajas.setVisible(false);
                bMod.setVisible(false);
                imagenPrincipal.setVisible(false);
                bVolver.setVisible(true);
                bModificar.setVisible(true);
                textoModificacion.setVisible(true);
                textoModificacion2.setVisible(true);
                textoModificacion21.setVisible(false);
                textoModificacion22.setVisible(false);
                bCancelarMod.setVisible(false);
                textoClave.setVisible(false);
                textoMarca.setVisible(false);
                textoModelo.setVisible(false);
                textoPrecio.setVisible(false);
                textoRegistro1.setVisible(false);
                textoRegistro2.setVisible(false);
                iClave.setVisible(false);
                iMarca.setVisible(false);
                iModelo.setVisible(false);
                iPrecio.setVisible(false);
                textoCantidad.setVisible(false);
                sCantidad.setVisible(false);
                textoYear.setVisible(false);
                iYear.setVisible(false);
                iClave.setText(null);
                iMarca.setText(null);
                iModelo.setText(null);
                iYear.setText(null);
                iPrecio.setText(null);
                sCantidad.setValue(0);
                bGuardar.setVisible(false);
            }
        });

        
        bGuardar.setBounds(350,220,100,35);
        bGuardar.setText("Guardar");
        bGuardar.setVisible(false);
        bGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String clave = iClave.getText();
                String marca = iMarca.getText();
                String modelo = iModelo.getText();
                String precio = iPrecio.getText();
                String year = iYear.getText();
                int claveconvertida;
                float precioconvertido;
                int yearconvertida;
                try {
                    if(marca.isEmpty()){
                        throw new MarcaVacia();
                    }
                    if(modelo.isEmpty()){
                        throw new ModeloVacio();
                    }
                    if(precio.isEmpty()){
                        throw new PrecioVacio();
                    }
                    if(year.isEmpty()){
                        throw new YearVacio();
                    }
                    claveconvertida = Integer.parseInt(clave);
                    precioconvertido = Float.parseFloat(precio);
                    yearconvertida = Integer.parseInt(year);
                    int cantidad = (Integer) sCantidad.getValue();
                    archivo.modificar(claveconvertida, marca, modelo, precioconvertido, yearconvertida, cantidad);
                    iClave.setText(null);
                    iMarca.setText(null);
                    iModelo.setText(null);
                    iPrecio.setText(null);
                    iYear.setText(null);
                    sCantidad.setValue(0);
                    DefaultTableModel model = new DefaultTableModel(archivo.recargarTabla(), new String[]{"CLAVE","MARCA","MODELO","A\u00d1O","PRECIO","CANTIDAD"}){
                            //Evitar que el usuario edite las celdas
                            @Override
                            public boolean isCellEditable(int row, int column){
                                return false;
                            }
                        };
                    jt.setModel(model);
                    sp.setVisible(true);
                    bVolver.setVisible(true);
                    bModificar.setVisible(true);
                    textoModificacion.setVisible(true);
                    textoModificacion2.setVisible(true);
                    textoModificacion21.setVisible(false);
                    textoModificacion22.setVisible(false);
                    bCancelarMod.setVisible(false);
                    textoClave.setVisible(false);
                    textoMarca.setVisible(false);
                    textoModelo.setVisible(false);
                    textoPrecio.setVisible(false);
                    textoRegistro1.setVisible(false);
                    textoRegistro2.setVisible(false);
                    iClave.setVisible(false);
                    iMarca.setVisible(false);
                    iModelo.setVisible(false);
                    iPrecio.setVisible(false);
                    textoCantidad.setVisible(false);
                    sCantidad.setVisible(false);
                    textoYear.setVisible(false);
                    iYear.setVisible(false);
                    bGuardar.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Coche modificado exitosamente");
                } catch (ModeloVacio error) {
                    JOptionPane.showMessageDialog(null, "Modelo vacio, introduce uno","ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (MarcaVacia error) {
                    JOptionPane.showMessageDialog(null, "Marca vacia, introduce una","ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (PrecioVacio error) {
                    JOptionPane.showMessageDialog(null, "Precio vacio, introduce uno","ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (YearVacio error) {
                    JOptionPane.showMessageDialog(null, "A\u00f1o vacio, introduce uno","ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException b) {
                    JOptionPane.showMessageDialog(null, "Porfavor ingresa la clave, el precio, a\u00f1o solo con numeros","ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException error) {
                    JOptionPane.showMessageDialog(null, "Porfavor llena todos los campos","ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (Exception error){
                    JOptionPane.showMessageDialog(null, "Error: " + e,"ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //

        bBajas.setBounds(50,150,100,35);
        bBajas.setText("Bajas");
        bBajas.setVisible(false);
        bBajas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                bAltas.setVisible(false);
                bCons.setVisible(false);
                bBajas.setVisible(false);
                bMod.setVisible(false);
                bVolver.setVisible(true);
                textoBajas.setVisible(true);
                textoBajas2.setVisible(true);
                iClaveEliminar.setVisible(true);
                bEliminarClave.setVisible(true);
                imagenBajas.setVisible(true);
                imagenPrincipal.setVisible(false);
                bLogout.setVisible(false);
            }
        });

        bVolver.setBounds(50,220,100,35);
        bVolver.setText("Volver");
        bVolver.setVisible(false);
        bVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                bAltas.setVisible(true);
                bCons.setVisible(true);
                bBajas.setVisible(true);
                bMod.setVisible(true);
                bVolver.setVisible(false);
                textoClave.setVisible(false);
                textoMarca.setVisible(false);
                textoModelo.setVisible(false);
                textoPrecio.setVisible(false);
                textoRegistro1.setVisible(false);
                textoRegistro2.setVisible(false);
                iClave.setVisible(false);
                iMarca.setVisible(false);
                iModelo.setVisible(false);
                iPrecio.setVisible(false);
                bRegistrar.setVisible(false);
                imagenRegistro.setVisible(false);
                bConsultaGen.setVisible(false);
                bConsultaEsp.setVisible(false);
                bConsultaClave.setVisible(false);
                textoConsultaGeneral.setVisible(false);
                sp.setVisible(false);
                textoConsultaModelo.setVisible(false);
                bBuscarBE.setVisible(false);
                bBuscarBC.setVisible(false);
                textoConsultaClave.setVisible(false);
                textoConsultaModelo2.setVisible(false);
                textoConsultaClave2.setVisible(false);
                iBusqueda.setVisible(false);
                iBusqueda.setText(null);
                iClave.setText(null);
                iMarca.setText(null);
                iModelo.setText(null);
                iPrecio.setText(null);
                iYear.setText(null);
                iBusqueda.setText(null);
                iClaveEliminar.setText(null);
                textoBajas.setVisible(false);
                textoBajas2.setVisible(false);
                iClaveEliminar.setVisible(false);
                bEliminarClave.setVisible(false);
                imagenPrincipal.setVisible(true);
                imagenBajas.setVisible(false);
                textoCantidad.setVisible(false);
                sCantidad.setVisible(false);
                textoYear.setVisible(false);
                iYear.setVisible(false);
                bModificar.setVisible(false);
                textoModificacion.setVisible(false);
                textoModificacion2.setVisible(false);
                bLogout.setVisible(true);
            }
        });

        bRegistrar.setBounds(350,220,100,35);
        bRegistrar.setText("Registrar");
        bRegistrar.setVisible(false);
        bRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String clave = iClave.getText();
                String marca = iMarca.getText();
                String modelo = iModelo.getText();
                String precio = iPrecio.getText();
                String year = iYear.getText();
                int claveconvertida;
                float precioconvertido;
                int yearconvertida;
                try {
                    if(clave.isEmpty()){
                        throw new EspacioVacio();
                    }
                    if(marca.isEmpty()){
                        throw new MarcaVacia();
                    }
                    if(modelo.isEmpty()){
                        throw new ModeloVacio();
                    }
                    if(precio.isEmpty()){
                        throw new PrecioVacio();
                    }
                    if(year.isEmpty()){
                        throw new YearVacio();
                    }
                    claveconvertida = Integer.parseInt(clave);
                    if(archivo.validarClave(claveconvertida) == true){
                        throw new ClaveRepetida();
                    }
                    precioconvertido = Float.parseFloat(precio);
                    yearconvertida = Integer.parseInt(year);
                    int cantidad = (Integer) sCantidad.getValue();
                    if(cantidad == 0){
                        throw new CantidadCero();
                    }
                    archivo.write(claveconvertida, marca, modelo, precioconvertido,yearconvertida,cantidad);
                    iClave.setText(null);
                    iMarca.setText(null);
                    iModelo.setText(null);
                    iPrecio.setText(null);
                    iYear.setText(null);
                    sCantidad.setValue(0);
                    JOptionPane.showMessageDialog(null, "Coche registrado exitosamente");
                } catch (EspacioVacio error) {
                    JOptionPane.showMessageDialog(null, "Porfavor introduce una clave","ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (ClaveRepetida error) {
                    JOptionPane.showMessageDialog(null, "Clave repetida, introduce una nueva","ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (ModeloVacio error) {
                    JOptionPane.showMessageDialog(null, "Modelo vacio, introduce uno","ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (MarcaVacia error) {
                    JOptionPane.showMessageDialog(null, "Marca vacia, introduce una","ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (PrecioVacio error) {
                    JOptionPane.showMessageDialog(null, "Precio vacio, introduce uno","ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (CantidadCero error) {
                    JOptionPane.showMessageDialog(null, "Debes agregar tener al menos un auto en Cantidad.","ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (YearVacio error) {
                    JOptionPane.showMessageDialog(null, "A\u00f1o vacio, introduce uno","ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException b) {
                    JOptionPane.showMessageDialog(null, "Porfavor ingresa la clave, el precio, a\u00f1o solo con numeros","ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException error) {
                    JOptionPane.showMessageDialog(null, "Porfavor llena todos los campos","ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (Exception error){
                    JOptionPane.showMessageDialog(null, "Error: " + e,"ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    public static void main(String[] args) throws IOException {
        Frame ob = new Frame();
        ob.setVisible(true);
    }

}


class ClaveRepetida extends Exception {
    public ClaveRepetida() {
        
    }
}

class MarcaVacia extends Exception {
    public MarcaVacia() {
        
    }
}

class ModeloVacio extends Exception {
    public ModeloVacio() {
        
    }
}

class PrecioVacio extends Exception {
    public PrecioVacio() {
        
    }
}

class YearVacio extends Exception {
    public YearVacio() {
        
    }
}

class CantidadCero extends Exception {
    public CantidadCero() {
        
    }
}

class EspacioVacio extends Exception {
    public EspacioVacio() {
        
    }
}

class NoStock extends Exception {
    public NoStock() {
        
    }
}

class SpinnerVacio extends Exception {
    public SpinnerVacio() {
        
    }
}



