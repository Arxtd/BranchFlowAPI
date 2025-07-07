package io.github.arxtd.branchflow_api.service;

import io.github.arxtd.branchflow_api.infra.exception.ItemNotFoundException;
import io.github.arxtd.branchflow_api.model.Branch;
import io.github.arxtd.branchflow_api.repository.BranchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BranchService {

    private final BranchRepository branchRepository;

    public Branch save(Branch branch) {
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
