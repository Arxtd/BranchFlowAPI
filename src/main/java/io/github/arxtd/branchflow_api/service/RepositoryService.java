package io.github.arxtd.branchflow_api.service;

import io.github.arxtd.branchflow_api.dto.RepositoryDTO;
import io.github.arxtd.branchflow_api.infra.exception.ItemNotFoundException;
import io.github.arxtd.branchflow_api.mapper.RepositoryMapper;
import io.github.arxtd.branchflow_api.model.Repository;
import io.github.arxtd.branchflow_api.repository.RepositoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class RepositoryService {

    private final RepositoryRepository repositoryRepository;
    private final RepositoryMapper repositoryMapper;

    public RepositoryDTO save(RepositoryDTO repository) {
        return repositoryMapper.toRepositoryDTO(repositoryRepository.save(repositoryMapper.toRepository(repository)));
    }

    public Page<RepositoryDTO> findAll(Pageable pageable) {
        Page<Repository> page = repositoryRepository.findAll(pageable);
        return page.map(repositoryMapper::toRepositoryDTO);
    }

    public Page<RepositoryDTO> search(String name, String description, Pageable pageable) {
        Page<Repository> repositoryPage = repositoryRepository
                .findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(name, description, pageable);

        return repositoryPage.map(repositoryMapper::toRepositoryDTO);
    }

    public void update(String name, RepositoryDTO repositoryDTO) {
        Repository repository = repositoryRepository.findRepositoryByName(name);

        if (repository != null) {
            repository.setName(repositoryDTO.getName());
            repository.setDescription(repositoryDTO.getDescription());
            repositoryRepository.save(repository);
        } else {
            throw new ItemNotFoundException();
        }
    }

    public void delete(String name) {
        Repository repository = repositoryRepository.findRepositoryByName(name);

        if (repository != null) {
            repositoryRepository.delete(repository);
        } else {
            throw new ItemNotFoundException();
        }
    }
}
