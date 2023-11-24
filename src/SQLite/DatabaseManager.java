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

    public int insertUserName(String userName, String password) throws SQLIntegrityConstraintViolationException {
        String insertQuery = "INSERT INTO database (userName, password) VALUES (?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT last_insert_rowid()");
            if (resultSet.next()) {
                return resultSet.getInt(1); // Return the last inserted rowid
            } else {
                throw new SQLException("Failed to retrieve the last inserted rowid.");
            }
            
            
        } 
        
        
        
        catch (SQLException e) {
        	
        	if (e.getErrorCode() == 19) {
                // Unique constraint violation (error code 19)
                throw new SQLIntegrityConstraintViolationException(e.getMessage(), e.getSQLState(), e.getErrorCode());
            }
        	else
        	{
        		e.printStackTrace();
                // Handle the exception or throw it as needed
        	}
        	
        	return -1;
            
        }
    }

    public int checkCredentialsAndGetRowID(String enteredUsername, String enteredPassword) {
        String sql = "SELECT rowid FROM database WHERE userName = ? AND password = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, enteredUsername);
            preparedStatement.setString(2, enteredPassword);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("rowid");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Return -1 if no matching user is found
    }

    
    //Getters for different coloumn in database
    
    //Protein Getters
    
    public int proteinGoal(int rowID) {
        String sql = "SELECT Protein_Goal FROM database WHERE rowid = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, rowID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("Protein_Goal");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Return 0 if there's an issue or no matching rowID
    }
    
    public int proteinRemain(int rowID) {
        String sql = "SELECT Protein_Remain FROM database WHERE rowid = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, rowID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("Protein_Remain");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Return 0 if there's an issue or no matching rowID
    }
    
    public int proteinAte(int rowID) {
        String sql = "SELECT Protein_Ate FROM database WHERE rowid = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, rowID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("Protein_Ate");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Return 0 if there's an issue or no matching rowID
    }
    
    //Carbs Getters
    
    public int carbsAte(int rowID) {
        String sql = "SELECT Carbs_Ate FROM database WHERE rowid = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, rowID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("Carbs_Ate");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Return 0 if there's an issue or no matching rowID
    }
    
    public int carbsRemain(int rowID) {
        String sql = "SELECT Carbs_Remain FROM database WHERE rowid = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, rowID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("Carbs_Remain");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Return 0 if there's an issue or no matching rowID
    }
    
    public int carbsGoal(int rowID) {
        String sql = "SELECT Carbs_Goal FROM database WHERE rowid = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, rowID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("Carbs_Goal");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Return 0 if there's an issue or no matching rowID
    }

    
    //Fats Getters
    
    public int fatsAte(int rowID) {
        String sql = "SELECT Fat_Ate FROM database WHERE rowid = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, rowID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("Fat_Ate");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Return 0 if there's an issue or no matching rowID
    }

    public int fatsRemain(int rowID) {
        String sql = "SELECT Fat_Remain FROM database WHERE rowid = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, rowID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("Fat_Remain");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Return 0 if there's an issue or no matching rowID
    }

    public int fatsGoal(int rowID) {
        String sql = "SELECT Fat_Goal FROM database WHERE rowid = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, rowID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("Fat_Goal");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Return 0 if there's an issue or no matching rowID
    }

    // Calorie Getters
    
    public int calorieAte(int rowID) {
        String sql = "SELECT Calorie_Ate FROM database WHERE rowid = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, rowID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("Calorie_Ate");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Return 0 if there's an issue or no matching rowID
    } 
    
    public int calorieRemain(int rowID) {
        String sql = "SELECT Calorie_Remain FROM database WHERE rowid = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, rowID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("Calorie_Remain");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Return 0 if there's an issue or no matching rowID
    }

    public int calorieGoal(int rowID) {
        String sql = "SELECT Calorie_Goal FROM database WHERE rowid = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, rowID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("Calorie_Goal");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Return 0 if there's an issue or no matching rowID
    }

    // SETTERS FOR DATABASE
    
    public void ProteinGoalWrite(int rowID, int newValue) {
        String updateQuery = "UPDATE database SET Protein_Goal = ? WHERE rowid = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setInt(1, newValue);
            preparedStatement.setInt(2, rowID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or throw it as needed
        }
    }
    
    public void CarbsGoalWrite(int rowID, int newValue) {
        String updateQuery = "UPDATE database SET Carbs_Goal = ? WHERE rowid = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setInt(1, newValue);
            preparedStatement.setInt(2, rowID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or throw it as needed
        }
    }
    
    public void FatsGoalWrite(int rowID, int newValue) {
        String updateQuery = "UPDATE database SET Fat_Goal = ? WHERE rowid = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setInt(1, newValue);
            preparedStatement.setInt(2, rowID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or throw it as needed
        }
    }
    
    public void CalorieGoalWrite(int rowID, int newValue) {
        String updateQuery = "UPDATE database SET Calorie_Goal = ? WHERE rowid = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setInt(1, newValue);
            preparedStatement.setInt(2, rowID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or throw it as needed
        }
    }

    public void updateValue(int rowID, int newValue, String columnName) {
        String updateQuery = "UPDATE database SET " + columnName + " = ? WHERE rowid = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setInt(1, newValue);
            preparedStatement.setInt(2, rowID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void addValue(int rowID, int addValue, String columnName) {
        String selectQuery = "SELECT " + columnName + " FROM database WHERE rowid = ?";
        String updateQuery = "UPDATE database SET " + columnName + " = ? WHERE rowid = ?";

        try {
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setInt(1, rowID);
            ResultSet resultSet = selectStatement.executeQuery();

            int currentValue = 0;
            if (resultSet.next()) {
                currentValue = resultSet.getInt(columnName);
            }

            int updatedValue = currentValue + addValue;

            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.setInt(1, updatedValue);
            updateStatement.setInt(2, rowID);
            updateStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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


}
