package xyz.z3ntu.weightmanager_server.presentation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xyz.z3ntu.weightmanager_server.domain.WeightData;
import xyz.z3ntu.weightmanager_server.service.WeightDataService;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("weightData")
public class WeightDataController {
    private final WeightDataService weightDataService;

    @GetMapping("/")
    public HttpEntity<List<WeightData>> getWeightData() {
        return ok(weightDataService.getWeightData());
    }

    @GetMapping("/{id}")
    public HttpEntity<WeightData> getWeightData(@PathVariable Long id) {
        Optional<WeightData> weightData = weightDataService.getWeightData(id);

        return (weightData.isPresent()) ? ok(weightData.get()) : notFound().build();
    }

    @PostMapping
    public HttpEntity<WeightData> createWeightData(@RequestBody WeightData weightData) {
        return ok(weightDataService.createWeightData(weightData));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateWeightData(@PathVariable Long id, @RequestBody WeightData weightData) {
        weightDataService.updateWeightData(id, weightData);
    }

    @DeleteMapping("/{id}")
    public void deleteWeightData(@PathVariable Long id) {
        weightDataService.deleteWeightData(id);
    }
}