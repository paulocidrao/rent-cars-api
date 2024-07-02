package br.gov.sp.fatec.service.impl;

import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.mapper.CarroMapper;
import br.gov.sp.fatec.domain.request.CarroRequest;
import br.gov.sp.fatec.domain.request.CarroUpdateRequest;
import br.gov.sp.fatec.domain.response.CarroResponse;
import br.gov.sp.fatec.repository.CarroRepository;
import br.gov.sp.fatec.service.CarroService;
import java.util.List;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarroServiceImpl implements CarroService {

    private final CarroRepository carroRepository;
    private final CarroMapper carroMapper;


    @Override
    public CarroResponse save(CarroRequest carroRequest) {
        Carro carro = carroMapper.map(carroRequest);
        return carroMapper.map(carroRepository.save(carro));
    }

    @Override
    public CarroResponse findById(Long id) {
        Carro carro = carroRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return carroMapper.map(carro);
    }

    @Override
    public List<CarroResponse> findAll() {
        return carroRepository.findAll().stream()
                .map(carroMapper::map)
                .toList();
    }

    @Override
    public void updateById(Long id, CarroUpdateRequest carroUpdateRequest) {
        Carro carroToUpdate = carroRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        if(carroToUpdate == null){
            throw new EntityNotFoundException("Carro não encontrado!");
        }
        carroRepository.save(carroToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        carroRepository.deleteById(id);
    }
}
