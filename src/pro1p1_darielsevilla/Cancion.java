/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pro1p1_darielsevilla;


public class Cancion {
    private String nombre;
    private String album;
    private String artista;
    private int lanzamiento;
    private int duracion;
    
    public Cancion(String name, String album, String artist, int release, int duration){
        this.nombre = name;
        this.album = album;
        this.artista = artist;
        this.lanzamiento = release;
        this.duracion = duration;
        
    }
    
    //metodo getters
    public String getName(){
        return nombre;
    }
    
    public String getAlbum(){
        return album;
    }
    
    public String getArtist(){
        return artista;
    }
    
    public int getRelease(){
        return lanzamiento;
    }
    
    public int getDuration(){
        return duracion;
    }
    
    public String getAttributes(){
        String resp = "<html>Nombre: "+this.nombre+"<br>";
        resp+= "Album: "+this.album+"<br>";
        resp+= "Artista: "+this.artista+"<br>";
        resp+= "Fecha de Lanzamiento: "+this.lanzamiento+"<br>";
        resp+= "Segundos de duracion: "+this.duracion+"<br>";
        resp+= "</html>";
        
        return resp;
    }
    
    //setters
    public void setName(String nombre){
        this.nombre = nombre;
    }
    
    public void setAlbum(String album){
        this.album = album;
    }
    
    public void setArtist(String artista){
        this.artista = artista;
    }
    
    public void setRelease(int lanzamiento){
        this.lanzamiento = lanzamiento;
    }
    
    public void setDuration(int duracion){
        this.duracion = duracion;
    }
}
