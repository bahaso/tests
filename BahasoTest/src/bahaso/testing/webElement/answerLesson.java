package bahaso.testing.webElement;

import org.bson.Document;

public interface answerLesson {
	public Object getAnswerData(Document data);
	public void answerRight(Object answer);
	public void answerWrong(Object answer);
}
