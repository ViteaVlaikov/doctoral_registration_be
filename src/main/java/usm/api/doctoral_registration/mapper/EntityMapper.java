package usm.api.doctoral_registration.mapper;

/**
 * EntityMapper describes methods for parse domain object into a DTO object
 */

public interface EntityMapper<E, D> {

    /**
     * methode parse domain to dto
     *
     * @param entity domain object
     * @return dto
     */
    D toDto(E entity);

    /**
     * methode parse dto to domain
     *
     * @param dto - data transfer object
     * @return domain object
     */
    E toEntity(D dto);
}
