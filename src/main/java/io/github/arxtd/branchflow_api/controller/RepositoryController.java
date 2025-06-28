package io.github.arxtd.branchflow_api.controller;

import io.github.arxtd.branchflow_api.dto.RepositoryDTO;
import io.github.arxtd.branchflow_api.service.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/repositories")
@AllArgsConstructor
public class RepositoryController {

    private final RepositoryService repositoryService;

    @PostMapping
    public ResponseEntity<RepositoryDTO> addRepository(@RequestBody RepositoryDTO repo) {
        return ResponseEntity.ok(repositoryService.save(repo));
    }

    @GetMapping
    public ResponseEntity<Page<RepositoryDTO>> getRepositories(Pageable pageable) {
        return ResponseEntity.ok(repositoryService.findAll(pageable));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<RepositoryDTO>> getRepository(@RequestParam(required = false) String name, @RequestParam(required = false) String description,
                                                  Pageable pageable) {
        return ResponseEntity.ok(repositoryService.search(name, description, pageable));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteRepository(@RequestParam String name) {
        repositoryService.delete(name);
        return ResponseEntity.ok("Repository deleted");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateRepository(@RequestParam String name, @RequestBody RepositoryDTO repo) {
        repositoryService.update(name, repo);
        return ResponseEntity.ok("Repository updated");
    }
}
