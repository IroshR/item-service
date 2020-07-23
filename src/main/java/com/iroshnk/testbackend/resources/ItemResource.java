package com.iroshnk.testbackend.resources;

import com.iroshnk.testbackend.api.response.CreationResponse;
import com.iroshnk.testbackend.api.response.SearchResponse;
import com.iroshnk.testbackend.model.Item;
import com.iroshnk.testbackend.service.ItemService;
import com.iroshnk.testbackend.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/items")
public class ItemResource {
    @Autowired
    private ItemService itemServiceImpl;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestHeader HttpHeaders httpHeaders, @RequestBody Item api,
                                    HttpServletResponse servletResponse) {

        CreationResponse response = itemServiceImpl.create(api);
        if (response.getStatus() == Status.RESPONSE_STATUS_FAIL) {
            servletResponse.setHeader("ETag", response.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        } else {
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getAll(HttpServletResponse servletResponse) {
        SearchResponse response = itemServiceImpl.getAll();

        if (response.getStatus() == Status.RESPONSE_STATUS_FAIL) {
            servletResponse.setHeader("ETag", response.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        } else if (response.getStatus() == Status.RESPONSE_STATUS_NO_DATA) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(response.getData(), HttpStatus.OK);
        }
    }
}
