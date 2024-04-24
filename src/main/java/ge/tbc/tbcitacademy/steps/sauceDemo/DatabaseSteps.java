package ge.tbc.tbcitacademy.steps.sauceDemo;

import ge.tbc.tbcitacademy.utils.MSSQLConnection;
import ge.tbc.tbcitacademy.utils.UserModel;
import io.qameta.allure.Step;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseSteps {

    @Step("Select user with username: {0}")
    public UserModel selectUser(String username) {
        UserModel login = null;
        try (Connection connection = MSSQLConnection.connect()) {
                String query = """
                            select * from Users where username = ?
                            """;
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                login = new UserModel(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password")
                );
            }
            return login;
        } catch (SQLException e) {
            e.printStackTrace();
            return login;
        }
    }
}
