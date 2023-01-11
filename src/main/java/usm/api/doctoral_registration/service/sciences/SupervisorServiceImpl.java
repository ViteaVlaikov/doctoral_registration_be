package usm.api.doctoral_registration.service.sciences;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.model.student.Supervisor;
import usm.api.doctoral_registration.repository.student.SupervisorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupervisorServiceImpl implements SupervisorService {
    private final SupervisorRepository supervisorRepository;
    @Override
    public List<Supervisor> findAll() {
        return supervisorRepository.findAll();
    }
}
