package com.dsm.library.controller;

import com.dsm.library.controller.request.RegistrationLibraryRequest;
import com.dsm.library.controller.response.LibraryResponse;
import com.dsm.library.service.LibraryCreationService;
import com.dsm.library.service.LibrarySearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class LibraryController {

    private final LibraryCreationService creationService;
    private final LibrarySearchService searchService;

    @PostMapping("/library")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerLibrary(@RequestBody RegistrationLibraryRequest request) throws Exception {
        creationService.createLibrary(request.getName());
    }

    @GetMapping("/library")
    @ResponseStatus(HttpStatus.OK)
    public LibraryResponse searchLibrary() {
        return new LibraryResponse(searchService.searchLibrary());
    }

    @GetMapping("/libraries/{libraryId}")
    public LibraryResponse.Library searchLibrary(@PathVariable("libraryId") long libraryId) {
        LibraryResponse.Library library = searchService.getLibrary(libraryId);
        return library;
    }
}