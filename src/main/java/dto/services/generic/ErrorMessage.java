package dto.services.generic;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class ErrorMessage {

    private int code;
    private String reason;
    private String message;
    private int status;
    private String referenceError;
    @SerializedName("@baseType") private String baseType;
    @SerializedName("@schemaLocation") private String schemaLocation;
    @SerializedName("@type") private String type;
}