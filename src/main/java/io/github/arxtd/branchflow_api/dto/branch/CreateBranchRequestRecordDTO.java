package io.github.arxtd.branchflow_api.dto.branch;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record CreateBranchRequestRecordDTO( @NotNull(message = "branch name null") String branchName) implements Serializable {
}
