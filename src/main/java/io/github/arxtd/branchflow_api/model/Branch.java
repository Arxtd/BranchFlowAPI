package io.github.arxtd.branchflow_api.model;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "branchs")
public class Branch {

    @Id
    private String id;
    @Indexed(unique = true)
    @NotNull
    private String name;
    @NotNull
    private String repositoryId;
}
