package app.curso.util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import app.curso.entidad.Transferencia;

public class DatabaseTransferencia {
    private  Connection conexion;
    public DatabaseTransferencia() {
        this.conexion = new DatabaseConnection().getConnection();
    }

    public boolean insertarTransferencia(Transferencia transferencia){
        PreparedStatement instruccion = null;
        try {
            instruccion = conexion.prepareStatement("INSERT INTO transferencia(id_ordenante, id_beneficiario, importe, concepto, fecha) VALUES (?,?,?,?,?)");
            instruccion.setInt(1, transferencia.getId_ordenante());
            instruccion.setInt(2, transferencia.getId_beneficiario());
            instruccion.setDouble(3, transferencia.getImporte());
            instruccion.setString(4, transferencia.getConcepto());
            instruccion.setTimestamp(5, transferencia.getFecha());
            instruccion.executeUpdate();
            instruccion.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(instruccion != null){
                try {
                    instruccion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public ArrayList <Transferencia> getTransferencias(){
        Statement instruccion = null;
        ArrayList<Transferencia> transferencias = new ArrayList<Transferencia>();
        try {
            instruccion = conexion.createStatement();
            ResultSet resultados = instruccion.executeQuery("SELECT * FROM transferencia");

            while (resultados.next()) {
                int id = resultados.getInt("id");
                int id_ordenante = resultados.getInt("id_ordenante");
                int id_beneficiario = resultados.getInt("id_beneficiario");
                Double importe = resultados.getDouble("importe");
                String concepto = resultados.getString("concepto");
                Timestamp fecha = resultados.getTimestamp("fecha");
                Transferencia transferencia = new Transferencia(id, id_ordenante, id_beneficiario, importe, concepto, fecha);
                transferencias.add(transferencia);
            }
            instruccion.close();
            return transferencias;
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(instruccion!= null){
                try {
                    instruccion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public Transferencia getTransferencia(int id){
        PreparedStatement instruccion = null;
        Transferencia mensaje = null;
        try {
            String query = "SELECT * FROM transferencia WHERE id= ?";
            instruccion = conexion.prepareStatement(query);
            instruccion.setInt(1,id);

            ResultSet resultados = instruccion.executeQuery();

            if (resultados.next()) {
                mensaje = new Transferencia();
                mensaje.setId (resultados.getInt("id"));
                mensaje.setId_ordenante(resultados.getInt("id_ordenante"));
                mensaje.setId_beneficiario(resultados.getInt("id_beneficiario"));
                mensaje.setImporte(resultados.getDouble("importe"));
                mensaje.setConcepto(resultados.getString("concepto"));
                mensaje.setFecha(resultados.getTimestamp("fecha"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(instruccion!= null){
                try {
                    instruccion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return mensaje;
    }

    public boolean eliminarTransferencia(int id){
        PreparedStatement instruccion = null;
        try {
            String query = "DELETE FROM transferencia WHERE id=?";
            instruccion = conexion.prepareStatement(query);
            instruccion.setInt(1,id);
            int filasBorradas = instruccion.executeUpdate();

            return filasBorradas != 0;
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(instruccion != null){
                try {
                    instruccion.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean actualizarTransferencia(Transferencia transferencia){
        PreparedStatement instruccion = null;
        try {
            String query = "UPDATE transferencia SET  id_ordenante = ?, id_beneficiario = ?, importe =?, concepto=?, fecha=? WHERE id =?";
            instruccion = conexion.prepareStatement(query);
            instruccion.setInt(1, transferencia.getId_ordenante());
            instruccion.setInt(2, transferencia.getId_beneficiario());
            instruccion.setDouble(3, transferencia.getImporte());
            instruccion.setString(4, transferencia.getConcepto());
            instruccion.setTimestamp(5, transferencia.getFecha());
            instruccion.setInt(6, transferencia.getId());
            int filasActualizadas = instruccion.executeUpdate();
            return filasActualizadas!= 0;

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(instruccion!= null){
                try {
                    instruccion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
