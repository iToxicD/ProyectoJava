import  java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //prueba
    }

    //Metodo para añadir canciones
    public void nuevaCancion(){
        Scanner sc = new Scanner(System.in);
        String sql = "INSERT INTO playlist (id, nombre, autor, duracion) VALUES (?,?,?,?);";
        int id = 0;
        String nombre = "", autor = "";
        Time duracion = null;
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/spotify", "root", "123456");
            PreparedStatement statement = conexion.prepareStatement(sql);
            id = sc.nextInt();
            statement.setInt(1, id);
            nombre = sc.next();
            statement.setString(2, nombre);
            autor = sc.next();
            statement.setString(3, autor);
            duracion = Time.valueOf(sc.next());
            statement.setTime(4, duracion);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void borrarCancion(){
        String borrarSql = "DELETE FROM playlist WHERE id = ?;";
        int id = 0;
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/spotify", "root", "123456");
            PreparedStatement statement = conexion.prepareStatement(borrarSql);
            statement.setInt(1, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
