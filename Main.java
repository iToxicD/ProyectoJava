import  java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //prueba

    }

    //Metodo para añadir canciones
    public static void nuevaCancion(){
        Scanner sc = new Scanner(System.in);
        String sql = "INSERT INTO playlist (id, nombre, autor, duracion) VALUES (?,?,?,?);";
        int id = 0;
        String nombre = "", autor = "";
        Time duracion = null;
        int actualizarFila;
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/spotify", "root", "123456");
            PreparedStatement statement = conexion.prepareStatement(sql);
            System.out.println("Añade id de cancion: ");
            id = sc.nextInt();
            statement.setInt(1, id);
            System.out.println("Añade nombre de cancion: ");
            nombre = sc.next();
            statement.setString(2, nombre);
            System.out.println("Añade autor de cancion: ");
            autor = sc.next();
            statement.setString(3, autor);
            System.out.println("Añade duracion de cancion: ");
            duracion = Time.valueOf(sc.next());
            statement.setTime(4, duracion);
            actualizarFila = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Método para borrar canciones
    public static void borrarCancion(){
        Scanner sc = new Scanner(System.in);
        String borrarSql = "DELETE FROM playlist WHERE id = ?;";
        int id = 0;
        int actualizarFila;
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/spotify", "root", "123456");
            PreparedStatement statement = conexion.prepareStatement(borrarSql);
            System.out.println("Id de la cancion a eliminar: ");
            id = sc.nextInt();
            statement.setInt(1, id);
            actualizarFila = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
