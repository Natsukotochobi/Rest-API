package com.raisetech.restapi;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;


@RestController
public class NameController {
    @GetMapping("/names")
    public List<String> getNames(String name) {
        return List.of("koyama", "tanaka");
    }

    @PostMapping("/names")
    public ResponseEntity<String> create(@Validated @RequestBody CreateForm form) {
// 登録処理は省略
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/names/id")
                .build()
                .toUri();

        return ResponseEntity.created(url).body("name successfully created");
    }

    @PatchMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("id") int id, @RequestBody UpdateForm form) {
        return ResponseEntity.ok(Map.of("Massage", "Update is success!"));
    }

    @DeleteMapping("/names/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        //削除処理は省略
        return ResponseEntity.ok("削除は正常に実行されました");
    }


}
