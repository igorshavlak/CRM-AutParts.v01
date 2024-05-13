package org.example.kyrsova.controller;

import org.example.kyrsova.DTO.AutoPartDTO;
import org.example.kyrsova.DTO.FilteredAutoPartDTO;
import org.example.kyrsova.model.AutoPart;
import org.example.kyrsova.service.AutoPartService;
import org.example.kyrsova.service.CategoryService;
import org.example.kyrsova.service.ProducerService;
import org.example.kyrsova.service.StoreHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/autoProducts")
public class AutoPartController {
    AutoPartService autoPartService;
    ProducerService producerService;
    StoreHouseService storeHouseService;
    CategoryService categoryService;

    @Autowired
    public AutoPartController(AutoPartService autoPartService, ProducerService producerService,
                              StoreHouseService storeHouseService, CategoryService categoryService) {
        this.autoPartService = autoPartService;
        this.producerService = producerService;
        this.storeHouseService = storeHouseService;
        this.categoryService = categoryService;

    }

    @GetMapping("/getAllAutoParts")
    public List<AutoPartDTO> getAutoParts() {
        List<AutoPartDTO> autoPartDTOS = new ArrayList<>();
        for (AutoPart autoPart : autoPartService.getAll()) {
            AutoPartDTO autoPartDTO = new AutoPartDTO();
            AutoPartToDTO(autoPartDTO, autoPartDTOS, autoPart);
        }
        return autoPartDTOS;
    }

    @PostMapping("/addProduct")
    public String addAutoPart(@RequestParam("name") String name,
                              @RequestParam("description") String description,
                              @RequestParam("producer") String producer,
                              @RequestParam("price") int price,
                              @RequestParam("purchase_price") int purchasePrice,
                              @RequestParam("category") String category,
                              @RequestParam("storage") String storage,
                              @RequestParam("count") int count,
                              @RequestParam("image") MultipartFile image) throws IOException {
        autoPartService.save(new AutoPart(name, description, image.getBytes(), producerService.getProducerIdByName(producer),
                categoryService.getCategoryIdByName(category), price, storeHouseService.getStoreHouseIdByName(storage), purchasePrice,
                count, 0));

        return "Successfully added product";
    }

    @GetMapping("/getFilteredProducts")
    public List<AutoPartDTO> getFilteredProducts(@RequestParam("category") String category,
                                                 @RequestParam("producer") String producer,
                                                 @RequestParam("storage") String storage,
                                                 @RequestParam("minPrice") String minPrice,
                                                 @RequestParam("maxPrice") String maxPrice) {
        FilteredAutoPartDTO filteredAutoPartDTO = new FilteredAutoPartDTO();
        if (!category.equals("All")) {
            filteredAutoPartDTO.category_id = categoryService.getCategoryIdByName(category);
        }
        if (!producer.equals("All")) {
            filteredAutoPartDTO.producer_id = producerService.getProducerIdByName(producer);
        }
        if (!storage.equals("All")) {
            filteredAutoPartDTO.store_house_id = storeHouseService.getStoreHouseIdByName(storage);
        }
        if (!minPrice.isEmpty() && !maxPrice.isEmpty()) {
            filteredAutoPartDTO.min_price = Integer.parseInt(minPrice);
            filteredAutoPartDTO.max_price = Integer.parseInt(maxPrice);
        }
        AutoPartDTO autoPartDTO;
        List<AutoPartDTO> autoPartDTOS = new ArrayList<>();
        List<AutoPart> autoParts;
        if (category.equals("All") && producer.equals("All") && storage.equals("All") && minPrice.isEmpty() && maxPrice.isEmpty()) {
            for (AutoPart autoPart : autoPartService.getAll()) {
                autoPartDTO = new AutoPartDTO();
                AutoPartToDTO(autoPartDTO, autoPartDTOS, autoPart);
            }
        } else {
            autoParts = autoPartService.getFilteredParts(filteredAutoPartDTO);
            for (AutoPart autoPart : autoParts) {
                autoPartDTO = new AutoPartDTO();
                AutoPartToDTO(autoPartDTO, autoPartDTOS, autoPart);
            }
        }
        return autoPartDTOS;
    }

    @PutMapping("/updateProduct")
    public String updateProduct(@RequestParam("id") String part_id,
                                @RequestParam("name") String name,
                                @RequestParam("description") String description,
                                @RequestParam("producer") String producer,
                                @RequestParam("price") int price,
                                @RequestParam("purchase_price") int purchasePrice,
                                @RequestParam("category") String category,
                                @RequestParam("storage") String storage,
                                @RequestParam("count") int count,
                                @RequestParam("image") MultipartFile image) throws IOException {
        autoPartService.update(new AutoPart(Integer.parseInt(part_id),name, description, image.getBytes(), producerService.getProducerIdByName(producer),
                categoryService.getCategoryIdByName(category), price, storeHouseService.getStoreHouseIdByName(storage), purchasePrice,
                count, 0));

        return "Successfully added product";
    }
    @DeleteMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("productId") int part_id) {
        autoPartService.delete(part_id);
        return "Successfully deleted product";
    }
    @GetMapping("/getPartNames")
    public List<String> getPartNames() {
        return autoPartService.getPartNames();
    }

    public void AutoPartToDTO(AutoPartDTO autoPartDTO, List<AutoPartDTO> autoPartDTOS, AutoPart autoPart) {
        autoPartDTO.part_id = autoPart.getPart_id();
        autoPartDTO.part_name = autoPart.getPart_name();
        autoPartDTO.part_desc = autoPart.getPart_desc();
        autoPartDTO.part_image = autoPart.getPart_image();
        autoPartDTO.category = categoryService.getCategoryNameById(autoPart.getCategory_id());
        autoPartDTO.part_producer = producerService.getProducerNameById(autoPart.getPart_producer_id());
        autoPartDTO.storage_house = storeHouseService.getStoreHouseNameById(autoPart.getStorage_house_id());
        autoPartDTO.count = autoPart.getCount();
        autoPartDTO.purchase_price = autoPart.getPurchase_price();
        autoPartDTO.part_price = autoPart.getPart_price();
        autoPartDTO.sales = autoPart.getSales();
        autoPartDTOS.add(autoPartDTO);
    }


}
