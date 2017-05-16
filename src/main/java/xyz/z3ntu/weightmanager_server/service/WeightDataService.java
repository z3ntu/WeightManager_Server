package xyz.z3ntu.weightmanager_server.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.z3ntu.weightmanager_server.domain.WeightData;
import xyz.z3ntu.weightmanager_server.persistence.WeightDataRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class WeightDataService {

    private final WeightDataRepository weightDataRepository;

    public Optional<WeightData> getWeightData(Long id) {
        return weightDataRepository.findById(id);
    }

    public List<WeightData> getWeightData() {
        return weightDataRepository.findAll();
    }

    @Transactional(readOnly = false)
    public WeightData createWeightData(WeightData weightData) {
        return weightDataRepository.save(weightData);
    }

    @Transactional(readOnly = false)
    public void updateWeightData(Long id, final WeightData weightData) {
        Optional<WeightData> existingWeightData = weightDataRepository.findById(id);
        existingWeightData.ifPresent(wd -> {
            wd.setContent(weightData.getContent());
            weightDataRepository.save(wd);
        });

        if (!existingWeightData.isPresent()) {
            weightDataRepository.save(weightData);
        }
    }

    @Transactional(readOnly = false)
    public void deleteWeightData(Long id) {
        weightDataRepository.delete(id);
    }
}