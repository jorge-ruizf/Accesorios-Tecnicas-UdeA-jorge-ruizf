/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicexample.Repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import loginexample.Entities.Accesorio;

/**
 *
 * @author jufeq
 */
public class AccesorioRepository {
    private final String path = "C:\\Users\\jorge\\Documents\\NetBeansProjects\\13.LoginExampleWithFiles\\Accesorios.json";
    private FileReader reader;
    
    public AccesorioRepository() throws FileNotFoundException{
        this.reader = new FileReader(path);
    }
    
    public ArrayList<Accesorio> leerAccesorios() throws Exception{
        try{
            Gson gson = new Gson();
            ArrayList<Accesorio> lstAccesorios =
                    gson.fromJson(reader, new TypeToken<ArrayList<Accesorio>>(){
                    }.getType());
            
            return lstAccesorios;
        }catch(Exception exe){
            throw new Exception("Ocurrio un error, contacta al administrador");
        }
    }
    
        
    public void guardarAccesorios(ArrayList<Accesorio> lstAccesorios) throws Exception {
        try (FileWriter writer = new FileWriter(path)) {
            Gson gson = new Gson();
            gson.toJson(lstAccesorios, writer);  // serializa y escribe en el archivo
        } catch (IOException e) {
            throw new Exception("Ocurrió un error al guardar los accesorios, contacta al administrador.");
        }
    }
}
