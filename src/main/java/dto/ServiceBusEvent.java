package dto;

import dto.services.Session;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

@Getter
public class ServiceBusEvent {

    public Integer id;
    public String href;
    public String eventId;
    public String eventTime;
    public String eventType;
    public String correlationId;
    public String domain;
    public String title;
    public String description;
    public String priority;
    public String timeOcurred; // todo bug - spelt wrong
    public Session session;
    public Event__1 event;

    @Getter
    public class Event__1 {

        public ProductOrder productOrder;
    }

    @Getter
    public class ProductOrder {

        @SerializedName("@baseType")
        public String baseType;
        public String schemaLocation;
        public String type;
        public String cancellationDate;
        public String cancellationReason;
        public String category;
        public String description;
        public String externalId;
        public String notificationContact;
        public String priority;
        public String requestedCompletionDate;
        public String requestedStartDate;
        public String state;
        public List<ProductOrderItem> productOrderItem = null;

    }

    @Getter
    public class ProductOrderItem {

        public String action;
        public String id;
        public Object productorderitemstring; //todo this feels wrong
        public Integer quantity;
        public String state;

    }

}
