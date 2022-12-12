package dto.services;

import lombok.Builder;
import lombok.Setter;
import lombok.experimental.Accessors;

@Builder
@Accessors(chain = true)
public class Attributes {

    @Setter private String additionalProp1;
    @Setter private String additionalProp2;
    @Setter private String additionalProp3;

}

