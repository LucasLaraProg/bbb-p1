package me.dio.coding.votacaobbb.api.repository;

import me.dio.coding.votacaobbb.api.model.ParameterModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParameterRepository extends MongoRepository<ParameterModel, String> {
}
