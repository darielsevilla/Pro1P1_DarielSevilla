
package pro1p1_darielsevilla;

import java.util.ArrayList;
import java.security.SecureRandom;

/**
 *
 * @author HP
 */
public class Storage {
    public static SecureRandom random = new SecureRandom();
    public static ArrayList<Cancion> songList = new ArrayList<>();
    public static String[] atributos = new String[5];
    //aspectos para recursion
    public static ArrayList<int[][]> matList = new ArrayList<>();
    public static int[] matrizAtributos = new int[2];
    
    public static void leeAtributos(int i, String atri){
        
        atributos[i] = atri;
    }
    
    public static void addAtributos(){
        Cancion temp = new Cancion(atributos[0], atributos[1], atributos[2], Integer.parseInt(atributos[3]), Integer.parseInt(atributos[4]));
        
        songList.add(temp);
    }
    
    public static String imprimirLista(){
        String resp = "<html>";
        
        for(int i = 0; i < songList.size(); i++){
           resp += String.format("%d. %s - %s <br>",i+1, songList.get(i).getName(), songList.get(i).getArtist());
        }
        resp += "</html>";
        return resp;
    }
    
    public static String informacion(int x){
          
        return songList.get(x-1).getAttributes();
    }
    
    public static void eliminar(int x){
        songList.remove(x-1);
    }
    
    public static Cancion getSong(int x){
        return songList.get(x-1);
    }
    
    public static void addMatrizAtribute(int x, int par){
        matrizAtributos[x] = par;
    }
    
    public static void addMatriz(){
        matList.add(lectura(new int[matrizAtributos[0]][matrizAtributos[1]],matrizAtributos[0]-1, matrizAtributos[1]-1));
       
    }
    
    public static int[][] lectura(int[][] temp, int fil, int col){
        //empieza llenando la ultima posicion de la matriz
        temp[fil][col] = random.nextInt(10);
        
        if(col != 0){
            //llena cada columna de la fila hasta q llega a la columna 0
            return lectura(temp, fil, col-1);
        }else if(fil != 0){
            //pasa a la fila de arriba, y resetea las columnas a su valor maximo, para repetir el mismo proceso
            return lectura(temp, fil-1, temp[0].length-1);
        }else{
            //cuando ambas sean 0, se abran llenado todos los espacios, y se regresara temp
            return temp;
        }
    }
    
    public static int matrizSize(){
        return matList.size();
    }
    
    public static int[][] getMatriz(int x){
        return matList.get(x);
    }
    
   public static String impMatriz(int[][] par, int fil, int col, String resp){
       /*como empieza desde el final, le agrega el valor en la posicion actual
       al frente de la cadena*/
       resp = String.format("[%d]", par[fil][col]) + resp;
       
       if(col != 0){
           //pasa por todas las columnas de la fila hasta q llegue a la primera columna
           return impMatriz(par, fil, col-1, resp);
       }else if(fil != 0){
           /*cuando se llegue a la primera columna, se agrega <br> como salto de linea,
           luego corre el metodo otra vez reseteando las columnas pero restando 1 fila*/
           resp = "<br>" + resp;
           return impMatriz(par, fil - 1, par[0].length-1, resp);
       }else{
           /*cuando se llegue a [0][0] se agregan los html a cada lado, para que los 
           <br> funcionen, y se retorna la cadena*/
           
           return resp;
       }
   }
   
   public static void eliminateMatList(){
       matList = new ArrayList<int [][]>(); 
   }
}
