package englishcentral.staj.demo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Note {
    @Id
    private String id;

    private String userId;
    private boolean isChangeable;
    private String title;
    private String bodyText;
}
