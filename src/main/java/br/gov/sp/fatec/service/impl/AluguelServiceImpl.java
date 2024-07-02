package br.gov.sp.fatec.service.impl;

import br.gov.sp.fatec.domain.entity.Aluguel;
import br.gov.sp.fatec.domain.mapper.AluguelMapper;
import br.gov.sp.fatec.domain.request.AluguelRequest;
import br.gov.sp.fatec.domain.request.AluguelUpdateRequest;
import br.gov.sp.fatec.domain.response.AluguelResponse;
import br.gov.sp.fatec.repository.AluguelRepository;
import br.gov.sp.fatec.service.AluguelService;
import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AluguelServiceImpl implements AluguelService {

    private final AluguelRepository aluguelRepository;
    private final AluguelMapper aluguelMapper;

    @Override
    public AluguelResponse save(AluguelRequest aluguelRequest) {
        Aluguel aluguel =  aluguelMapper.map(aluguelRequest);
        return aluguelMapper.map(aluguelRepository.save(aluguel));
    }

    @Override
    public AluguelResponse findById(Long id) {
        Aluguel aluguel = aluguelRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return aluguelMapper.map(aluguel);
    }

    @Override
    public List<AluguelResponse> findAll() {
        return aluguelRepository.findAll()
                .stream()
                .map(aluguelMapper::map)
                .toList();
    }

    @Override
    public void updateById(Long id, AluguelUpdateRequest aluguelRequest) {
        Aluguel aluguelToUpdate = aluguelRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        if(aluguelToUpdate == null) {
            throw new EntityNotFoundException("Aluguel não encontrado!");
        }
        aluguelToUpdate.setCreatedAt(aluguelRequest.datainico());
        aluguelToUpdate.setUpdatedAt(aluguelRequest.datafim());
        aluguelRepository.save(aluguelToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        aluguelRepository.deleteById(id);

    }
}
