package com.isofh.his.service.category;

import com.isofh.his.dto.category.AssuranceCardDto;
import com.isofh.his.model.category.AssuranceCard;
import com.isofh.his.repository.category.AssuranceCardRepository;
import com.isofh.his.storage.StorageService;
import com.isofh.his.util.ExcelUtil;
import com.isofh.his.util.Util;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AssuranceCardServiceImpl implements AssuranceCardService {

    @Autowired
    private AssuranceCardRepository repository;

    private final StorageService storageService;

    @Autowired
    public AssuranceCardServiceImpl(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public AssuranceCard get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public AssuranceCard save(AssuranceCard model) {
        return repository.save(model);
    }

    @Override
    public String importExcel(MultipartFile file) {
        String fileName = storageService.store(file);

        List<Map<String, Object>> result = ExcelUtil.readFile(fileName, 1, 1);

        List<AssuranceCardDto> cardDtos = Util.convertValues(result, AssuranceCardDto.class);

        List<String> mes = new ArrayList<>();
        for (AssuranceCardDto dto : cardDtos) {
            try {
                AssuranceCard card = save(getModel(dto));
                mes.add("OK: " + card.getId());
            } catch (Exception e) {
                mes.add("Fail: " + e.getMessage());
            }
        }

        return ExcelUtil.appendLog(fileName, 1, 1, mes);
    }

    ModelMapper modelMapper = null;
    @Override
    public ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
        }

        return modelMapper;
    }

    @Override
    public AssuranceCard getModel(AssuranceCardDto dto) {
        if (dto == null) {
            return null;
        }
        return getModelMapper().map(dto, AssuranceCard.class);
    }

    @Override
    public AssuranceCardDto getDto(AssuranceCard model) {
        if (model == null) {
            return null;
        }
        return getModelMapper().map(model, AssuranceCardDto.class);
    }
}
