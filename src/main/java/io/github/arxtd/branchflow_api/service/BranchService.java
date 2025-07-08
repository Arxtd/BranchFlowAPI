package io.github.arxtd.branchflow_api.service;

import io.github.arxtd.branchflow_api.dto.branch.CreateBranchRequestRecordDTO;
import io.github.arxtd.branchflow_api.infra.exception.ItemNotFoundException;
import io.github.arxtd.branchflow_api.infra.exception.NullFieldException;
import io.github.arxtd.branchflow_api.model.Branch;
import io.github.arxtd.branchflow_api.repository.BranchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BranchService {

    private final BranchRepository branchRepository;
    private final RepositoryService repositoryService;

    public Branch save(CreateBranchRequestRecordDTO branchCreate, String repositoryId) {

        if (branchCreate.branchName() == null || branchCreate.branchName().isEmpty()) {
            throw new NullFieldException("Null branchName");

        } else if (!repositoryService.exists(repositoryId)) {
            throw new ItemNotFoundException("Repository not found or not exists");
        }

        Branch branch = Branch.builder()
                .name(branchCreate.branchName())
                .repositoryId(repositoryId)
                .build();

        return branchRepository.save(branch);
    }

    public Branch findBranchById(String id) {
        return branchRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }

    public void deleteBranchById(String id) {
        branchRepository.deleteById(id);
    }

    public Branch updateBranch(String id, Branch branch) {
        Branch branchToUpdate = findBranchById(id);
        branchToUpdate.setName(branch.getName());
        return branchRepository.save(branchToUpdate);
    }


}
