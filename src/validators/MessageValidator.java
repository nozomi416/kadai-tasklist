package validators;

import java.util.ArrayList;
import java.util.List;

import models.Task;

public class MessageValidator {
    //バリデーションを実行
    public static List<String> validate(Task t) {
        List<String> errors = new ArrayList<String>();

        String content_error = validateContent(t.getContent());
        if(!content_error.equals("")) {
            errors.add(content_error);
        }
        return errors;
    }

    //タスクの必須入力チェック
    private static String validateContent(String content) {
        if(content == null || content.equals("")) {
            return "メッセージを入力してください。";
        }
        return "";
    }
}
