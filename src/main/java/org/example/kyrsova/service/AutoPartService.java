package org.example.kyrsova.service;

import org.example.kyrsova.DTO.FilteredAutoPartDTO;
import org.example.kyrsova.model.AutoPart;
import org.example.kyrsova.repository.AutoPartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoPartService {
    AutoPartRepository autoPartRepository;
    @Autowired
    public AutoPartService(AutoPartRepository autoPartRepository) {
        this.autoPartRepository = autoPartRepository;
    }
    public List<AutoPart> getFilteredParts(FilteredAutoPartDTO filteredAutoPartDTO) {
        return autoPartRepository.getFilteredParts(filteredAutoPartDTO);
    }
    public List<AutoPart> getAll() {
        return autoPartRepository.getAllAutoParts();
    }
    public AutoPart getById(int id) {
       return autoPartRepository.getAutoPartById(id);
    }
    public void save(AutoPart autoPart) {
         autoPartRepository.addAutoPart(autoPart);
    }
    public void delete(int id) {
        autoPartRepository.removeAutoPartById(id);
    }
    public void update(AutoPart autoPart) {
        autoPartRepository.update(autoPart);
    }
    public List<String> getPartNames(){
        return autoPartRepository.getPartNames();
    }
    public int getIdByName(String name) {
        return autoPartRepository.getIdByName(name);
    }
    public int getPriceById(int id) {
        return autoPartRepository.getPriceById(id);
    }


}
