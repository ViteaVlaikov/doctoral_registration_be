package usm.api.doctoral_registration.mapper;

import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import usm.api.doctoral_registration.dto.supervisor.SupervisorDTO;
import usm.api.doctoral_registration.model.supervisor.Supervisor;
import usm.api.doctoral_registration.repository.supervisor.SupervisorRepository;

@Mapper
@Component
public interface SupervisorMapper extends EntityMapper<Supervisor, SupervisorDTO> {
//
//    @Override
//    SupervisorDTO toDto(Supervisor entity);
//
//    @Override
//    Supervisor toEntity(SupervisorDTO name);
}
