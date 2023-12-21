package software.ulpgc.kata4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLiteSongLoader implements SongLoader{
    public final Connection connection;
    public static final String queryAll = "SELECT field1, field2 FROM spoti WHERE field2 = 'Quevedo'";


    public SQLiteSongLoader(Connection connection) {
        this.connection = connection;
    }

    public List<Song> load(ResultSet resultSet) throws SQLException {
        List<Song> list = new ArrayList<>();
        while (resultSet.next()){
            list.add(songFrom(resultSet));
        }return list;
    }

    private Song songFrom(ResultSet resultSet) throws SQLException{
        return new Song(
                resultSet.getString("field1"),
                resultSet.getString("field2")
        );
    }

    @Override
    public List<Song> loadAll() throws SQLException {
        return load(queryAll());
    }

    private ResultSet queryAll() throws SQLException {
        return connection.createStatement().executeQuery(queryAll);
    }
}
