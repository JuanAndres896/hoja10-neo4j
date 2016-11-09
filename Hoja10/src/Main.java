/* 
Universidad del Valle de Guatemala
Algoritmos y estructuras de datos
Hoja de trabajo 10
Rodrigo Barrios, carné 15009
Juan Andrés García - 15046
José Luis Méndez - 15024
Christian Morales - 15015

Main.java

Este programa recoje la cantidad de correos enviados entre 14 empleados de una empresa de software y lo ordena en una estructura de grafo.
Esta estructura sirve para determinar los empleados que están más conectados entre sí y los que se mantienen más  aislados.
*/
import java.io.File;
import org.neo4j.cypher.internal.ExecutionEngine;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.logging.LogProvider;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;
public class Main {
    
    //Se crea una enumeración tipo nodo que implementa a Label
    public enum NodeType implements Label{
        Persona;
    }
    //Se crea una enumeración tipo relación que implementa a Label
    public enum RelationType implements RelationshipType{
        Correos;
    }
    
    static Result resultado1,resultado2,resultado3,resultado4,resultado5,resultado6;
    
    public static void main(String[] args) {
        //Se crea una fabrica para crear bases de datos
        GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
        //Se obtiene la dirección de la base de datos, esta cambia en cada computadora:
        File directorio = new File("C:\\Users\\usuario\\Documents\\Neo4j\\default.graphdb");
        //Se utiliza el objeto tipo file para ingresar al archivo del grafo
        GraphDatabaseService graphDb = dbFactory.newEmbeddedDatabase(directorio);
        graphDb.execute("MATCH (n)\n" +
"OPTIONAL MATCH (n)-[r]-()\n" + 
"DELETE n,r");
        
        
        //Se intenta realizar una transacción u operación en Neo4j
        try (Transaction tx = graphDb.beginTx()){
            
            //Se crean los nodos para cada empleado, todos son de tipo persona
            Node Per1 = graphDb.createNode(NodeType.Persona);
            //Número de identifiación del empleado
            Per1.setProperty("Id",1);
            //Nombre del empleado
            Per1.setProperty("Nombre", "Persona 1");
            
            Node Per2 = graphDb.createNode(NodeType.Persona);
            Per2.setProperty("Id",2);
            Per2.setProperty("Nombre", "Persona 2");
            
            Node Per3 = graphDb.createNode(NodeType.Persona);
            Per3.setProperty("Id",3);
            Per3.setProperty("Nombre", "Persona 3");
            
            Node Per4 = graphDb.createNode(NodeType.Persona);
            Per4.setProperty("Id",4);
            Per4.setProperty("Nombre", "Persona 4");
            
            Node Per5 = graphDb.createNode(NodeType.Persona);
            Per5.setProperty("Id",5);
            Per5.setProperty("Nombre", "Persona 5");
            
            Node Per6 = graphDb.createNode(NodeType.Persona);
            Per6.setProperty("Id",6);
            Per6.setProperty("Nombre", "Persona 6");
            
            Node Per7 = graphDb.createNode(NodeType.Persona);
            Per7.setProperty("Id",7);
            Per7.setProperty("Nombre", "Persona 7");
            
            Node Per8 = graphDb.createNode(NodeType.Persona);
            Per8.setProperty("Id",8);
            Per8.setProperty("Nombre", "Persona 8");
            
            Node Per9 = graphDb.createNode(NodeType.Persona);
            Per9.setProperty("Id",9);
            Per9.setProperty("Nombre", "Persona 9");
            
            Node Per10 = graphDb.createNode(NodeType.Persona);
            Per10.setProperty("Id",10);
            Per10.setProperty("Nombre", "Persona 10");
            
            Node Per11 = graphDb.createNode(NodeType.Persona);
            Per11.setProperty("Id",11);
            Per11.setProperty("Nombre", "Persona 11");
            
            Node Per12 = graphDb.createNode(NodeType.Persona);
            Per12.setProperty("Id",12);
            Per12.setProperty("Nombre", "Persona 12");
            
            Node Per13 = graphDb.createNode(NodeType.Persona);
            Per13.setProperty("Id",13);
            Per13.setProperty("Nombre", "Persona 13");
            
            Node Per14 = graphDb.createNode(NodeType.Persona);
            Per14.setProperty("Id",14);
            Per14.setProperty("Nombre", "Persona 14");
            
            
            //Se crean relaciones entre los empleados, las cuales indican que se han enviado correos
            Relationship P1P2 = Per1.createRelationshipTo(Per2,RelationType.Correos);
            //Se define cuantos correos ha mandado el empleado al otro
            P1P2.setProperty("Cantidad",3);
            
            Relationship P1P3 = Per1.createRelationshipTo(Per3,RelationType.Correos);
            P1P3.setProperty("Cantidad",2);
            
            Relationship P1P9 = Per1.createRelationshipTo(Per9,RelationType.Correos);
            P1P9.setProperty("Cantidad",6);
            
            Relationship P2P1 = Per2.createRelationshipTo(Per1,RelationType.Correos);
            P2P1.setProperty("Cantidad",5);
            
            Relationship P2P3 = Per2.createRelationshipTo(Per3,RelationType.Correos);
            P2P3.setProperty("Cantidad",8);
            
            Relationship P2P4 = Per2.createRelationshipTo(Per4,RelationType.Correos);
            P2P4.setProperty("Cantidad",2);
            
            Relationship P2P12 = Per2.createRelationshipTo(Per12,RelationType.Correos);
            P2P12.setProperty("Cantidad",1);
            
            Relationship P3P1 = Per3.createRelationshipTo(Per1,RelationType.Correos);
            P3P1.setProperty("Cantidad",5);
            
            Relationship P3P4 = Per3.createRelationshipTo(Per4,RelationType.Correos);
            P3P4.setProperty("Cantidad",2);
            
            Relationship P4P5 = Per4.createRelationshipTo(Per5,RelationType.Correos);
            P4P5.setProperty("Cantidad",5);
            
            Relationship P4P11 = Per4.createRelationshipTo(Per11,RelationType.Correos);
            P4P11.setProperty("Cantidad",2);
            
            Relationship P4P13 = Per4.createRelationshipTo(Per13,RelationType.Correos);
            P4P13.setProperty("Cantidad",3);
            
            Relationship P4P14 = Per4.createRelationshipTo(Per14,RelationType.Correos);
            P4P14.setProperty("Cantidad",7);
            
            Relationship P5P4 = Per5.createRelationshipTo(Per4,RelationType.Correos);
            P5P4.setProperty("Cantidad",2);
            
            Relationship P5P6 = Per5.createRelationshipTo(Per6,RelationType.Correos);
            P5P6.setProperty("Cantidad",6);
            
            Relationship P5P11 = Per5.createRelationshipTo(Per11,RelationType.Correos);
            P5P11.setProperty("Cantidad",4);
            
            Relationship P5P12 = Per5.createRelationshipTo(Per12,RelationType.Correos);
            P5P12.setProperty("Cantidad",3);
            
            Relationship P5P13 = Per5.createRelationshipTo(Per13,RelationType.Correos);
            P5P13.setProperty("Cantidad",7);
            
            Relationship P5P14 = Per5.createRelationshipTo(Per14,RelationType.Correos);
            P5P14.setProperty("Cantidad",9);
       
            Relationship P6P4 = Per6.createRelationshipTo(Per4,RelationType.Correos);
            P6P4.setProperty("Cantidad",6);
            
            Relationship P6P5 = Per6.createRelationshipTo(Per5,RelationType.Correos);
            P6P5.setProperty("Cantidad",2);
            
            Relationship P6P12 = Per6.createRelationshipTo(Per12,RelationType.Correos);
            P6P12.setProperty("Cantidad",7);
            
            Relationship P6P13 = Per6.createRelationshipTo(Per13,RelationType.Correos);
            P6P13.setProperty("Cantidad",7);
            
            Relationship P7P8 = Per7.createRelationshipTo(Per8,RelationType.Correos);
            P7P8.setProperty("Cantidad",12);
            
            Relationship P7P9 = Per7.createRelationshipTo(Per9,RelationType.Correos);
            P7P9.setProperty("Cantidad",13);
            
            Relationship P7P11 = Per7.createRelationshipTo(Per11,RelationType.Correos);
            P7P11.setProperty("Cantidad",1);
            
            Relationship P8P6 = Per8.createRelationshipTo(Per6,RelationType.Correos);
            P8P6.setProperty("Cantidad",3);
            
            Relationship P8P7 = Per8.createRelationshipTo(Per7,RelationType.Correos);
            P8P7.setProperty("Cantidad",14);
            
            Relationship P8P9 = Per8.createRelationshipTo(Per9,RelationType.Correos);
            P8P9.setProperty("Cantidad",21);
            
            Relationship P8P10 = Per8.createRelationshipTo(Per10,RelationType.Correos);
            P8P10.setProperty("Cantidad",2);
            
            Relationship P9P5 = Per9.createRelationshipTo(Per5,RelationType.Correos);
            P9P5.setProperty("Cantidad",4);
            
            Relationship P9P7 = Per9.createRelationshipTo(Per7,RelationType.Correos);
            P9P7.setProperty("Cantidad",12);
            
            Relationship P9P8 = Per9.createRelationshipTo(Per8,RelationType.Correos);
            P9P8.setProperty("Cantidad",23);
            
            Relationship P10P4 = Per10.createRelationshipTo(Per4,RelationType.Correos);
            P10P4.setProperty("Cantidad",9);
            
            Relationship P10P5 = Per10.createRelationshipTo(Per5,RelationType.Correos);
            P10P5.setProperty("Cantidad",7);
            
            Relationship P10P6 = Per10.createRelationshipTo(Per6,RelationType.Correos);
            P10P6.setProperty("Cantidad",1);
            
            Relationship P10P7 = Per10.createRelationshipTo(Per7,RelationType.Correos);
            P10P7.setProperty("Cantidad",1);
            
            Relationship P10P11 = Per10.createRelationshipTo(Per11,RelationType.Correos);
            P10P11.setProperty("Cantidad",5);
            
            Relationship P10P12 = Per10.createRelationshipTo(Per12,RelationType.Correos);
            P10P12.setProperty("Cantidad",4);
            
            Relationship P10P13 = Per10.createRelationshipTo(Per13,RelationType.Correos);
            P10P13.setProperty("Cantidad",8);
            
            Relationship P10P14 = Per10.createRelationshipTo(Per14,RelationType.Correos);
            P10P14.setProperty("Cantidad",7);
            
            Relationship P11P4 = Per11.createRelationshipTo(Per4,RelationType.Correos);
            P11P4.setProperty("Cantidad",4);
            
            Relationship P11P6 = Per11.createRelationshipTo(Per6,RelationType.Correos);
            P11P6.setProperty("Cantidad",1);
            
            Relationship P11P10 = Per11.createRelationshipTo(Per10,RelationType.Correos);
            P11P10.setProperty("Cantidad",1);
                      
            Relationship P11P13 = Per11.createRelationshipTo(Per13,RelationType.Correos);
            P11P13.setProperty("Cantidad",9);
            
            Relationship P11P14 = Per11.createRelationshipTo(Per14,RelationType.Correos);
            P11P14.setProperty("Cantidad",1);
            
            Relationship P12P4 = Per12.createRelationshipTo(Per4,RelationType.Correos);
            P12P4.setProperty("Cantidad",4);
            
            Relationship P12P5 = Per12.createRelationshipTo(Per5,RelationType.Correos);
            P12P5.setProperty("Cantidad",4);
            
            Relationship P12P6 = Per12.createRelationshipTo(Per6,RelationType.Correos);
            P12P6.setProperty("Cantidad",9);
            
            Relationship P12P10 = Per12.createRelationshipTo(Per10,RelationType.Correos);
            P12P10.setProperty("Cantidad",2);
            
            Relationship P12P11 = Per12.createRelationshipTo(Per11,RelationType.Correos);
            P12P11.setProperty("Cantidad",4);
            
            Relationship P12P13 = Per12.createRelationshipTo(Per13,RelationType.Correos);
            P12P13.setProperty("Cantidad",8);
            
            Relationship P12P14 = Per12.createRelationshipTo(Per14,RelationType.Correos);
            P12P14.setProperty("Cantidad",9);
            
            Relationship P13P4 = Per13.createRelationshipTo(Per4,RelationType.Correos);
            P13P4.setProperty("Cantidad",1);
            
            Relationship P13P5 = Per13.createRelationshipTo(Per5,RelationType.Correos);
            P13P5.setProperty("Cantidad",3);
            
            Relationship P13P10 = Per13.createRelationshipTo(Per10,RelationType.Correos);
            P13P10.setProperty("Cantidad",2);
            
            Relationship P13P11= Per13.createRelationshipTo(Per11,RelationType.Correos);
            P13P11.setProperty("Cantidad",3);
            
            Relationship P13P12 = Per13.createRelationshipTo(Per2,RelationType.Correos);
            P13P12.setProperty("Cantidad",2);
            
            Relationship P14P4 = Per14.createRelationshipTo(Per4,RelationType.Correos);
            P14P4.setProperty("Cantidad",7);
            
            Relationship P14P10 = Per14.createRelationshipTo(Per10,RelationType.Correos);
            P14P10.setProperty("Cantidad",6);
            
            Relationship P14P11 = Per14.createRelationshipTo(Per11,RelationType.Correos);
            P14P11.setProperty("Cantidad",8);
            
            Relationship P14P12 = Per14.createRelationshipTo(Per12,RelationType.Correos);
            P14P12.setProperty("Cantidad",3);
            //Aquí se imprimen TODAS las relaciones de correos en el grafo
            System.out.println("Aquí se muestran todas las relaciones del grafo:\n");
            //Se hacen queries para ver todos los nodos y todas sus relaciones de Correos
            resultado1 = graphDb.execute("MATCH (P1:Persona)-[C:Correos]->(P2:Persona) RETURN P1.Nombre");
            resultado2 = graphDb.execute("MATCH (P1:Persona)-[C:Correos]->(P2:Persona) RETURN P2.Nombre");
            resultado3 = graphDb.execute("MATCH (P1:Persona)-[C:Correos]->(P2:Persona) RETURN C.Cantidad");
            //El objeto Result puede devolver un iterador con el metodo .columnAs()
            Iterator<String>r1=resultado1.columnAs("P1.Nombre");
            Iterator<String>r2=resultado2.columnAs("P2.Nombre");
            Iterator<String>r3=resultado3.columnAs("C.Cantidad");
            //Se crearon listas para insertar los datos del iterador
            LinkedList<String> res1 = new LinkedList();
            LinkedList<String> res2 = new LinkedList();
            LinkedList<Object> res3 = new LinkedList();
            //Se agregan los datos a la lista
            while (r1.hasNext()){
                res1.add(r1.next());
            }
            while (r2.hasNext()){
                res2.add(r2.next());
            }
            while (r3.hasNext()){
                res3.add(r3.next());
            }
            //Tamaño de la lista
            int size2 = res1.size();
            //Impresión de la consulta
            for(int i=0;i<size2;i++){
                System.out.println("La "+res1.get(i)+" envió "+res3.get(i)+" correos a la "+res2.get(i));
            }
            //Se hace exactamente lo mismo, pero ahora la condicion es que el mínimo de correos es de 6
            System.out.println("\n\nLas siguientes personas han enviado 6 correos o más:\n");
            resultado4 = graphDb.execute("MATCH (P1:Persona)-[C:Correos]->(P2:Persona) WHERE C.Cantidad > 6 RETURN P1.Nombre");
            resultado5 = graphDb.execute("MATCH (P1:Persona)-[C:Correos]->(P2:Persona) WHERE C.Cantidad > 6 RETURN P2.Nombre");
            resultado6 = graphDb.execute("MATCH (P1:Persona)-[C:Correos]->(P2:Persona) WHERE C.Cantidad > 6 RETURN C.Cantidad");
            
            Iterator<String>r4=resultado4.columnAs("P1.Nombre");
            Iterator<String>r5=resultado5.columnAs("P2.Nombre");
            Iterator<String>r6=resultado6.columnAs("C.Cantidad");
            
            LinkedList<String> res4 = new LinkedList();
            LinkedList<String> res5 = new LinkedList();
            LinkedList<Object> res6 = new LinkedList();
            
            while (r4.hasNext()){
                res4.add(r4.next());
            }
            while (r5.hasNext()){
                res5.add(r5.next());
            }
            while (r6.hasNext()){
                res6.add(r6.next());
            }
            
            int size1 = res4.size();
            
            for(int i=0;i<size1;i++){
                System.out.println("La "+res4.get(i)+" envió "+res6.get(i)+" correos a la "+res5.get(i));
            }
            System.out.println("");
            
            //PEOPLE COMMUNICATION INCISO E
            
            int[] degrees= new int[14];
            int[] order= new int[degrees.length];
            int k=-1;

            for (int i=0; i<degrees.length; i++)
		degrees[i]=graphDb.getNodeById(i).getDegree(Direction.BOTH);

            for (int i=0; i<degrees.length; i++){
		int b1=0;
		for(int j=0; j<degrees.length; j++){
                    int d= degrees[j];
                    if (d>=b1){
			b1=d;
			k=j;
                    }
		}
            order[i]=k;
            degrees[k]=0;
            }
            
            System.out.println("Personas ordenadas de la más comunicada a la menos comunicada: ");
            System.out.println("");
            //Se imprime el nombre de las personas segun el array ya ordenado
            for(int z=0; z<degrees.length; z++){
		System.out.println(" Persona "+ (order[z]+1));
            }
            System.out.println("");
            
            //INCISO F
            //INCISO CHEPE LUIS
        
            //SE CREA VECTOR CON LOS IDs
            Vector<Integer> vectorID= new Vector<>();
            Vector<Long> vectorCant= new Vector<>();
            for(int i=0; i<196; i++){
                try{
                    Relationship rel= graphDb.getRelationshipById(i);
                    long cantidad = (long) rel.getProperty("Cantidad");
                    vectorID.addElement(i);
                    vectorCant.addElement(cantidad); 
                }catch(Exception e){
                    
                }
            }
        
            //SCANNER PARA SOLICITAR LOS DATOS
            Scanner scan= new Scanner(System.in);
            int indNodo;
            int fNodo;
        
            //INGRESO DE LA PERSONA DE BÚSQUEDA
            System.out.println("Ingrese el número de la persona origen: ");
            indNodo= scan.nextInt() - 1;
            int iNodo=indNodo;
        
            //INGRESO DE LA PERSONA DESTINO
            System.out.println("Ingrese el número de la persona destino (para mostrar todas las relaciones ingrese 0): ");
            fNodo= scan.nextInt() - 1;
				
            //ARRAYS PARA ALMACENAMIENTO DE VALORES
            long[] nodos= {9999,9999,9999,9999,9999,9999,9999,9999,9999,9999,9999,9999,9999,9999};
            boolean[] temps={false,false,false,false,false,false,false,false,false,false,false,false,false,false};
            int[] desde= new int[14];
			
            nodos[indNodo]=0;
            desde[indNodo]=indNodo;
			
            for(int z=0; z<14; z++){
            //establecer nodos temporales
                for(int i=0; i<vectorID.size(); i++){
                    Relationship relation = graphDb.getRelationshipById(vectorID.get(i));
                    int nA= (int)relation.getStartNode().getId();
                    int nB= (int)relation.getEndNode().getId();
                    long l1= (long) relation.getProperty("Cantidad");
                    //Se almacena temporalmente todas las relaciones entre los nodos
                    if(nA==indNodo){
                        if (nodos[nB]>(nodos[indNodo]+l1)){
                            nodos[nB]=nodos[indNodo]+l1;
                            desde[nB]=indNodo;
                        }
                    }
                }
                // Se encuentra el menor de los nodos temporales
                long b= 10000;
                int  m =-1;
                for(int j=0; j<nodos.length; j++){
                    long d= nodos[j];
                    if(temps[j]==false){
                        if (d<=b){
                            b=d;
                            m=j;
                        }
                    }
                }
					
                // establecer minimo como fijo
                temps[m]=true;
                // cambiar nodo de partida
                indNodo=m;						
            } 
         
            if (fNodo==-1){
                //para todos los nodos
                for (int i=0; i<14; i++){
                    long cco= nodos[i];
                    if(cco==9999)
                        System.out.println("Persona "+(iNodo+1)+" no ha mandado correos a Persona "+(i+1));
                    else	
                        System.out.println("La cantidad mínima de correos enviados de Persona "+(iNodo+1)+" a Persona"+(i+1)+" es: "+cco);
                }
            }else{
                //dado un nodo destino 
                long cor=nodos[fNodo];
                //Si la correlacion nunca fue modificada
                if(cor==9999)
                    System.out.println("Persona "+(iNodo+1)+" no ha mandado correos a Persona "+(fNodo+1));
                else
                    //Caso contrario
                    System.out.println("La cantidad mínima de correos enviados de Persona "+(iNodo+1)+" a Persona"+(fNodo+1)+" es: "+cor);
            }
    
	
            tx.success();
        }
        //Se cierra la base de datos para guardar todos los cambios
        graphDb.shutdown();
    }
    
}