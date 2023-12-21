package software.ulpgc.kata4;

import java.sql.SQLException;
import java.util.List;

public interface SongLoader {
    List<Song> loadAll() throws SQLException;
}
