package org.example.mysql.dao;

import lombok.AllArgsConstructor;
import org.example.mysql.ConnectionProvider;
import org.example.mysql.SQLRuntimeException;
import org.example.mysql.entity.Launch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class LaunchDaoImpl implements LaunchDao {

    private static final String FIND_BY_ID_QUERY = "SELECT id, name, total, passed, failed, skipped FROM launches  WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT id, name, total, passed, failed, skipped FROM launches";
    private final ConnectionProvider connectionProvider;

    @Override
    public Optional<Launch> findById(Integer id) {
        try (Connection connection = connectionProvider.provideConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_QUERY)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next() ? Optional.of(mapResultSetToEntity(resultSet)) : Optional.empty();
            }

        } catch (SQLException e) {
            throw new SQLRuntimeException("find by id", e);
        }

    }

    @Override
    public List<Launch> findAll() {
        try (Connection connection = connectionProvider.provideConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            ArrayList<Launch> launches = new ArrayList<>();
            while (resultSet.next()) {
                launches.add(mapResultSetToEntity(resultSet));
            }

            return launches;

        } catch (SQLException e) {
            throw new SQLRuntimeException("find by id", e);
        }
    }

    private static Launch mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return Launch.builder()
                .id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .total(resultSet.getInt("total"))
                .passed(resultSet.getInt("passed"))
                .failed(resultSet.getInt("failed"))
                .skipped(resultSet.getInt("skipped"))
                .build();
    }
}
