package io.github.arxtd.branchflow_api.mapper;

import io.github.arxtd.branchflow_api.dto.repository.RepositoryDTO;
import io.github.arxtd.branchflow_api.model.Repository;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RepositoryMapper {
    Repository toRepository(RepositoryDTO dto);
    RepositoryDTO toRepositoryDTO(Repository repository);
    List<RepositoryDTO> toRepositoryDTOList(List<Repository> repositoryList);
}
