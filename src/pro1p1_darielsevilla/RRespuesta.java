/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pro1p1_darielsevilla;

/**
 *
 * @author HP
 */
public class RRespuesta extends javax.swing.JFrame {

    private int opcion;
    private String message;
    private String respuesta;
    private int[][] respuestaMatrices;
    
    public RRespuesta(int x, int para) {
        opcion = x;
        if(opcion == 1){
            respuesta = Integer.toString(BinarioDecimal(0,para,0));
        }else if(opcion == 2){
            respuesta = DecimalBinario("",para);
        }else{
          int[][] nueva = new int[Storage.getMatriz(0).length][Storage.getMatriz(1)[0].length];
          nueva = multiplicacion(Storage.getMatriz(0), Storage.getMatriz(1), nueva, nueva.length-1, nueva[0].length-1);
          respuesta = "<html> Primera Matriz: <br>" + Storage.impMatriz(Storage.getMatriz(0), Storage.getMatriz(0).length-1, Storage.getMatriz(0)[0].length -1, "") + "<br><br>";
          respuesta += "Segunda matriz: <br>" + Storage.impMatriz(Storage.getMatriz(1), Storage.getMatriz(1).length-1, Storage.getMatriz(1)[0].length-1, "") + "<br><br>";
          respuesta += "Matriz respuesta: <br>" + Storage.impMatriz(nueva, nueva.length-1, nueva[0].length-1, "") + "</html>";
          Storage.eliminateMatList();
        }
        
        initComponents();
        setVisible(true);
    }
    
    public void setMessage(int par){
        if(par == 1){
            message = "Numero Decimal:";
        }else if (par == 2){
            message = "Numero binario";
        }else{
            message = "Matriz respuesta";
        }
        
    }
    
    public String DecimalBinario(String resp, int num){
        //primero, saca el residuo del numero entre 2. 
        int valor = num % 2;
        //cambia el valor de num por el entero de num/2.
        num = num/2;
        //agrega ese numero, que sera 0 o 1, al inicio de la cadena
        resp = Integer.toString(valor) + resp;
        //si el numero es 0, retorna la respuesta
        if(num == 0){
          return resp;  
        } else {
            /*si el numero no es 0, significa que aun hay mas valores q dividir, asi que vuelve a correr la funcion, que se detendra hasta
            que num sea 0*/
            return DecimalBinario(resp, num);
        }
        
    }
    
    public int BinarioDecimal(int loop, int para, int resp){
        /*multiplica el ultimo digito de para, por 2 a la loop potencia. loop se inicializaria siempre con 0,
        pero se almacena como variable en en los parametros para que su valor se guarde en el siguiente loop. Lo
        mismo con resp*/
        resp += (para % 10) * (Math.pow(2, loop));
        para /= 10;
        if(para == 0){
            //si para es 0, ya no hay caracteres, por lo que se acabo el numero y el metodo terminara
            return resp;
        }else{
            //si para no es 0, se volvera a correr el metodo, con para disminuido, resp con su valor aumentado, y con loop añadido 1 en cada metodo
            return BinarioDecimal(loop+1,para,resp);
        }
    }
    
    public int rowProduct(int[][] par1, int[][] par2, int k, int i, int j){
        
        int resp = 0;
        
        if(k != par2.length-1){
          //si k no es igual al ultimo numero, se le sumara, la misma funcion con k+1, y asi hasta q k sea igual a par2.length
          resp += rowProduct(par1, par2, k+1, i, j);  
        }
            
        /*cuando k sea igual a n, osea par2.length, se le sumara a resp el producto de par[i][k] y par2[i][k]
        el ultimo valor se regresara, lo que hara q todos los otros valores salgan del if y sumen el producto de los valores en 
        sus respectivas posiciones. Cada funcion, al salir del if, regresara resp*/
        resp += par1[i][k] * par2[k][j];
         
       
        return resp;
        
       
    }
    
    public int[][] multiplicacion(int[][] par1, int[][] par2, int[][] par3, int i, int j){
        //para el valor de la posicion actual de la matriz, se utiliza el metodo rowProduct usando como parametros los valores de la posicion actual de la matriz
        par3[i][j] = rowProduct(par1, par2, 0, i, j);
        
        if(j != 0){
            //si no esta al inicio de la fila, va hacia atras 1, y repite este proceso
            multiplicacion(par1, par2, par3, i, j-1);
        }else if(i != 0){
            //si esta al inicio de la fila, la posicion se mueve a la fila anterior, y se reinicia el valor de las filas al ultimo
            multiplicacion(par1, par2, par3, i-1, par3[0].length - 1);
        }
        
        //si ambos son 0, se llego al incio de la matriz, por lo cual todas las casillas estan llenas, y se terminara la funcion
        return par3;
        
        
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        actualResp = new javax.swing.JLabel();
        salida = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(message);

        actualResp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        actualResp.setForeground(new java.awt.Color(255, 255, 255));
        actualResp.setText(respuesta);

        salida.setBackground(new java.awt.Color(0, 153, 153));
        salida.setForeground(new java.awt.Color(0, 0, 0));
        salida.setText("Ok");
        salida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salidaActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro1p1_darielsevilla/exclamation.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(actualResp))
                .addContainerGap(221, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salida, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actualResp))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salida)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void salidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salidaActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_salidaActionPerformed

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
            java.util.logging.Logger.getLogger(RRespuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RRespuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RRespuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RRespuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel actualResp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton salida;
    // End of variables declaration//GEN-END:variables
}
