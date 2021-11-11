package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.MetaData;

@Repository
public interface RepoMetaData extends JpaRepository<MetaData, Long> {
}
