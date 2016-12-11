package application.forms;

import data.User;

import javax.validation.constraints.NotNull;
import java.util.List;

public class MessageForm {

    @NotNull
    private String message;

    private String hashtags;

    public String getHashtags() {
        return hashtags;
    }

    public void setHashtags(String hashtags) {
        this.hashtags = hashtags;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
