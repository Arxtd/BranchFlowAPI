package io.github.arxtd.branchflow_api.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "repositorys")
public class Repository {

    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String description;
}
