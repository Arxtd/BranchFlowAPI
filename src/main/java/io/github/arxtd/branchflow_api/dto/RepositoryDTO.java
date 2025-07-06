package io.github.arxtd.branchflow_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepositoryDTO {
    private String id;
    private String name;
    private String description;
}
