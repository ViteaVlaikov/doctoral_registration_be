//package usm.api.doctoral_registration.mapper;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import usm.api.doctoral_registration.dto.supervisor.SupervisorDTO;
//import usm.api.doctoral_registration.model.supervisor.SteeringCommittee;
//
//@Component
//public class SteeringCommitteeMapper implements EntityMapper<SteeringCommittee, SupervisorDTO> {
//
//    SupervisorMapper supervisorMapper;
//
//    @Override
//    public SupervisorDTO toDto(SteeringCommittee entity) {
//        return supervisorMapper.toDto(entity.getSupervisor());
//    }
//
//    @Override
//    public SteeringCommittee toEntity(SupervisorDTO supervisorDTO) {
//        return null;
//    }
//}
