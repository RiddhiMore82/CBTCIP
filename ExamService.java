package exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamService {
	public List<Question> getQuestions(){
		List<Question> questions = new ArrayList<>();
		try(Connection connection = Database.getConnection()){
			String query = "SELECT * FROM questions";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery(); 
		
			while(resultSet.next()) {
				Question question = new Question(
					resultSet.getInt("question_id"),
					resultSet.getString("question"),
					resultSet.getString("option1"),
					resultSet.getString("option2"),
					resultSet.getString("option3"),
					resultSet.getString("option4"),
					resultSet.getInt("correct_option")
					);
				questions.add(question);
			}
		}catch(SQLException e) {
		e.printStackTrace();
		}
		return questions;
	}
	
	
	public int submitAnswers(User user, List<Integer> answers) {
		List<Question> questions = getQuestions();
		int score = 0;
		for(int i = 0; i < questions.size(); i++) {
			if(questions.get(i).getCorrectOption() == answers.get(i)) {
				score++;
			}
		}
		
		try(Connection connection = Database.getConnection()){
			String query = "INSERT INTO results (user_id, score) VALUES (?,?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, user.getUserId());
			statement.setInt(2, score);
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return score;
	}
}
