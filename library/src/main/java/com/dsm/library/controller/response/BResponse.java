package com.dsm.library.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class BResponse {
    private List<B> book;
}
