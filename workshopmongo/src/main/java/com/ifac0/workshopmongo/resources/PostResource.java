package com.ifac0.workshopmongo.resources;

import com.ifac0.workshopmongo.domain.Post;
import com.ifac0.workshopmongo.resources.util.URL;
import com.ifac0.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value = "/{id}", method= RequestMethod.GET)
    public ResponseEntity<Optional<Post>> findById(@PathVariable String id) {
        Optional<Post> obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/titlesearch", method= RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text",defaultValue = "") String text) {
        text = URL.dedoceParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
}
