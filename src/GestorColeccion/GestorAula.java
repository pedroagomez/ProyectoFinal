package GestorColeccion;

import Aula.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GestorAula {

    private HashMap<Integer,Aula> mapaAula;             // SE UTILIZO UN HASHMAP PARA BUSCAR UN AULA
                                                        // POR SU NUMERO.

    public GestorAula() {
        this.mapaAula = new HashMap<>();
    }

    public JSONArray toJson()throws JSONException
    {
        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray();
        for(Map.Entry<Integer,Aula> it : mapaAula.entrySet())
        {
            obj.put("numero",it.getKey());
            obj.put("aula",it.getValue().toJson());
            array.put(obj);

        }
        return array;

    }

    public void agregarAula(int numeroAula,Aula aula)
    {
        if(!mapaAula.containsKey(numeroAula))
        {
            mapaAula.put(numeroAula,aula);
        }
    }

    public boolean validarExistenciaAula(int numeroAula)
    {
        boolean existencia=false;
        if(mapaAula.containsKey(numeroAula))
        {
            existencia=true;
        }
        return existencia;
    }

    /*public String aulaNoDisponible()
    {
        StringBuilder builder=new StringBuilder();
        Iterator<Map.Entry<Integer,Aula>>it=mapaAula.entrySet().iterator();
        while(it.hasNext() )
        {
            Map.Entry<Integer,Aula>conjunto=it.next();
            if(!conjunto.getValue().isDisponible())
            {
                builder.append("Numero de aula : "+conjunto.getKey()).append("\n");
                builder.append(conjunto.getValue().toStringSinMateria()).append("\n");

            }
        }
        return builder.toString();
    }
*/


    // DEVUELVE CADENA DE STRING QUE MUESTRA TODAS LAS AULAS DISPONIBLES
   /* public String verAulasDisponibles()
    {
        StringBuilder builder= new StringBuilder();
        Iterator<Map.Entry<Integer,Aula>>it=mapaAula.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<Integer,Aula>conjunto=it.next();
            if(conjunto.getValue().isDisponible())
            {
                builder.append(conjunto.getValue().toStringSinMateria()).append("\n");
            }
        }
        return builder.toString();
    }*/



    // LISTA TODAS LAS AULAS QUE TIENEN UNA COMPUTADORA
    public String verAulasConComputadoras() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Integer, Aula> entry : mapaAula.entrySet()) {
            Aula aula = entry.getValue();
            if (aula instanceof AulaComputadora) {
                builder.append("Numero de aula: ").append(entry.getKey()).append("\n");
                builder.append(aula.toStringSinMateria()).append("\n");
            }
        }
        return builder.toString();
    }

    public String verAulasNormales() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Integer, Aula> entry : mapaAula.entrySet()) {
            Aula aula = entry.getValue();
            if (aula instanceof AulaNormal) {
                builder.append("Numero de aula: ").append(entry.getKey()).append("\n");
                builder.append(aula.toStringSinMateria()).append("\n");
            }
        }
        return builder.toString();
    }

    //MUESTRA TODAS LAS AULAS
    public String listarAulas()
    {
        StringBuilder builder= new StringBuilder();
        Iterator<Map.Entry<Integer,Aula>>it=mapaAula.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<Integer,Aula>conjunto=it.next();
            builder.append("Numero de aula : "+conjunto.getKey()).append("\n");
            builder.append(conjunto.getValue().toStringSinMateria()).append("\n");

        }
        return builder.toString();
    }

    public Aula buscarAulaPorNumero(int numeroAula) {
        return mapaAula.get(numeroAula);
    }
    //archivos
    public void cargarArchivoAula(){
        try {
            FileOutputStream ac=new FileOutputStream("Aulas.bin");
            DataOutputStream bc=new DataOutputStream(ac);
            ObjectOutputStream ar=new ObjectOutputStream(ac);
            Iterator<Map.Entry<Integer,Aula>>it=mapaAula.entrySet().iterator();
            while(it.hasNext())
            {
                Map.Entry<Integer,Aula>conjunto=it.next();
                bc.writeInt(conjunto.getKey());
                ar.writeObject(conjunto.getValue());
            }
            ac.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public String eliminarAula(int IDaula){
        String cadena = "";
        Aula aux = null;
        aux = buscarAulaPorNumero(IDaula);
        if(aux!=null) {
            cadena = "Se elimina el aula = " + aux.toStringSinMateria();
        }else {
            cadena = "Aula no encontrada";
        }
        return cadena;
    }

    public void leerArchivoAula(){

        try {
            FileInputStream fis = new FileInputStream("Aulas.bin");
            DataInputStream dis = new DataInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(fis);
            boolean bandera = true;
            while (bandera) {
                agregarAula(dis.readInt(), (Aula) ois.readObject());
            }
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }


}
