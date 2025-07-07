package io.github.arxtd.branchflow_api.repository;

import io.github.arxtd.branchflow_api.model.Branch;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BranchRepository extends MongoRepository<Branch, String> {
}
