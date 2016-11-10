/* 
Universidad del Valle de Guatemala
Algoritmos y estructuras de datos
Hoja de trabajo 10
Rodrigo Barrios, carné 15009
Juan Andrés García - 15046
José Luis Méndez - 15024
Christian Morales - 15015
*/

/* Clase empleada, utilizada para el inciso D*/
public class Empleado implements Comparable<Empleado> {
    private Integer num;
    private String nombre;
    /* Constructor */
    public Empleado(int num, String nombre){
        this.num = num;
        this.nombre = nombre;
        
    }
    public int getNum(){
        return num;
    }
    public String getNombre(){
        return nombre;
    }
    @Override
    public int compareTo(Empleado o) {
        return num.compareTo(o.getNum());
    }
    
}
