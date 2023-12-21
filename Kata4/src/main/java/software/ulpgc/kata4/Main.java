package software.ulpgc.kata4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:BaseSpoti.db");
        List<Song> songs = new SQLiteSongLoader(connection).loadAll();
        for (Song song : songs){
            System.out.println(song);
        }
    }
}
