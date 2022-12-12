package dto.services;


import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

@Builder
@Accessors(chain = true)
@Getter
public class Session {

    private Attributes attributes;
    private String correlationId;
    private String email;
    private String fullName;
    private String loginName;
    private String xCorrelationId;

}
