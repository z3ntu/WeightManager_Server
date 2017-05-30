package xyz.z3ntu.weightmanager_server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.z3ntu.weightmanager_server.domain.WeightData;
import xyz.z3ntu.weightmanager_server.persistence.WeightDataRepository;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Service
public class InitializationService {

    private final WeightDataRepository weightDataRepository;

    @PostConstruct
    public void initializeDemoData() {
        weightDataRepository.save(IntStream.rangeClosed(1, 100).mapToObj(this::weightData).collect(Collectors.toList()));
    }

    private WeightData weightData(int number) {
        return WeightData.builder().date(Calendar.getInstance().getTime()).weight(number).build();
    }
}