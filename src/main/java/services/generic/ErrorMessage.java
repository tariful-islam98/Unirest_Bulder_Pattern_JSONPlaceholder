package services.generic;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class ErrorMessage {

    private int code;
    private String message;
    private int status;
}