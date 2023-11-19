package by.pvt.controller;

import by.pvt.aspect.CustomLogging;
import by.pvt.dto.DeleteOrFindDto;
import by.pvt.dto.guest.GuestResponse;
import by.pvt.dto.save.SaveRequest;
import by.pvt.dto.save.SaveResponse;
import by.pvt.service.SaveService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
@RequiredArgsConstructor
public class SaveController {
    private final SaveService service;

    @PostMapping("/add")
    public SaveResponse addSale(@Valid @RequestBody SaveRequest saveRequest) {
        return service.save(saveRequest);
    }
    @PostMapping("/addSaveByGuest")
    public GuestResponse addSaveByUser(@RequestParam("idUser") Long idUser, @RequestBody DeleteOrFindDto dto) {
        return service.addSaveByUser(idUser,dto);
    }

    @GetMapping("/getSave")
    public List<SaveResponse> getALl() {
        return service.getAll();
    }

    @GetMapping("/findById")
    @CustomLogging
    public SaveResponse findById(@RequestBody DeleteOrFindDto dto) {
        return service.findById(dto.getId());
    }

    @DeleteMapping("/deleteId")
    public void deleteSale(@RequestBody DeleteOrFindDto dto) {
        service.delete(dto.getId());
    }

    @PutMapping("/editSave")
    public SaveResponse editSave(@RequestBody SaveRequest saveRequest) {
        return service.save(saveRequest);
    }
}
