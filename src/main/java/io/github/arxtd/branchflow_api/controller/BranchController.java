package io.github.arxtd.branchflow_api.controller;

import io.github.arxtd.branchflow_api.dto.branch.CreateBranchRequestRecordDTO;
import io.github.arxtd.branchflow_api.model.Branch;
import io.github.arxtd.branchflow_api.service.BranchService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/branch")
@AllArgsConstructor
public class BranchController {

    private final BranchService branchService;

    @PostMapping("/{repositoryId}")
    public ResponseEntity<Branch> addBranch(@PathVariable("repositoryId") String repositoryId, @RequestBody CreateBranchRequestRecordDTO createBranchRequestRecordDTO) {
        return ResponseEntity.ok(branchService.save(createBranchRequestRecordDTO, repositoryId));
    }

}
