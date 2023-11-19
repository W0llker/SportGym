package by.pvt.controller;

import by.pvt.dto.guest.GuestRequest;
import by.pvt.dto.guest.GuestResponse;
import by.pvt.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("guest")
@RequiredArgsConstructor
public class GuestController {
    private final GuestService guestService;
    @GetMapping
    public List<GuestResponse> getAllGuest() {
        return guestService.getAllGuest();
    }
    @PostMapping("addGuest")
    public GuestResponse addGuest(@RequestBody GuestRequest guestRequest) {
        return guestService.add(guestRequest);
    }
    @DeleteMapping("deleteGuest")
    public void deleteGuest(@RequestParam("idName") Long id) {
        guestService.remove(id);
    }
    @PutMapping("editGuest")
    public GuestResponse editGuest(@RequestBody GuestRequest guestRequest) {
        return guestService.add(guestRequest);
    }
}
