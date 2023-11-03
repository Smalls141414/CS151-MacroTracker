package SQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class DatabaseManager {
    private Connection connection;

    public DatabaseManager() {
        connectToDatabase();
    }

    public void connectToDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:src/SQLite/database.db");
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or throw it as needed
        }
    }

    public void insertUserName(String userName, String password) throws SQLIntegrityConstraintViolationException {
        String insertQuery = "INSERT INTO database (userName, password) VALUES (?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	
        	if (e.getErrorCode() == 19) {
                // Unique constraint violation (error code 19)
                throw new SQLIntegrityConstraintViolationException(e.getMessage(), e.getSQLState(), e.getErrorCode());
            }
        	else
        	{
        		e.printStackTrace();
                // Handle the exception or throw it as needed
        	}
            
        }
    }

    public boolean checkCredentials(String enteredUsername, String enteredPassword) {
        String sql = "SELECT * FROM database WHERE userName = ? AND password = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, enteredUsername);
            preparedStatement.setString(2, enteredPassword);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or throw it as needed
        }
        return false;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or throw it as needed
        }
    }

    //public void databaseEdit() {
      //  String sql = "UPDATE database (userName, password) VALUES (?, ?)";

    	
    //}

}
