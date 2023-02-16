//package usm.api.doctoral_registration.mapper;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.factory.Mappers;
//import org.springframework.beans.factory.annotation.Autowired;
//import usm.api.doctoral_registration.model.country.Country;
//import usm.api.doctoral_registration.repository.country.CountryRepository;
//
////@RunWith(SpringJUnit4ClassRunner.class)
////@SpringJUnitConfig
//class EntityMapperTest {
//
//    @Getter
//    @Setter
//    @NoArgsConstructor
//    @AllArgsConstructor
//    static class SubDummy {
//        int id;
//
//        String str;
//    }
//
//    @Getter
//    @Setter
//    @NoArgsConstructor
//    @AllArgsConstructor
//    static class Dummy {
//
//        int id;
//
//        SubDummy sub;
//    }
//
//    @Getter
//    @Setter
//    static class DummyDto {
//
//        int id;
//
//        String str;
//    }
//
//
//    static class SubDummyMapper implements EntityMapper<SubDummy, String> {
//
//        DummyRepository dummyRepository;
//
//        public SubDummyMapper() {
//            this.dummyRepository = new DummyRepository();
//        }
//
//        @Override
//        public String toDto(SubDummy entity) {
//            return entity.str;
//        }
//
//        @Override
//        public SubDummy toEntity(Integer dto) {
//            return dummyRepository.getById()
//        }
//    }
//    @Mapper(uses = {SubDummyMapper.class})
//    interface DummyMapper extends EntityMapper<Dummy, DummyDto> {
//
//        DummyMapper INSTANCE = Mappers.getMapper(DummyMapper.class);
//
//        @Override
//        @Mapping(target = "str", source = "sub.str")
//        DummyDto toDto(Dummy entity);
//
//        @Override
//        @Mapping(target = "sub", expression = "java()")
//        Dummy toEntity(DummyDto dto);
//    }
//
//    static class DummyRepository {
//        public SubDummy getById(int id) {
//            return new SubDummy(1, "str");
//        }
//    }
//
//    private final DummyMapper mapper = DummyMapper.INSTANCE;
//
//    @Test
//    void test() {
//        Dummy dummy = new Dummy(1, new SubDummy(1, "str"));
//
//        DummyDto dto = mapper.toDto(dummy);
//
//        Assertions.assertEquals(dummy.sub.str, dto.str);
//    }
//}