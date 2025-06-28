package io.github.arxtd.branchflow_api.repository;

import com.mongodb.lang.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RepositoryRepository extends MongoRepository<io.github.arxtd.branchflow_api.model.Repository, String> {

    Page<io.github.arxtd.branchflow_api.model.Repository> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name, String description, Pageable pageable);
    Page<io.github.arxtd.branchflow_api.model.Repository> findAll(@NonNull Pageable pageable);

    io.github.arxtd.branchflow_api.model.Repository findRepositoryByName(String name);
}
