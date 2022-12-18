package courseRegistrationSystem.service;

public interface Mapper<T, R>{
    //From Normal To Dto
    R mapTo(T entity);

}
